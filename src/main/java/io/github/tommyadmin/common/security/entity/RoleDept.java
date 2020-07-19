package io.github.tommyadmin.common.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_role")
public class RoleDept {

    @TableId(type = IdType.AUTO)
    private Long roleId;

    @TableId(type = IdType.AUTO)
    private Long deptId;
}