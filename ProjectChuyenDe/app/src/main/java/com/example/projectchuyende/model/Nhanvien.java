package com.example.projectchuyende.model;

public class Nhanvien {
    String sStaffName;
    String  sMember;

    @Override
    public String toString() {
        return "Nhanvien{" +
                "sStaffName='" + sStaffName + '\'' +
                ", sMember='" + sMember + '\'' +
                '}';
    }

    public String getsStaffName() {
        return sStaffName;
    }

    public void setsStaffName(String sStaffName) {
        this.sStaffName = sStaffName;
    }

    public String getsMember() {
        return sMember;
    }

    public void setsMember(String sMember) {
        this.sMember = sMember;
    }
}
