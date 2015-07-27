package com.red.alumni.bean;

public class Contentbean {

    private int content_id;
    private String content_title;
    private String content_detail;
    private String content_date;
    private int content_userid;

    public Contentbean() {
    }

    public Contentbean(int contentId, String contentDetail, String contentDate, int contentUserid ) {
        content_id = contentId;
        content_detail = contentDetail;
        content_date = contentDate;
        content_userid = contentUserid;
    }

    public Contentbean(int contentId, String contentTitle, String contentDetail, String contentDate, int contentUserid ) {
        content_id = contentId;
        content_title = contentTitle;
        content_detail = contentDetail;
        content_date = contentDate;
        content_userid = contentUserid;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int contentId) {
        content_id = contentId;
    }

    public String getContent_title() {
        return content_title;
    }

    public void setContent_title(String contentTitle) {
        content_title = contentTitle;
    }

    public String getContent_detail() {
        return content_detail;
    }

    public void setContent_detail(String contentDetail) {
        content_detail = contentDetail;
    }

    public String getContent_date() {
        return content_date;
    }

    public void setContent_date(String contentDate) {
        content_date = contentDate;
    }

    public int getContent_userid() {
        return content_userid;
    }

    public void setContent_userid(int contentUserid) {
        content_userid = contentUserid;
    }

}
