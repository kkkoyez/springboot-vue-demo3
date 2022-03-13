package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@TableName("study")
@Data
public class Study {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String shareName;
    private String theme;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date time;
    private String materials;
}
