package com.example.projectchuyende.activity.signup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projectchuyende.R;
import com.example.projectchuyende.validators.AddressValidator;
import com.example.projectchuyende.validators.EmailValidator;
import com.example.projectchuyende.validators.PasswordValidator;
import com.example.projectchuyende.validators.PhoneNumberValidator;
import com.example.projectchuyende.validators.UsernameValidator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;


public class SignUpActivity extends Activity {
    ImageView imgBack;
    EditText edtAccount, edtPassword, edtEmail, edtPhoneNumber, edtAddress;
    Button btnSignup;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();

        imgBack = findViewById(R.id.imgBack);
        edtAccount = findViewById(R.id.edtAccount);
        edtPassword = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        edtAddress = findViewById(R.id.edtAddress);
        btnSignup = findViewById(R.id.btnSignup);

        setControl();
        Toolbar toolbar = findViewById(R.id.toolbar_forgotpassword);
    }

    private void setControl() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtAccount.getText().toString();
                String password = edtPassword.getText().toString();
                String email = edtEmail.getText().toString();
                String address = edtAddress.getText().toString();
                String phoneNumber = edtPhoneNumber.getText().toString();

//                UsernameValidator usernameValidator = new UsernameValidator();
//                PasswordValidator passwordValidator = new PasswordValidator();
//                EmailValidator emailValidator = new EmailValidator();
//                AddressValidator addressValidator = new AddressValidator();
//                PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
//
//                if (usernameValidator.validate(username) == false) {
//                    return;
//                } else if (passwordValidator.validate(password) == false) {
//                    return;
//                } else if (emailValidator.validate(email) == false) {
//                    return;
//                } else if (addressValidator.validate(address) == false) {
//                    return;
//                } else if (phoneNumberValidator.validate(phoneNumber) == false) {
//                    return;
//                } else {
//                    String permisstion = "user";
//                    register(username, password, email, address, phoneNumber, permisstion);
//                }

                String permisstion = "user";
                register(username, password, email, address, phoneNumber, permisstion);
            }
        });
    }

    private void register(final String username, final String password, final String email, final String address, final String phoneNumber, final String permisstion) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    String userId = firebaseUser.getUid();
                    databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userId);

                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("userId", userId);
                    hashMap.put("username", username);
                    hashMap.put("email", email);
                    hashMap.put("address", address);
                    hashMap.put("phoneNumber", phoneNumber);
                    hashMap.put("permisstion", permisstion);

                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Sign up success!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignUpActivity.this, "Sign up failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(SignUpActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
