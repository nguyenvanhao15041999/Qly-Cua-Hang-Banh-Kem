package com.example.projectchuyende.ui.bill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.projectchuyende.R;
import com.example.projectchuyende.ui.order.Bookdesk;

public class Bill extends AppCompatActivity {
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        Toolbar toolbar = findViewById(R.id.toolbarbill);
        imgBack= findViewById(R.id.imgBack);
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
    }
}
