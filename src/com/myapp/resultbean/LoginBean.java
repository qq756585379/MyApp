package com.myapp.resultbean;

/**
 * Author： yichaoran
 * Data： 2017-08-23 16:45
 * Description：登录结果返回的类
 **/
public class LoginBean {
    /**
     * code : 1
     * msg : 登录成功
     */

    private int code;
    private String msg;
    private User body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getBody() {
        return body;
    }

    public void setBody(User body) {
        this.body = body;
    }

    public static class User {
        private int juuid;
        private String userName;
        private String userIcon;
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
            return userIcon;
        }

        public void setUserIcon(String userIcon) {
            this.userIcon = userIcon;
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
    }

}
