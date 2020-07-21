package com.wigen.auth.security.handle;

import com.alibaba.fastjson.JSON;
import com.wigen.common.resp.Result;
import org.apache.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 认证失败处理类
 * </p>
 *
 * @author wangwq
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        int code = HttpStatus.SC_UNAUTHORIZED;
        String msg = String.format("", httpServletRequest.getRequestURI());

        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().print(JSON.toJSONString(Result.error(code, msg)));
    }
}
