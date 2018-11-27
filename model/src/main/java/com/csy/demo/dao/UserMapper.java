package com.csy.demo.dao;

import com.csy.demo.model.User;
import com.csy.demo.utils.MapperUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends MapperUtil<User> {

    List<User> query(Map map);
}