package com.G7.StoryWeb.dto;

public class RoleDTO {
    private int id;
    private String roleName;
    private String desc;

    public RoleDTO(String roleName,String desc){
        this.desc=desc;
        this.roleName=roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
