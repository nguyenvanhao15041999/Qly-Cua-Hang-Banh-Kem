package com.example.projectchuyende.ui.account;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectchuyende.R;
import com.example.projectchuyende.model.ThongtinBanh;
import com.example.projectchuyende.ui.bill.Bill;
import com.example.projectchuyende.ui.table.FirebaseBan;

import java.util.ArrayList;

public class Product_chi_tiet extends AppCompatActivity {
    ArrayList<ThongtinBanh> databanh = new ArrayList<>();
    TextView edtMotaSP;
    TextView txtSo, txtSanpham;
    Button btnthem, btnCong, btnTru;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_chi_tiet);
        edtMotaSP=findViewById(R.id.edtMotaSP);
        btnthem = findViewById(R.id.btnthem);
        btnCong = findViewById(R.id.increaseQuantityBtn);
        btnTru = findViewById(R.id.decreaseQuantityBtn);
        txtSo = findViewById(R.id.quantity);
        txtSanpham = findViewById(R.id.tvEmpName);
        setEvent();
    }

    private void setEvent() {
        String sosanh="banh";
        Intent intent=getIntent();
        if (intent.getStringExtra("index")==sosanh){
            edtMotaSP.setText(intent.getStringExtra("motabanh"));
        }else{
            edtMotaSP.setText(intent.getStringExtra("motanuoc"));
            txtSanpham.setText(intent.getStringExtra("tenNuoc"));
        }
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cong;
                cong = index+1;
                txtSo.setText(String.valueOf(cong));
                index++;
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tru;
                if(index == 0){
                    Toast.makeText(getApplication(),"can not decrease any more",Toast.LENGTH_LONG).show();
                }else{
                    tru = index-1;
                    txtSo.setText(String.valueOf(tru));
                    index--;
                }}
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Product_chi_tiet.this, Bill.class);
                startActivity(intent);
            }
        });

    }
}