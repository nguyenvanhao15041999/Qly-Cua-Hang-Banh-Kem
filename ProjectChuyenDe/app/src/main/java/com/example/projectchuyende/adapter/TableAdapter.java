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
import com.example.projectchuyende.model.BanDat;

import java.util.ArrayList;

public class TableAdapter extends ArrayAdapter {

    //Hàm Custom
    Context context;
    int resource;
    ArrayList<BanDat> data_ban;
    public TableAdapter(Context context, int resource, ArrayList<BanDat> data_ban) {
        super(context, resource, data_ban);
        this.context = context;
        this.resource = resource;
        this.data_ban = data_ban;
    }


    //Hàm getCount
    @Override
    public int getCount() {
        return data_ban.size();
    }

    //Hàm getView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewBan=convertView;

        if (viewBan==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewBan = inflater.inflate(R.layout.grid_ban, null);
        }
        BanDat ban= (BanDat) getItem(position);

        if (ban != null) {

            TextView SoBan = viewBan.findViewById(R.id.tvSoBan);
            TextView SoNguoi = viewBan.findViewById(R.id.tvSoNguoi);
            ImageView imgBanDat=viewBan.findViewById(R.id.imgBanDat);



            SoBan.setText(ban.getSoBan());
            SoNguoi.setText(ban.getSoNguoi());
            Glide.with(getContext()).load(ban.getImgBanDat()).into(imgBanDat);

        }
        return viewBan;
    }
}
