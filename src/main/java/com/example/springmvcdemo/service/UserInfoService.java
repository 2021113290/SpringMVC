package com.example.springmvcdemo.service;

import com.example.springmvcdemo.entity.UserInfo;
import com.example.springmvcdemo.mapper.UserInfoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserInfoById(Integer id) {
        return userInfoMapper.getUserInfoById(id);
    }
}
