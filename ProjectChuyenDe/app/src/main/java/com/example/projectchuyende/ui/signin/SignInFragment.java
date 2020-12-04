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
import com.example.projectchuyende.validators.EmailValidator;
import com.example.projectchuyende.validators.PasswordValidator;
import com.example.projectchuyende.validators.UsernameValidator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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
                String username = edtAccount.getText().toString(); // username = email
                String password = edtPassword.getText().toString();

//                EmailValidator emailValidator = new EmailValidator();
//                PasswordValidator passwordValidator = new PasswordValidator();
//
//                if (emailValidator.validate(username) == false) {
//                    return;
//                } else if (passwordValidator.validate(password) == false) {
//                    return;
//                } else {
//                    login(username, password);
//                }

                login(username, password);
            }
        });
    }

    private void login(String username, String password) {
        firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("signin", "Sign in success");
                }else{
                    Log.d("signin", "Sign in failed");
                }
            }
        });
    }

}
