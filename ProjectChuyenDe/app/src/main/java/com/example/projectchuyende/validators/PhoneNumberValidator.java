package com.example.projectchuyende.validators;

import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private Pattern pattern;
    private static final String PHONE_NUMBER_PATTERN = "\\d{10}|(?:\\d{3}-){3}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

    public PhoneNumberValidator() {
        pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
    }

    public boolean validate(final String phoneNumber) {
        return pattern.matcher(phoneNumber).matches();
    }
}
