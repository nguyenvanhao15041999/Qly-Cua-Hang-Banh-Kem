package com.example.projectchuyende.ui.liststaff;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projectchuyende.R;
import com.example.projectchuyende.adapter.ListStaffAdapter;
import com.example.projectchuyende.model.Nhanvien;

import java.util.ArrayList;

public class List_staff extends Fragment {
    ListView lv_listStaff;
    ArrayList<Nhanvien> datalistStaff = new ArrayList<>();
    ListStaffAdapter ListStaffadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.show_liststaff, container, false);
        lv_listStaff = root.findViewById(R.id.lv_listStaff);
        return root;
    }
    private void setEvent() {
        dataViewListStaff();
        ListStaffadapter = new ListStaffAdapter(getContext(), R.layout.show_liststaff, datalistStaff);
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

}