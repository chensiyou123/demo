package com.csy.demo.controller;

import com.csy.demo.model.User;
import com.csy.demo.service.UserService;
import com.csy.demo.utils.PageQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/** 登录
 * Created by tengj on 2017/4/10.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> save(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> update(@RequestBody User user){
        return userService.update(user);
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public Map<String,Object> query(PageQuery pageQuery){
        return userService.query(pageQuery);
    }
    @RequestMapping(value = "/testsave",method = RequestMethod.GET)
    public Map<String,Object> testsave(PageQuery pageQuery){
        return userService.save(null);
    }
}
