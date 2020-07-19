package io.github.tommyadmin.common.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user_job")
public class UserJob {

    @TableId(type = IdType.AUTO)
    private Long userId;

    @TableId(type = IdType.AUTO)
    private Long jobId;
}
