package com.example.projectchuyende.model;

import java.io.Serializable;

public class Nhan_Vien implements Serializable {
    private String Chucvu;
    private String Date;
    private String Email;
    private String EmployeeCode;
    private String userId;
    private String Password;
    private String Phone;
    private String Tennv;
    private String User;
    private String permission;
    private String imgURL;

    public Nhan_Vien() {
    }

    public Nhan_Vien(String chucvu, String date, String email, String employeeCode, String userId, String password, String phone, String tennv, String user, String permission) {
        this.Chucvu = chucvu;
        this.Date = date;
        this.Email = email;
        this.EmployeeCode = employeeCode;
        this.userId = userId;
        this.Password = password;
        this.Phone = phone;
        this.Tennv = tennv;
        this.User = user;
        this.permission = permission;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public void setChucvu(String chucvu) {
        Chucvu = chucvu;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getTennv() {
        return Tennv;
    }

    public void setTennv(String tennv) {
        Tennv = tennv;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
