package com.example.hateoas.controller;

import com.example.hateoas.entity.GratingWithResources;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @GetMapping("/greeting")
    public HttpEntity<GratingWithResources.UserGreetings> greeting(
            @RequestParam(value = "name", defaultValue = "world") String name) {

        GratingWithResources.UserGreetings resources = new GratingWithResources.UserGreetings();
        resources.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(resources, HttpStatus.OK);

    }


}
