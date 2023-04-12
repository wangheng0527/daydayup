package com.example.wangheng.domain.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author wanngheng
 * @date 2023/4/12 22:16
 */
@Data
@TableName(value = "t_user")
public class User {

    @TableId(type = IdType.ASSIGN_ID)
    private String uuid;

    @TableField(value = "name")
    private String name;

    @TableField(value = "password")
    private String password;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "deleted")
    private String deleted;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
