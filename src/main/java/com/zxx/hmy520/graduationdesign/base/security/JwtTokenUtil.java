package com.zxx.hmy520.graduationdesign.base.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author kam
 * @Description: JwtTokenUtil
 * @date 2018/6/13 11:20
 */
public final class JwtTokenUtil {

    private static final String CLAIM_KEY_SUB = "sub";
    private static final String CLAIM_KEY_NICKNAME = "nickName";
    private static final String CLAIM_KEY_CREATED = "created";

    private static final String secret =
            "MIIEowIBAAKCAQEA0NvVwOi0fVXmf7oVMWBaoFZmUvrKgH/0waZ7LF9Fdh3phgKP\n" +
                    "iM2LXkqSHKJkOAd9JhQg+sY51vYPGVTQMO0/vstJqt4msiNZMQgobqEVCk3fSnCZ\n" +
                    "hjl9sVmZPz9s7YyGf2wBEIUA9EPq0X83ABZtZHa2FFcCEsT5LkMslZ1Bnva4ji/u\n" +
                    "GY/dOLLoCpShoQJ8yt372rH0lgCo6lAuOId+Nvfemz1kxELBarghZXMghI8WvoVf\n" +
                    "2EXzZ0fDl32ENrmsVvra3i996BnKMLxGKWltbItLNXdnogfU1d5ShuoX1DA20JQE\n" +
                    "WTzHWtRW8AbOylfTUMnRUeTYnzrXTDGn7OIZ+wIDAQABAoIBAQCUI5kVXvjF/Wuk\n" +
                    "JMRrZUBigWXKbX+8bQWZZQ/whRKrmMPN/Xr5OXEkzBeen8AdzZICtDxAIuFbiuNi\n" +
                    "wDl6uoyAM4ho3XDs4Q2eLX8gGLjnuhwqnHsILTbt1/NOXRpR016CeoS2xt/KYXHo\n" +
                    "bicAtOeaXmj/PEeIMJXdLmAtLoEg0e07nxT6VshtQd5ZARPUddZdvoaIEgdKFKaz\n" +
                    "98Kf+P7zlF0LUT7j1Od6hkCOy+NrF6uVpkLJVJrKZTvqbrkD3c3OQy7r9hHrJ6vi\n" +
                    "UAQzw3p/ePSFxcT15Ip3Dbeccg5SFGwga4hxc8ev2xfaj8PL4k57xefOypXPuy6l\n" +
                    "yuduwoTBAoGBAPp7YOA0UiKWToEbKh6ApQ9O3Lm4uOpRHLydS53qvpjAYRhtR7rv\n" +
                    "Y+pgw7CNSnVL/vXwKBvaf73lArhoAD/rKWkNxRv8REJB9ljJE3W3Kyl3VRCkS4fr\n" +
                    "zsprJoKzA7q/Qof99Qt27QFvp0M7IQzdII+ocnDJ+dOacbg4yCK9FbmTAoGBANV1\n" +
                    "t7jgnchbtdLiSjaF2AED9qkro/ehw+kUyTme8SY/Y0nqS7JlGJT/s6iHMxOOalVh\n" +
                    "3GSeXqCp8aaf46OUJ+bfpCB53rtu1jE5KBWeac30LfIkd53prKtdFLzkkRLjFWOi\n" +
                    "ATH0ugj/zVFx7mFD0pmxFbBLXnLdb6uSbGCWVT75AoGAUScCBwHMjpomCxwy9Dj3\n" +
                    "wVLqnl1jw77N0aogoqQ4ZiMGEjTtpXoD5B6/qAbO1dvuWd4aEJQlCPAWhopjclIN\n" +
                    "U5T7hIqhztmyJ6fV3zCeEkwwSjkAo6PZlqlKi9PV5H4s3wR/jNxWAz4aceTJW3KV\n" +
                    "JxYLJdG6WD1UlLwI04BxdnMCgYBjqRBcCtLf5qGfkfNgPWE6KCWTmkJ1rVsQiZnh\n" +
                    "gynH17R9oBwzcCvn9PJmbqkUKlvO/V+uwpofnPir+N6JUvTGQAga+YtaK0dpt+vV\n" +
                    "HB79/1EsSoZmfeEWKOEzx+tLzCYCXHL+ZeotpXCw4+aOFuJOy3T62FWCf4xRqI1d\n" +
                    "ExM90QKBgBUA6PCcclOFSuxiJfjSCGTT/bEvFuBbrE3JAKjwO1p3IH3xS41WWKN0\n" +
                    "q3Hmt/evLzcSWyh44irElkD926/UYK74Ncb2WldSc0fFXvKxxY1ZmLKluLXfWu3O\n" +
                    "CYiESp0rkoubAyf8+q3dW1xnnlExqAGxjpurzyC5Xc6zSliL/D/3"; // 秘钥

    private static final Long expiration = (60L * 60 * 24 * 10);  // token 有效期秒

    /**
     * 生成KEY
     *
     * @return
     */
    private static Key getKeyInstance() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }

    /**
     * JwtUser 转 Claims
     *
     * @param user
     * @return
     */
    private static Map<String, Object> jwtUserToClaims(JwtUser user) {
        Map<String, Object> map = new HashMap<>();
        map.put(CLAIM_KEY_SUB, user.getId());
        map.put(CLAIM_KEY_NICKNAME, user.getName());
        map.put(CLAIM_KEY_CREATED, new Date());
        return map;
    }

    /**
     * claims 转 JwtUser
     *
     * @param claims
     * @return
     */
    private static JwtUser claimsToJwtUser(Claims claims) {
        JwtUser jwtUser = new JwtUser();
        jwtUser.setId(Long.valueOf((Integer) claims.get(CLAIM_KEY_SUB)));
        jwtUser.setName(String.valueOf(claims.get(CLAIM_KEY_NICKNAME)));
        return jwtUser;
    }

    /**
     * 生成token
     *
     * @param user
     * @return
     */
    public static JwtToken generateToken(JwtUser user) {
        return buildToken(jwtUserToClaims(user));
    }

    /**
     * 构建
     *
     * @param claims
     * @return
     */
    private static JwtToken buildToken(Map<String, Object> claims) {
        Date expirationTime = generateExpirationDate();
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, getKeyInstance())
                .compact();
        return new JwtToken(token, expirationTime);
    }

    /**
     * 生成token 有效期
     *
     * @return
     */
    private static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 根据token 获取当前用户id
     *
     * @param token
     * @return
     */
    public static Long getUserId(String token) {
        Long userId;
        try {
            final Claims claims = getClaimsFromToken(token);
            userId = Long.valueOf(claims.getSubject());
        } catch (Exception e) {
            userId = null;
        }
        return userId;
    }


    /**
     * 根据token 获取当前用户id
     *
     * @param token
     * @return
     */
    public static JwtUser getUserInfo(String token) {
        JwtUser jwtUser;
        try {
            final Claims claims = getClaimsFromToken(token);
            jwtUser = claimsToJwtUser(claims);
        } catch (Exception e) {
            jwtUser = null;
        }
        return jwtUser;
    }


    /**
     * 根据token 获取创建时间
     *
     * @param token
     * @return
     */
    public static Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    /**
     * 解析token并获取相关信息
     *
     * @param token
     * @return
     */
    public static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(getKeyInstance())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }


    /**
     * 刷新token
     *
     * @param token
     * @return
     */
    public static JwtToken refreshToken(String token) {
        JwtToken refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = buildToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 检查token 有效
     *
     * @param token
     * @return
     */
    public static boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 判断token 是否有效
     *
     * @param token
     * @return
     */
    private static boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        if (Objects.isNull(expiration)) {
            return true;
        }
        return expiration.before(new Date());
    }

    /**
     * 获取token 过期时间
     *
     * @param token
     * @return
     */
    public static Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }
}
