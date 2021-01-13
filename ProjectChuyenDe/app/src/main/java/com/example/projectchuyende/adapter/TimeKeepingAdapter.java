package com.example.projectchuyende.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projectchuyende.R;
import com.example.projectchuyende.model.Nhan_Vien;
import com.example.projectchuyende.model.TimeKeeping;

import java.util.ArrayList;

public class TimeKeepingAdapter extends ArrayAdapter<TimeKeeping> {
    Context context;
    int resource;
    ArrayList<TimeKeeping> dataTime;

    public TimeKeepingAdapter(@NonNull Context context, int resource, @NonNull ArrayList<TimeKeeping> dataTime) {
        super(context, resource, dataTime);
        this.context=context;
        this.resource=resource;
        this.dataTime=dataTime;
    }

    @Override
    public int getCount() {
        return dataTime.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            view=layoutInflater.inflate(R.layout.show_timekeeping,null);
        }
        TimeKeeping timeKeeping=getItem(position);
        if (timeKeeping!=null){
            TextView txtTenNV=view.findViewById(R.id.tv_nameTK);
            TextView txtNgayCong=view.findViewById(R.id.tv_ngaycongTK);
            TextView txtTongGio=view.findViewById(R.id.tv_tonggioTK);
            TextView txtLuongCB=view.findViewById(R.id.tv_luongCBTK);
            TextView txtTongLuong=view.findViewById(R.id.tv_tongluongTK);

            txtTenNV.setText(timeKeeping.getTenNhanVien());
            txtNgayCong.setText(timeKeeping.getNgayCong());
            txtTongGio.setText(timeKeeping.getTongGio());
            txtLuongCB.setText(timeKeeping.getLuongCB());
            txtTongLuong.setText(timeKeeping.getTongLuong());
        }
        return view;
    }
}
