package edu.aiub.cs.geonames.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aiub.cs.geonames.model.base.User;
import edu.aiub.cs.geonames.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Sk.GolamMuhammad on 9/17/2017.
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final AtomicLong createCounter = new AtomicLong();

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    String addNewUser(@RequestParam String json) {
        ObjectMapper mapper = new ObjectMapper();
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        try {
            User newUser = mapper.readValue(json, User.class);
            userRepository.save(newUser);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{status:'OK'}";
    }
}
