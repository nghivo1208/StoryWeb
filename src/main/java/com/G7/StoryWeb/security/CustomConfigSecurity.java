package com.G7.StoryWeb.security;

import com.G7.StoryWeb.service.FacebookConnectionSignup;
import com.G7.StoryWeb.service.FacebookSignInAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;


@Configuration
@EnableWebSecurity
public class CustomConfigSecurity {



    @Autowired
    CustomAuthentication authProvider;

    @Autowired
    CustomFilterJWT customFilterJwt;

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/loginBasic/**")
                .permitAll()
                .antMatchers("/login/**", "/signin/**", "/signup/**")
                .permitAll()

                .antMatchers("/Literaries/**")
                .permitAll()
                .anyRequest()
                .authenticated()


                /*.and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout();*/

//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
        ;
//        http.addFilterBefore(customFilterJwt, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
