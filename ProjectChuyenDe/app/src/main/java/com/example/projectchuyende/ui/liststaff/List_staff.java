package com.example.projectchuyende.ui.liststaff;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projectchuyende.R;
import com.example.projectchuyende.adapter.ListStaffAdapter;
import com.example.projectchuyende.firebaseallManager.FirebaseallManager;
import com.example.projectchuyende.model.Nhanvien;
import com.example.projectchuyende.ui.account.Staff_inform;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class List_staff extends Fragment {
    ListView lv_listStaff;
    ArrayList<Nhanvien> arrdata_listStaff = new ArrayList<>();
    ListStaffAdapter ListStaffadapter;
    FirebaseallManager firebaseallManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_list_staff, container, false);
        lv_listStaff = root.findViewById(R.id.lv_listStaff);
        firebaseallManager = new FirebaseallManager(getActivity());
        setEvent();
        return root;

    }


    private void setEvent() {
        if (ListStaffadapter == null) {
            firebaseallManager.loadDSNhanVien(new FirebaseallManager.IListener() {
                @Override
                public void onSuccess() {
                    arrdata_listStaff.addAll(firebaseallManager.getArrNhanvien());
                    ListStaffadapter = new ListStaffAdapter(getActivity(), R.layout.show_liststaff, arrdata_listStaff);
                    lv_listStaff.setAdapter(ListStaffadapter);
                }

                @Override
                public void onFail() {

                }
            });
        } else {
            ListStaffadapter.notifyDataSetChanged();
        }
    }

}