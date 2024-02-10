package com.example.springmvcdemo.mapper;

import com.example.springmvcdemo.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private  UserInfoMapper userInfoMapper;

    @Test
    void getUserInfoById() {
        UserInfo userInfo=userInfoMapper.getUserInfoById(1);
        System.out.println(userInfo);;
        assertEquals("admin",userInfo.getUsername());
    }

    @Test
    void add() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("test");
        userInfo.setPassword("test");
        userInfo.setCreatetime(LocalDateTime.now());
        userInfo.setUpdatetime(LocalDateTime.now());
        int num=userInfoMapper.add(userInfo);
        assertEquals(1,num);
    }

    @Test
    void getAll() {
        List<UserInfo> list=userInfoMapper.getAll();
        assertEquals(1,list.size());
    }

    @Test
    void update() {
        UserInfo userInfo=new UserInfo();
        userInfo.setId(1);
        assertEquals(1,userInfoMapper.update(1,"admin"));
        System.out.println(userInfo);
    }

    @Test
    void deleteById() {
        Integer id=3;
        int result=userInfoMapper.deleteById(id);
        assertEquals(1,result);
    }

    @Test
    void add2() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("XIAO");
        userInfo.setPhoto(null);
        userInfo.setPassword("123456");
        int num=userInfoMapper.add2(userInfo);
        assertEquals(1,num);
    }

    @Test
    void add3() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("da");
        userInfo.setPhoto(null);
        userInfo.setPassword("123");
        int num=userInfoMapper.add3(userInfo);
        assertEquals(1,num);
    }

    @Test
    void getListByCondition() {
        List<UserInfo> list=userInfoMapper.getListByCondition(null,"123");
        System.out.println(list);
    }

    @Test
    void update2() {
        UserInfo userInfo=new UserInfo();
        userInfo.setId(4);
        userInfo.setUsername(null);
        userInfo.setPassword(null);
        userInfo.setPhoto("photo.png");
        int result=userInfoMapper.update2(userInfo);
        System.out.println("受影响的行数"+result);

    }

    @Test
    void delete2() {
        List<Integer> ids=new ArrayList<>();
        ids.add(6);
        ids.add(7);
        int result=userInfoMapper.delete2(ids);
        System.out.println("删除："+result);
    }
}