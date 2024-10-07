package org.launchcode.codingevents.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("events")
public class EventController {

    private static Map<String, String> events = new HashMap<>() {{
        put("Philly Java Jam", "The first LC Philly Java Meet up");
        put("PHP PHL", "A php meetup at the airport");
        put("Web Audio 101", "Intro to the Web Audio API with JavaScript");
    }};



    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", events);
        return "events/index";
    }

    // lives at /events
    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    //lives at /events
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, String eventDescription){
        //events.add(eventName);
        events.put(eventName, eventDescription);
        return "redirect:/events";
    }
}
