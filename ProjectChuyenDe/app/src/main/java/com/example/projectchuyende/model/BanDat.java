package com.example.projectchuyende.model;

public class BanDat {
    private String soBan;
    private String soNguoi;
    private String imgBanDat;

    public BanDat() {

    }

    public BanDat(String soBan) {
        super();
        this.soBan= soBan;
    }

    public BanDat(String soBan, String soNguoi, String imgBanDat) {
        super();
        this.soBan = soBan;
        this.soNguoi = soNguoi;
        this.imgBanDat = imgBanDat;

    }

    public String getSoBan() {
        return soBan;
    }

    public void setSoBan(String soBan) {
        this.soBan = soBan;
    }

    public String getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(String soNguoi) {
        this.soNguoi = soNguoi;
    }

    public String getImgBanDat() {
        return imgBanDat;
    }

    public void setImgBanDat(String imgBanDat) {
        this.imgBanDat = imgBanDat;
    }

    @Override
    public String toString() {
        return "Table{" +
                "soBan='" + soBan + '\'' +
                ", soNguoi='" + soNguoi + '\'' +
                ", imgBanDat='" + imgBanDat + '\'' +
                '}';
    }
}
