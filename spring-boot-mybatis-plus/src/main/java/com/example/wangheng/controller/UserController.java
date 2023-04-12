package com.example.wangheng.controller;

import com.example.wangheng.domain.pojo.User;
import com.example.wangheng.service.UserService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanngheng
 * @date 2023/4/12 22:35
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/query/uuid")
    public User queryByUuid(@Param("uuid") String uuid) {
        return userService.getById(uuid);
    }
}
