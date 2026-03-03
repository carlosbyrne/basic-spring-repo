package com.makers.makersbnb.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// tell Spring Boot this class is a controller
@RestController
public class StaticPageController {
    // tell Spring Boot this method handles the 'GET "/"' request
    @GetMapping("/")
    public ModelAndView landingPage() {
        ModelAndView modelAndView = new ModelAndView("/LandingPage");
        Integer nSpaces = 100;
        modelAndView.addObject("nSpaces", nSpaces);
        // imagine these reviews were stored in a database
        String[] reviews = new String[] {"Awesome", "Nice", "Perfect"};
        modelAndView.addObject("reviews", reviews);
        Integer lastWeekBookings = 123;
        modelAndView.addObject("lastWeekBookings", lastWeekBookings);
        return modelAndView;
    }


    @GetMapping("/contactus")
    public ModelAndView contactUs() {
        return new ModelAndView("ContactInfo");
        }
}


