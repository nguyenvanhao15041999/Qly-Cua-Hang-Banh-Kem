package com.example.projectchuyende.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projectchuyende.R;
import com.example.projectchuyende.model.Nhanvien;

import java.util.ArrayList;

public class ListStaffAdapter extends ArrayAdapter<Nhanvien> {
    Context context;
    int resource;
    ArrayList<Nhanvien> dataNhanvien;

    public ListStaffAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Nhanvien> dataNhanvien) {
        super(context, resource, dataNhanvien);
        this.context = context;
        this.resource = resource;
        this.dataNhanvien = dataNhanvien;
    }

    @Override
    public int getCount() {
        return dataNhanvien.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View viewNV=convertView;
        
        if (viewNV==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewNV = inflater.inflate(R.layout.show_liststaff, null);
        }
        Nhanvien nhanvien=getItem(position);
        if (nhanvien != null) {

            TextView NameStaff = viewNV.findViewById(R.id.tv_nameStaff_LS);
            TextView MemberStaff = viewNV.findViewById(R.id.tv_MemberStaff_LS);
            ImageView imgStaff=viewNV.findViewById(R.id.imgListStaff);

            NameStaff.setText("Ten NV: " + nhanvien.getName());
            MemberStaff.setText("Chuc Vu NV: " + nhanvien.getChucvu());
            imgStaff.setImageResource(R.drawable.ban);

        }
        return viewNV;
    }
}
