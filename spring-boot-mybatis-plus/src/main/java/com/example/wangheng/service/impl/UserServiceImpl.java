package com.example.wangheng.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wangheng.domain.pojo.User;
import com.example.wangheng.domain.vo.UserResponse;
import com.example.wangheng.exception.CustomiseException;
import com.example.wangheng.exception.ExceptionEnum;
import com.example.wangheng.mapper.UserMapper;
import com.example.wangheng.mapstruct.UserMapStruct;
import com.example.wangheng.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wanngheng
 * @date 2023/4/12 22:26
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * query User by user uuid
     *
     * @param uuid user uuid
     * @return UserResponse
     */
    @Override
    public UserResponse queryByUuid(String uuid) {
        User user;

        try {
             user = userMapper.selectById(uuid);
        } catch (Exception e) {
            throw new CustomiseException(ExceptionEnum.ACCESS_DATABASE_EXCEPTION, "query user by uuid exception");
        }
        if (ObjectUtil.isNull(user)) {
            throw new CustomiseException(ExceptionEnum.USER_NOT_FOUND_EXCEPTION);
        }

        return UserMapStruct.INSTANCE.user2Response(user);
    }
}
