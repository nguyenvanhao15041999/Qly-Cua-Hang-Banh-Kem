package com.example.projectchuyende.SanPham;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.projectchuyende.model.Nuoc;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class FirebaseNuoc {
    public static final String SanPhamNuoc = "SanPhamNuoc";
    Context context;
    DatabaseReference mDatabaseNuoc;
    FirebaseStorage storage;
    StorageReference storageReference;

    ArrayList<Nuoc> arrNuoc;
    public ArrayList<Nuoc> getArrNuoc() { return arrNuoc; }
    public void setArrNuoc(ArrayList<Nuoc> arrNuoc) {
        this.arrNuoc = arrNuoc;
    }
    private ProgressDialog dialog;

    public FirebaseNuoc(Context context) {
        this.context = context;
        dialog = new ProgressDialog(context);
        dialog.setMessage("Đang tải....");
        mDatabaseNuoc = FirebaseDatabase.getInstance().getReference();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        arrNuoc = new ArrayList<>();
    }


    public interface IListener {
        void onSuccess();
        void onFail();
    }

    public interface IListenerUploadFile {
        void onSuccess(String url);
        void onFail();
    }

    //Xử lý truyền dữ liệu Nước Uống từ Firebase xuống
    public void LoadDSNuoc(final FirebaseNuoc.IListener iListener) {
        mDatabaseNuoc.child(SanPhamNuoc).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Nuoc nuoc;
                arrNuoc = new ArrayList<Nuoc>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    nuoc = data.getValue(Nuoc.class);
                    arrNuoc.add(nuoc);
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
