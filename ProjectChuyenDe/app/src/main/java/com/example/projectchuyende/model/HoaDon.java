package com.example.projectchuyende.model;

public class HoaDon {
    private String tenBanhV;
    private String soLuongV;
    private String soTienV;
    private String imgHoaDonV;

    public HoaDon() {

    }

    public HoaDon(String tenBanhV) {
        super();
        this.tenBanhV= tenBanhV;
    }

    public HoaDon(String tenBanhV, String soLuongV, String soTienV, String imgHoaDonV) {
        super();
        this.soLuongV = soLuongV;
        this.tenBanhV = tenBanhV;
        this.soTienV = soTienV;
        this.imgHoaDonV = imgHoaDonV;
    }

    public String getTenBanhV() {
        return tenBanhV;
    }

    public void setTenBanhV(String tenBanhV) {
        this.tenBanhV = tenBanhV;
    }

    public String getSoLuongV() {
        return soLuongV;
    }

    public void setSoLuongV(String soLuongV) {
        this.soLuongV = soLuongV;
    }

    public String getSoTienV() {
        return soTienV;
    }

    public void setSoTienV(String soTienV) {
        this.soTienV = soTienV;
    }

    public String getImgHoaDonV() {
        return imgHoaDonV;
    }

    public void setImgHoaDonV(String imgHoaDonV) {
        this.imgHoaDonV = imgHoaDonV;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "tenBanhV='" + tenBanhV + '\'' +
                ", soLuongV='" + soLuongV + '\'' +
                ", soTienV='" + soTienV + '\'' +
                ", imgHoaDonV='" + imgHoaDonV + '\'' +
                '}';
    }
}
