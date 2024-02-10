package com.example.springmvcdemo.mapper;

import com.example.springmvcdemo.entity.vo.ArticleInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    ArticleInfoVo getById(@Param("id")Integer id);;

}
