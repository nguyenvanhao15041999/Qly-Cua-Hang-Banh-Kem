package com.example.projectchuyende.ui.bill;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.projectchuyende.R;
import com.example.projectchuyende.ui.pay.PayFragment;

import java.util.ArrayList;

public class Bill extends AppCompatActivity {
    ImageView imgBack;
    ListView lvDanhSach;
    Button btnHuy, btnThanhToan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        Toolbar toolbar = findViewById(R.id.toolbarbill);
        imgBack= findViewById(R.id.imgBack);
        btnHuy= findViewById(R.id.btnHuy);
        lvDanhSach= findViewById(R.id.lvDanhSachHD);
        btnThanhToan= findViewById(R.id.btnThanhToan);

        setSupportActionBar(toolbar);
        setEvent();
    }

    public void setEvent() {


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bill.this, PayFragment.class);
                startActivity(intent);
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Bill.this);
                builder.setTitle("Thông Báo");
                builder.setMessage("Bạn có muốn Huỷ không?");
                builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
}
