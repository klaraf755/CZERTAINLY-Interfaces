package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.common.enums.IPlatformEnum;

public enum SignatureAlgorithm implements IPlatformEnum {


    ;

    private final String code;

    private final String label;

    private final String description;

    SignatureAlgorithm(String code, String label, String description) {
        this.code = code;
        this.label = label;
        this.description = description;
    }

    @Override
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
