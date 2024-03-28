package com.czertainly.api.interfaces.core.client;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SignResponseDto {


    @Schema(description = "UUID of the signature", requiredMode = Schema.RequiredMode.REQUIRED)
    private String uuid;

}
