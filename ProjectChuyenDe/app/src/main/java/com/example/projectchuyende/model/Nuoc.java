package com.example.projectchuyende.model;

public class Nuoc {
    String tenNuoc, giaCa, diaChi, giam;

    public String getTenNuoc() {
        return tenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        this.tenNuoc = tenNuoc;
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
                "tenNuoc='" + tenNuoc + '\'' +
                ", giaCa='" + giaCa + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", giam='" + giam + '\'' +
                '}';
    }
}
