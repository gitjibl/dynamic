package com.example.dynamic_test.service.impl;

import com.example.dynamic_test.entity.Test;
import com.example.dynamic_test.dao.TestMapper;
import com.example.dynamic_test.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
