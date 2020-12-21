package com.example.projectchuyende.ui.listdesk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;

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
    Desk desk;
    Dialog dialog;

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
                final AlertDialog.Builder builderChucnang = new AlertDialog.Builder(getActivity());
                builderChucnang.setTitle("Chức Năng");
                final String[] chucnang = {"Thêm", "Sửa", "Xóa"};
                final AlertDialog.Builder builderThem = new AlertDialog.Builder(getActivity());
                builderThem.setTitle(" Thêm bàn ");
                final AlertDialog.Builder builderSua = new AlertDialog.Builder(getActivity());
                builderSua.setTitle(" Sửa bàn ");
                builderChucnang.setItems(chucnang, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialogInterface, int i) {
                        switch (chucnang[i]) {
                            case "Thêm":
                                View customListdesk = getLayoutInflater().inflate(R.layout.dialog_listdesk_custom, null);
                                builderThem.setView(customListdesk);
                                final EditText txtTenbanLD = customListdesk.findViewById(R.id.txtTenBanLD_dialog);
                                final EditText txtSonguoiLD = customListdesk.findViewById(R.id.txtSonguoiLD_dialog);
                                final Spinner spKhuVucLD = customListdesk.findViewById(R.id.spKhuvucLD_dialog);

                                final Button btnDong = customListdesk.findViewById(R.id.btnCancelLD_dialog);
                                final Button btnDongy = customListdesk.findViewById(R.id.btnAcceptLD_dialog);
                                desk = new Desk();
                                btnDongy.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (txtTenbanLD.length() == 0 && txtSonguoiLD.length() == 0) {
                                            Toast.makeText(getActivity(), "Mời nhập thông tin!", Toast.LENGTH_SHORT).show();
                                        } else {
                                            desk.setTenBan(txtTenbanLD.getText().toString());
                                            desk.setSoNguoi(Integer.parseInt(txtSonguoiLD.getText().toString()));
                                            desk.setKhuVuc(spKhuVucLD.getSelectedItem().toString());
                                            desk.setTinhTrang(false);
                                            dataDesk.add(desk);

                                            firebaseListDesk.ThemBan(desk, new FirebaseListDesk.IListener() {
                                                @Override
                                                public void onSuccess() {
                                                    Toast.makeText(getActivity(), "Thêm Thành Công!", Toast.LENGTH_SHORT).show();
                                                    txtTenbanLD.setText("");
                                                    txtSonguoiLD.setText(null);
                                                    spKhuVucLD.setSelection(0);
                                                }

                                                @Override
                                                public void onFail() {

                                                }
                                            });
                                            dataDesk.clear();
                                            deskAdapter.notifyDataSetChanged();
                                        }
                                    }

                                });

                                btnDong.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                    }
                                });
                                AlertDialog dialogThem = builderThem.create();
                                dialogThem.show();
                                break;

                            case "Sửa":
                                View customSua = getLayoutInflater().inflate(R.layout.dialog_listdesk_custom, null);
                                builderSua.setView(customSua);

                                int index = -1;

                                final EditText txtTenbanLD1 = customSua.findViewById(R.id.txtTenBanLD_dialog);
                                final EditText txtSonguoiLD1 = customSua.findViewById(R.id.txtSonguoiLD_dialog);
                                final Spinner spKhuVucLD1 = customSua.findViewById(R.id.spKhuvucLD_dialog);

                                Button btnDong1 = customSua.findViewById(R.id.btnCancelLD_dialog);
                                final Button btnDongy1 = customSua.findViewById(R.id.btnAcceptLD_dialog);

                                desk = dataDesk.get(vitri);

                                txtTenbanLD1.setText(desk.getTenBan());
                                txtSonguoiLD1.setText(String.valueOf(desk.getSoNguoi()));
                                spKhuVucLD1.setSelection(dataDesk.indexOf(desk.getKhuVuc()));
                                dataDesk.clear();
                                btnDongy1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        desk.setTenBan(txtTenbanLD1.getText().toString());
                                        desk.setSoNguoi(Integer.parseInt(txtSonguoiLD1.getText().toString()));
                                        desk.setKhuVuc(spKhuVucLD1.getSelectedItem().toString());
                                        desk.setTinhTrang(false);

                                        firebaseListDesk.SuaBan(desk.getMaBan(), desk, new FirebaseListDesk.IListener() {
                                            @Override
                                            public void onSuccess() {
                                                Toast.makeText(getActivity(), "Đã Sửa", Toast.LENGTH_LONG).show();
                                            }

                                            @Override
                                            public void onFail() {

                                            }
                                        });
                                        deskAdapter.notifyDataSetChanged();
                                    }
                                });


                                AlertDialog dialogSua = builderSua.create();
                                dialogSua.show();
                                break;
                            default:
                                desk = dataDesk.get(vitri);
                                final String idMaBan = desk.getMaBan();
                                firebaseListDesk.xoaBan(idMaBan, new FirebaseListDesk.IListener() {
                                    @Override
                                    public void onSuccess() {
                                        Toast.makeText(getActivity(), "Da xoa", Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void onFail() {

                                    }
                                });
                                dataDesk.clear();
                                deskAdapter.notifyDataSetChanged();
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
