package io.github.tommyadmin.common.security;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.github.tommyadmin.module.system.entity.User;
import io.github.tommyadmin.module.system.mapper.MenuMapper;
import io.github.tommyadmin.module.system.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private final UserMapper userMapper;

    private final MenuMapper menuMapper;

    public UserDetailsServiceImpl(UserMapper userMapper, MenuMapper menuMapper) {
        this.userMapper = userMapper;
        this.menuMapper = menuMapper;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        LOG.debug("Authenticating user '{}'", login);

        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
        return Optional.ofNullable(userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, lowercaseLogin)))
                .map(user -> createSpringSecurityUser(lowercaseLogin, user))
                .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
        if (!user.isActive()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
        }
        Set<GrantedAuthority> grantedAuthorities = menuMapper.selectPermissionByUserId(user.getId()).stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }
}
