package com.example.projectchuyende.SanPham;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.projectchuyende.model.Banh;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class FirebaseBanh {
    public static final String SanPhamBanh = "SanPhamBanh";
    Context context;
    DatabaseReference mDatabaseBanh;
    FirebaseStorage storage;
    StorageReference storageReference;

    ArrayList<Banh> arrBanh;

    public ArrayList<Banh> getArrBanh() {
        return arrBanh;
    }

    public void setArrBanh(ArrayList<Banh> arrBanh) {
        this.arrBanh = arrBanh;
    }

    private ProgressDialog dialog;

    public FirebaseBanh(Context context) {
        this.context = context;
        dialog = new ProgressDialog(context);
        dialog.setMessage("Đang tải....");
        mDatabaseBanh = FirebaseDatabase.getInstance().getReference();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        arrBanh = new ArrayList<>();
    }


    public interface IListener {
        void onSuccess();

        void onFail();
    }

    public interface IListenerUploadFile {
        void onSuccess(String url);

        void onFail();
    }

    public void LoadDSBanh(final FirebaseBanh.IListener iListener) {
        mDatabaseBanh.child(SanPhamBanh).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Banh banh;
                arrBanh = new ArrayList<Banh>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    banh = data.getValue(Banh.class);
                    arrBanh.add(banh);
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
