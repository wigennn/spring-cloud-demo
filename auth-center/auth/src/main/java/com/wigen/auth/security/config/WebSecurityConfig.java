package com.wigen.auth.security.config;

import com.wigen.auth.security.filter.JwtAuthenticationTokenFilter;
import com.wigen.auth.security.handle.AuthenticationEntryPointImpl;
import com.wigen.auth.security.handle.LogoutSuccessHandlerImpl;
import com.wigen.auth.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    LogoutSuccessHandlerImpl logoutSuccessHandler;

    @Autowired
    AuthenticationEntryPointImpl authenticationEntryPoint;

    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.cors().and()
                .csrf().disable() // 禁用csrf
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and() // 认证失败处理类
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // session创建策略：无状态session
                .authorizeRequests() // 过滤请求
//                .antMatchers().anonymous() // 某些请求可以匿名访问
//                .antMatchers().permitAll() // 某些特定请求直接访问
                .anyRequest() // 除上述的请求，其他请求都要鉴权
                .authenticated();
        http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler); // 退出成功返回信息

        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
