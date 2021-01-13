package com.example.projectchuyende.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projectchuyende.R;
import com.example.projectchuyende.model.HoaDon;

import java.util.ArrayList;

public class HoaDonAdapter extends ArrayAdapter {

    //Hàm Custom
    Context context;
    int resource;
    ArrayList<HoaDon> data_hoadon;
    public HoaDonAdapter(Context context, int resource, ArrayList<HoaDon> data_hoadon) {
        super(context, resource, data_hoadon);
        this.context = context;
        this.resource = resource;
        this.data_hoadon = data_hoadon;
    }


    //Hàm getCount
    @Override
    public int getCount() {
        return data_hoadon.size();
    }

    //Hàm getView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewHD=convertView;

        if (viewHD==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewHD = inflater.inflate(R.layout.listview_bill, null);
        }
        HoaDon hoaDon= (HoaDon) getItem(position);

        if (hoaDon != null) {

            TextView SoTienV = viewHD.findViewById(R.id.tvSoTienV);
            TextView TenBanhV = viewHD.findViewById(R.id.tvTenBanhV);
            TextView SoLuongV = viewHD.findViewById(R.id.tvSoLuongV);
            ImageView imgHoaDon=viewHD.findViewById(R.id.imgHoaDon);



            SoLuongV.setText(hoaDon.getSoLuongV());
            SoTienV.setText(hoaDon.getSoTienV());
            TenBanhV.setText(hoaDon.getTenBanhV());
            Glide.with(getContext()).load(hoaDon.getImgHoaDonV()).into(imgHoaDon);

        }
        return viewHD;
    }
}
