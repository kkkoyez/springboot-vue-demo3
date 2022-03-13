package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Pick;
import com.example.demo.entity.Recruitment;
import com.example.demo.mapper.PickMapper;
import com.example.demo.mapper.RecruitmentMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/recruitment")
public class RecruitmentController {

    @Resource
    RecruitmentMapper recruitmentMapper;


//    新增
    @PostMapping
    public Result<?> save(@RequestBody Recruitment recruitment) {
        recruitmentMapper.insert(recruitment);
        return Result.success();
    }

//    更新
    @PutMapping
    public Result<?> update(@RequestBody Recruitment recruitment) {
        recruitmentMapper.updateById(recruitment);
        return Result.success();
    }

    //    删除
    @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable Long id) {
        recruitmentMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<Recruitment> wrapper = Wrappers.<Recruitment>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Recruitment::getName, search);

        }
        Page<Recruitment> recruitmentPage = recruitmentMapper.selectPage(new Page<>(pageNum, pageSize),wrapper);
        return Result.success(recruitmentPage);
    }


}
