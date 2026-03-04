package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import lombok.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

// No need to instantiate the repository
// This declaration is enough - Spring Boot does the rest :)


// tell Spring Boot this class is a controller
@RestController
public class StaticPageController {
    // tell Spring Boot this method handles the 'GET "/"' request
    @Autowired
    SpaceRepository spaceRepository;
    @GetMapping("/")
    public ModelAndView landingPage() {
        var allSpaces = allSpaces();
        ModelAndView modelAndView = new ModelAndView("/LandingPage");
        var nSpaces = 0;
        for( Space space: allSpaces ){
            System.out.println(space.getName());
            nSpaces++;
        }
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

    @GetMapping("/spaces")
    public ModelAndView availableSpaces() {
        ArrayList<String> formattedSpaces = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView("AvailableSpaces");
        var allSpaces = allSpaces();
        for (var space : allSpaces) {
            var name = space.getName();
            var price = space.getPrice();
            var description = space.getDescription();
            String formattedSpace = String.format("%s: %s. Available for £%.2f", name, description, price);
            formattedSpaces.add(formattedSpace);
        }
        modelAndView.addObject("spaces", formattedSpaces);
        System.out.println(formattedSpaces);
        return modelAndView;
    }

    public Iterable<Space> allSpaces() {
        return spaceRepository.findAll();
    }
}

