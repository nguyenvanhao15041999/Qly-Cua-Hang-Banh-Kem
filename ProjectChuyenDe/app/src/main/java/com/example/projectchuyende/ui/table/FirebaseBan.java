package com.example.projectchuyende.ui.table;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.projectchuyende.model.Banh;
import com.example.projectchuyende.model.Desk;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class FirebaseBan {
    public static String ThongTinBan = "ThongTinBan";
    Context context;
    DatabaseReference mDatabaseBan;
    FirebaseStorage storage;
    StorageReference storageReference;

    ArrayList<Desk> arrBan;
    public ArrayList<Desk> getArrBan() {
        return arrBan;
    }

    public void setArrBan(ArrayList<Desk> arrBan) {
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

    //Xử lý truyền dữ liệu Thông Tin Bàn từ Firebase xuống
    public void LoadDBan(final FirebaseBan.IListener iListener) {
        mDatabaseBan.child(ThongTinBan).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Desk ban;
                arrBan = new ArrayList<Desk>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    ban = data.getValue(Desk.class);
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
