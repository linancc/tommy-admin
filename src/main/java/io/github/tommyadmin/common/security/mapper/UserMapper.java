package io.github.tommyadmin.common.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.tommyadmin.common.security.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMapper extends BaseMapper<User> {

    Optional<User> findOneWithAuthoritiesByUsername(String username);

}
