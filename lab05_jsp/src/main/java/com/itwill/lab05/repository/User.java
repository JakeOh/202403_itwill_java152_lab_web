package com.itwill.lab05.repository;

// Model. users 테이블.
public class User {
    private Integer id;
    private String userid;
    private String password;
    private String email;
    private Integer points;
    
    public User() {}

    public User(Integer id, String userid, String password, String email, Integer points) {
        this.id = id;
        this.userid = userid;
        this.password = password;
        this.email = email;
        this.points = points;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userid=" + userid + ", password=" + password + ", email=" + email + ", points="
                + points + "]";
    }

    // TODO: builder 패턴
    
}
