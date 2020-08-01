package io.github.tommyadmin.common.security;

import com.baomidou.mybatisplus.extension.api.R;
import io.github.tommyadmin.common.security.jwt.TokenProvider;
import io.github.tommyadmin.module.system.entity.vo.LoginVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private final TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/authenticate")
    public R<JWTToken> authorize(@RequestBody LoginVO loginVO) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginVO.getUsername(), loginVO.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        boolean rememberMe = loginVO.isRememberMe() != null && loginVO.isRememberMe();
        String jwt = tokenProvider.createToken(authentication, rememberMe);

        return R.ok(new JWTToken(jwt));
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    @Getter
    @Setter
    @AllArgsConstructor
    static class JWTToken {

        private String token;
    }
}
