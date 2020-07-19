package io.github.tommyadmin.common.security.service;

import io.github.tommyadmin.common.security.SecurityUtils;
import io.github.tommyadmin.common.security.entity.User;
import io.github.tommyadmin.common.security.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities() {
        return SecurityUtils.getCurrentUsername().flatMap(userMapper::findOneWithAuthoritiesByUsername);
    }

}
