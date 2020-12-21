package com.example.projectchuyende.model;

import java.io.Serializable;

public class Nhanvien implements Serializable {
    private String Name;
    private String Chucvu;
    private String ImgURL;
    private String MaNV;
    private String DiaChi;
    private String Email;
    private Long Luong;
    private String SDT;
    private String gioiTinh;

    public Nhanvien() {

    }

    public Nhanvien(String MaNV) {
        super();
        this.MaNV = MaNV;
    }

    public Nhanvien(String Name, String Chucvu, String ImgURL) {
        super();
        this.Name = Name;
        this.Chucvu = Chucvu;
        this.ImgURL = ImgURL;
    }

    public Nhanvien(String MaNV, String Name, String ChucVu, String SDT, String gioiTinh, String Email, String DiaChi, Long Luong) {
        super();
        this.MaNV = MaNV;
        this.Name = Name;
        this.Chucvu = ChucVu;
        this.SDT = SDT;
        this.gioiTinh = gioiTinh;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.Luong = Luong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getImgURL() {
        return ImgURL;
    }

    public void setImgURL(String imgURL) {
        ImgURL = imgURL;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public void setChucvu(String chucvu) {
        Chucvu = chucvu;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getLuong() {
        return Luong;
    }

    public void setLuong(Long luong) {
        Luong = luong;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "Nhanvien{" +
                "Name='" + Name + '\'' +
                ", Chucvu='" + Chucvu + '\'' +
                ", ImgURL='" + ImgURL + '\'' +
                ", MaNV='" + MaNV + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", Email='" + Email + '\'' +
                ", Luong=" + Luong +
                ", SDT='" + SDT + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                '}';
    }
}
