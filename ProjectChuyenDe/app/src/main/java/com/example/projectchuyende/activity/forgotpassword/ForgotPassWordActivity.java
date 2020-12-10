package com.example.projectchuyende.activity.forgotpassword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projectchuyende.R;
import com.example.projectchuyende.ui.signin.SignInFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassWordActivity extends Activity {
    ImageView tvBack;
    Toolbar toolbar;
    EditText edtEmailToReset;
    Button btnReset;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword_activity);
        tvBack = findViewById(R.id.imgBack);
        Toolbar toolbar = findViewById(R.id.toolbar_forgotpassword);
        edtEmailToReset = findViewById(R.id.edtEmailToReset);
        btnReset = findViewById(R.id.btnReset);

        firebaseAuth = FirebaseAuth.getInstance();

        setControl();

    }

    private void setControl() {
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmailToReset.getText().toString();
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ForgotPassWordActivity.this, "Check email to reset!", Toast.LENGTH_SHORT).show();
                        }else{
                            String mes = task.getException().getMessage();
                            Toast.makeText(ForgotPassWordActivity.this, "Error: " + mes, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
