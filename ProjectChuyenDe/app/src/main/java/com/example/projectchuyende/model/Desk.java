package com.example.projectchuyende.model;

public class Desk {
    private String TenBan;
    private String KhuVuc;
    private boolean TinhTrang;
    private String MaBan;
    private int SoNguoi;

    public Desk() {

    }

    public Desk(String TenBan, boolean TinhTrang, int SoNguoi,String KhuVuc ) {
        super();
        this.TenBan = TenBan;
        this.TinhTrang = TinhTrang;
        this.SoNguoi=SoNguoi;
        this.KhuVuc=KhuVuc;
    }
    public Desk (String MaBan){
        super();
        this.MaBan=MaBan;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "TenBan='" + TenBan + '\'' +
                ", KhuVuc='" + KhuVuc + '\'' +
                ", TinhTrang=" + TinhTrang +
                ", MaBan='" + MaBan + '\'' +
                ", SoNguoi=" + SoNguoi +
                '}';
    }

    public String getTenBan() {
        return TenBan;
    }

    public void setTenBan(String tenBan) {
        TenBan = tenBan;
    }

    public String getKhuVuc() {
        return KhuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        KhuVuc = khuVuc;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public String getMaBan() {
        return MaBan;
    }

    public void setMaBan(String maBan) {
        MaBan = maBan;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        SoNguoi = soNguoi;
    }
}
