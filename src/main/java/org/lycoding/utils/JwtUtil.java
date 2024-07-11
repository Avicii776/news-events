package org.lycoding.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    private static final String Key="lycoding";//设置加密解密的密钥
//    接收业务数据，生成token并返回
    public static String genToken(Map<String,Object> claims ){
        return JWT.create()
                .withClaim("claims",claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*12))//设置token过期时间
                .sign(Algorithm.HMAC256(Key));//设置签名
    }
//接收token，验证token，并返回业务数据
    public static Map<String,Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(Key))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
