package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Pick;
import com.example.demo.entity.User;
import com.example.demo.mapper.PickMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pick")
public class PickController {

    @Resource
    PickMapper pickMapper;


//    新增
    @PostMapping
    public Result<?> save(@RequestBody Pick pick) {
        pickMapper.insert(pick);
        return Result.success();
    }

//    更新
    @PutMapping
    public Result<?> update(@RequestBody Pick pick) {
        pickMapper.updateById(pick);
        return Result.success();
    }

    //    删除
    @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable Long id) {
        pickMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<Pick> wrapper = Wrappers.<Pick>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Pick::getPickName, search);

        }
        Page<Pick> pickPage = pickMapper.selectPage(new Page<>(pageNum, pageSize),wrapper);
        return Result.success(pickPage);
    }


}
