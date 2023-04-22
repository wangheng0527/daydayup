package com.example.demo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户信息表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "t_user")
public class User implements Serializable {

    /**
     * 用户唯一表示UUID
     */
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String uuid;

    /**
     * 用户账号名称
     */
    private String name;

    /**
     * 用户账号密码
     */
    private String password;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 逻辑删除标识
     */
    @Column(onInsertValue = "0")
    private String deleted;

    /**
     * 用户信息创建时间
     */
    @Column(onInsertValue = "now()")
    private Timestamp createTime;

    /**
     * 用户信息最近一次被修改时间
     */
    @Column(onInsertValue = "now()", onUpdateValue = "now()")
    private Timestamp updateTime;

}
