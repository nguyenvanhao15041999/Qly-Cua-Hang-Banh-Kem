package com.example.projectchuyende.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.projectchuyende.R;
import com.example.projectchuyende.model.Banh;
import com.example.projectchuyende.ui.home.HomeFragment;

import java.util.ArrayList;

public class BanhAdapter extends ArrayAdapter {
    //Hàm Custom
    Context context;
    int resource;
    ArrayList<Banh> data;

    public BanhAdapter(Context context, int resource, ArrayList<Banh> data) {
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
        TextView tvTenBanh = view.findViewById(R.id.tvTenBanh);
        TextView tvGiaCa = view.findViewById(R.id.tvGiaBan);
        TextView tvDiaChi = view.findViewById(R.id.tvDiaChi);
        TextView tvGiam = view.findViewById(R.id.tvGiam);
        ImageView imgAnhBanh = view.findViewById(R.id.imgAnhBanh);

        //Xử lý dữ liệu
        Banh banh = data.get(position);
        tvTenBanh.setText(banh.getTenBanh());
        tvGiaCa.setText(banh.getGiaCa());
        tvDiaChi.setText(banh.getDiaChi());
        tvGiam.setText(banh.getGiam());
        imgAnhBanh.setImageResource(R.drawable.banh);
        return view;
    }
}
