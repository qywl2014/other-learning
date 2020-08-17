package com.wulang.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/name")
    public Mono<String> name(){
        return Mono.just("wu lang");
    }
    @GetMapping("/id")
    public String id(){
        return "dd";
    }
}
