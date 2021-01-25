package com.yuqixian.ms.domain.user;

/**
 * 用户实体类
 */
public class User {

    private int id;
    private String username;// 用户名唯一
    private String password;
    private String email;
    private String telephone;
    private int level;// 用户等级  0：普通用户  1：管理员用户

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public User(int id, String username, String password, String email, String telephone, int level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.level = level;
    }

    public User(String username, String password, String email, String telephone, int level) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.level = level;
    }
}
