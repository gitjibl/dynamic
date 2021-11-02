package com.example.dynamic_test.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dynamic_test.entity.SnHnbi;
import com.example.dynamic_test.service.SnHnbiService;
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
 * @since 2021-11-01
 */
@RestController
@RequestMapping("/sn-hnbi")
public class SnHnbiController {

    @Autowired
    SnHnbiService snHnbiService;

    @RequestMapping("/list")
    public List<SnHnbi> list(){
        return snHnbiService.list();
    }

    @RequestMapping("/getlist")
    public List<SnHnbi> getlist(){
        return snHnbiService.getlist();
    }


}

