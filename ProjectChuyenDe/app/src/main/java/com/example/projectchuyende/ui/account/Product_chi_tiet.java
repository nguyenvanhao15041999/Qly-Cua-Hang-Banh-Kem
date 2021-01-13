package com.example.projectchuyende.ui.account;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectchuyende.R;
import com.example.projectchuyende.model.ThongtinBanh;
import com.example.projectchuyende.ui.table.FirebaseBan;

import java.util.ArrayList;

public class Product_chi_tiet extends AppCompatActivity {
    ArrayList<ThongtinBanh> databanh = new ArrayList<>();
    EditText edtMotaSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_chi_tiet);
        edtMotaSP=findViewById(R.id.edtMotaSP);
        setEvent();
    }

    private void setEvent() {
        String sosanh="banh";
        Intent intent=getIntent();
        if (intent.getStringExtra("index")==sosanh){
            edtMotaSP.setText(intent.getStringExtra("motabanh"));
        }else{
            edtMotaSP.setText(intent.getStringExtra("motanuoc"));
        }
    }
}