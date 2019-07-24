package ru.ncedu.lebedev.spring.simpleSpringBootApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping
    public String defaultInformation(Map<String, Object> model) {
        model.put("defaultInformation",
                "To see greetings enter next URL: /hello");
        return "default";
    }

    @GetMapping("/hello")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "Friend") String name,
            Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }
}
