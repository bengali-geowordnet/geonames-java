package edu.aiub.cs.geonames.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aiub.cs.geonames.model.Data;
import edu.aiub.cs.geonames.model.Geoname;
import edu.aiub.cs.geonames.repository.GeonameRepository;
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
 */
@Controller
@RequestMapping(path = "/data")
public class DataController {

    @Autowired
    private GeonameRepository geonameRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    //@PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser(@RequestParam String jsonStr) {

        /*Geoname geoname = new Geoname();
        geoname.setGeonameId(geonameid);
        geoname.setName(name);
        geonameRepository.save(geoname);*/

        ObjectMapper mapper = new ObjectMapper();
        //String jsonStr = "{\"name\":\"Mahesh\"}";

        //map json to student
        Geoname geoname = new Geoname();
        try{

            Data data = mapper.readValue(jsonStr, Data.class);

            geoname = data.getGeoname();
            System.out.println(geoname.getCountry_code());
            geonameRepository.save(geoname);
            return mapper.writeValueAsString(geoname.getName());
            //System.out.println(data);

            //jsonStr = mapper.writeValueAsString(data);

            //System.out.println(jsonStr);
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }

        return "";
    }
}
