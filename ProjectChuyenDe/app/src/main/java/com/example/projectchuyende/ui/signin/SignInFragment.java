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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_signin, container, false);
        btnSignup = root.findViewById(R.id.btnSignup);
        tvForgotpass = root.findViewById(R.id.tvForgotpassword);
        edtAccount = root.findViewById(R.id.edtAccount);
        textView = root.findViewById(R.id.textView);

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
                if(isValidEmail(edtAccount.getText().toString().trim())){
                    Toast.makeText(getContext(), "Ban nhap dung email", Toast.LENGTH_SHORT).show();
                    textView.setText("Đúng email");
                    textView.setTextColor(Color.parseColor("   #00FF00"));
                }else{
                    Toast.makeText(getContext(), "Ban nhap sai email", Toast.LENGTH_SHORT).show();
                    textView.setText("Nhập sai email");
                    textView.setTextColor(Color.parseColor("#FF0000"));
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
                    if (EmailValidator.isValidEmail(username) == false) {
                        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference reference = firebaseDatabase.getReference("PrivateUsers");
                        reference.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                PrivateUser privateUser = snapshot.getValue(PrivateUser.class);
                                MainActivity.isLogin = true;
                                DatabaseReference ref = firebaseDatabase.getReference("Nhan_Vien");
                                ref.child(privateUser.getUserID()).addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        Nhanvien nhanvien = snapshot.getValue(Nhanvien.class);
                                        Intent intent = getActivity().getIntent();
                                        intent.setClass(getActivity(), MainActivity.class);
                                        intent.putExtra("nhanvien", nhanvien);
                                        getActivity().startActivity(intent);
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        Toast.makeText(getActivity(), "Login failed 1!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(getActivity(), "Login failed 2!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        login(username, password);
                    }
                } else if (TextUtils.isEmpty(username)) {
                    edtAccount.setError("Account is invalid!");
                } else if (TextUtils.isEmpty(password)) {
                    edtPassword.setError("Password is invalid!");
                }
            }
        });
    }

    private void login(final String username, String password) {
        firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d("signin", "Sign in success");
                    MainActivity.isLogin = true;
                } else {
                    Log.d("signin", "Sign in failed");
                }
            }
        });


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userID = user.getUid();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users");
        ref.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User nguoidung = snapshot.getValue(User.class);
                Intent intent = getActivity().getIntent();
                intent.setClass(getActivity(), MainActivity.class);
                intent.putExtra("nguoidung", nguoidung);
                getActivity().startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}


