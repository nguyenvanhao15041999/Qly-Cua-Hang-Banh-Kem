package com.example.projectchuyende.model;

public class Banh {
    String tenBanh, giaCa, diaChi, giam;

    public String getTenBanh() {
        return tenBanh;
    }

    public void setTenBanh(String tenBanh) {
        this.tenBanh = tenBanh;
    }

    public String getGiaCa() {
        return giaCa;
    }

    public void setGiaCa(String giaCa) {
        this.giaCa = giaCa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGiam() {
        return giam;
    }

    public void setGiam(String giam) {
        this.giam = giam;
    }

    @Override
    public String toString() {
        return "Banh{" +
                "tenBanh='" + tenBanh + '\'' +
                ", giaCa='" + giaCa + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", giam='" + giam + '\'' +
                '}';
    }
}
