package com.pre.wfj;

import cn.hutool.jwt.JWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

public class test {
    private long time = 1000*60*60*24;
    private String signatrue = "admin";
//    @Test
//    public void jwt(){
//        JwtBuilder jwtBuilder = Jwts.builder();
//        String jwtToken = jwtBuilder
//                .setHeaderParam("alg","HS256")
//                .setHeaderParam("type","jwt")
//                .claim("name","tom")
//                .claim("role","admin")
//                .setSubject("admin-test")
//                .setExpiration(new Date(System.currentTimeMillis()+time))
//                .setId(UUID.randomUUID().toString())
//                .signWith(SignatureAlgorithm.HS256,signatrue)
//                .compact();
//                 System.out.println(jwtToken);
//
//    }
//    解密码
//    public void parse(){
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cGUiOiJqd3QifQ.eyJuYW1lIjoidG9tIiwicm9sZSI6ImFkbWluIiwic3ViIjoiYWRtaW4tdGVzdCIsImV4cCI6MTYyOTk2MzA1NiwianRpIjoiMzFmYTkzMWYtZmNhMi00ZjljLWJlYjMtMjgyMWIxYTk0Mzg1In0.DKnpwpRG-hPjAMfiXHGEsUcAF5CYfhkStWuGxGLqXW0";
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(signatrue)).build();
//        DecodedJWT verify = jwtVerifier.verify(token);
//        System.out.println(verify.getClaim("name").asString());
//        System.out.println(verify.getClaim("role").asString());
//        JwtParser jwtParser = Jwts.parser();
//        Jws<Claims> claimsJws =  jwtParser.setSigningKey(signatrue).parseClaimsJwt(token);
//        Claims claims = claimsJws.getBody();
//        System.out.println(claims.get("name"));
//        System.out.println(claims.get("role"));
//        System.out.println(claims.getId());
//        System.out.println(claims.getSubject());
//        System.out.println(claims.getExpiration());
//    }
}
