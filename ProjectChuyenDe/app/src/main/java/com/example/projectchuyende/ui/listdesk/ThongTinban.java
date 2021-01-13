package com.example.projectchuyende.ui.listdesk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectchuyende.R;
import com.example.projectchuyende.model.Desk;
import com.example.projectchuyende.ui.pay.PayFragment;

public class ThongTinban extends AppCompatActivity {
    TextView txtTenban, txtSonguoi, txtKhuvuc;
    Button btnDat;
    ImageView imgBan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tinban);

        btnDat = findViewById(R.id.btnDatTTB);
        txtTenban = findViewById(R.id.tvNameTTB);
        txtSonguoi = findViewById(R.id.tvSonguoiTTB);
        txtKhuvuc = findViewById(R.id.tvKhuvucTTB);
        imgBan = findViewById(R.id.imgThongtinban);
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

        btnDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PayFragment.class);
                startActivity(intent);
            }
        });
    }
}
