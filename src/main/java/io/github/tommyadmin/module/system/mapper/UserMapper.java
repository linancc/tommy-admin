package io.github.tommyadmin.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.tommyadmin.module.system.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
