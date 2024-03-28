package com.czertainly.api.interfaces.core.client;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class VerificationReportDto {
    // plus dalsie

    @Schema(description = "Signature is valid")
    private boolean valid;

}
