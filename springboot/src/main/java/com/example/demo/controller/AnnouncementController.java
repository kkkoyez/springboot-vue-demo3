package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Announcement;
import com.example.demo.entity.User;
import com.example.demo.mapper.AnnouncementMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

    @Resource
    AnnouncementMapper announcementMapper;


//    新增
    @PostMapping
    public Result<?> save(@RequestBody Announcement announcement) {
        announcementMapper.insert(announcement);
        return Result.success();
    }

//    更新
    @PutMapping
    public Result<?> update(@RequestBody Announcement announcement) {
        announcementMapper.updateById(announcement);
        return Result.success();
    }

    //    删除
    @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable Long id) {
        announcementMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<Announcement> wrapper = Wrappers.<Announcement>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Announcement::getTheme, search);

        }
        Page<Announcement> announcementPage = announcementMapper.selectPage(new Page<>(pageNum, pageSize),wrapper);
        return Result.success(announcementPage);
    }


}
