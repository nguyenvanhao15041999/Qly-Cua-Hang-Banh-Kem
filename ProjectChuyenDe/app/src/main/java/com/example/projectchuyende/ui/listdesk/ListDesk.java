package com.example.projectchuyende.ui.listdesk;

import android.app.AlertDialog;
import android.app.Dialog;
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
import com.example.projectchuyende.adapter.ListStaffAdapter;
import com.example.projectchuyende.firebaseallManager.FirebaseListDesk;
import com.example.projectchuyende.model.Desk;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class ListDesk extends Fragment {
    GridView gv_ListDesk;
    ArrayList<Desk> dataDesk = new ArrayList<>();
    DeskAdapter deskAdapter;
    FirebaseListDesk firebaseListDesk;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_listdesk, container, false);
        gv_ListDesk = root.findViewById(R.id.gv_listDesk);
        firebaseListDesk = new FirebaseListDesk(getActivity());
        setEvent();
        return root;
    }

    private void setEvent() {
        if (deskAdapter == null) {
            firebaseListDesk.LoadListDesk(new FirebaseListDesk.IListener() {
                @Override
                public void onSuccess() {
                    dataDesk.addAll(firebaseListDesk.getArrDesk());
                    deskAdapter = new DeskAdapter(getContext(), R.layout.show_listdesk, dataDesk);
                    gv_ListDesk.setAdapter(deskAdapter);
                }

                @Override
                public void onFail() {

                }
            });
        } else {
            deskAdapter.notifyDataSetChanged();
        }

        gv_ListDesk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int vitri, long l) {
                AlertDialog.Builder builderChucnang = new AlertDialog.Builder(getActivity());
                builderChucnang.setTitle("Chức Năng");
                final String[] chucnang = {"Sửa", "Xóa"};
                final AlertDialog.Builder builderSua = new AlertDialog.Builder(getActivity());
                builderSua.setTitle(" Sửa bàn ");
                builderChucnang.setItems(chucnang, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialogInterface, int i) {
                        switch (chucnang[i]) {
                            case "Sửa":
                                View customListdesk = getLayoutInflater().inflate(R.layout.dialog_listdesk_custom, null);
                                builderSua.setView(customListdesk);
                                final EditText txtTenbanLD = customListdesk.findViewById(R.id.txtTenBanLD_dialog);
                                final EditText txtSonguoiLD = customListdesk.findViewById(R.id.txtSonguoiLD_dialog);
                                final Spinner spKhuVucLD = customListdesk.findViewById(R.id.spKhuvucLD_dialog);

                                final Button btnHuy = customListdesk.findViewById(R.id.btnCancelLD_dialog);
                                Button btnDongy = customListdesk.findViewById(R.id.btnAcceptLD_dialog);
                                int index = -1;
                                final Desk suadesk = dataDesk.get(vitri);
                                txtTenbanLD.setText(suadesk.getTenBan());
                                txtSonguoiLD.setText(String.valueOf(suadesk.getSoNguoi()));
                                spKhuVucLD.setSelection(dataDesk.indexOf(suadesk.getKhuVuc()));

                                btnDongy.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        firebaseListDesk.SuaBan(suadesk.getMaBan(), suadesk, new FirebaseListDesk.IListener() {
                                            @Override
                                            public void onSuccess() {
                                                Toast.makeText(getActivity(), "Sửa sản phẩm thành công!", Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void onFail() {

                                            }
                                        });
                                    }
                                });

                                btnHuy.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        AlertDialog.Builder builderSua = new AlertDialog.Builder(getActivity());
                                        builderSua.setTitle("Warning!");
                                        builderSua.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterf, int i) {

                                            }
                                        });
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
}
