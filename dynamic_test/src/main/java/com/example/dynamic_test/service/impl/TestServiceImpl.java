package com.example.dynamic_test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dynamic_test.entity.SnHnbi;
import com.example.dynamic_test.entity.Test;
import com.example.dynamic_test.dao.TestMapper;
import com.example.dynamic_test.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jibl
 * @since 2021-08-18
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public IPage<Test> getPage() {
        Page<Test> page = new Page(1,4);
        QueryWrapper<Test> wrapper = new QueryWrapper<>();
        IPage<Test> snHnbiIPage = testMapper.selectPage(page, wrapper);
        return snHnbiIPage;
    }
}
