package com.example.projectchuyende.ui.liststaff;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        View root = inflater.inflate(R.layout.activity_list_staff, container, false);
        lv_listStaff = root.findViewById(R.id.lv_listStaff);
        setEvent();
        return root;

    }
    private void setEvent() {
        dataViewListStaff();
        ListStaffadapter = new ListStaffAdapter(getContext(), R.layout.show_liststaff, datalistStaff);
        lv_listStaff.setAdapter(ListStaffadapter);
        lv_listStaff.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setMessage("Ban co muon xoa?");
                builder.setTitle("Chuc nang");
                builder.setPositiveButton("Xoa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(),"ban xoa thanh cong",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
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
        Nhanvien nhanvien2 = new Nhanvien();
        nhanvien2.setsStaffName("Phan duy thai");
        nhanvien2.setsMember("Nhan vien");
        datalistStaff.add(nhanvien2);
    }

}