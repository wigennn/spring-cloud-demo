package com.wigen.auth.security.service;

import com.wigen.auth.core.entity.User;
import com.wigen.auth.security.model.LoginUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 查询数据库user
        User user = new User();
        if (user == null) {
            throw new UsernameNotFoundException("登陆用户:" + userName + " 不存在");
        }
        // 删除

        // 停用
        return new LoginUser(user);
    }
}
