package com.example.wangheng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wangheng.domain.pojo.User;
import com.example.wangheng.mapper.UserMapper;
import com.example.wangheng.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wanngheng
 * @date 2023/4/12 22:26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
