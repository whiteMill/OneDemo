package com.example.admin.onedemo;

/**
 * Created by wl on 2016/10/13.
 */
public class User {
    private String username;
    private String firstCharacter;

    public User(String username, String firstCharacter) {
        this.username = username;
        this.firstCharacter = firstCharacter;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstCharacter() {
        return firstCharacter;
    }

    public void setFirstCharacter(String firstCharacter) {
        this.firstCharacter = firstCharacter;
    }
}
