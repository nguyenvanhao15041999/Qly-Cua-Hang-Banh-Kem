package com.example.projectchuyende.ui.listdesk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projectchuyende.R;
import com.example.projectchuyende.adapter.DeskAdapter;
import com.example.projectchuyende.model.Desk;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class ListDesk extends Fragment {
    GridView gv_ListDesk;
    ArrayList<Desk> dataDesk = new ArrayList<>();
    DeskAdapter deskAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_listdesk, container, false);
        gv_ListDesk = root.findViewById(R.id.gv_listDesk);
        setEvent();
        return root;
    }

    private void setEvent() {
        dataviewDesk();
        deskAdapter = new DeskAdapter(getContext(), R.layout.show_listdesk, dataDesk);
        gv_ListDesk.setAdapter(deskAdapter);

        gv_ListDesk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builderChucnang = new AlertDialog.Builder(getActivity());
                builderChucnang.setTitle("Chức Năng");
                final String[] chucnang = {"Sửa", "Xóa"};
                final AlertDialog.Builder builderSua = new AlertDialog.Builder(getActivity());
                builderSua.setTitle(" Sửa bàn ");
                builderChucnang.setItems(chucnang, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (chucnang[i]) {
                            case "Sửa":
                                View customListdesk = getLayoutInflater().inflate(R.layout.dialog_listdesk_custom, null);
                                builderSua.setView(customListdesk);
                                final EditText txtTenbanLD = customListdesk.findViewById(R.id.txtTenBanLD_dialog);
                                final EditText txtSonguoiLD = customListdesk.findViewById(R.id.txtSonguoiLD_dialog);
                                final Button btnHuy = customListdesk.findViewById(R.id.btnCancelLD_dialog);
                                Button btnDongy = customListdesk.findViewById(R.id.btnAcceptLD_dialog);
                                final Spinner spKhuvuc = customListdesk.findViewById(R.id.spKhuvucLD_dialog);
                                btnDongy.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(getActivity(), "Tên bàn là: " + txtTenbanLD.getText().toString() + "\n"
                                                + "Số người: " + txtSonguoiLD.getText().toString() + "\n"
                                                + "Khu vực: " + spKhuvuc.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                                    }
                                });
                                btnHuy.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                                        builder.setTitle("Bạn có muốn thoát?");
                                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int i) {
                                               Toast.makeText(getActivity(),"Dong y",Toast.LENGTH_LONG).show();
                                            }
                                        });
                                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                           dialogInterface.cancel();
                                            }
                                        });
                                        AlertDialog dialog=builder.create();
                                        dialog.show();
                                    }
                                });
                                AlertDialog dialogSua = builderSua.create();
                                dialogSua.show();
                                break;
                            default:
                                Toast.makeText(getActivity(), "Da xoa", Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                });
                AlertDialog dialogChucnang = builderChucnang.create();
                dialogChucnang.show();
            }
        });
    }

    private void dataviewDesk() {
        Desk desk = new Desk();
        desk.setsSothutu("ban 1");
        dataDesk.add(desk);
        Desk desk1 = new Desk();
        desk1.setsSothutu("ban 2");
        dataDesk.add(desk1);
        Desk desk2 = new Desk();
        desk2.setsSothutu("ban 3");
        dataDesk.add(desk2);
        Desk desk3 = new Desk();
        desk3.setsSothutu("ban 4");
        dataDesk.add(desk3);
    }
}
