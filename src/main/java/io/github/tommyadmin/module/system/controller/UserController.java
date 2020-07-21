package io.github.tommyadmin.module.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.tommyadmin.module.system.entity.User;
import io.github.tommyadmin.module.system.service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理
 *
 * @author Tommy
 * @since 2020-07-21
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 通过 id 查询用户
     *
     * @param id 用户 id
     * @return 用户对象
     */
    @GetMapping("/{id}")
    public R<User> getUser(@PathVariable Long id) {
        return R.ok(userService.getById(id));
    }

    /**
     * 用户分页查询
     *
     * @param page 分页查询
     * @param user 用户对象
     * @return 分页查询结果集
     */
    @PostMapping
    public R<IPage<User>> listUser(Page<User> page, @RequestBody User user) {

        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery()
                .like(StringUtils.hasLength(user.getUserName()), User::getUserName, user.getUserName())
                .like(StringUtils.hasLength(user.getEmail()), User::getEmail, user.getEmail())
                .eq(User::isActive, true);

        return R.ok(userService.page(page, queryWrapper));
    }

    /**
     * 通过 id 更新用户
     *
     * @param user 用户对象
     * @return 更新结果
     */
    @PutMapping
    public R<Object> updateUser(User user) {
        return userService.saveOrUpdate(user) ? R.ok(null) : R.failed("更新用户失败！");
    }

    /**
     * 通过 id 删除用户
     *
     * @param id 用户 id
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public R<Object> deleteUser(@PathVariable Long id) {
        return userService.removeById(id) ? R.ok(null) : R.failed("删除用户失败！");
    }
}
