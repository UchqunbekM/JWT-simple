package com.example.appjwtrest.Contoller;

import com.example.appjwtrest.Dto;
import com.example.appjwtrest.Security.JWTprovider;
import com.example.appjwtrest.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTML;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    JWTprovider jwTprovider;

    @PostMapping("/login")
    public HttpEntity<?> logintosystem(@RequestBody Dto dto) {
        UserDetails userDetails = authService.loadUserByUsername(dto.getUsername());
        boolean equals = userDetails.getPassword().equals(dto.getPassword());
        if (equals) {
            String s = jwTprovider.genetareToken(dto.getUsername());
            return ResponseEntity.ok(s);
        }
        return ResponseEntity.status(401).body("xato");
    }
}
