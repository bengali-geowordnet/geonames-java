package edu.aiub.cs.geonames.controller;

import edu.aiub.cs.geonames.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    //@PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser(@RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        /*User user = new User();
        user.setName(name);
        userRepository.save(user);*/
        return "Saved";
    }

    /*@RequestMapping(value = "/user", method = RequestMethod.GET)
    public User showUser(@RequestParam(value="name", defaultValue="User") String name) {
        return new User(counter.incrementAndGet(),
                String.format(template, name));
    }*/
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    //@GetMapping(path="/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showUser(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "showUser";
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public User createUser(@RequestParam(value = "name", defaultValue = "User") String name) {
        /*return new User(createCounter.incrementAndGet(),
                String.format(template, name));*/
        return new User("email","7777777");
    }
}
