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
import com.example.projectchuyende.adapter.HoaDonAdapter;
import com.example.projectchuyende.adapter.TableAdapter;
import com.example.projectchuyende.model.Desk;
import com.example.projectchuyende.model.HoaDon;
import com.example.projectchuyende.ui.pay.PayFragment;
import com.example.projectchuyende.ui.table.FirebaseBan;

import java.util.ArrayList;

public class Bill extends AppCompatActivity {
    ImageView imgBack;
    ListView lvDanhSachV;
    Button btnHuy, btnThanhToan;
    ArrayList<HoaDon> data_HD = new ArrayList<>();
    HoaDonAdapter customAdapter_bill;
    FirebaseHoaDon FirebaseHoaDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        Toolbar toolbar = findViewById(R.id.toolbarbill);
        imgBack= findViewById(R.id.imgBack);
        btnHuy= findViewById(R.id.btnHuy);
        lvDanhSachV= findViewById(R.id.lvDanhSachHD);
        FirebaseHoaDon = new FirebaseHoaDon(getApplication());
        btnThanhToan= findViewById(R.id.btnThanhToan);

        setSupportActionBar(toolbar);
        setEvent();
    }

    public void setEvent() {
        //Gọi Dữ liệu Bánh từ Firebase
        if (customAdapter_bill == null) {
            FirebaseHoaDon.LoadDSHoaDon(new FirebaseHoaDon.IListener() {
                @Override
                public void onSuccess() {
                    data_HD.addAll(FirebaseHoaDon.getArrHD());
                    customAdapter_bill = new HoaDonAdapter(getApplication(), R.layout.listview_bill, data_HD);
                    lvDanhSachV.setAdapter(customAdapter_bill);
                }

                @Override
                public void onFail() {

                }
            });

        } else {
            customAdapter_bill.notifyDataSetChanged();
        }



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
