package com.zxx.hmy520.graduationdesign.base.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kam
 * @Description: JwtUser
 * @date 2018/6/12 15:47
 */
@Data
public class JwtUser {

    private Long id;

    private String name;

    public JwtUser() {
    }

    public JwtUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 输出UserDetails 用户信息
     *
     * @return
     */
    public UserDetails toUserDetails() {
        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                // 暂时不需要
                return null;
            }

            @Override
            public String getUsername() {
                return String.valueOf(id);
            }

            // 只做jwtToken 验证 登录逻辑另行处理
            @Override
            public String getPassword() {
                return "";
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
        };
        return userDetails;
    }

    /**
     * 角色列表载入
     *
     * @param roles
     * @return
     */
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> roles) {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
