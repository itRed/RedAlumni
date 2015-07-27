package com.red.alumni.bean;

public class Statusbean {

    private int status_id;
    private String status_des;

    public Statusbean() {
    }

    public Statusbean(int statusId, String statusDes ) {
        status_id = statusId;
        status_des = statusDes;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int statusId) {
        status_id = statusId;
    }

    public String getStatus_des() {
        return status_des;
    }

    public void setStatus_des(String statusDes) {
        status_des = statusDes;
    }

}
