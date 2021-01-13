package com.example.projectchuyende.ui.table;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import com.example.projectchuyende.SanPham.FirebaseBanh;
import com.example.projectchuyende.SanPham.FirebaseNuoc;
import com.example.projectchuyende.adapter.BanhAdapter;
import com.example.projectchuyende.adapter.DeskAdapter;
import com.example.projectchuyende.adapter.NuocAdapter;
import com.example.projectchuyende.adapter.TableAdapter;
import com.example.projectchuyende.firebaseallManager.FirebaseListDesk;
import com.example.projectchuyende.model.BanDat;
import com.example.projectchuyende.model.Banh;
import com.example.projectchuyende.model.Desk;
import com.example.projectchuyende.model.Nuoc;
import com.example.projectchuyende.model.User;
import com.example.projectchuyende.ui.account.Product_chi_tiet;
import com.example.projectchuyende.ui.listdesk.ThongTinban;
import com.example.projectchuyende.ui.order.BookParty;
import com.example.projectchuyende.ui.order.Bookdesk;

import java.util.ArrayList;

public class Table extends AppCompatActivity {
    ImageView imgBack;
    Button btnDatBan;
    GridView gvBan;
    ArrayList<BanDat> data_ban = new ArrayList<>();
    ArrayList<Desk> dataDesk = new ArrayList<>();
    TableAdapter customAdapter_ban;
    FirebaseBan FirebaseBan;
    Desk desk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        Toolbar toolbar = findViewById(R.id.toolbartable);
        imgBack = findViewById(R.id.imgBack);
        btnDatBan = findViewById(R.id.btnDatBan);
        gvBan = findViewById(R.id.gvBan);
        FirebaseBan = new FirebaseBan(getApplication());
        setSupportActionBar(toolbar);
        setEvent();
    }

    private void setEvent() {

        //Gọi Dữ liệu Bánh từ Firebase
        if (customAdapter_ban == null) {
            FirebaseBan.LoadDSBan(new FirebaseBan.IListener() {
                @Override
                public void onSuccess() {
                    data_ban.addAll(FirebaseBan.getArrBan());
                    customAdapter_ban = new TableAdapter(getApplication(), R.layout.grid_ban, data_ban);
                    gvBan.setAdapter(customAdapter_ban);
                }

                @Override
                public void onFail() {
                }
            });
        } else {
            customAdapter_ban.notifyDataSetChanged();
        }

        //Xử lý nút ListView khai báo thông tin Sản Phẩm
        gvBan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int vitri, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplication());
                final String[] danhsach = {"Thông tin"};
                builder.setItems(danhsach,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (danhsach[i]) {
                            case "Thông tin":
                                Intent intent = new Intent(getApplication(), Product_chi_tiet.class);
                                startActivity(intent);
                                break;
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

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


