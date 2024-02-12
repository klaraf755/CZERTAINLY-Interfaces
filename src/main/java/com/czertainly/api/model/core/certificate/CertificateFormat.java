package com.czertainly.api.model.core.certificate;

import com.czertainly.api.model.common.enums.IPlatformEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Arrays;


@Schema(enumAsRef = true)
public enum CertificateFormat implements IPlatformEnum {

    RAW("raw", "Raw", "Raw certificate format, extension based on encoding"),
    PKCS7("pkcs7", "PKCS#7", "PKCS#7 certificate format");
    private final String code;
    private final String label;
    private final String description;

    private static final CertificateFormat[] VALUES;

    static {
        VALUES = values();
    }

    CertificateFormat(String code, String label, String description) {
        this.code = code;
        this.label = label;
        this.description = description;
    }

    @JsonCreator
    public static CertificateFormat fromCode(String code) {
        return Arrays.stream(VALUES)
                .filter(e -> e.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported certificate format %s.", code)));
    }


    @Override
    @JsonValue
    public String getCode() {
        return this.code;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
