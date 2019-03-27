package com.csy.securety1.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface MenuMapper {
    List query(Map map);
}
