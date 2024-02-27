package com.czertainly.api.model.core.signature;

import io.swagger.v3.oas.annotations.media.Schema;

public class SignatureProfileDto {

    @Schema(description = "UUID of the Signature Profile",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String uuid;

    @Schema(description = "Name of the Signature Profile",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    private String description;

}
