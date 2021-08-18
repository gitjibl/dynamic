package com.example.dynamic_test.controller;


import com.example.dynamic_test.entity.SysUser;
import com.example.dynamic_test.service.SysUserService;
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
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping("/list")
    public List<SysUser> list(){
        return sysUserService.list();
    }
}

