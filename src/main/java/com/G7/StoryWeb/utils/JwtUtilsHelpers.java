package com.G7.StoryWeb.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtilsHelpers {

    @Value("${jwt.privateKey}")
    private String privateKey;

    private long expiredTime = 8 * 60 * 60 * 1000;

    public String ganerateToken(){
        System.out.println("Kiểm tra : "+privateKey);
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        Date date = new Date();
        long currentDate = date.getTime()+expiredTime;
        Date expiredDate = new Date(currentDate);
        String jwt = Jwts.builder() // (1)
                .setSubject("Bob")      // Dữ liệu mún lưu kèm khi mã hoá JWT để sau này lấy ra sử dụng
                .signWith(key)     // key mã hoá
                .setExpiration(expiredDate)  //set thoi gian token
                .compact();
        System.out.println("Token : "+jwt);
        return jwt;
    }

    public boolean verificationToKen(String token){
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;

        }catch (Exception e){
            System.out.println("Loi giai ma token: "+e.getMessage());
            return false;
        }
    }



}
