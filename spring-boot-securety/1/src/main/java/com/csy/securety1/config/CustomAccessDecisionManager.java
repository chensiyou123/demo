package com.csy.securety1.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

    /**
     * 比对权限
     * @param auth 当前用户信息
     * @param object 可以获取当前请求的对象
     * @param ca 访问路径设置进去的匹配路径
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication auth, Object object, Collection<ConfigAttribute> ca) throws AccessDeniedException, InsufficientAuthenticationException {
        Collection<? extends GrantedAuthority>  auths = auth.getAuthorities();//此处的Attribute在用户认证时候就添加进入的
        for(ConfigAttribute configAttribute:ca){
            if("ROLE_LOGIN".equals(configAttribute.getAttribute()) && auth instanceof UsernamePasswordAuthenticationToken){
                return;
            }
            for(GrantedAuthority authentication:auths){
                if(configAttribute.getAttribute().equals(authentication.getAuthority())){
                    return;
                }
            }
            throw new AccessDeniedException("权限不足");


        }
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
