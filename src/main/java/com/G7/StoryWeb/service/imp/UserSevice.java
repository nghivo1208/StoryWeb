package com.G7.StoryWeb.service.imp;

import com.G7.StoryWeb.dto.UserDTO;

public interface UserSevice {
    boolean insertUser(UserDTO userDTO);
    boolean updateUser(UserDTO userDTO);
}
