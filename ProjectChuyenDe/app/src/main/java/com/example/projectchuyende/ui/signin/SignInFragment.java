package com.example.projectchuyende.ui.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.projectchuyende.R;
import com.example.projectchuyende.activity.forgotpassword.ForgotPassWordActivity;
import com.example.projectchuyende.activity.signup.SignUpActivity;

public class SignInFragment extends Fragment {
    Button btnSignup;
    TextView tvForgotpass;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_signin, container, false);
        btnSignup = root.findViewById(R.id.btnSignup);
        tvForgotpass = root.findViewById(R.id.tvForgotpassword);
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
    }

}
