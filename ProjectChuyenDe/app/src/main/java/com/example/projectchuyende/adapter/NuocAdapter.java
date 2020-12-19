package com.example.projectchuyende.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        View view = LayoutInflater.from(getContext()).inflate(resource, null);
        //Khai báo
        TextView tvTenSP = view.findViewById(R.id.tvTenSP);
        TextView tvGiaCa = view.findViewById(R.id.tvGiaBan);
        TextView tvDiaChi = view.findViewById(R.id.tvDiaChi);
        TextView tvGiam = view.findViewById(R.id.tvGiam);
        ImageView imgAnhBanh = view.findViewById(R.id.imgAnh);

        //Xử lý dữ liệu
        Nuoc nuoc = data.get(position);
        tvTenSP.setText(nuoc.getTenNuoc());
        tvGiaCa.setText(nuoc.getGiaCa());
        tvDiaChi.setText(nuoc.getDiaChi());
        tvGiam.setText(nuoc.getGiam());
        imgAnhBanh.setImageResource(R.drawable.cocacola);
        return view;
    }
}
