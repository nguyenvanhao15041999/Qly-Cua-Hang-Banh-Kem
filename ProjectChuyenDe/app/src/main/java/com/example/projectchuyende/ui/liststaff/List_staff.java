package com.example.projectchuyende.ui.liststaff;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projectchuyende.R;
import com.example.projectchuyende.adapter.ListStaffAdapter;
import com.example.projectchuyende.firebaseallManager.FirebaseallManager;
import com.example.projectchuyende.model.Nhan_Vien;
import com.example.projectchuyende.ui.account.Staff_inform;

import java.util.ArrayList;

public class List_staff extends Fragment {
    ListView lv_listStaff;
    ArrayList<Nhan_Vien> arrdata_listStaff = new ArrayList<>();
    ListStaffAdapter ListStaffadapter;
    FirebaseallManager firebaseallManager;
    Nhan_Vien nhanvien;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_list_staff, container, false);
        lv_listStaff = root.findViewById(R.id.lv_listStaff);
        firebaseallManager = new FirebaseallManager(getActivity());

        setEvent();
        return root;

    }


    private void setEvent() {
        if (ListStaffadapter == null) {
            firebaseallManager.loadDSNhanVien(new FirebaseallManager.IListener() {
                @Override
                public void onSuccess() {
                    arrdata_listStaff.addAll(firebaseallManager.getArrNhanvien());
                    ListStaffadapter = new ListStaffAdapter(getActivity(), R.layout.show_liststaff, arrdata_listStaff);
                    lv_listStaff.setAdapter(ListStaffadapter);
                }

                @Override
                public void onFail() {

                }
            });
        } else {
            ListStaffadapter.notifyDataSetChanged();
        }

        lv_listStaff.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int vitri, long l) {
                AlertDialog.Builder builderChucnang = new AlertDialog.Builder(getActivity());
                builderChucnang.setTitle("Chức năng");
                final String[] danhsachChucnang = {"Thông tin", "Xóa"};
                builderChucnang.setItems(danhsachChucnang, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (danhsachChucnang[i]) {
                            case "Thông tin":
                                Staff_inform staff_inform = new Staff_inform();
                                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.lnListstaff, staff_inform);
                                fragmentTransaction.commit();
                                Bundle bundle=new Bundle();
                                bundle.putString("Tennv","Phan Duy Thai");
                                staff_inform.setArguments(bundle);

                                break;
                            default:
                                nhanvien=arrdata_listStaff.get(vitri);
                                firebaseallManager.xoaNhanvien(nhanvien.getUserId(), new FirebaseallManager.IListener() {
                                    @Override
                                    public void onSuccess() {
                                        Toast.makeText(getActivity(),"Xóa thành công",Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFail() {

                                    }
                                });
                                break;
                        }
                    }
                });
                AlertDialog dialogList_staff = builderChucnang.create();
                dialogList_staff.show();
            }
        });
    }
}