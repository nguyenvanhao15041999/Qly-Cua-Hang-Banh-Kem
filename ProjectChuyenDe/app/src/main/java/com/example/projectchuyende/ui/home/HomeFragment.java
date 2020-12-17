package com.example.projectchuyende.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.projectchuyende.R;
import com.example.projectchuyende.adapter.BanhAdapter;
import com.example.projectchuyende.model.Banh;
import com.example.projectchuyende.ui.account.Product_chi_tiet;
import com.example.projectchuyende.ui.order.BookParty;
import com.example.projectchuyende.ui.order.Bookdesk;
import com.example.projectchuyende.ui.table.Table;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    Button btnKhu, btnDatTiec, btnBanh, btnNuocUong;
    ListView lvDanhSach;

    int index = -1;

    ArrayList<Banh> data_banh = new ArrayList<>();

    BanhAdapter customAdapter_banh;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        btnKhu = root.findViewById(R.id.btnKhu);
        btnDatTiec = root.findViewById(R.id.btnDattiec);
        btnBanh = root.findViewById(R.id.btnBanh);
        btnNuocUong = root.findViewById(R.id.btnNuoc);
        lvDanhSach = root.findViewById(R.id.lvDanhsachHome);
        setEvent();
        return root;
    }

    public void setEvent() {

        //Gọi hàm tạo
        KhoiTao();

        //Gọi dữ liệu lên màn hình
        customAdapter_banh = new BanhAdapter(getContext(), R.layout.banh_listview, data_banh);
        lvDanhSach.setAdapter(customAdapter_banh);
        
        btnKhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Table.class);
                getActivity().startActivity(intent);
            }
        });

        btnDatTiec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BookParty.class);
                getActivity().startActivity(intent);
            }
        });

        btnBanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Banh.class);
                getActivity().startActivity(intent);
            }
        });

    }

    // Tạo dữ liệu
    private void KhoiTao() {
        //Gọi dữ liệu có sẵn
        Banh banh = new Banh();
        banh.setTenBanh("Bánh Sinh Nhật");
        banh.setGiaCa("250.000đ");
        banh.setDiaChi("Thiên Ân");
        banh.setGiam("5%");
        data_banh.add(banh);

        //Gọi dữ liệu có sẵn
        Banh banh1 = new Banh();
        banh1.setTenBanh("Flan");
        banh1.setGiaCa("10.000đ");
        banh1.setDiaChi("Thiên Ân");
        banh1.setGiam("");
        data_banh.add(banh1);

        //Gọi dữ liệu có sẵn
        Banh banh2 = new Banh();
        banh2.setTenBanh("Bánh Ngọt");
        banh2.setGiaCa("10.000đ");
        banh2.setDiaChi("Thiên Hương");
        banh2.setGiam("1%");
        data_banh.add(banh2);

        //Gọi dữ liệu có sẵn
        Banh banh3 = new Banh();
        banh3.setTenBanh("Bánh Kem");
        banh3.setGiaCa("100.000đ");
        banh3.setDiaChi("Thiên Ân");
        banh3.setGiam("2%");
        data_banh.add(banh3);

        //Gọi dữ liệu có sẵn
        Banh banh4 = new Banh();
        banh4.setTenBanh("Bánh Trai Cây");
        banh4.setGiaCa("30.000đ");
        banh4.setDiaChi("Thiên Ân");
        banh4.setGiam("1%");
        data_banh.add(banh4);
    }

}