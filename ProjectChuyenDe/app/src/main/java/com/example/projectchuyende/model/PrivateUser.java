package com.example.projectchuyende.model;

public class PrivateUser {
    private String userID;
    private String password;

    public PrivateUser() {
    }

    public PrivateUser(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
