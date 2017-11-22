package edu.aiub.cs.geonames.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aiub.cs.geonames.model.Data;
import edu.aiub.cs.geonames.model.UserData;
import edu.aiub.cs.geonames.model.base.Location;
import edu.aiub.cs.geonames.model.base.Region;
import edu.aiub.cs.geonames.repository.DataRepository;
import edu.aiub.cs.geonames.repository.LocationRepository;
import edu.aiub.cs.geonames.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by Farhan on 9/18/2017.
 * Receives the data sent to server.
 * https://stackoverflow.com/questions/1688099/converting-json-to-java
 * {
 * "appKey": system_hash,
 * "userKey": system_hash,
 * "location": {
 * "name": "",
 * "longitude": 12.33,
 * "latitude": 222.36,
 * "altitude": 10,
 * "elevation": 10,
 * "type": ""
 * },
 * "region": {
 * "name": "",
 * "type": ""
 * }
 * }
 */
@Controller
@RequestMapping(path = "/data")
public class DataController {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DataRepository dataRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    String addNewUser(@RequestParam String jsonStr) {


        ObjectMapper mapper = new ObjectMapper();
        UserData userData;
        try {

            userData = mapper.readValue(jsonStr, UserData.class);
            int appInfoId = userData.getAppInfoId();
            int userId = userData.getUserId();
            Location location = userData.getLocation();
            Region region = userData.getRegion();
            location = locationRepository.save(location);
            region = regionRepository.save(region);
            Data data = new Data(userId, appInfoId, location.getLocationId(), region.getRegionId());
            dataRepository.save(data);
            //return mapper.writeValueAsString(userData);
            return "{status:'OK'}";
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "{status:'ERROR'}";
    }
}
