package com.example.projectchuyende.firebaseallManager;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.projectchuyende.model.Desk;
import com.example.projectchuyende.model.Nhanvien;
import com.google.android.gms.auth.api.signin.internal.Storage;
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

import java.util.ArrayList;

public class FirebaseListDesk {
    public static String ThongTinBan = "ThongTinBan";

    Context context;
    DatabaseReference mDatabaseDesk;
    FirebaseStorage storage;
    StorageReference storageReference;

    ArrayList<Desk> arrDesk;

    public ArrayList<Desk> getArrDesk() {
        return arrDesk;
    }

    public void setArrDesk(ArrayList<Desk> arrDesk) {
        this.arrDesk = arrDesk;
    }

    private ProgressDialog dialog;

    public FirebaseListDesk(Context context) {
        this.context = context;
        dialog = new ProgressDialog(context);
        dialog.setMessage("Đang tải...");
        mDatabaseDesk = FirebaseDatabase.getInstance().getReference();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        arrDesk = new ArrayList<>();
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

    public interface IListener {
        void onSuccess();

        void onFail();
    }

    public interface IListenerUploadFile {
        void onSuccess(String url);

        void onFail();
    }

    public void LoadListDesk(final IListener iListener) {
        showLoading(true);
        mDatabaseDesk.child(ThongTinBan).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Desk desk;
                arrDesk = new ArrayList<Desk>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    desk = data.getValue(Desk.class);
                    arrDesk.add(desk);
                }
                iListener.onSuccess();
                showLoading(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                iListener.onFail();
            }
        });
    }

    public void ThemBan(Desk desk, final IListener iListener) {
        showLoading(true);
        String id = mDatabaseDesk.child(ThongTinBan).push().getKey();
        desk.setMaBan(id);
        mDatabaseDesk.child(ThongTinBan).child(desk.getMaBan()).setValue(desk).addOnSuccessListener(new OnSuccessListener<Void>() {
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

    public void SuaBan(String ID, Desk desk, final IListener iListener) {
        showLoading(true);
        mDatabaseDesk.child(ThongTinBan).child(ID).setValue(desk).addOnCompleteListener(new OnCompleteListener<Void>() {
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

    public void xoaBan(String id, final IListener listener){
        showLoading(true);
        mDatabaseDesk.child(ThongTinBan).child(id).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
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
}
