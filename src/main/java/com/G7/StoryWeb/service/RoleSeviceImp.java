package com.G7.StoryWeb.service;

import com.G7.StoryWeb.dto.RoleDTO;
import com.G7.StoryWeb.entity.Roles;
import com.G7.StoryWeb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleSeviceImp implements com.G7.StoryWeb.service.imp.RoleSevice {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAllRole() {
        return null;
    }

    @Override
    public List<Roles> getRoleByName(String name) {
        return roleRepository.findByRoleName(name);
    }

    @Override
    public boolean insertRole(RoleDTO roleDTO) {

        Roles roles = new Roles();
        roles.setRoleName(roleDTO.getRoleName());
        roles.setDesc(roleDTO.getDesc());

        try {
            roleRepository.save(roles);
            return true;
        }catch (Exception e){
            System.out.println("Lỗi insertRole"+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateRole(RoleDTO roleDTO) {

        boolean kiemtra = roleRepository.existsById(roleDTO.getId());
        if(roleRepository.existsById(roleDTO.getId())){
            Roles roles = new Roles();
            roles.setId(roleDTO.getId());
            roles.setRoleName(roleDTO.getRoleName());
            roles.setDesc(roleDTO.getDesc());
            try {
                roleRepository.save(roles);
                return true;

            }catch (Exception e){
                System.out.println("Lỗi updateRole : "+e.getMessage());
                return false;
            }
        }else {
            System.out.println("ID này không tồn tại");
            return false;
        }

    }

    @Override
    public boolean deleteRolebyId(int id) {

        try {
            roleRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println("Loi deleteRolebyId"+e.getMessage());
            return false;
        }
    }
}
