package com.example.springmvcdemo.mapper;

import com.example.springmvcdemo.entity.vo.ArticleInfoVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleMapperTest {
    @Autowired
    private ArticleMapper articleMapper;
    @Test
    void getById() {
        ArticleInfoVo articleInfoVo=articleMapper.getById(1);
        System.out.println(articleInfoVo);
    }
}