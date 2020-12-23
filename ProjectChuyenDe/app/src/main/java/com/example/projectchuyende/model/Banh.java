package com.example.projectchuyende.model;

public class Banh {
    private String diaChi;
    private String tenBanh;
    private String giaCa;
    private String giam;
    private String ImgAnhBanh;


    public Banh() {

    }

    public Banh(String tenBanh) {
        super();
        this.tenBanh= tenBanh;
    }

    public Banh(String tenBanh, String diaChi, String giaCa, String giam, String imgAnhBanh) {
        super();
        this.tenBanh = tenBanh;
        this.diaChi = diaChi;
        this.giaCa = giaCa;
        this.giam = giam;
        this.ImgAnhBanh = imgAnhBanh;
    }

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

    public String getImgAnhBanh() {
        return ImgAnhBanh;
    }

    public void setImgAnhBanh(String imgAnhBanh) {
        ImgAnhBanh = imgAnhBanh;
    }

    @Override
    public String toString() {
        return "Banh{" +
                "diaChi='" + diaChi + '\'' +
                ", tenBanh='" + tenBanh + '\'' +
                ", giaCa='" + giaCa + '\'' +
                ", giam='" + giam + '\'' +
                ", ImgAnhBanh='" + ImgAnhBanh + '\'' +
                '}';
    }
}

