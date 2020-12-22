package com.example.projectchuyende.ui.listdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectchuyende.R;
import com.example.projectchuyende.model.Desk;

public class ThongTinban extends AppCompatActivity {
    TextView txtTenban, txtSonguoi, txtKhuvuc;
    Button btnThem;
    ImageView imgBan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tinban);
        btnThem = findViewById(R.id.btnthemTTB);
        txtTenban = findViewById(R.id.tvNameTTB);
        txtSonguoi = findViewById(R.id.tvSonguoiTTB);
        txtKhuvuc = findViewById(R.id.tvKhuvucTTB);
        imgBan=findViewById(R.id.imgThongtinban);
        setEvent();
    }

    private void setEvent() {
        Intent intent = getIntent();
        txtTenban.setText(intent.getStringExtra("Tenban"));
        txtSonguoi.setText(String.valueOf(intent.getStringExtra("Songuoi")));
        txtKhuvuc.setText(intent.getStringExtra("Khuvuc"));
        boolean tinhtrang = intent.getBooleanExtra("Tinhtrang", false);
        if (tinhtrang) {
            imgBan.setImageResource(R.drawable.table_full);
        } else {
            imgBan.setImageResource(R.drawable.table_rong);
        }

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), ListDesk.class);
                startActivity(intent);
            }
        });
    }
}