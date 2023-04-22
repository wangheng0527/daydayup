package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangheng
 */
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class SpringBootMybatisFlexApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisFlexApplication.class, args);
    }

}
