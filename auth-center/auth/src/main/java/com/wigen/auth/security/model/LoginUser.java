package com.wigen.auth.security.model;

import com.wigen.auth.core.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Data
public class LoginUser implements UserDetails {

    private static final long serialVersionUID = -1702981638263140486L;

    /**
     * 用户唯一ID
     */
    private String token;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登陆时间
     */
    private Long loginTime;

    /**
     * 用户信息
     */
    private User user;


    public LoginUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
