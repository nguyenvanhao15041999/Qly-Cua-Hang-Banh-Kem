package com.example.projectchuyende.ui.account;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projectchuyende.R;

public class Staff_inform extends Fragment {
    Button btn_taikhoan;
    TextView txtMaNV, txtTenNV, txtChucvu, txtSDT, txtGioitinh, txtEmail, txtDiachi, txtLuong;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_staff_inform, container, false);

        btn_taikhoan = root.findViewById(R.id.btntaikhoan);
        txtMaNV = root.findViewById(R.id.txtmanv);
        txtTenNV = root.findViewById(R.id.txtnamenv);
        txtChucvu = root.findViewById(R.id.txtchucvunv);
        txtSDT = root.findViewById(R.id.txtsdtnv);
        txtGioitinh = root.findViewById(R.id.txtGioitinh);
        txtEmail = root.findViewById(R.id.txtmail);
        txtDiachi = root.findViewById(R.id.txtDiaChi);
        txtLuong = root.findViewById(R.id.txtLuong);
        setEvent();
        return root;
    }

    public void setEvent() {
txtTenNV.setText(getArguments().getString("Tennv"));

        btn_taikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Change_account.class);
                getActivity().startActivity(intent);
            }
        });
    }

}