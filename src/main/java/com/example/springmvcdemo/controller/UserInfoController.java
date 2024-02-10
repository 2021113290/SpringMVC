package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.entity.UserInfo;
import com.example.springmvcdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/getbyid")
    public UserInfo getUserInfoById(Integer id) {
        return userInfoService.getUserInfoById(id);
    }
}
