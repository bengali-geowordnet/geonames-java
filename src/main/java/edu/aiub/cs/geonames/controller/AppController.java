package edu.aiub.cs.geonames.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aiub.cs.geonames.model.Data;
import edu.aiub.cs.geonames.model.base.AppInfo;
import edu.aiub.cs.geonames.repository.AppInfoRepository;
import edu.aiub.cs.geonames.utility.Utils;
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
 * {
 * "name": "A A A",
 * "type": "game",
 * "email": "aaa@example.com"
 * }
 */
@Controller
@RequestMapping(path = "/app")
public class AppController {

    @Autowired
    AppInfoRepository appInfoRepository;

    /**
     * Registers a new application in the system.
     *
     * @param json the JSON data received via API
     * @return sends back response code in JSON format
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    String addNewApp(@RequestParam String json) {

        AppInfo appInfo;

        ObjectMapper mapper = new ObjectMapper();
        Data data;
        try {
            appInfo = mapper.readValue(json, AppInfo.class);
            String token = Utils.getAppToken(appInfo.getName(), appInfo.getEmail());
            appInfo.setToken(token);
            appInfoRepository.save(appInfo);
            //return mapper.writeValueAsString(appInfo);
            return String.format("{token:%s}", token);
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
