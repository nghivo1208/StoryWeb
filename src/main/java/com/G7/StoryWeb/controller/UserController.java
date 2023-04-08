package com.G7.StoryWeb.controller;


import com.G7.StoryWeb.dto.UserDTO;
import com.G7.StoryWeb.service.imp.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserSevice userSevice;

    @PostMapping("")
    public ResponseEntity<?> insertUser(@RequestBody UserDTO userDTO){

        userSevice.insertUser(userDTO);

        return new ResponseEntity<>("", HttpStatus.OK);
    }


}
