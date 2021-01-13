package com.example.projectchuyende.ui.bill;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.projectchuyende.model.BanDat;
import com.example.projectchuyende.model.HoaDon;
import com.example.projectchuyende.ui.table.FirebaseBan;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class FirebaseHoaDon {
    public static final String DanhSachBill = "DanhSachBill";
    Context context;
    DatabaseReference mDatabaseBill;
    FirebaseStorage storage;
    StorageReference storageReference;

    ArrayList<HoaDon> arrHD;
    public ArrayList<HoaDon> getArrHD() {
        return arrHD;
    }
    public void setArrHD(ArrayList<HoaDon> arrHD) {
        this.arrHD = arrHD;
    }
    private ProgressDialog dialog;
    public FirebaseHoaDon(Context context) {
        this.context = context;
        dialog = new ProgressDialog(context);
        dialog.setMessage("Đang tải....");
        mDatabaseBill = FirebaseDatabase.getInstance().getReference();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        arrHD = new ArrayList<>();
    }

    public interface IListener {
        void onSuccess();
        void onFail();
    }

    public interface IListenerUploadFile {
        void onSuccess(String url);
        void onFail();
    }

    //Xử lý truyền dữ liệu
    public void LoadDSHoaDon(final FirebaseHoaDon.IListener iListener) {
        mDatabaseBill.child(DanhSachBill).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HoaDon hoaDon;
                arrHD = new ArrayList<HoaDon>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {

                    hoaDon = data.getValue(HoaDon.class);
                    arrHD.add(hoaDon);
                }
                iListener.onSuccess();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                iListener.onFail();
            }
        });


    }
}
