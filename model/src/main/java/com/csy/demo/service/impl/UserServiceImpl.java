package com.csy.demo.service.impl;

import com.csy.demo.dao.UserMapper;
import com.csy.demo.model.User;
import com.csy.demo.service.UserService;
import com.csy.demo.utils.PageQuery;
import com.csy.demo.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> save(User user) {
        if(user==null){
            user = new User();
        }
        user.setId(UUIDUtils.getUUID());
        user.setName("小米");
        user.setPasswrod("123");
        userMapper.insertSelective(user);
        Map map = new HashMap();
        map.put("message","添加成功");
        return map;
    }

    @Override
    public Map<String, Object> update(User user) {
        User target = userMapper.selectByPrimaryKey(user.getId());
        if(target==null){
            user = new User();
        }
        user.setId(target.getId());
        user.setName("小米");
        user.setPasswrod("123");
        userMapper.insertSelective(user);
        Map map = new HashMap();
        map.put("message","更新成功");
        return map;
    }


    @Override
    public Map<String, Object> query(PageQuery pageQuery) {
        Map map = pageQuery.convertFilterToMap();
        PageHelper.startPage(1, 10);
        List<User> list = userMapper.query(map);
        PageInfo<User> page = new PageInfo<User>(list);
        Map resultMap = new HashMap();
        resultMap.put("info",page);
        return resultMap;
    }
}
