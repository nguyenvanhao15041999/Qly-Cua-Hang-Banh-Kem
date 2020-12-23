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
import com.example.projectchuyende.model.Banh;

import java.util.ArrayList;

public class BanhAdapter extends ArrayAdapter {
    //Hàm Custom
    Context context;
    int resource;
    ArrayList<Banh> data_Banh;

    public BanhAdapter(Context context, int resource, ArrayList<Banh> data_Banh) {
        super(context, resource, data_Banh);
        this.context = context;
        this.resource = resource;
        this.data_Banh = data_Banh;
    }


    //Hàm getCount
    @Override
    public int getCount() {
        return data_Banh.size();
    }

    //Hàm getView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewBanh=convertView;

        if (viewBanh==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewBanh = inflater.inflate(R.layout.banh_listview, null);
        }
        Banh banh= (Banh) getItem(position);

        if (banh != null) {

            TextView TenBanh = viewBanh.findViewById(R.id.tvTenBanh);
            TextView GiaCa = viewBanh.findViewById(R.id.tvGiaBan);
            TextView DiaChi = viewBanh.findViewById(R.id.tvDiaChi);
            TextView Giam = viewBanh.findViewById(R.id.tvGiam);
            ImageView imgAnhBanh=viewBanh.findViewById(R.id.imgAnhBanh);


            TenBanh.setText(banh.getTenBanh());
            DiaChi.setText(banh.getDiaChi());
            GiaCa.setText(banh.getGiaCa());
            Giam.setText(banh.getGiam());
            Glide.with(getContext()).load(banh.getImgAnhBanh()).into(imgAnhBanh);

        }
        return viewBanh;
    }
}
