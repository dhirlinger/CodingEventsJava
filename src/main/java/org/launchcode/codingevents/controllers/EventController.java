package org.launchcode.codingevents.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    @GetMapping("index")
    public String displayAllEvents(Model model){
        List<String> events = new ArrayList<>();
        events.add("First Philly Java");
        events.add("Philly React Review");
        events.add("STL Java Review");
        model.addAttribute("events", events);
        return "events/index";
    }

    // lives at /events
    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    @PostMapping
    public String createEvent(@RequestParam String eventName){
        events.add(eventName);
        return "redirect:/events";
    }
}
