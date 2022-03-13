package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("announcement")
@Data
public class Announcement {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String theme;
    private String content;

}
