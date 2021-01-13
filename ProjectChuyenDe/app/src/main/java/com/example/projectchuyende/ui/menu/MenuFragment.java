package com.example.projectchuyende.ui.menu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.projectchuyende.R;
import com.example.projectchuyende.SanPham.FirebaseBanh;
import com.example.projectchuyende.SanPham.FirebaseNuoc;
import com.example.projectchuyende.adapter.BanhAdapter;
import com.example.projectchuyende.adapter.NuocAdapter;
import com.example.projectchuyende.model.Banh;
import com.example.projectchuyende.model.Nuoc;
import com.example.projectchuyende.ui.order.BookParty;
import com.example.projectchuyende.ui.table.Table;

import java.util.ArrayList;

public class MenuFragment extends Fragment {
    Button btnBanh, btnNuocUong;
    ListView lvDanhSach;
    int index = -1;

    ArrayList<Banh> data_banh = new ArrayList<>();
    ArrayList<Nuoc> data_nuoc = new ArrayList<>();
    BanhAdapter customAdapter_banh;
    NuocAdapter customAdapter_nuoc;
    FirebaseBanh FirebaseBanh;
    FirebaseNuoc FirebaseNuoc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        btnBanh = root.findViewById(R.id.btnBanh);
        btnNuocUong = root.findViewById(R.id.btnNuoc);
        lvDanhSach = root.findViewById(R.id.lvDanhsachHome);

        FirebaseBanh = new FirebaseBanh(getActivity());
        FirebaseNuoc = new FirebaseNuoc(getActivity());
        setEvent();
        return root;
    }

    public void setEvent() {

        //Gọi Dữ liệu Bánh từ Firebase
        if (customAdapter_banh == null) {
            FirebaseBanh.LoadDSBanh(new FirebaseBanh.IListener() {
                @Override
                public void onSuccess() {
                    data_banh.addAll(FirebaseBanh.getArrBanh());
                    customAdapter_banh = new BanhAdapter(getActivity(), R.layout.banh_listview, data_banh);
                    lvDanhSach.setAdapter(customAdapter_banh);
                }
                @Override
                public void onFail() {}
            });
        }
        else {customAdapter_banh.notifyDataSetChanged();
        }

        //Gọi Dữ liệu Nước Uống từ Firebase
        if (customAdapter_nuoc == null) {
            FirebaseNuoc.LoadDSNuoc(new FirebaseNuoc.IListener() {
                @Override
                public void onSuccess() {
                    data_nuoc.addAll(FirebaseNuoc.getArrNuoc());
                    customAdapter_nuoc = new NuocAdapter(getActivity(), R.layout.nuoc_listview, data_nuoc);
                    lvDanhSach.setAdapter(customAdapter_nuoc);
                }
                @Override
                public void onFail() {}
            });
        }
        else {customAdapter_nuoc.notifyDataSetChanged();
        }

        //Xử lý nút Button chuyển list Bánh
        btnBanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gọi dữ liệu lên màn hình
                customAdapter_banh = new BanhAdapter(getContext(), R.layout.banh_listview, data_banh);
                lvDanhSach.setAdapter(customAdapter_banh);
            }
        });

        //Xử lý nút Button chuyển list Nước Uống
        btnNuocUong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gọi dữ liệu lên màn hình
                customAdapter_nuoc = new NuocAdapter(getContext(), R.layout.nuoc_listview, data_nuoc);
                lvDanhSach.setAdapter(customAdapter_nuoc);
            }
        });

        //Xử lý nút ListView khai báo thông tin Sản Phẩm
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int vitri, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final String[] danhsach = {"Thông tin"};
                builder.setItems(danhsach,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (danhsach[i]) {
                            case "Thông tin":
                                Intent intent = new Intent(getActivity(), BookParty.class);
                                getActivity().startActivity(intent);
                                break;
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}