package com.otilm.api.model.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Validates that a string is a dotted-decimal ASN.1 object identifier (ITU-T X.660: first arc 0-2,
 * no leading zeros, up to 128 arcs). Null values are valid — pair with {@code @NotBlank} where the
 * OID is required. Mirrors core's {@code OidHandler.isOid} grammar so boundary validation and
 * runtime checks agree.
 */
@Constraint(validatedBy = ValidOidValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidOid {

    String message() default "must be a dotted-decimal object identifier (OID)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
