package com.mall.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author heavytiger
 * @version 1.0
 * @description 使用json web token技术生成和校验token，解码Base64获取需要的参数
 * @date 2021/12/23 12:09
 */
public class JwtUtil {
    // 过期时间为EXPIRE_TIME(毫秒)
    private static final long EXPIRE_TIME = 1 * 30 * 60 * 1000;

    // 使用UUID随机生成的私钥
    private static final String TOKEN_SECRET = "bb4e674bb30812a68df4a46351535389a223bfce46004097b6d48f40ae6c011c";

    /**
     * 生成签名,EXPIRE_TIME(毫秒)后过期
     *
     * @param username 用户名
     * @return 加密的token
     */
    public static String sign(Integer userId, String username) {
        try {
            // 过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            // 附带username，userId信息，生成签名，允许
            return JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 校验token是否正确
     * @param token 密钥
     * @return token是否被修改或是否超时
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 直接获取token中的用户的账户名
     * @param token 请求中的token
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 不解密直接从token中获取用户ID
     * @param token 请求中的token
     * @return 返回用户ID Integer
     */
    public static Integer getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asInt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
