package com.example.projectchuyende.validators;

import java.util.regex.Pattern;

public class AddressValidator {
    private Pattern pattern;
    private static final String USERNAME_PATTERN = "^[a-z0-9._-]{5,150}$";

    public AddressValidator() {
        pattern = Pattern.compile(USERNAME_PATTERN);
    }

    public boolean validate(final String address) {
        return pattern.matcher(address).matches();
    }
}
