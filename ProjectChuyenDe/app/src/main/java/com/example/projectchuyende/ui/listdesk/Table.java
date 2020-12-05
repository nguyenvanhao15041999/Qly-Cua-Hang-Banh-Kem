package com.example.projectchuyende.ui.listdesk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.projectchuyende.R;
import com.example.projectchuyende.ui.order.Bookdesk;

public class Table extends AppCompatActivity {
    ImageView imgBack;
    Button btnDatBan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        Toolbar toolbar = findViewById(R.id.toolbarbookdesk);
        imgBack = findViewById(R.id.imgBack);
        btnDatBan = findViewById(R.id.btnDatBan);
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

        btnDatBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Table.this, Bookdesk.class);
                startActivity(intent);
            }
        });
    }
}