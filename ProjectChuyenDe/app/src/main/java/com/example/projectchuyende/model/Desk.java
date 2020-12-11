package com.example.projectchuyende.model;

public class Desk {
    String sSoban;
    String sTrangthai;

    @Override
    public String toString() {
        return "Desk{" +
                "sSoban='" + sSoban + '\'' +
                ", sTrangthai='" + sTrangthai + '\'' +
                '}';
    }

    public String getsSoban() {
        return sSoban;
    }

    public void setsSoban(String sSoban) {
        this.sSoban = sSoban;
    }

    public String getsTrangthai() {
        return sTrangthai;
    }

    public void setsTrangthai(String sTrangthai) {
        this.sTrangthai = sTrangthai;
    }
}
