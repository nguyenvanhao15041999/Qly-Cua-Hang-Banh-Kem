package com.example.projectchuyende.ui.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.projectchuyende.MainActivity;
import com.example.projectchuyende.R;
import com.example.projectchuyende.SanPham.FirebaseNuoc;
import com.example.projectchuyende.adapter.BanhAdapter;
import com.example.projectchuyende.adapter.NuocAdapter;
import com.example.projectchuyende.SanPham.FirebaseBanh;
import com.example.projectchuyende.model.Banh;
import com.example.projectchuyende.model.Nuoc;
import com.example.projectchuyende.ui.order.BookParty;
import com.example.projectchuyende.ui.table.Table;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    Button btnKhu, btnDatTiec, btnBanh, btnNuocUong;
    ListView lvDanhSach;

    int index = -1;

    ArrayList<Banh> data_banh = new ArrayList<>();
    ArrayList<Nuoc> data_nuoc = new ArrayList<>();
    BanhAdapter customAdapter_banh;
    NuocAdapter customAdapter_nuoc;
    FirebaseBanh FirebaseBanh;
    FirebaseNuoc FirebaseNuoc;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        btnKhu = root.findViewById(R.id.btnKhu);
        btnDatTiec = root.findViewById(R.id.btnDattiec);
        btnBanh = root.findViewById(R.id.btnBanh);
        btnNuocUong = root.findViewById(R.id.btnNuoc);
        lvDanhSach = root.findViewById(R.id.lvDanhsachHome);

        //lvDanhSach.setOnItemLongClickListener(new ItemLongClickRemove());
        setEvent();
        FirebaseBanh = new FirebaseBanh(getActivity());
        FirebaseNuoc = new FirebaseNuoc(getActivity());
        setEvent();


        return root;


    }

    public void setEvent() {


        //Gọi dữ liệu lên màn hình
        customAdapter_banh = new BanhAdapter(getContext(), R.layout.banh_listview, data_banh);
        lvDanhSach.setAdapter(customAdapter_banh);

        //
        if (customAdapter_banh == null) {
            FirebaseBanh.LoadDSBanh(new FirebaseBanh.IListener() {
                @Override
                public void onSuccess() {
                    data_banh.addAll(FirebaseBanh.getArrBanh());
                    customAdapter_banh = new BanhAdapter(getActivity(), R.layout.banh_listview, data_banh);
                    lvDanhSach.setAdapter(customAdapter_banh);
                }
                @Override
                public void onFail() {}
            });
        }
            else {customAdapter_banh.notifyDataSetChanged();
        }

        //
        if (customAdapter_nuoc == null) {
//            FirebaseNuoc.LoadDSNuoc(new FirebaseNuoc.IListener() {
//                @Override
//                public void onSuccess() {
//                    data_nuoc.addAll(FirebaseNuoc.getArrNuoc());
//                    customAdapter_nuoc = new NuocAdapter(getActivity(), R.layout.nuoc_listview, data_nuoc);
//                    lvDanhSach.setAdapter(customAdapter_nuoc);
//                }
//                @Override
//                public void onFail() {}
//            });
        }
        else {customAdapter_banh.notifyDataSetChanged();
        }


        btnKhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Table.class);
                getActivity().startActivity(intent);
            }
        });

        btnDatTiec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BookParty.class);
                getActivity().startActivity(intent);
            }
        });

        btnBanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gọi dữ liệu lên màn hình
                customAdapter_banh = new BanhAdapter(getContext(), R.layout.banh_listview, data_banh);
                lvDanhSach.setAdapter(customAdapter_banh);
            }
        });

        btnNuocUong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gọi dữ liệu lên màn hình
                customAdapter_nuoc = new NuocAdapter(getContext(), R.layout.nuoc_listview, data_nuoc);
                lvDanhSach.setAdapter(customAdapter_nuoc);
            }
        });


    }

    /**private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            //Tạo đối tượng
            AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
//Thiết lập tiêu đề
            b.setTitle("Xác nhận");
            b.setMessage("Bạn có đồng ý thoát chương trình không?");
// Nút Ok
            b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                   // finish();
                }
            });
//Nút Cancel
            b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
//Tạo dialog
            AlertDialog al = b.create();
//Hiển thị
            al.show();

            return (true);

        }
    }*/

    /**private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
            alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    SaleManager.get().getProducts().remove(position);
                    //cập nhật lại listview
                    adapter.notifyDataSetChanged();

                }
            });
            alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //không làm gì
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }*/

}