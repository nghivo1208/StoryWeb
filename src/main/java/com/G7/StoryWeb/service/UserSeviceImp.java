package com.G7.StoryWeb.service;

import com.G7.StoryWeb.dto.UserDTO;
import com.G7.StoryWeb.entity.Roles;
import com.G7.StoryWeb.entity.Users;
import com.G7.StoryWeb.repository.UserRepository;
import com.G7.StoryWeb.service.imp.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSeviceImp implements UserSevice {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean insertUser(UserDTO userDTO) {

        Roles roles = new Roles();
        roles.setId(userDTO.getRoleID());

        Users users = new Users();
        users.setEmail(userDTO.getEmail());
        users.setPassword(userDTO.getPassword());
        users.setFullname(userDTO.getFullname());
        users.setAddress(userDTO.getAddress());
        users.setRoles(roles);

        try {
            userRepository.save(users);
            return true;
        }catch (Exception e) {
            System.out.println("Lỗi insertUser: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return false;
    }
}
