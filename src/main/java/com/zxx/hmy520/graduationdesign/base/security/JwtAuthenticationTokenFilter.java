package com.zxx.hmy520.graduationdesign.base.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kam
 * @Description: JwtAuthenticationTokenFilter
 * @date 2018/6/13 11:14
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    // token 前缀
    private static final String tokenHeader = "zxx-token";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authToken = request.getHeader(tokenHeader);
        log.debug("token过滤 authToken:{}", authToken);
        if (authToken != null) {
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                if (JwtTokenUtil.validateToken(authToken)) {
                    JwtUser userInfo = JwtTokenUtil.getUserInfo(authToken);
                    log.debug("token过滤 userId:{}", userInfo.getId());
                    UserDetails userDetails = userInfo.toUserDetails();
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
