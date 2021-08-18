package com.example.dynamic_main.generator;

/**
 * @ProjectName: sysxy
 * @Package: com.sysam.sysxymain.config
 * @ClassName: MybatisPlusConfig
 * @Author: jibl
 * @Description:配置分页插件
 * @Date: 2021/1/19 9:38
 * @Version: 1.0
 */

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
