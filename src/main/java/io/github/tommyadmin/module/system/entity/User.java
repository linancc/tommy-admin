package io.github.tommyadmin.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.tommyadmin.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class User extends BaseEntity {

    private Long id;

    private String userName;

    private String password;

    private String nickName;

    private String phone;

    private String email;

    @TableField("is_active")
    private boolean active;
}
