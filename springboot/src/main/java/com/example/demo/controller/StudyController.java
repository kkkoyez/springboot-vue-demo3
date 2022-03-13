package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Study;
import com.example.demo.mapper.StudyMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/study")
public class StudyController {

    @Resource
    StudyMapper studyMapper;


//    新增
    @PostMapping
    public Result<?> save(@RequestBody Study study) {
        studyMapper.insert(study);
        return Result.success();
    }

//    更新
    @PutMapping
    public Result<?> update(@RequestBody Study study) {
        studyMapper.updateById(study);
        return Result.success();
    }

    //    删除
    @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable Long id) {
        studyMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<Study> wrapper = Wrappers.<Study>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Study::getShareName, search);

        }
        Page<Study> studyPage = studyMapper.selectPage(new Page<>(pageNum, pageSize),wrapper);
        return Result.success(studyPage);
    }


}
