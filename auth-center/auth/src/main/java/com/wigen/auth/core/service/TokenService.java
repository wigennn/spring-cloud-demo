package com.wigen.auth.core.service;

import com.wigen.auth.constant.Constants;
import com.wigen.auth.security.model.LoginUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Component
public class TokenService {

    private static final String TOKEN_PREFIX = "Bearer ";

    private String header = "Authorization";

    private String secret = "RS256";

    /**
     * token保存30分钟
     */
    private static final Long TOKEN_SAVE_MILLIS = 30 * 60 * 1000L;


    public String createToken(LoginUser loginUser) {
        String token = UUID.randomUUID().toString().replace("-", "");
        loginUser.setToken(token);
        refreshToken(loginUser);

        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_TOKEN_KEY, token);
        return createToken(claims);
    }

    public String createToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return token;
    }


    public void delToken(String token) {
        // 删除token
        String tokenKey = getTokenKey(token);
        // redis删除
    }

    public void verifyToken(LoginUser loginUser) {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= TOKEN_SAVE_MILLIS) {
            refreshToken(loginUser);
        }
    }

    public void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + TOKEN_SAVE_MILLIS);

        String tokenKey = getTokenKey(loginUser.getToken());
        // redis缓存用户user信息

    }

    public LoginUser getLoginUser(HttpServletRequest request) {
        return null;
    }

    /**
     * 获取token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StringUtils.isNotBlank(token) && token.startsWith(TOKEN_PREFIX)) {
            token = token.replace(TOKEN_PREFIX, "");
        }

        return token;
    }

    private String getTokenKey(String token) {
        return Constants.LOGIN_TOKEN_KEY + token;
    }
}
