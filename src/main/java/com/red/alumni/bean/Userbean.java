package com.red.alumni.bean;

public class Userbean {
    private int user_id;
    private String user_name;
    private String user_alias;
    private String user_pwd;
    private String user_email;
    private String user_birth;
    private String user_home;
    private String user_place;
    private String user_phone;
    private String user_qq;
    private String user_motto;
    private int user_roleid;
    private int user_statusid;
    private int user_user_permission;

    
     public Userbean(String userName, int userRoleid, int userStatusid, int userUserPermission ) {
        user_name = userName;
        user_roleid = userRoleid;
        user_statusid = userStatusid;
        user_user_permission = userUserPermission;
    }

    public Userbean(int userId, String userName, String userPwd, String userEmail, String userPhone, String userQq,
                    int userRoleid, int userStatusid ) {
        user_id = userId;
        user_name = userName;
        user_pwd = userPwd;
        user_email = userEmail;
        user_phone = userPhone;
        user_qq = userQq;
        user_roleid = userRoleid;
        user_statusid = userStatusid;
    }

    public Userbean(int userId, String userName, String userAlias, String userPwd, String userEmail, String userBirth,
                    String userHome, String userPlace, String userPhone, String userQq, String userMotto,
                    int userRoleid, int userStatusid, int userUserPermission ) {
        user_id = userId;
        user_name = userName;
        user_alias = userAlias;
        user_pwd = userPwd;
        user_email = userEmail;
        user_birth = userBirth;
        user_home = userHome;
        user_place = userPlace;
        user_phone = userPhone;
        user_qq = userQq;
        user_motto = userMotto;
        user_roleid = userRoleid;
        user_statusid = userStatusid;
        user_user_permission = userUserPermission;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int userId) {
        user_id = userId;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String userName) {
        user_name = userName;
    }

    public String getUser_alias() {
        return user_alias;
    }

    public void setUser_alias(String userAlias) {
        user_alias = userAlias;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String userPwd) {
        user_pwd = userPwd;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String userEmail) {
        user_email = userEmail;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(String userBirth) {
        user_birth = userBirth;
    }

    public String getUser_home() {
        return user_home;
    }

    public void setUser_home(String userHome) {
        user_home = userHome;
    }

    public String getUser_place() {
        return user_place;
    }

    public void setUser_place(String userPlace) {
        user_place = userPlace;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String userPhone) {
        user_phone = userPhone;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String userQq) {
        user_qq = userQq;
    }

    public String getUser_motto() {
        return user_motto;
    }

    public void setUser_motto(String userMotto) {
        user_motto = userMotto;
    }

    public int getUser_roleid() {
        return user_roleid;
    }

    public void setUser_roleid(int userRoleid) {
        user_roleid = userRoleid;
    }

    public int getUser_statusid() {
        return user_statusid;
    }

    public void setUser_statusid(int userStatusid) {
        user_statusid = userStatusid;
    }

    public int getUser_user_permission() {
        return user_user_permission;
    }

    public void setUser_user_permission(int userUserPermission) {
        user_user_permission = userUserPermission;
    }

}
