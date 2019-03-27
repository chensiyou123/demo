package com.csy.demo.service.impl;

import com.csy.demo.dao.ArcTypeMapper;
import com.csy.demo.dao.ArtcleMapper;
import com.csy.demo.model.ArcType;
import com.csy.demo.model.Article;
import com.csy.demo.service.ArcTypeService;
import com.csy.demo.service.ArticleService;
import com.csy.demo.utils.PageQuery;
import com.csy.demo.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("artcleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArtcleMapper artcleMapper;

    @Override
    public Map<String, Object> save(Article article) {
        if(article==null){
            article = new Article();
        }
        article.setId(UUIDUtils.getUUID());
        article.setName("小米");

        artcleMapper.insertSelective(article);
        Map map = new HashMap();
        map.put("message","添加成功");
        return map;
    }

    @Override
    public Map<String, Object> update(Article article) {
        Article target = artcleMapper.selectByPrimaryKey(article.getId());
        if(target==null){
            article = new Article();
        }
        article.setId(target.getId());
        article.setName("小米");
        artcleMapper.insertSelective(article);
        Map map = new HashMap();
        map.put("message","更新成功");
        return map;
    }


    @Override
    public PageInfo query(PageQuery pageQuery) {
        Map map = pageQuery.convertFilterToMap();
        PageHelper.startPage(1, 10);
        List<Article> list = artcleMapper.query(map);
        PageInfo<Article> page = new PageInfo<Article>(list);
        return page;
    }

    @Override
    public List<Article> list(Map map) {
        return artcleMapper.query(map);
    }
}
