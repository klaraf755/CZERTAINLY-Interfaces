package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.common.enums.IPlatformEnum;

public enum PackagingOption implements IPlatformEnum {

    ENVELOPING("enveloping", "Enveloping", "Signature will have Enveloping packing option"),
    ENVELOPED("enveloped", "Enveloped", "Signature will have Enveloped packing option"),
    DETACHED("detached", "Detached", "Signature will have Detached packing option"),
    ;

    private final String code;

    private final String label;

    private final String description;

    PackagingOption(String code, String label, String description) {
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
