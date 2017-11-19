package edu.aiub.cs.geonames.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aiub.cs.geonames.model.Data;
import edu.aiub.cs.geonames.model.base.AppInfo;
import edu.aiub.cs.geonames.model.base.Location;
import edu.aiub.cs.geonames.model.base.Region;
import edu.aiub.cs.geonames.repository.AppInfoRepository;
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
 * Created by Farhan on 11/19/2017.
 * Receives the data sent to server.
 * https://stackoverflow.com/questions/1688099/converting-json-to-java
 {
 "name": "A A A",
 "type": "game"
 }
 */
@Controller
@RequestMapping(path = "/app")
public class AppController {

    @Autowired
    AppInfoRepository appInfoRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    String addNewApp(@RequestParam String json) {

        AppInfo appInfo;

        ObjectMapper mapper = new ObjectMapper();
        Data data;
        try {
            appInfo = mapper.readValue(json, AppInfo.class);
            appInfoRepository.save(appInfo);
            return mapper.writeValueAsString(appInfo);
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
