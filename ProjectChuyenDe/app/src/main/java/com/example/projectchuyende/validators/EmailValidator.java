package com.example.projectchuyende.validators;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean isValidEmail(CharSequence target) {
        return (Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
