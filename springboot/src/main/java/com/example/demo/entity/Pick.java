package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@TableName("pick")
@Data
public class Pick {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String pickName;
    private String pickThing;
    private String pickPicture;
    private String pickCharacteristic;
    private String pickPlace;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date pickTime;
    private String pickContact;
}
