package com.example.wangheng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.wangheng.domain.pojo.User;
import com.example.wangheng.domain.vo.UserResponse;
import org.springframework.stereotype.Service;

/**
 * @author wanngheng
 * @date 2023/4/12 22:25
 */
@Service
public interface UserService extends IService<User> {

    /**
     * query User by user uuid
     * @param uuid user uuid
     * @return UserResponse
     */
    UserResponse queryByUuid(String uuid);
}
