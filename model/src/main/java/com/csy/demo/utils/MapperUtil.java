package com.csy.demo.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MapperUtil<T> extends Mapper<T>, MySqlMapper<T> {
}
