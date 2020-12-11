package com.example.projectchuyende.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectchuyende.R;
import com.example.projectchuyende.model.Desk;

import java.util.ArrayList;

public class DeskAdapter extends ArrayAdapter {
    @NonNull
    Context context;
    int resource;
    ArrayList<Desk> dataDesk;

    public DeskAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Desk> dataDesk) {
        super(context, resource, dataDesk);
        this.context = context;
        this.resource = resource;
        this.dataDesk = dataDesk;
    }

    @Override
    public int getCount() {
        return dataDesk.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View viewDesk;
        if (convertView == null) {
            viewDesk = View.inflate(parent.getContext(), resource, null);
        } else viewDesk = convertView;

        TextView tvDesk = viewDesk.findViewById(R.id.tv_numberDesk);
        ImageView imgDesk = viewDesk.findViewById(R.id.imgDesk);
        final Desk desk = dataDesk.get(position);
        if (desk.getsTrangthai()=="Trống"){
            imgDesk.setImageResource(R.drawable.table_rong);
        }else {
            imgDesk.setImageResource(R.drawable.table_full);
        }

        return viewDesk;
    }
}
