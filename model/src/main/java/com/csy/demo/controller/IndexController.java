package com.csy.demo.controller;

import com.csy.demo.service.ArticleService;
import com.csy.demo.utils.PageQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/** 登录
 * Created by tengj on 2017/4/10.
 */
@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;
    @RequestMapping(value = "/")
    public ModelAndView root(){
        ModelAndView mv = new ModelAndView();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPage(1);
        pageQuery.setSize(10);
        PageInfo pageInfo = articleService.query(pageQuery);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("index");
        return mv;
    }

}
