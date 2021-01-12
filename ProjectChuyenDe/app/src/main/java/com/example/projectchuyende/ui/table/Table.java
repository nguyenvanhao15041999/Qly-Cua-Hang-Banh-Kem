package com.example.projectchuyende.ui.table;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projectchuyende.R;
import com.example.projectchuyende.SanPham.FirebaseNuoc;
import com.example.projectchuyende.adapter.DeskAdapter;
import com.example.projectchuyende.adapter.NuocAdapter;
import com.example.projectchuyende.firebaseallManager.FirebaseListDesk;
import com.example.projectchuyende.model.Desk;
import com.example.projectchuyende.ui.listdesk.ThongTinban;
import com.example.projectchuyende.ui.order.BookParty;
import com.example.projectchuyende.ui.order.Bookdesk;

import java.util.ArrayList;

public class Table extends AppCompatActivity {
    ImageView imgBack;
    Button btnDatBan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        Toolbar toolbar = findViewById(R.id.toolbartable);
        imgBack = findViewById(R.id.imgBack);
        btnDatBan = findViewById(R.id.btnDatBan);
        setSupportActionBar(toolbar);
        setEvent();
    }

    private void setEvent() {
        btnDatBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Table.this, Bookdesk.class);
                startActivity(intent);
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}


