package com.example.projectchuyende.ui.signin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.projectchuyende.MainActivity;
import com.example.projectchuyende.Preferences;
import com.example.projectchuyende.R;
import com.example.projectchuyende.activity.forgotpassword.ForgotPassWordActivity;
import com.example.projectchuyende.activity.signup.SignUpActivity;
import com.example.projectchuyende.model.Nhan_Vien;
import com.example.projectchuyende.model.Nhanvien;
import com.example.projectchuyende.model.PrivateUser;
import com.example.projectchuyende.model.User;
import com.example.projectchuyende.validators.EmailValidator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInFragment extends Fragment {
    Button btnSignup;
    TextView tvForgotpass;
    EditText edtAccount;
    TextView textView;
    EditText edtPassword;
    Button btnSignin;
    CheckBox chkPass;
    private FirebaseAuth firebaseAuth;
    Intent intent;
    RadioGroup rbtngChonLoaiTK;
    FirebaseUser user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_signin, container, false);
        btnSignup = root.findViewById(R.id.btnSignup);
        tvForgotpass = root.findViewById(R.id.tvForgotpassword);
        edtAccount = root.findViewById(R.id.edtAccount);
        textView = root.findViewById(R.id.textView);
        rbtngChonLoaiTK = root.findViewById(R.id.rbtngChonLoaiTK);

        edtPassword = root.findViewById(R.id.edtPassword);
        btnSignin = root.findViewById(R.id.btnSignin);
        chkPass = root.findViewById(R.id.showPasss);

        firebaseAuth = FirebaseAuth.getInstance();

        intent = getActivity().getIntent();
        validateEmail();
        showPassword();
        setEvent();
        return root;

    }

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    // Validate emmail
    public void validateEmail() {
        //final String email = edtAccount.getText().toString().trim();
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        edtAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (isValidEmail(edtAccount.getText().toString().trim())) {
                    textView.setText("Nhập Đúng email");

                } else {
                    textView.setText("Nhập sai email");

                }
            }
        });
    }

    public void showPassword() {
        chkPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b) {
                    // hide password
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

                } else {
                    // show password
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }

    public void setEvent() {
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(getActivity(), SignUpActivity.class);
                getActivity().startActivity(intent);
            }
        });
        tvForgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(getActivity(), ForgotPassWordActivity.class);
                getActivity().startActivity(intent);
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtAccount.getText().toString(); // username = email
                String password = edtPassword.getText().toString();
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    switch (rbtngChonLoaiTK.getCheckedRadioButtonId()) {
                        case R.id.rbtnKH: {
                            String table = "Users";
                            String mess = "nguoidung";
                            login(username, password, table, mess);
                        }
                        break;
                        case R.id.rbtnNV: {
                            String table = "Nhan_Vien";
                            String mess = "nhanvien";
                            login(username, password, table, mess);
                        }
                        break;
                        case R.id.rbtnAdmin: {
                            String table = "PrivateUsers";
                            String mess = "admin";
                            login(username, password, table, mess);
                        }
                        break;
                        default: {
                            Toast.makeText(getActivity(), "Chọn loại tài khoản đăng nhập!", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else if (TextUtils.isEmpty(username)) {
                    edtAccount.setError("Account is invalid!");
                } else if (TextUtils.isEmpty(password)) {
                    edtPassword.setError("Password is invalid!");
                }
            }
        });
    }


    private void login(final String username, String password, final String table, final String mess) {
        firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d("signin", "Sign in success");
                    Toast.makeText(getActivity(), "Sign in success", Toast.LENGTH_SHORT).show();
                    user = FirebaseAuth.getInstance().getCurrentUser();

                    if (user.getUid() != null) {
                        String userID = user.getUid();

                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(table);
                        ref.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(mess.equals("admin")){
                                    changeIntent(mess, username);
                                }else {
                                    changeIntent(mess, snapshot);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        Toast.makeText(getActivity(), "Connecting to database is failed!", Toast.LENGTH_SHORT).show();
                    }

                    MainActivity.isLogin = true;
                } else {
                    Log.d("signin", "Sign in failed");
                    Toast.makeText(getActivity(), "Sign in failed", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void changeIntent(String mess, DataSnapshot snapshot) {
        Intent intent = getActivity().getIntent();
        intent.setClass(getActivity(), MainActivity.class);

        if (mess.equals("nguoidung")) {
            User nguoidung = snapshot.getValue(User.class);
            intent.putExtra(mess, nguoidung);
        } else if (mess.equals("nhanvien")) {
            Nhan_Vien nhanvien = snapshot.getValue(Nhan_Vien.class);
            intent.putExtra(mess, nhanvien);
        }

        getActivity().startActivity(intent);

    }

    private void changeIntent(String mess, String username){
        Intent intent = getActivity().getIntent();
        intent.setClass(getActivity(), MainActivity.class);
        intent.putExtra(mess, username);
        getActivity().startActivity(intent);
    }
}


