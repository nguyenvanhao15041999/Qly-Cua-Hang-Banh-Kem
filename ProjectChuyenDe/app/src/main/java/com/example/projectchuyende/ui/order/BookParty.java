package com.example.projectchuyende.ui.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.projectchuyende.R;
import com.example.projectchuyende.ui.bill.Bill;

public class BookParty extends AppCompatActivity {
    ImageView imgBack;
    Button btnDat, btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookparty);
        Toolbar toolbar = findViewById(R.id.toolbarbookdesk);
        imgBack= findViewById(R.id.imgBack);
        btnDat= findViewById(R.id.btnDat);
        btnHuy= findViewById(R.id.btnHuy);
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

        btnDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookParty.this, Bill.class);
                startActivity(intent);
            }
        });
    }
}