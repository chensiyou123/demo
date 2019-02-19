package com.csy.securety1.service;

import com.csy.securety1.entity.User;
import com.csy.securety1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Userservice implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Map map = new HashMap();
        map.put("userName",userName);
        List<User> users =userMapper.loadUserByUsername(map);
        if(CollectionUtils.isEmpty(users)){
            throw new UsernameNotFoundException("账户不存在");
        }
        User u = users.get(0);
        map.put("userId",u.getId());
        u.setRoles(userMapper.getUserRolesByUId(map));
        return u;
    }
}
