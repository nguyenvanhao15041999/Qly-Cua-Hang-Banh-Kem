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
import com.example.projectchuyende.ui.bill.Bill;

public class Staff_inform extends AppCompatActivity {
    Button btn_taikhoan;
    TextView txtMaNV, txtTenNV, txtChucvu, txtSDT, txtGioitinh, txtEmail, txtLuong;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_inform);

        btn_taikhoan = findViewById(R.id.btntaikhoan);
        txtMaNV = findViewById(R.id.txtmanv);
        txtTenNV = findViewById(R.id.txtnamenv);
        txtChucvu = findViewById(R.id.txtchucvunv);
        txtSDT = findViewById(R.id.txtsdtnv);
        txtGioitinh = findViewById(R.id.txtGioitinh);
        txtEmail = findViewById(R.id.txtmail);
        txtLuong = findViewById(R.id.txtLuong);
        setEvent();

    }

    public void setEvent() {
        Intent intent=getIntent();
        txtTenNV.setText(intent.getStringExtra("Tennv"));
        txtMaNV.setText(intent.getStringExtra("Manv"));
        txtLuong.setText(intent.getStringExtra("luong"));
        txtEmail.setText(intent.getStringExtra("email"));
        txtGioitinh.setText(intent.getStringExtra("gioitinh"));
        txtSDT.setText(intent.getStringExtra("SDT"));
        txtChucvu.setText(intent.getStringExtra("Chucvu"));
        btn_taikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Staff_inform.this, Account.class);
                startActivity(intent);
            }
        });
    }


}