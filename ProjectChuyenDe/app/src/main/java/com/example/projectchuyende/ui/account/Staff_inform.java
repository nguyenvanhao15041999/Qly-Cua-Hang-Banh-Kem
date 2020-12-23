package com.example.projectchuyende.ui.account;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.projectchuyende.R;

public class Staff_inform extends Fragment {
    Button btn_taikhoan;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_staff_inform, container, false);
        btn_taikhoan = root.findViewById(R.id.btntaikhoan);

        setEvent();
        return root;
    }

    public void setEvent() {
        btn_taikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Change_account.class);
                getActivity().startActivity(intent);
            }
        });
    }

}