package io.github.tommyadmin.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.tommyadmin.module.system.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    Set<String> selectMenuPermsByUserId(Long id);
}
