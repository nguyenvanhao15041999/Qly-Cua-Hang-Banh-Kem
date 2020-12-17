package com.example.projectchuyende.firebaseallManager;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.projectchuyende.model.Nhanvien;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class FirebaseallManager {
    public static final String Nhan_Vien = "Nhan_Vien";

    Context context;
    DatabaseReference mDatabase;
    FirebaseStorage storage;
    StorageReference storageReference;

    ArrayList<Nhanvien> arrNhanvien;

    public ArrayList<Nhanvien> getArrNhanvien() {
        return arrNhanvien;
    }

    public void setArrNhanvien(ArrayList<Nhanvien> arrNhanvien) {
        this.arrNhanvien = arrNhanvien;
    }

    private ProgressDialog dialog;

    public FirebaseallManager(Context context) {
        this.context = context;
        dialog = new ProgressDialog(context);
        dialog.setMessage("Đang tải...");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        arrNhanvien = new ArrayList<>();
    }

    public void showLoading(boolean isShow){
        if(dialog != null){
            if(isShow){
                dialog.show();
            }else {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        }
    }
    public void loadDSNhanVien(final IListener listener){
        showLoading(true);
        mDatabase.child(Nhan_Vien).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Nhanvien nhanvien;
                arrNhanvien = new ArrayList<Nhanvien>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    nhanvien = ds.getValue(Nhanvien.class);
                    arrNhanvien.add(nhanvien);
                }
                listener.onSuccess();
                showLoading(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onFail();
            }
        });
    }

    public interface IListener {
        void onSuccess();

        void onFail();
    }

    public interface IListenerUploadFile {
        void onSuccess(String url);

        void onFail();
    }
}
