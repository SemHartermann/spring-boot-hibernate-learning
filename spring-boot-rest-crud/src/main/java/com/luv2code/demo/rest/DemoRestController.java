package com.luv2code.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "say hello for my little friend";
    }

}
