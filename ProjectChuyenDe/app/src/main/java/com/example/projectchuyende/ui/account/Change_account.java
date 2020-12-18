package com.example.projectchuyende.ui.account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectchuyende.R;
import com.example.projectchuyende.model.Nhanvien;

public class Change_account extends AppCompatActivity {
    Button btntaotaikhoan;
    EditText edtManv, edtTennv, edtsdt, edtmatkhau, edtTaikhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_account);
        btntaotaikhoan = findViewById(R.id.btnTao);
       // edtManv = findViewById(R.id.txtManv);
        edtTennv = findViewById(R.id.txtHoTen);
        edtsdt = findViewById(R.id.txtsdtnv);
        edtTaikhoan = findViewById(R.id.txtAccount);
        edtmatkhau = findViewById(R.id.txtpass);
        btntaotaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nhanvien nhanvien = new Nhanvien();
                if (nhanvien != null) {
                    if (edtManv.length() == 0) {
                        Toast.makeText(Change_account.this, "Vui lòng nhập mã nhân viên", Toast.LENGTH_SHORT).show();
                    } else if (edtTennv.length() == 0) {
                        Toast.makeText(Change_account.this, "Vui lòng nhập tên nhân viên", Toast.LENGTH_SHORT).show();
                    } else if (edtsdt.length() == 0) {
                        Toast.makeText(Change_account.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                    } else if (edtTaikhoan.length() == 0) {
                        Toast.makeText(Change_account.this, "Vui lòng nhập tài khoản", Toast.LENGTH_SHORT).show();
                    } else if (edtmatkhau.length() == 0) {
                        Toast.makeText(Change_account.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                    } else if (edtManv.length() < 5 || edtTennv.length() < 5 || edtsdt.length() < 5 || edtTaikhoan.length() < 5 || edtmatkhau.length() < 5) {
                        Toast.makeText(Change_account.this, "Điền ít nhất 5 ký tự cho tất cả các trường!!!", Toast.LENGTH_SHORT).show();

                    }

                }
            }

        });
    }

//    private Nhanvien createNhanvien() {
//        String manv = edtManv.getText().toString();
//        String tennv = edtTennv.getText().toString();
//        String sdt = edtsdt.getText().toString();
//        String taikhoan = edtTaikhoan.getText().toString();
//        String password = edtmatkhau.getText().toString();
//        //Nhanvien nhanvien = new Nhanvien("",manv, tennv, sdt,taikhoan, password);
//        return Nhanvien;
//    }
}