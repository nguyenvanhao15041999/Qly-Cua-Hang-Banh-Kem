package com.example.projectchuyende.ui.table;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.projectchuyende.SanPham.FirebaseBanh;
import com.example.projectchuyende.model.BanDat;
import com.example.projectchuyende.model.Banh;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class FirebaseBan {
    public static final String Table = "Table";
    Context context;
    DatabaseReference mDatabaseBan;
    FirebaseStorage storage;
    StorageReference storageReference;

    ArrayList<BanDat> arrBan;
    public ArrayList<BanDat> getArrBan() {
        return arrBan;
    }
    public void setArrBan(ArrayList<BanDat> arrBan) {
        this.arrBan = arrBan;
    }
    private ProgressDialog dialog;
    public FirebaseBan(Context context) {
        this.context = context;
        dialog = new ProgressDialog(context);
        dialog.setMessage("Đang tải....");
        mDatabaseBan = FirebaseDatabase.getInstance().getReference();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        arrBan = new ArrayList<>();
    }

    public interface IListener {
        void onSuccess();
        void onFail();
    }

    public interface IListenerUploadFile {
        void onSuccess(String url);
        void onFail();
    }

    //Xử lý truyền dữ liệu Bánh từ Firebase xuống
    public void LoadDSBan(final FirebaseBan.IListener iListener) {
        mDatabaseBan.child(Table).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                BanDat ban;
                arrBan = new ArrayList<BanDat>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    ban = data.getValue(BanDat.class);
                    arrBan.add(ban);
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
