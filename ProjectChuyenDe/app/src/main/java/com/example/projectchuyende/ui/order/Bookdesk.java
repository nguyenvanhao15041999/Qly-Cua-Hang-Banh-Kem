package com.example.projectchuyende.ui.order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.projectchuyende.R;
<<<<<<< Updated upstream
import com.example.projectchuyende.ui.home.HomeFragment;
=======
import com.example.projectchuyende.ui.listdesk.Table;
import com.example.projectchuyende.ui.pay.Bill;
>>>>>>> Stashed changes
import com.google.android.material.navigation.NavigationView;

public class Bookdesk extends AppCompatActivity {
    ImageView imgBack;
    Button btnDat, btnHuy;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdesk);
        Toolbar toolbar = findViewById(R.id.toolbarbookdesk);
<<<<<<< Updated upstream
=======
        imgBack = findViewById(R.id.imgBack);
        btnDat = findViewById(R.id.btnDat);
        btnHuy = findViewById(R.id.btnHuy);
>>>>>>> Stashed changes
        setSupportActionBar(toolbar);
        setControl();
        setEvent();
    }

    public void setControl() {
        imgBack= findViewById(R.id.imgBack);
        btnDat= findViewById(R.id.btnDat);
        btnHuy= findViewById(R.id.btnHuy);
    }

    public void setEvent() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
<<<<<<< Updated upstream

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Bookdesk.this);
                alertDialogBuilder.setTitle("Exit Application?");
                alertDialogBuilder
                        .setMessage("Click yes to exit!")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        
                                    }
                                })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
=======
>>>>>>> Stashed changes

        btnDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bookdesk.this, Bill.class);
                startActivity(intent);
            }
        });
    }
}
