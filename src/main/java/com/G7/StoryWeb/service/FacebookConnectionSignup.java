package com.G7.StoryWeb.service;

import com.G7.StoryWeb.entity.Users;
import com.G7.StoryWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;


//Dang ki
@Service
public class FacebookConnectionSignup  implements ConnectionSignUp {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        Users user = new Users();
        user.setFullname(connection.getDisplayName());
        user.setPassword("12345678");
        userRepository.save(user);
        return user.getFullname();
    }
}
