package com.example.projectchuyende.ui.account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectchuyende.R;

public class Product_chi_tiet extends AppCompatActivity {
    Button btn_taotaikhoan;
    EditText edtManv, edtTennv, edtsdt, edtmatkhau, edtTaikhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_chi_tiet);
    }
}