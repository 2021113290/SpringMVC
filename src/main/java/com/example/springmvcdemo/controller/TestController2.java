package com.example.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hahaha")
public class TestController2 {
    @RequestMapping("/index")
    public String index(){
        return "/hahaha.html";
    }
}
