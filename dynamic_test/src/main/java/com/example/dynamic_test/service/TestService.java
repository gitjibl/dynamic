package com.example.dynamic_test.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.dynamic_test.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jibl
 * @since 2021-08-18
 */
@DS("slave_1")
public interface TestService extends IService<Test> {

    IPage<Test> getPage();
}
