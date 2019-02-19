package com.csy.securety1.mapper;

import com.csy.securety1.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {

    List<Role>query(Map map);
}
