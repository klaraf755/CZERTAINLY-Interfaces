package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.common.enums.IPlatformEnum;
import com.czertainly.api.model.core.certificate.CertificateState;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true)
public enum SignatureStatus implements IPlatformEnum {

    REQUESTED("requested", "Requested"),
    REJECTED("rejected", "Rejected"),
    PENDING_APPROVAL("pending_approval", "Pending approval"),
    SIGNED("signed", "Signed", "Data has been signed"),
    ;

    private static final SignatureStatus[] VALUES;

    static {
        VALUES = values();
    }

    private final String code;
    private final String label;
    private final String description;

    SignatureStatus(String code, String label) {
        this(code, label,null);
    }

    SignatureStatus(String code, String label, String description) {
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
