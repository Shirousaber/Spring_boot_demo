package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private final AtomicLong id = new AtomicLong();
    private static final String template = "Hello,%s";
    @RequestMapping("/hello")
    public String hello()
    {
        return "Hello, too.";
    }
    @GetMapping("/Greetings")
    public Greetings greetings(@RequestParam(value = "name", defaultValue ="the world")String name)
    {
        return new Greetings(id.incrementAndGet(),String.format(template, name));
    }
}
