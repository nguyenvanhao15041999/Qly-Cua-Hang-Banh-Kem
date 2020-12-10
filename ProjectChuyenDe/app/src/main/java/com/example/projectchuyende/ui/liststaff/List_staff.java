package com.example.projectchuyende.ui.liststaff;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.example.projectchuyende.ui.account.Staff_inform;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class List_staff extends Fragment {
    ListView lv_listStaff;
    ArrayList<Nhanvien> data_listStaff = new ArrayList<>();
    ListStaffAdapter ListStaffadapter;

    DatabaseReference mdata;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_list_staff, container, false);
        lv_listStaff = root.findViewById(R.id.lv_listStaff);
        mdata=FirebaseDatabase.getInstance().getReference();
        mdata.child("Hoten").setValue("Vovu");
        setEvent();
        return root;

    }
    private void setEvent() {
        dataViewListStaff();
        ListStaffadapter = new ListStaffAdapter(getContext(), R.layout.show_liststaff, data_listStaff);
        lv_listStaff.setAdapter(ListStaffadapter);




        lv_listStaff.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builderChucnang = new AlertDialog.Builder(getActivity());
                builderChucnang.setTitle("Chức năng");
                final String[] danhsachChucnang={"Thông tin","Xóa"};
                builderChucnang.setItems(danhsachChucnang, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (danhsachChucnang[i]){
                            case "Thông tin":
                                Intent intent=new Intent(getActivity(), Staff_inform.class);
                                startActivity(intent);
                                break;
                            default:
                                break;
                        }
                    }
                });
                AlertDialog dialogList_staff = builderChucnang.create();
                dialogList_staff.show();
            }
        });
    }

    private void dataViewListStaff() {
        final Nhanvien nhanvien = new Nhanvien();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Staff");
        String NVID = mDatabase.push().getKey();
        Nhanvien nhanvienfile = new Nhanvien("Võ Minh Tấn Vũ", "Nhân Viên");
        mDatabase.child(NVID).setValue(nhanvienfile);
        nhanvien.setsStaffName("Phan duy thai");
        nhanvien.setsMember("Nhan vien");
        data_listStaff.add(nhanvien);
        Nhanvien nhanvien1 = new Nhanvien();
        nhanvien1.setsStaffName("Phan duy thai");
        nhanvien1.setsMember("Nhan vien");
        data_listStaff.add(nhanvien1);
        Nhanvien nhanvien2 = new Nhanvien();
        nhanvien2.setsStaffName("Phan duy thai");
        nhanvien2.setsMember("Nhan vien");
        data_listStaff.add(nhanvien2);
    }

}