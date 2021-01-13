package com.example.projectchuyende.ui.timekeeping;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projectchuyende.R;
import com.example.projectchuyende.adapter.TimeKeepingAdapter;
import com.example.projectchuyende.model.Nhan_Vien;
import com.example.projectchuyende.model.TimeKeeping;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;


public class timekeeping extends Fragment {
    ListView lv_timeKeeping;
    Nhan_Vien nhan_vien;

    ArrayList<TimeKeeping> datatimeKeeping = new ArrayList<>();
    ArrayList<Nhan_Vien> datanv;
    TimeKeepingAdapter TimeKeepingadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_timekeeping, container, false);
        lv_timeKeeping = root.findViewById(R.id.lv_timeKeeping);

        setEvent();
        return root;

    }

    private void setEvent() {
        Khoitao();
        TimeKeepingadapter = new TimeKeepingAdapter(getContext(), R.layout.show_timekeeping, datatimeKeeping);
        lv_timeKeeping.setAdapter(TimeKeepingadapter);
    }

    private void Khoitao() {

        TimeKeeping timeKeeping = new TimeKeeping();
        timeKeeping.setTenNhanVien(" Phan Duy Thai ");
        timeKeeping.setNgayCong(String.valueOf(20));
        timeKeeping.setLuongCB(String.valueOf(10000000) + " VND ");
        timeKeeping.setTongGio(String.valueOf(150) + " GIỜ ");
        timeKeeping.setTongLuong(String.valueOf(10000000 + 150 * 20) + " VND ");
        datatimeKeeping.add(timeKeeping);

        TimeKeeping timeKeeping1 = new TimeKeeping();
        timeKeeping1.setTenNhanVien("Tan vu");
        timeKeeping1.setNgayCong(String.valueOf(25));
        timeKeeping1.setLuongCB(String.valueOf(10000000) + " VND ");
        timeKeeping1.setTongGio(String.valueOf(170) + " GIỜ ");
        timeKeeping1.setTongLuong(String.valueOf(10000000 + 170 * 20) + " VND ");
        datatimeKeeping.add(timeKeeping1);
    }


}