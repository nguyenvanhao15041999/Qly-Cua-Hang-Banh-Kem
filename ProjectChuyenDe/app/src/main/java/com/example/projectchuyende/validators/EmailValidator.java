package com.example.projectchuyende.validators;

import java.util.regex.Pattern;

public class EmailValidator {
    private Pattern pattern;
    public static final String EMAIL_PATTERN = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean validate(String emailStr) {
        return pattern.matcher(emailStr).matches();
    }
}
