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
import com.example.projectchuyende.model.Nuoc;

import java.util.ArrayList;

public class NuocAdapter extends ArrayAdapter {
    //Hàm Custom
    Context context;
    int resource;
    ArrayList<Nuoc> data;

    public NuocAdapter(Context context, int resource, ArrayList<Nuoc> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }


    //Hàm getCount
    @Override
    public int getCount() {
        return data.size();
    }

    //Hàm getView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewNuoc=convertView;

        if (viewNuoc==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewNuoc = inflater.inflate(R.layout.nuoc_listview, null);
        }
        Nuoc nuoc= (Nuoc) getItem(position);

        if (nuoc != null) {

            TextView TenBanh = viewNuoc.findViewById(R.id.tvTenNuoc);
            TextView GiaCa = viewNuoc.findViewById(R.id.tvGiaBan);
            TextView DiaChi = viewNuoc.findViewById(R.id.tvDiaChi);
            TextView Giam = viewNuoc.findViewById(R.id.tvGiam);
            ImageView imgAnhNuoc=viewNuoc.findViewById(R.id.imgAnhNuoc);

            TenBanh.setText(nuoc.getTenNuoc());
            DiaChi.setText(nuoc.getDiaChi());
            GiaCa.setText(nuoc.getGiaCa());
            Giam.setText(nuoc.getGiam());
            Glide.with(getContext()).load(nuoc.getImgAnhNuoc()).into(imgAnhNuoc);
        }
        return viewNuoc;
    }
}
