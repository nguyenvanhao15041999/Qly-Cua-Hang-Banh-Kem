package com.example.projectchuyende.ui.account;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectchuyende.R;
import com.example.projectchuyende.model.ThongtinBanh;

import java.util.ArrayList;

public class Product_chi_tiet extends Fragment {
    ArrayList<ThongtinBanh> databanh= new ArrayList<>();
    EditText edtMotaSP;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_product_chi_tiet, container, false);
        edtMotaSP = root.findViewById(R.id.edtMotaSP);
        setEvent();
        return root;
    }

    private void setEvent() {
        khoitao();
        ThongtinBanh TTBANH = new ThongtinBanh();
        edtMotaSP.setText(TTBANH.getMoTa().toString());
    }

    private void khoitao() {
        ThongtinBanh ttbanh = new ThongtinBanh();
        ttbanh.setMoTa(" Một phụ nữ giải thích vấn đề tế nhị của mình với bác sĩ rằng cô ta luôn đánh rắm mà không thể kiềm chế được. “Nhưng cũng may là chúng không bốc mùi và không kêu thành tiếng. Thực ra nãy giờ ngồi nói chuyện với bác sĩ mà tôi đã hai lần... rồi đó”, cô ta nói.");
        databanh.add(ttbanh);
    }

}