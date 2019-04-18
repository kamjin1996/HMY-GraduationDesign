package com.zxx.hmy520.graduationdesign.base.security.utils;

import com.zxx.hmy520.graduationdesign.base.security.JwtTokenUtil;
import com.zxx.hmy520.graduationdesign.base.security.JwtUser;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * spring security 工具类
 */
public final class SpringSecurityUtil {

    /**
     * spring security 获取当前用户ID
     *
     * @return
     */
    public static Long getUserId() {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            return Long.valueOf(userDetails.getUsername());
        } catch (Exception e) {
            throw new AccessDeniedException("Spring Security环境无法获取用户 ID", e);
        }
    }

    /**
     * 获取用户昵称
     *
     * @return
     */
    public static String getName() {
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            String token = request.getHeader("xdpx-token");
            JwtUser userInfo = JwtTokenUtil.getUserInfo(token);
            return userInfo.getName();
        } catch (Exception e) {
            throw new AccessDeniedException("Spring Security环境无法获取用户 name", e);
        }
    }

}
