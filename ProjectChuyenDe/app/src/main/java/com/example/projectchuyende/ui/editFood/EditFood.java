package com.example.projectchuyende.ui.editFood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectchuyende.R;

public class EditFood extends AppCompatActivity {


    EditText edtTenSanPham, edtLoaiSanPham , edtDiaChi, edtGia,edtHinhAnh;
    Button btnSuaMon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);

        setControl();
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