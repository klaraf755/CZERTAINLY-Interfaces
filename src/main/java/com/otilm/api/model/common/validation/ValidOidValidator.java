package com.otilm.api.model.common.validation;

import jakarta.validation.ConstraintValidator;

import java.util.regex.Pattern;

public class ValidOidValidator implements ConstraintValidator<ValidOid, String> {

    /** Dotted-decimal OID: first arc 0-2, no leading zeros, 2-128 arcs (same grammar as core's OidHandler). */
    private static final Pattern OID_PATTERN = Pattern.compile("^[0-2](\\.(0|[1-9]\\d{0,38})){1,127}$");

    @Override
    public boolean isValid(String value, jakarta.validation.ConstraintValidatorContext context) {
        return value == null || OID_PATTERN.matcher(value).matches();
    }
}
