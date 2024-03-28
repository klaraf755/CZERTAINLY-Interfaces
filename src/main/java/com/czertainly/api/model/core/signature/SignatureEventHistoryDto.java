package com.czertainly.api.model.core.signature;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SignatureEventHistoryDto {

    @Schema(description = "UUID of the event", requiredMode = Schema.RequiredMode.REQUIRED)
    private String uuid;

    @Schema(description = "UUID of the Signature", requiredMode = Schema.RequiredMode.REQUIRED)
    private String signatureUuid;

    @Schema(description = "Event creation time", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime created;

    @Schema(description = "Data when data has been signed")
    private LocalDateTime signedAt;

    @Schema(description = "Data when data has been approved for signing")
    private LocalDateTime approvedAt;

    @Schema(description = "Created By", requiredMode = Schema.RequiredMode.REQUIRED)
    private String createdBy;

    @Schema(description = "Event message", requiredMode = Schema.RequiredMode.REQUIRED)
    private String message;



}
