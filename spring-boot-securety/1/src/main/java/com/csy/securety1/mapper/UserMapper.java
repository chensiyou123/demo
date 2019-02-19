package com.csy.securety1.mapper;

import com.csy.securety1.entity.Role;
import com.csy.securety1.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<User> loadUserByUsername(Map map);
    List<Role>getUserRolesByUId(Map map);
}
