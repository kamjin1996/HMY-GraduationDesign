package com.zxx.hmy520.graduationdesign.base.security;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class JwtToken implements Serializable {

    /**
     * token
     */
    private String token;

    /**
     * 有效期
     */
    private Date expirationTime;

    public JwtToken(String token, Date expirationTime) {
        this.token = token;
        this.expirationTime = expirationTime;
    }
}
