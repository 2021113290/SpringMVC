package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.entity.UserInfo;
import com.example.springmvcdemo.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class UserInfoControllerTest {
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Test
    void getUserInfoById() {
        UserInfo userInfo=userInfoMapper.getUserInfoById(1);
        System.out.println(userInfo);
    }
}