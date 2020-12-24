package com.example.projectchuyende.model;

import java.io.Serializable;

public class Nhan_Vien implements Serializable {
    private String Chucvu;
    private String Date;
    private String Email;
    private String EmployeeCode;
    private String NhanVienId;
    private String Password;
    private String Phone;
    private String Tennhanvien;
    private String User;
    private String permission;

    public Nhan_Vien() {
    }

    public Nhan_Vien(String chucvu, String date, String email, String employeeCode, String nhanVienId, String password, String phone, String tennhanvien, String user, String permission) {
        Chucvu = chucvu;
        Date = date;
        Email = email;
        EmployeeCode = employeeCode;
        NhanVienId = nhanVienId;
        Password = password;
        Phone = phone;
        Tennhanvien = tennhanvien;
        User = user;
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

    public String getNhanVienId() {
        return NhanVienId;
    }

    public void setNhanVienId(String nhanVienId) {
        NhanVienId = nhanVienId;
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

    public String getTennhanvien() {
        return Tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        Tennhanvien = tennhanvien;
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
}
