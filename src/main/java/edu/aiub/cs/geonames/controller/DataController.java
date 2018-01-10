package edu.aiub.cs.geonames.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aiub.cs.geonames.model.Data;
import edu.aiub.cs.geonames.model.UserData;
import edu.aiub.cs.geonames.model.base.AppInfo;
import edu.aiub.cs.geonames.model.base.Location;
import edu.aiub.cs.geonames.model.base.Region;
import edu.aiub.cs.geonames.model.base.User;
import edu.aiub.cs.geonames.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by Farhan on 9/18/2017.
 * Receives the data sent to server.
 * https://stackoverflow.com/questions/1688099/converting-json-to-java
 {
 "appKey":"06ac2d4e579155ab0801025a9ee50f3ca1ef45c6",
 "userKey":"d81ad03e7d6191e9c039b2cd35ed3039cc8422e2",
 "location":{
 "name":"",
 "longitude":12.33,
 "latitude":222.36,
 "altitude":10,
 "elevation":10,
 "type":""
 },
 "region":{
 "name":"",
 "type":""
 }
 }
 */
@Controller
@RequestMapping(path = "api/v1/data")
public class DataController {

    @Autowired
    AppInfoRepository appInfoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DataRepository dataRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Data> addNewData(@RequestParam String json) {
        ObjectMapper mapper = new ObjectMapper();
        UserData userData;
        try {
            userData = mapper.readValue(json, UserData.class);
            AppInfo appInfo = appInfoRepository.findByToken(userData.getAppKey());
            User user = userRepository.findByToken(userData.getUserKey());
            if(appInfo == null || user == null) {
                return ResponseEntity.notFound().build();
            }
            Location location = userData.getLocation();
            Region region = userData.getRegion();
            location = locationRepository.save(location);
            region = regionRepository.save(region);
            Data data = new Data(user.getUserId(), appInfo.getAppId(), location.getLocationId(), region.getRegionId());
            dataRepository.save(data);
            //return mapper.writeValueAsString(userData);
            return ResponseEntity.ok().body(data);
        } catch (JsonParseException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    ResponseEntity<Data> createData(@Valid @RequestBody UserData userData) {
        long appInfoId = appInfoRepository.findByToken(userData.getAppKey()).getAppId();
        long userId = userRepository.findByToken(userData.getUserKey()).getUserId();
        Location location = userData.getLocation();
        Region region = userData.getRegion();
        location = locationRepository.save(location);
        region = regionRepository.save(region);
        Data data = new Data(userId, appInfoId, location.getLocationId(), region.getRegionId());
        dataRepository.save(data);
        return ResponseEntity.ok().body(dataRepository.save(data));
    }
}
