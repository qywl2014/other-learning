package com.wulang.springboottest.controller;

import com.google.gson.JsonObject;
import com.wulang.springboottest.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class NewsController {
    private static int count = 0;

    @Autowired
    private Dog dog;

    @PostConstruct
    public void init() {
        System.out.println("-------------- " + dog.getName());
    }

    @GetMapping("/api/skNewsTopic")
    public String a(String dt, int type) {
        JsonObject jsonObject = new JsonObject();
        return jsonObject.toString();
    }
}
