package com.example.springmvcdemo.entity.vo;

import com.example.springmvcdemo.entity.ArticleInfo;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xinyu
 * @version 1.0
 * @description: TODO
 * @date 2024/2/10 11:41
 */
@Data
public class ArticleInfoVo  extends ArticleInfo implements Serializable {
    private  final long serializableId=1L;
    private String username;

    @Override
    public String toString() {
        return "ArticleInfoVo{" +
                "username='" + username + '\'' +
                "} " + super.toString();
    }
}
