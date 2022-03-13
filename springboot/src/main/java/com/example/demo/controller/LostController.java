package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Lost;
import com.example.demo.entity.User;
import com.example.demo.mapper.LostMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/lost")
public class LostController {

    @Resource
    LostMapper lostMapper;


//    新增
    @PostMapping
    public Result<?> save(@RequestBody Lost lost) {
        lostMapper.insert(lost);
        return Result.success();
    }

//    更新
    @PutMapping
    public Result<?> update(@RequestBody Lost lost) {
        lostMapper.updateById(lost);
        return Result.success();
    }

    //    删除
    @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable Long id) {
        lostMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<Lost> wrapper = Wrappers.<Lost>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Lost::getName, search);
        }
        Page<Lost> lostPage = lostMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(lostPage);
    }


}
