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
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectchuyende.R;
import com.example.projectchuyende.model.Desk;

import java.util.ArrayList;

public class DeskAdapter extends ArrayAdapter<Desk> {
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
        View viewDesk = convertView;
        if (viewDesk == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            viewDesk = layoutInflater.inflate(R.layout.show_listdesk, null);
        }
        Desk desk = getItem(position);

        if (desk!=null){
            TextView tvDesk = viewDesk.findViewById(R.id.tv_numberDesk);
            TextView tvSlot = viewDesk.findViewById(R.id.tv_numberSlot);
            ImageView imgDesk = viewDesk.findViewById(R.id.imgDesk);

            tvDesk.setText(desk.getTenBan());
            tvSlot.setText(" Số lượng người: "+String.valueOf(desk.getSoNguoi()));
            if (desk.isTinhTrang()==true){
                imgDesk.setImageResource(R.drawable.table_full);
            }else {
                imgDesk.setImageResource(R.drawable.table_rong);
            }
        }




        return viewDesk;
    }
}
