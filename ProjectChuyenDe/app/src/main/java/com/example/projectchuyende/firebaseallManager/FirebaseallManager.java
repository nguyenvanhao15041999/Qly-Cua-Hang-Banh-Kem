package com.example.projectchuyende.firebaseallManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.example.projectchuyende.model.Desk;
import com.example.projectchuyende.model.Nhanvien;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.UUID;

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

    public void showLoading(boolean isShow) {
        if (dialog != null) {
            if (isShow) {
                dialog.show();
            } else {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        }
    }


    public void loadDSNhanVien(final IListener listener) {
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

    public void ThemNhanvien(Nhanvien nhanvien, final FirebaseallManager.IListener iListener) {
        showLoading(true);
        String id = mDatabase.child(Nhan_Vien).push().getKey();
        nhanvien.setMaNV(id);
        mDatabase.child(Nhan_Vien).child(nhanvien.getMaNV()).setValue(nhanvien).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                showLoading(false);
                iListener.onSuccess();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                iListener.onFail();
            }
        });
    }

    public void SuaNhanvien(String ID, Nhanvien nhanvien, final FirebaseallManager.IListener iListener) {
        showLoading(true);
        mDatabase.child(Nhan_Vien).child(ID).setValue(nhanvien).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                iListener.onSuccess();
                showLoading(false);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                iListener.onFail();
            }
        });
    }

    public void xoaNhanvien(String id, final FirebaseallManager.IListener listener) {
        showLoading(true);
        mDatabase.child(Nhan_Vien).child(id).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                listener.onSuccess();
                showLoading(false);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onFail();
            }
        });
    }

    public void uploadFile(Uri uri, final IListenerUploadFile listener) {
        showLoading(true);
        final StorageReference reference = storageReference.child("img/" + UUID.randomUUID().toString());
        reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Uri downloadUrl = uri;
                        String imgURL = downloadUrl.toString();
                        listener.onSuccess(imgURL);
                    }
                });
                showLoading(false);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
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
