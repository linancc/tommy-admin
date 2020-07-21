package io.github.tommyadmin.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.tommyadmin.module.system.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据用户 id 查询菜单权限
     *
     * @param id 用户 id
     * @return 权限 Set
     */
    Set<String> selectPermissionByUserId(Long id);
}
