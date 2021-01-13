package com.example.projectchuyende.ui.editFood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.projectchuyende.R;

public class EditFood extends AppCompatActivity {


    EditText edtTenSanPham, edtLoaiSanPham, edtDiaChi, edtGia;
    ImageView edtHinhAnh;
    Button btnSuaMon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);

        setControl();
        setEvent();
    }

    private void setEvent() {
        Intent intent = getIntent();
        edtTenSanPham.setText(intent.getStringExtra("tenbanh"));
        edtDiaChi.setText(intent.getStringExtra("diachibanh"));
        edtGia.setText(intent.getStringExtra("giacabanh"));
        Glide.with(getApplicationContext()).load(intent.getStringExtra("imgbanh")).into(edtHinhAnh);


        edtTenSanPham.setText(intent.getStringExtra("tennuoc"));
        edtDiaChi.setText(intent.getStringExtra("diachinuoc"));
        edtGia.setText(intent.getStringExtra("giacanuoc"));
        Glide.with(getApplicationContext()).load(intent.getStringExtra("imgnuoc")).into(edtHinhAnh);
    }

    private void setControl() {
        edtTenSanPham = findViewById(R.id.edtTenSanPham);
        edtLoaiSanPham = findViewById(R.id.edtLoaiSanPham);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtGia = findViewById(R.id.edtGia);
        edtHinhAnh = findViewById(R.id.edtHinhAnh);
        btnSuaMon = findViewById(R.id.btnSuaMon);
    }
}