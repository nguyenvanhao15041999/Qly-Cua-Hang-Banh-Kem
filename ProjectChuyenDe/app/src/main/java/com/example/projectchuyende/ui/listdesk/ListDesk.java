package com.example.projectchuyende.ui.listdesk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
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
                final String[] items = {"Thongtin", "Xóa", "Sửa"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//Thiết lập title
                builder.setTitle("Chuc nang");
//Thiết lập item
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    //Xử lý sự kiện
                    public void onClick(DialogInterface dialog, int which) {
                        if (items.equals("Thongtin")){
                            Toast.makeText(getContext(),"thong tin",Toast.LENGTH_LONG).show();
                        }else {
                            if (items.equals("Xóa")){
                                Toast.makeText(getContext(),"xoa",Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(getContext(),"Sua",Toast.LENGTH_LONG).show();
                            }
                        }

                        /*switch() {
                            case items[0]:
                                Toast.makeText(getContext(),"thong tin",Toast.LENGTH_LONG).show();

                                break;
                            case "xoa":
                                Toast.makeText(getContext(),"xoa",Toast.LENGTH_LONG).show();

                                break;
                            default:
                                Toast.makeText(getContext(),"sua",Toast.LENGTH_LONG).show();

                                break;
                        }*/
                    }
                });
//Hiển thị dialog
                builder.show();
            }
        });
    }

    private void dataviewDesk() {
        Desk desk=new Desk();
        desk.setsSothutu("ban 1");
        dataDesk.add(desk);
        Desk desk1=new Desk();
        desk1.setsSothutu("ban 2");
        dataDesk.add(desk1);
        Desk desk2=new Desk();
        desk2.setsSothutu("ban 3");
        dataDesk.add(desk2);
        Desk desk3=new Desk();
        desk3.setsSothutu("ban 4");
        dataDesk.add(desk3);
    }
}
