package com.yxs.testcase.controller;

import com.yxs.testcase.component.AComponent;
import com.yxs.testcase.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AController {

    @Autowired
    private AComponent aComponent;

    @GetMapping(value = "/info")
    public UserInfo testA1(Integer id){
        UserInfo userInfo = aComponent.normalMethod(id);
        return userInfo;
    }
}
