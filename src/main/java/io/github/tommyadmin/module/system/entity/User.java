package io.github.tommyadmin.module.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@TableName("sys_user")
public class User {

    private Long id;

    private String userName;

    private String password;

    private String nickName;

    private String phone;

    private String email;

    @TableField("is_active")
    private boolean active;
}
