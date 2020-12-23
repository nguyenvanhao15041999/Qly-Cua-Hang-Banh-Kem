package com.example.projectchuyende.ui.account;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.projectchuyende.R;
import com.example.projectchuyende.activity.signup.SignUpActivity;
import com.example.projectchuyende.model.Nhanvien;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class Change_account extends AppCompatActivity {
    Button btntaotaikhoan;
    EditText edtManv, edtTennv, edtsdt, edtmatkhau, edtTaikhoan, edtAdress, edtchucvu,edt_email;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_account);
        firebaseAuth = FirebaseAuth.getInstance();
        btntaotaikhoan = findViewById(R.id.btnTao);
        edtManv = findViewById(R.id.txtmanv);
        edt_email = findViewById(R.id.txtmail);
        edtTennv = findViewById(R.id.txtHoTen);
        edtsdt = findViewById(R.id.txtsdtnv);
        edtTaikhoan = findViewById(R.id.txtAccount);
        edtmatkhau = findViewById(R.id.txtpass);
        edtAdress = findViewById(R.id.txtngaysinh);
        edtchucvu = findViewById(R.id.txtchucvunv);
        setControl();
        Toolbar toolbar = findViewById(R.id.toolbar_forgotpassword);
    }


    private void setControl() {

        btntaotaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String manv = edtManv.getText().toString();
                String tennv = edtTennv.getText().toString();
                String sdt = edtsdt.getText().toString();
                String user = edtsdt.getText().toString();
                String password = edtmatkhau.getText().toString();
                String email = edt_email.getText().toString();
                String address = edtAdress.getText().toString();
                String chucvu = edtchucvu.getText().toString();
                String permisstion = "user";

                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password)
                        && !TextUtils.isEmpty(manv) && !TextUtils.isEmpty(tennv)
                        && !TextUtils.isEmpty(chucvu) && !TextUtils.isEmpty(address)
                        && !TextUtils.isEmpty(sdt) && !TextUtils.isEmpty(email)) {
                    register(manv, user, password, sdt, address, tennv, chucvu, email, permisstion);
                } else if (TextUtils.isEmpty(manv)) {
                    edtManv.setError("Employee code is invalid!");
                } else if (TextUtils.isEmpty(tennv)) {
                    edtTennv.setError("Staff's name is invalid!");
                } else if (TextUtils.isEmpty(chucvu)) {
                    edtchucvu.setError("position is invalid!");
                } else if (TextUtils.isEmpty(address)) {
                    edtAdress.setError("Address is invalid!");
                } else if (TextUtils.isEmpty(sdt)) {
                    edtsdt.setError("Phone Number is invalid!");
                } else if (TextUtils.isEmpty(user)) {
                    edtTaikhoan.setError("Account is invalid!");
                } else if (TextUtils.isEmpty(password)) {
                    edtmatkhau.setError("Password is invalid!");
                } else if (TextUtils.isEmpty(email)) {
                    edt_email.setError("Password is invalid!");
                }
            }
        });
    }
    private void register(final String manv, final String user, final String password, final String sdt, final String address, final String tennv, final String chucvu, final String email, String permisstion) {
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    String userId = firebaseUser.getUid();
                    databaseReference = FirebaseDatabase.getInstance().getReference("User_NhanVien").child(userId);

                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("userId", userId);
                    hashMap.put("User", user);
                    hashMap.put("Manv", manv);
                    hashMap.put("address", address);
                    hashMap.put("sdt", sdt);
                    hashMap.put("Email", email);
                    hashMap.put("Tennv", tennv);
                    hashMap.put("Chucvu", chucvu);
                    hashMap.put("Password", password);

                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Change_account.this, "Tạo thành công!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Change_account.this, "Lỗi!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                } else {
                    Toast.makeText(Change_account.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}