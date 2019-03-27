package com.csy.securety1.config;

import com.csy.securety1.entity.Menu;
import com.csy.securety1.entity.Role;
import com.csy.securety1.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomFilterinvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 设置当前路径需要的角色，如果在所有的角色中都没有与之匹配的则表示改url不需要角色，登录就能访问设置Attribute为role_login
     * 如果有需要匹配的角色则把角色对应的名称都设置到Attribute中
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        Map map = new HashMap();
        List<Menu> allMenu = menuMapper.query(map);
        for(Menu m:allMenu){
            if(antPathMatcher.match(m.getPattern(),requestUrl)){
                List<Role>roles = m.getRoles();
                String[] roleArr =new String[roles.size ()];
                for(int i = 0;i<roles.size();i++){
                    roleArr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleArr);
            }
        }
        return SecurityConfig.createList("role_login");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
