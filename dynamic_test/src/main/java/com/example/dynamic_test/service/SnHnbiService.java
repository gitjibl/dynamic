package com.example.dynamic_test.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dynamic_test.entity.SnHnbi;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jibl
 * @since 2021-11-01
 */
@DS("dm")
public interface SnHnbiService extends IService<SnHnbi> {

    List<SnHnbi> getlist();
}
