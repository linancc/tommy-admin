package io.github.tommyadmin.common.security.mapper;

import io.github.tommyadmin.common.security.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {

        Optional<User> admin = userMapper.findOneWithAuthoritiesByUsername("admin");
    }

}
