package com.example.appjwtrest.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTprovider {
//    public static void main(String[] args) {
//        String userLogin = genetareToken("userLogin");
//        System.out.println("userLogin = " + userLogin);
//    }
   static String secret = "Secretkey";
    public  String genetareToken(String username) {
        long expireTime = 36_000_000;

        Date expire = new Date(System.currentTimeMillis() + expireTime);
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expire)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return token;
    }

    // HS512 ishlashi uchun pomga qoshish kerak
//     <dependency>
//            <groupId>javax.xml.bind</groupId>
//            <artifactId>jaxb-api</artifactId>
//        </dependency>

}