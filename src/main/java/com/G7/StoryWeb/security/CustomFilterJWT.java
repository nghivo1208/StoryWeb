package com.G7.StoryWeb.security;

import com.G7.StoryWeb.utils.JwtUtilsHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomFilterJWT extends OncePerRequestFilter {

    @Autowired
    JwtUtilsHelpers jwtUtilsHelpers;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //System.out.println("Day là ft");
        try {
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtilsHelpers.verificationToKen(jwt)){

            }

            boolean isSuccsess = jwtUtilsHelpers.verificationToKen(jwt);
            System.out.println("jwt : "+isSuccsess);

        }catch (Exception e){

        }
        filterChain.doFilter(request, response);
    }

    //Lấy token trên  header
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }


}
