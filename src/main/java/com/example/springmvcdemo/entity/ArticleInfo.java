package com.example.springmvcdemo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xinyu
 * @version 1.0
 * @description: TODO
 * @date 2024/2/10 11:38
 */
@Data
public class ArticleInfo implements Serializable {
    private  final long serializableId=1L;

    private int id;
    private String title;
    private String content;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int uid;
    private int rcount;
    private int state;

}
