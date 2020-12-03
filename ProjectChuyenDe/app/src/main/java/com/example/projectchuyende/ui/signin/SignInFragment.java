package com.example.projectchuyende.ui.signin;

import android.content.Intent;
import android.os.Bundle;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_signin, container, false);
        btnSignup = root.findViewById(R.id.btnSignup);
        tvForgotpass = root.findViewById(R.id.tvForgotpassword);
        edtAccount = root.findViewById(R.id.edtAccount);
        edtPassword = root.findViewById(R.id.edtPassword);
        btnSignin = root.findViewById(R.id.btnSignin);
        setEvent();
        return root;
    }

    public void setEvent() {
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignUpActivity.class);
                getActivity().startActivity(intent);
            }
        });
        tvForgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ForgotPassWordActivity.class);
                getActivity().startActivity(intent);
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                reference.child("login").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String username = edtAccount.getText().toString();
                        String password = edtPassword.getText().toString();
                        if (snapshot.child(username).exists()) {
                            if (snapshot.child(username).child("password").getValue(String.class).equals(password)) {
                                if (snapshot.child(username).child("as").getValue(String.class).equals("user")) {
                                    Log.d("user", "User login sucess");
                                } else {
                                    if (snapshot.child(username).child("as").getValue(String.class).equals("admin")) {
                                        Log.d("admin", "Admin login sucess");
                                    }
                                }
                            }
                        } else {
                            Log.d("failed", "login failed");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

}
