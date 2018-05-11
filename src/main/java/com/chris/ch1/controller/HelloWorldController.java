package com.chris.ch1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @RequestMapping("/say.html")
    public @ResponseBody String say(){
        return "Hello Spring Boot 2.0!";
    }
}




