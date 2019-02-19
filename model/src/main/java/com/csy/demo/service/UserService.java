package com.csy.demo.service;

import com.csy.demo.model.User;
import com.csy.demo.utils.PageQuery;
import com.csy.demo.utils.SimpleMessage;

import java.util.Map;

/**
 * Created by tengj on 2017/4/7.
 */

public interface UserService{

    Map<String,Object>save(User user);

    Map<String,Object>update(User user);

    SimpleMessage query(PageQuery pageQuery);




}
