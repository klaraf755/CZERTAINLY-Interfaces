package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.common.enums.IPlatformEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true)
public enum SignatureFormat implements IPlatformEnum {

    PADES("pAdES", "PAdES","Signature format for PDF files"),
    XADES("xAdES", "XAdES","Signature format for XML files"),
    CADES("cAdES", "CAdES","Signature format for cryptographic message syntax"),
    JADES("jAdES", "JAdES","Signature format for JSON"),
    ASIC("aSiC", "ASiC","Signature format for multiple files"),
    OTHER("other", "Other", "Signature format not defined in enum")
    ;

    private final String code;

    private final String label;

    private final String description;

    SignatureFormat(String code, String label, String description) {
        this.code = code;
        this.label = label;
        this.description = description;
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
