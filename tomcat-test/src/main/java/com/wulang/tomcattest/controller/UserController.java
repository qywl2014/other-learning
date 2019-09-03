package com.wulang.tomcattest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUserName")
    public String getUserName(){
        return "Leo";
    }
}
