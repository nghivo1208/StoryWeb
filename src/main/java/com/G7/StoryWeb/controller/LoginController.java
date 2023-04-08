package com.G7.StoryWeb.controller;

import com.G7.StoryWeb.payload.ResponseData;
import com.G7.StoryWeb.utils.JwtUtilsHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginBasic")
public class LoginController {

    @Autowired
    JwtUtilsHelpers jwtUtilsHelpers;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username,
                                    @RequestParam String password){

        UsernamePasswordAuthenticationToken token = new
                UsernamePasswordAuthenticationToken(username,password);
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

//        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        String jwtKey = Encoders.BASE64.encode(key.getEncoded());
//        System.out.println("SecretKey : "+jwtKey);

        ResponseData responseData = new ResponseData();
        responseData.setData(jwtUtilsHelpers.ganerateToken());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(){

        return new ResponseEntity<>("Hello signup", HttpStatus.OK);
    }
}
