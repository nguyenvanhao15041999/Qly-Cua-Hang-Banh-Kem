package com.example.projectchuyende.validators;

import java.util.regex.Pattern;

public class PasswordValidator {
    private Pattern pattern;
    private static final String PASSWORD_PATTERN = "((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!.#$@_+,?-]).{8,32})";
    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean validate(final String password) {
        return pattern.matcher(password).matches();
    }
}
