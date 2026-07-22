package com.otilm.api.model.common.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidOidValidatorTest {

    private final ValidOidValidator validator = new ValidOidValidator();

    @Test
    void nullIsValid() {
        // Optional OID fields pair @ValidOid with @NotBlank/@NullableNotBlank for presence.
        assertTrue(validator.isValid(null, null));
    }

    @Test
    void dottedDecimalOidsAreValid() {
        assertTrue(validator.isValid("2.5.29.37", null));
        assertTrue(validator.isValid("0.9.2342.19200300.100.1.25", null));
        assertTrue(validator.isValid("1.3.6.1.4.1.311.20.2.3", null));
    }

    @Test
    void arbitraryStringsAreInvalid() {
        assertFalse(validator.isValid("", null));
        assertFalse(validator.isValid("not-an-oid", null));
        assertFalse(validator.isValid("2.5.29.37 with trailing text", null));
    }

    @Test
    void controlCharacterPayloadsAreInvalid() {
        // The OID rides log lines and persisted event messages; CR/LF must never pass.
        assertFalse(validator.isValid("2.5.29.37\ninjected=line", null));
        assertFalse(validator.isValid("2.5.29.37\r\ninjected", null));
    }

    @Test
    void malformedArcsAreInvalid() {
        assertFalse(validator.isValid("3.1.2", null), "first arc must be 0-2 (ITU-T X.660)");
        assertFalse(validator.isValid("2", null), "a single arc is not an OID");
        assertFalse(validator.isValid("2.5.29.037", null), "leading zeros in an arc are rejected");
        assertFalse(validator.isValid("2..5", null), "empty arcs are rejected");
        assertFalse(validator.isValid(".2.5", null), "a leading dot is rejected");
        assertFalse(validator.isValid("2.5.", null), "a trailing dot is rejected");
    }
}
