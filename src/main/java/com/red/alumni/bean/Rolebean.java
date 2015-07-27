package com.red.alumni.bean;

public class Rolebean {

    private int role_id;
    private String role_des;

    public Rolebean() {
    }

    public Rolebean(int roleId, String roleDes ) {
        role_id = roleId;
        role_des = roleDes;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int roleId) {
        role_id = roleId;
    }

    public String getRole_des() {
        return role_des;
    }

    public void setRole_des(String roleDes) {
        role_des = roleDes;
    }

}
