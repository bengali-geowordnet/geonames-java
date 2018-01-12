package edu.aiub.cs.geonames.controller.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aiub.cs.geonames.model.base.User;
import edu.aiub.cs.geonames.repository.UserRepository;
import edu.aiub.cs.geonames.utility.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Sk.GolamMuhammad on 9/17/2017.
 *
 * https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
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
@RequestMapping(path = "api/v1/users")
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

    @PostMapping()
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        String token = Utils.getUserToken(user.getName(),user.getEmail(), user.getPhone());
        user.setToken(token);
        //return mapper.writeValueAsString(user);
        return ResponseEntity.ok().body(userRepository.save(user));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User userDetails,
                                           @PathVariable(value = "id") long userId) {
        User user = userRepository.findOne(userId);
        if(user==null) {
            return ResponseEntity.notFound().build();
        }
        user.setFullName(userDetails.getFullName());
        user.setDateOfBirth(userDetails.getDateOfBirth());
        user.setAddress(userDetails.getAddress());
        user.setPhone(userDetails.getPhone());
        user.setAge(userDetails.getAge());
        user.setCountry(userDetails.getCountry());
        user.setEducation(userDetails.getEducation());

        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {

        User user = userRepository.findOne(userId);
        if(user==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }
}
