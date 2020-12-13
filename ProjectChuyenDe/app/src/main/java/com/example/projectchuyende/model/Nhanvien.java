package com.example.projectchuyende.model;

public class Nhanvien {
    private String Name;
    private String Chucvu;
    private Long Age;

    public Nhanvien() {

    }

    public Nhanvien(String Name) {
        super();
        this.Name = Name;
    }

    public Nhanvien(String Name, String Chucvu, Long Age) {
        super();
        this.Name = Name;
        this.Chucvu = Chucvu;
        this.Age = Age;
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
                ", Age='" + Age + '\'' +
                '}';
    }
}
