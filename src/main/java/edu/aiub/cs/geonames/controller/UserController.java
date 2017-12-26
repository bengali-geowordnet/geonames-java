package edu.aiub.cs.geonames.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aiub.cs.geonames.model.base.User;
import edu.aiub.cs.geonames.repository.UserRepository;
import edu.aiub.cs.geonames.utility.Utils;
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
 * {
 * "name": "A",
 * "email": "abc@example.com",
 * "type": "user",
 * "fullName": "A A A",
 * "dateOfBirth": "1997-11-07 00:00:00",
 * "gender": "male",
 * "address": "Road -23, Block - B",
 * "phone": "01711111111",
 * "age": 23,
 * "country": "BD",
 * "education": "Secondary"
 * }
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
        try {
            User user = mapper.readValue(json, User.class);
            String token = Utils.getUserToken(user.getName(),user.getEmail(), user.getPhone());
            user.setToken(token);
            userRepository.save(user);
            //return mapper.writeValueAsString(user);
            return String.format("{\"token\": \"%s\"}", token);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{status:\"ERROR\"}";
    }
}
