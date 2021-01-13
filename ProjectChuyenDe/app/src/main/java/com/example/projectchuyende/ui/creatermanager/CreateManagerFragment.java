package com.example.projectchuyende.ui.creatermanager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projectchuyende.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class CreateManagerFragment extends Fragment {


    Button btntaotaikhoan;
    EditText edtManv, edtTennv, edtsdt, edtmatkhau, edtTaikhoan, edtAdress, edtchucvu,edt_email;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    RadioButton rdbnam, rdbnu, rdbNhanvien, rdbQuanly;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)  {
        View root = inflater.inflate(R.layout.activity_change_account, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        btntaotaikhoan = root.findViewById(R.id.btnTao);
        edtManv =  root.findViewById(R.id.txtmanv);
        rdbnam =  root.findViewById(R.id.txt_Nam);
        rdbnu =  root.findViewById(R.id.txt_Nu);
        edt_email =  root.findViewById(R.id.txtmail);
        edtTennv =  root.findViewById(R.id.txtHoTen);
        edtsdt =  root.findViewById(R.id.txtsdtnv);
        edtTaikhoan =  root.findViewById(R.id.txtAccount);
        edtmatkhau =  root.findViewById(R.id.txtpass);
        edtAdress =  root.findViewById(R.id.txtngaysinh);
        setControl();
        Toolbar toolbar =  root.findViewById(R.id.toolbar_forgotpassword);
        return  root;
    }


    private void setControl() {

        btntaotaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String manv = edtManv.getText().toString();
                String tennv = edtTennv.getText().toString();
                String sdt = edtsdt.getText().toString();
                String user = edtTaikhoan.getText().toString();
                String password = edtmatkhau.getText().toString();
                String email = edt_email.getText().toString();
                String address = edtAdress.getText().toString();
                String gioitinh="";
                if (rdbnam.isChecked()){
                    gioitinh=rdbnam.getText().toString();
                }

                if(rdbnu.isChecked()){
                    gioitinh=rdbnu.getText().toString();
                }
                String permisstion = "user";

                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password)
                        && !TextUtils.isEmpty(manv) && !TextUtils.isEmpty(tennv)
                        && !TextUtils.isEmpty(address)
                        && !TextUtils.isEmpty(sdt) && !TextUtils.isEmpty(email)) {
                    register(manv, user, password, sdt, address, tennv,  email,gioitinh, permisstion);
                } else if (TextUtils.isEmpty(manv)) {
                    edtManv.setError("Employee code is invalid!");
                } else if (TextUtils.isEmpty(tennv)) {
                    edtTennv.setError("Staff's name is invalid!");
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
    private void register(final String manv, final String user, final String password, final String sdt, final String address, final String tennv, final String email, final String giotinh,String permisstion) {
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    String userId = firebaseUser.getUid();
                    databaseReference = FirebaseDatabase.getInstance().getReference("Nhan_Vien").child(userId);

                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("userId", userId);
                    hashMap.put("User", user);
                    hashMap.put("Manv", manv);
                    hashMap.put("address", address);
                    hashMap.put("sdt", sdt);
                    hashMap.put("Email", email);
                    hashMap.put("Tennv", tennv);
                    hashMap.put("Password", password);
                    hashMap.put("gioitinh", giotinh);
                    hashMap.put("chucvu", "Quản Lý");
                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getContext(), "Tạo thành công!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "Lỗi!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                } else {
                    Toast.makeText(getContext(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
