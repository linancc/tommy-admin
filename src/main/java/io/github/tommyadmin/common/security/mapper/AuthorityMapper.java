package io.github.tommyadmin.common.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.tommyadmin.common.security.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityMapper extends BaseMapper<Role> {
}
