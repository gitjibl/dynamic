package com.example.dynamic_test.dao;

import com.example.dynamic_test.entity.SnHnbi;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jibl
 * @since 2021-11-01
 */
public interface SnHnbiMapper extends BaseMapper<SnHnbi> {

    List<SnHnbi> getlist();
}
