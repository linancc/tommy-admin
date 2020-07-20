package io.github.tommyadmin.module.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.tommyadmin.module.system.entity.User;
import io.github.tommyadmin.module.system.mapper.UserMapper;
import io.github.tommyadmin.module.system.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
