package com.ilionx.musicapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/helloworld")
public class HelloWorldController {

    @GetMapping
    public String sayHello() {
        return "hello world from Spring!";
    }
}
