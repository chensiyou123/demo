package com.csy.demo.dao;

import com.csy.demo.model.ArcType;
import com.csy.demo.model.Article;
import com.csy.demo.utils.MapperUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArtcleMapper extends MapperUtil<Article> {

    List<Article> query(Map map);
}