package com.G7.StoryWeb.security;

import com.G7.StoryWeb.service.imp.LoginSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthentication implements AuthenticationProvider {

    @Autowired
    LoginSevice loginSeviceImp;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if(loginSeviceImp.login(username,password)){
            return new UsernamePasswordAuthenticationToken(username,password,new ArrayList<>());
        }else {
            System.out.println("Login khong thanh cong loi 401");
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
