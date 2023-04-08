package com.G7.StoryWeb.service;

import com.G7.StoryWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginSeviceImp implements com.G7.StoryWeb.service.imp.LoginSevice {

    @Autowired
    UserRepository userRepository;


    @Override
    public boolean login(String username, String password) {
        return userRepository.findByEmailAndPassword(username,password).size()>0;
    }
}
