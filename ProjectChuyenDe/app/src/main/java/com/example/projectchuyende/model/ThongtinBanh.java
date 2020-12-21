package com.example.projectchuyende.model;

public class ThongtinBanh {
    private String diaChi;
    private String tenBanh;
    private String moTa;

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenBanh() {
        return tenBanh;
    }

    public void setTenBanh(String tenBanh) {
        this.tenBanh = tenBanh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "ThongtinBanh{" +
                "diaChi='" + diaChi + '\'' +
                ", tenBanh='" + tenBanh + '\'' +
                ", moTa='" + moTa + '\'' +
                '}';
    }
    public ThongtinBanh() {

    }

    public ThongtinBanh(String tenBanh) {
        super();
        this.tenBanh = tenBanh;
    }

    public ThongtinBanh(String tenBanh, String diaChi, String moTa) {
        super();
        this.tenBanh = tenBanh;
        this.diaChi = diaChi;
        this.moTa = moTa;
    }
}
