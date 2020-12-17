package com.example.projectchuyende.ui.signin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.example.projectchuyende.validators.PasswordValidator;
import com.example.projectchuyende.validators.UsernameValidator;
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

public class SignInFragment extends Fragment {
    Button btnSignup;
    TextView tvForgotpass;
    EditText edtAccount;
    EditText edtPassword;
    Button btnSignin;
    private FirebaseAuth firebaseAuth;
    Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_signin, container, false);
        btnSignup = root.findViewById(R.id.btnSignup);
        tvForgotpass = root.findViewById(R.id.tvForgotpassword);
        edtAccount = root.findViewById(R.id.edtAccount);
        edtPassword = root.findViewById(R.id.edtPassword);
        btnSignin = root.findViewById(R.id.btnSignin);

        firebaseAuth = FirebaseAuth.getInstance();

        intent = getActivity().getIntent();

        setEvent();
        return root;


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


