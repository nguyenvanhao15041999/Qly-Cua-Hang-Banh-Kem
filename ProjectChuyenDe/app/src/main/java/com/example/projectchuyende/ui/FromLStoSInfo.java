package com.example.projectchuyende.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.projectchuyende.R;
import com.example.projectchuyende.ui.liststaff.List_staff;

public class FromLStoSInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_l_sto_s_info);


        List_staff list_staff = new List_staff();
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.chuyentrang, list_staff, null).commit();
    }
}