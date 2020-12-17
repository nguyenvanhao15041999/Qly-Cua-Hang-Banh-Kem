package com.example.projectchuyende.model;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String address;
    private String email;
    private String permission;
    private String phoneNumber;
    private String username;

    public User() {
    }

    public User(String userId, String address, String email, String permission, String phoneNumber, String username) {
        this.userId = userId;
        this.address = address;
        this.email = email;
        this.permission = permission;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
