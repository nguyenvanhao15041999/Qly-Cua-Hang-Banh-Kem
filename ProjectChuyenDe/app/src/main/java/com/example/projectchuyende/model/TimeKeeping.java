package com.example.projectchuyende.model;

public class TimeKeeping {
    private String tenNhanVien;
    private String ngayCong;
    private String tongGio;
    private String luongCB;
    private String tongLuong;

    public TimeKeeping(){

    }
    public TimeKeeping(String tenNhanVien,String ngayCong,String tongGio,String luongCB,String tongLuong){
        super();
        this.tenNhanVien=tenNhanVien;
        this.ngayCong=ngayCong;
        this.tongGio=tongGio;
        this.luongCB=luongCB;
        this.tongLuong=tongLuong;
    }

    @Override
    public String toString() {
        return "TimeKeeping{" +
                "tenNhanVien='" + tenNhanVien + '\'' +
                ", ngayCong='" + ngayCong + '\'' +
                ", tongGio='" + tongGio + '\'' +
                ", luongCB='" + luongCB + '\'' +
                ", tongLuong='" + tongLuong + '\'' +
                '}';
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(String ngayCong) {
        this.ngayCong = ngayCong;
    }

    public String getTongGio() {
        return tongGio;
    }

    public void setTongGio(String tongGio) {
        this.tongGio = tongGio;
    }

    public String getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(String luongCB) {
        this.luongCB = luongCB;
    }

    public String getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(String tongLuong) {
        this.tongLuong = tongLuong;
    }
}
