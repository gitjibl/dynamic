package com.example.dynamic_test.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.dynamic_test.entity.SnHnbi;
import com.example.dynamic_test.entity.Test;
import com.example.dynamic_test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jibl
 * @since 2021-08-18
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/list")
    public List<Test> list(){
        return testService.list();
    }

    @RequestMapping("/page")
    public IPage<Test> page(){
        return testService.getPage();
    }

}

