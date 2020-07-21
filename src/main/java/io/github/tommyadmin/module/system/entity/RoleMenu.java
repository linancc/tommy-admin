package io.github.tommyadmin.module.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_role_menu")
public class RoleMenu {

    private Long roleId;

    @TableId(type = IdType.AUTO)
    private Long menuId;
}
