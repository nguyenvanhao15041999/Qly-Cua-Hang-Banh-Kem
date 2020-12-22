package com.example.projectchuyende.model;

public class Nuoc {
    private String diaChi;
    private String tenNuoc;
    private String giaCa;
    private String giam;
    private String ImgAnhNuoc;


    public Nuoc() {

    }

    public Nuoc(String tenNuoc) {
        super();
        this.tenNuoc= tenNuoc;
    }

    public Nuoc(String tenNuoc, String diaChi, String giaCa, String giam, String imgAnhNuoc) {
        super();
        this.tenNuoc = tenNuoc;
        this.diaChi = diaChi;
        this.giaCa = giaCa;
        this.giam = giam;
        this.ImgAnhNuoc = imgAnhNuoc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenNuoc() {
        return tenNuoc;
    }

    public void setTenNuoc(String tenBanh) {
        this.tenNuoc = tenBanh;
    }

    public String getGiaCa() {
        return giaCa;
    }

    public void setGiaCa(String giaCa) {
        this.giaCa = giaCa;
    }

    public String getGiam() {
        return giam;
    }

    public void setGiam(String giam) {
        this.giam = giam;
    }

    public String getImgAnhNuoc() {
        return ImgAnhNuoc;
    }

    public void setImgAnhNuoc(String imgAnhNuoc) {
        imgAnhNuoc = imgAnhNuoc;
    }

    @Override
    public String toString() {
        return "Nuoc{" +
                "diaChi='" + diaChi + '\'' +
                ", tenNuoc='" + tenNuoc + '\'' +
                ", giaCa='" + giaCa + '\'' +
                ", giam='" + giam + '\'' +
                ", ImgAnhNuoc='" + ImgAnhNuoc + '\'' +
                '}';
    }
}

