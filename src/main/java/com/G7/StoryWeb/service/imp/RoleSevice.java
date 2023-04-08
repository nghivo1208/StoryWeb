package com.G7.StoryWeb.service.imp;

import com.G7.StoryWeb.dto.RoleDTO;
import com.G7.StoryWeb.entity.Roles;

import java.util.List;

public interface RoleSevice {
    List<RoleDTO> getAllRole();
    List<Roles> getRoleByName(String name);
    boolean insertRole(RoleDTO roleDTO);
    boolean updateRole(RoleDTO roleDTO);
    boolean deleteRolebyId(int id);
}
