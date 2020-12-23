package com.example.projectchuyende.ui.pay;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.Fragment;

import com.example.projectchuyende.R;

public class PayFragment extends Fragment {


        RadioButton radTrucTiep , radChuyenKhoan;
        Button btnThanhToan ,btnHuy;
        EditText edtDanhGia;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pay, container, false);



            radChuyenKhoan = root.findViewById(R.id.radChuyenKhoan);
            radTrucTiep = root.findViewById(R.id.radTrucTiep);
            btnThanhToan = root.findViewById(R.id.btnThanhToan);
            btnHuy = root.findViewById(R.id.btnHuy);
            edtDanhGia = root.findViewById(R.id.edtDanhGia);


        setEvent();
        return root;


    }


    private void setEvent() {




        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radChuyenKhoan.isChecked())
                {

                }
                else
                    {

                }
            }
        });

    }




}