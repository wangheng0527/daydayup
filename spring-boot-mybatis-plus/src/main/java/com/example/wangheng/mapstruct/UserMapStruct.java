package com.example.wangheng.mapstruct;

import com.example.wangheng.domain.pojo.User;
import com.example.wangheng.domain.vo.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author wanngheng
 * @date 2023/4/13 23:12
 */
@Mapper
public interface UserMapStruct {

    UserMapStruct INSTANCE = Mappers.getMapper(UserMapStruct.class);

    /**
     * User convert to UserResponse
     * @param user User
     * @return UserResponse
     */
    UserResponse user2Response(User user);
}
