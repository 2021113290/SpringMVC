package com.example.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@RequestMapping("/calc")
public class CalcController {
    @RequestMapping("/sum")
    public String sum(Integer num1, Integer num2) {
        return String.format("<h1>计算的结果是：%d</h1><a href='javascript:h istory.go(-1);'>返回</a>", num1 + num2);
    }
}
