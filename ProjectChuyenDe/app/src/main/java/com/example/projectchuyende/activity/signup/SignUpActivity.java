package com.example.projectchuyende.activity.signup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;

import com.example.projectchuyende.R;


public class SignUpActivity extends Activity {
    ImageView imgBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        imgBack= findViewById(R.id.imgBack);
        setControl();
        Toolbar toolbar = findViewById(R.id.toolbar_forgotpassword);
    }
    private void setControl(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
