package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Slf4j
@Controller
@ResponseBody
@RequestMapping("/test")
public class TestController {
    //    获取普通变量
    @RequestMapping("/hi")
    public String getInt(Integer num) {
        return "num:" + num;
    }

    //    获取对象
    @RequestMapping("/user")
    public String getUser(User user) {
        return user.toString();
    }

    //    参数重命名
    @RequestMapping("/time")
    public String showTime(@RequestParam("t1") String startTime, @RequestParam("t2") String endTime) {
        return "开始时间：" + startTime + " 结束时间：" + endTime;
    }

    @PostMapping("/json")
    public String getUserJson(@RequestBody User user) {
        return user.toString();
    }

    @RequestMapping("/login/{username}/{password}")
    public String login(@PathVariable("username") String username, @PathVariable("password") String password) {
        return username + " " + password;
    }

    @RequestMapping("/login/{username}/and/{password}")
    public String login2(@PathVariable("username") String name, @PathVariable("password") String word) {
        return name + ": " + word;
    }

    @RequestMapping("/upfile")
    public String upfile(@RequestPart("myfile") MultipartFile file) throws IOException {
//        根目录
        String path = "D:\\javaee";
//        根目录+唯一文件名
        path += UUID.randomUUID().toString();
//        根目录＋唯一文件名+后缀
        path += file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        file.transferTo(new File(path));
        return path;
    }

    //    获取 Request 和 Response 对象
    @GetMapping("/getParam")
    public String getParam(HttpServletRequest req) {
        return req.getParameter("name");
    }

    //    传统获取 header/cookie
    @RequestMapping("/getcookie")
    public String getCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for (Cookie item : cookies
        ) {
            log.error(item.getName() + ":" + item.getValue());
        }
        return "get cookie";
    }

    //    简洁的获取 Cookie—@CookieValue
    @RequestMapping("/cookie")
    @ResponseBody
    public String cookie(@CookieValue("zhangsan") String bite) {
        return "cookie：" + bite;
    }

    //    简洁获取 Header—@RequestHeader
    @RequestMapping("/header")
    @ResponseBody
    public String header(@RequestHeader("User-Agent") String userAgent) {
        return "userAgent：" + userAgent;
    }

    //    Session 存储和获取
    @RequestMapping("/setsess")
    @ResponseBody
    public String setsess(HttpServletRequest request) {
// 获取 HttpSession 对象，参数设置为 true 表示如果没有 session 对象就创建⼀个session
        HttpSession session = request.getSession(true);
        if (session != null) {
            session.setAttribute("username", "java");
        }
        return "session 存储成功";
    }

    @RequestMapping("/sess")
    @ResponseBody
    public String sess(HttpServletRequest request) {
// 如果 session 不存在，不会⾃动创建
        HttpSession session = request.getSession(false);
        String username = "暂⽆";
        if (session != null && session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
        }
        return "username：" + username;
    }

    //    获取 Session 更简洁的⽅式：
    @RequestMapping("/sess2")
    @ResponseBody
    public String sess2(@SessionAttribute(value = "username", required = false)
                        String username) {
        return "username：" + username;
    }

}
