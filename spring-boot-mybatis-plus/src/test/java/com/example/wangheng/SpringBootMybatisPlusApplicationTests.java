package com.example.wangheng;

import com.example.wangheng.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.selectById("fc1fe564c16d9e79addea37a85d6caed"));
    }

}
