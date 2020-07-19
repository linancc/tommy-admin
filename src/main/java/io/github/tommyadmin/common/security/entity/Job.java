package io.github.tommyadmin.common.security.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_job")
public class Job {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String jobname;
}
