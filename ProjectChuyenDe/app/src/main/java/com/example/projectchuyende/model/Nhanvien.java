package com.example.projectchuyende.model;

public class Nhanvien {
    private String Name;
    private String Chucvu;
    private Long Age;
    private String ImgURL;
    private String MaNV;

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

    public Nhanvien() {

    }

    public Nhanvien(String Name) {
        super();
        this.Name = Name;
    }

    public Nhanvien(String Name, String Chucvu, String ImgURL) {
        super();
        this.Name = Name;
        this.Chucvu = Chucvu;
        this.ImgURL = ImgURL;
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

    public Long getAge() {
        return Age;
    }

    public void setAge(Long age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Nhanvien{" +
                "Name='" + Name + '\'' +
                ", Chucvu='" + Chucvu + '\'' +
                ", Age=" + Age +
                ", ImgURL='" + ImgURL + '\'' +
                ", MaNV='" + MaNV + '\'' +
                '}';
    }
}
