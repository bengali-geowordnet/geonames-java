package edu.aiub.cs.geonames.controller.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/web")
public class WebController {

    @GetMapping()
    public ResponseEntity index() {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/apps")
    public ResponseEntity allApps() {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/users")
    public ResponseEntity allUsers() {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/data")
    public ResponseEntity allData() {
        return ResponseEntity.ok().build();
    }
}
