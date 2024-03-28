package com.czertainly.api.interfaces.core.web;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UpdateSignatureRequestDto {

    @Schema(description = "Description of Signed Data or data waiting to be signed")
    private String dataDescription;

    @Schema(description = "Owner of the signed data",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String creator;

    @Schema(description = "Group of the signed data",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String group;

}
