package com.G7.StoryWeb.controller;


import com.G7.StoryWeb.dto.RoleDTO;
import com.G7.StoryWeb.service.RoleSeviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleSeviceImp roleSevice;

    @GetMapping("")
    public ResponseEntity<?> getAllRole(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getRoleByName(@PathVariable String name){
        return new ResponseEntity<>(roleSevice.getRoleByName(name), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?>updateRole(@RequestBody RoleDTO roleDTO){

        roleSevice.updateRole(roleDTO);
        return  new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertRole(@RequestBody RoleDTO roleDTO){
        roleSevice.insertRole(roleDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }
    @DeleteMapping("")
    public ResponseEntity<?> deleteRolebyId(@RequestParam Integer id){
        roleSevice.deleteRolebyId(id);
        return new ResponseEntity<>("",HttpStatus.OK);
    }
}




