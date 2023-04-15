package com.example.wangheng.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author wanngheng
 * @date 2023/4/13 23:11
 */
@Data
public class UserResponse {

    String uuid;

    String name;

    String password;

    String phone;

    String deleted;

    Date createTime;

    Date updateTime;
}
