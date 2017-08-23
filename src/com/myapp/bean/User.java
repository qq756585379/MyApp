package com.myapp.bean;

/**
 * @author yichaoran
 * @create 2017-08-21 12:00
 * @Description:
 **/
public class User {
    private int juuid;
    private String userName;
    private String user_icon;
    private String phone;
    private String area;
    private String abstracts;
    private String message;

    public int getJuuid() {
        return juuid;
    }

    public void setJuuid(int juuid) {
        this.juuid = juuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIcon() {
        return user_icon;
    }

    public void setUserIcon(String userIcon) {
        this.user_icon = userIcon;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" +
                "juuid=" + juuid +
                ", userName='" + userName + '\'' +
                ", userIcon='" + user_icon + '\'' +
                ", phone='" + phone + '\'' +
                ", area='" + area + '\'' +
                ", abstracts='" + abstracts + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
