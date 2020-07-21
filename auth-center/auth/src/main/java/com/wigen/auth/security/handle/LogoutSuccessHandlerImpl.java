package com.wigen.auth.security.handle;

import com.alibaba.fastjson.JSON;
import com.wigen.auth.utils.ServletUtil;
import com.wigen.common.resp.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 退出成功处理类
 * </p>
 *
 * @author wangwq
 */
@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        // 清除用户token

        // 返回退出信息
        ServletUtil.renderString(httpServletResponse, JSON.toJSONString(Result.error(500, "退出成功")));
    }
}
