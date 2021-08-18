package com.example.dynamic_main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@ComponentScan({"com.example.*"})
@MapperScan("com.example.*.dao")
public class DynamicMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicMainApplication.class, args);
    }

}
