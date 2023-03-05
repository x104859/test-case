package com.yxs.testcase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/a")
public class AController {

    @GetMapping(value = "/a1")
    public String testA1(){
        return "success";
    }
}
