package com.csy.demo.service;

import com.csy.demo.model.ArcType;
import com.csy.demo.model.Article;
import com.csy.demo.utils.PageQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by tengj on 2017/4/7.
 */

public interface ArticleService {

    Map<String,Object>save(Article article);

    Map<String,Object>update(Article article);

    PageInfo query(PageQuery pageQuery);

    List<Article>list(Map map);




}
