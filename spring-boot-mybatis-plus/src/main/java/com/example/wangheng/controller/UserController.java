package com.example.wangheng.controller;

import com.example.wangheng.domain.vo.UserRequest;
import com.example.wangheng.domain.vo.UserResponse;
import com.example.wangheng.service.UserService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/insert")
    public void insert(@Param("user") UserRequest request) {
        userService.save(null);
    }

    @GetMapping("/query/uuid")
    public UserResponse queryByUuid(@Param("uuid") String uuid) {
        return userService.queryByUuid(uuid);
    }
}
