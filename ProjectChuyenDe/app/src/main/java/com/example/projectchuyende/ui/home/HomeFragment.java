package com.example.projectchuyende.ui.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.projectchuyende.R;
import com.example.projectchuyende.SanPham.FirebaseNuoc;
import com.example.projectchuyende.adapter.BanhAdapter;
import com.example.projectchuyende.adapter.NuocAdapter;
import com.example.projectchuyende.SanPham.FirebaseBanh;
import com.example.projectchuyende.firebaseallManager.FirebaseallManager;
import com.example.projectchuyende.model.Banh;
import com.example.projectchuyende.model.Nuoc;
import com.example.projectchuyende.ui.account.Product_chi_tiet;
import com.example.projectchuyende.ui.account.Staff_inform;
import com.example.projectchuyende.ui.bill.Bill;
import com.example.projectchuyende.ui.order.BookParty;
import com.example.projectchuyende.ui.order.Bookdesk;
import com.example.projectchuyende.ui.table.Table;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    Button btnKhu, btnDatTiec, btnBanh, btnNuocUong;
    ListView lvDanhSach;
    String index = "banh";

    ArrayList<Banh> data_banh = new ArrayList<>();
    ArrayList<Nuoc> data_nuoc = new ArrayList<>();
    BanhAdapter customAdapter_banh;
    NuocAdapter customAdapter_nuoc;
    FirebaseBanh FirebaseBanh;
    FirebaseNuoc FirebaseNuoc;
    Banh banh;
    Nuoc nuoc;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        btnKhu = root.findViewById(R.id.btnKhu);
        btnDatTiec = root.findViewById(R.id.btnDattiec);
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
                public void onFail() {
                }
            });
        } else {
            customAdapter_banh.notifyDataSetChanged();
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
                public void onFail() {
                }
            });
        } else {
            customAdapter_nuoc.notifyDataSetChanged();
        }

        //Xử lý nút Button chuyển trang Bàn
        btnKhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Table.class);
                getActivity().startActivity(intent);
            }
        });

        //Xử lý nút Button chuyển trang Đặt Tiệc
        btnDatTiec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BookParty.class);
                getActivity().startActivity(intent);

            }
        });
        //Gọi dữ liệu lên màn hình
        customAdapter_banh = new BanhAdapter(getContext(), R.layout.banh_listview, data_banh);
        lvDanhSach.setAdapter(customAdapter_banh);

        //Xử lý nút Button chuyển list Bánh
        btnBanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gọi dữ liệu lên màn hình
                customAdapter_banh = new BanhAdapter(getContext(), R.layout.banh_listview, data_banh);
                lvDanhSach.setAdapter(customAdapter_banh);
                index = "banh";
            }
        });

        //Xử lý nút Button chuyển list Nước Uống
        btnNuocUong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gọi dữ liệu lên màn hình
                customAdapter_nuoc = new NuocAdapter(getContext(), R.layout.nuoc_listview, data_nuoc);
                lvDanhSach.setAdapter(customAdapter_nuoc);
                index = "nuoc";
            }
        });

        //Xử lý nút ListView khai báo thông tin Sản Phẩm
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int vitri, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final String[] danhsach = {"Thông tin"};
                builder.setItems(danhsach, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (danhsach[i]) {
                            case "Thông tin":
                                Intent intent = new Intent(getActivity(), Product_chi_tiet.class);
                                if (index == "banh") {
                                    banh = data_banh.get(vitri);
                                    intent.putExtra("motabanh", banh.getMoTa());
                                } else {
                                    nuoc = data_nuoc.get(vitri);
                                    intent.putExtra("motanuoc", nuoc.getMoTa());
                                    intent.putExtra("tenNuoc", nuoc.getTenNuoc());
                                }


                                intent.putExtra("index", index);

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