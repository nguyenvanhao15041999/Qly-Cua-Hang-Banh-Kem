package com.example.projectchuyende.ui.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.projectchuyende.R;

public class BookParty extends AppCompatActivity {
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookparty);
        Toolbar toolbar = findViewById(R.id.toolbarbookparty);
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