package com.zxx.hmy520.graduationdesign.base.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author kam
 * @Description: JwtAuthenticationEntryPoint
 * @date 2018/6/13 18:24
 */
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.debug("security 未认证 ", e);
        if (e instanceof InsufficientAuthenticationException) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "未认证");
        }
    }

}
