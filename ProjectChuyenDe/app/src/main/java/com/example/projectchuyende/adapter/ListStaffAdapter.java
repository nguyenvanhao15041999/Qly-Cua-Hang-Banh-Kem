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

public class ListStaffAdapter extends ArrayAdapter {
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
        View viewNhanvien;
        if (convertView==null){
            viewNhanvien = View.inflate(parent.getContext(),resource,null);
        }else viewNhanvien=convertView;
        TextView NameStaff=viewNhanvien.findViewById(R.id.tv_nameStaff_LS);
        TextView MemberStaff=viewNhanvien.findViewById(R.id.tv_MemberStaff_LS);

        final Nhanvien nhanvien = this.dataNhanvien.get(position);
        NameStaff.setText("Ten NV: " + nhanvien.getsStaffName());
        MemberStaff.setText("Chuc Vu NV: " + nhanvien.getsMember());
        ImageView menu_listStaff = viewNhanvien.findViewById(R.id.imgListStaff);
        menu_listStaff.setImageResource(R.drawable.ban);
        return viewNhanvien;
    }
}
