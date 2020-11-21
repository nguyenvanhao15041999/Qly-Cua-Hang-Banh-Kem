package com.example.projectchuyende;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projectchuyende.adapter.ListStaffAdapter;
import com.example.projectchuyende.model.Nhanvien;

import java.util.ArrayList;

public class List_staff extends AppCompatActivity {
    ListView lv_listStaff;
    ArrayList<Nhanvien> datalistStaff = new ArrayList<>();
    ListStaffAdapter ListStaffadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_staff);
        setControl();
        setEvent();
    }

    private void setEvent() {
        dataViewListStaff();
        ListStaffadapter = new ListStaffAdapter(this, R.layout.show_liststaff, datalistStaff);
        lv_listStaff.setAdapter(ListStaffadapter);
    }

    private void dataViewListStaff() {
        Nhanvien nhanvien = new Nhanvien();
        nhanvien.setsStaffName("Phan duy thai");
        nhanvien.setsMember("Nhan vien");
        datalistStaff.add(nhanvien);
        Nhanvien nhanvien1 = new Nhanvien();
        nhanvien1.setsStaffName("Phan duy thai");
        nhanvien1.setsMember("Nhan vien");
        datalistStaff.add(nhanvien1);
    }

    private void setControl() {
        lv_listStaff = findViewById(R.id.lv_listStaff);
    }
}