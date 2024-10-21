package com.iitposs.pos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping(path = "/get-test")
    public String getMyText(){
        return "Hello world";
    }

    @GetMapping(path = "/get-name")
    public String getMyName(){
        return "Kamal";
    }

}
