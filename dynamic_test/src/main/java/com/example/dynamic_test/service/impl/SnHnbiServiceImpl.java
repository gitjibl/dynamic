package com.example.dynamic_test.service.impl;

import com.example.dynamic_test.entity.SnHnbi;
import com.example.dynamic_test.dao.SnHnbiMapper;
import com.example.dynamic_test.service.SnHnbiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jibl
 * @since 2021-11-01
 */
@Service
public class SnHnbiServiceImpl extends ServiceImpl<SnHnbiMapper, SnHnbi> implements SnHnbiService {

    @Autowired
    SnHnbiMapper snHnbiMapper;

    @Override
    public List<SnHnbi> getlist() {
        return snHnbiMapper.getlist();
    }
}
