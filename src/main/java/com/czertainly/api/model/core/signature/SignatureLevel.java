package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.common.enums.IPlatformEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true)
public enum SignatureLevel implements IPlatformEnum {
    BASELINE_B("b-b", "Baseline-B","Provides requirements for the incorporation of signed and some unsigned attributes when the signature is actually generated."),
    BASELINE_T("b-t", "Baseline-T","Provides requirement for the generation and inclusion of a trusted token for an existing signature, proving that the signature itself actually existed at a certain date and time."),
    BASELINE_LT("b-lt", "Baseline-LT","Provides requirements for the incorporation of all the material required for validating the signature in the signature document."),
    BASELINE_LTA("b-lta", "Baseline-LTA","Provides requirements for the incorporation of time-stamp tokens that allow validation of the signature long time after its generation."),
    ;

    private final String code;

    private final String label;

    private final String description;

    SignatureLevel(String code, String label, String description) {
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
