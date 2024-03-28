package com.czertainly.api.model.client.signing;

import com.czertainly.api.model.common.attribute.v1.RequestAttributeDto;
import com.czertainly.api.model.connector.signing.VerificationReport;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ClientSignatureVerificationRequestDto {

    @Schema(description = "Validation Attributes", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<RequestAttributeDto> verificationAttributes;

    @Schema(description = "Signed Data with signature to be verified",requiredMode = Schema.RequiredMode.REQUIRED)
    private List<SignatureDataDto> data;

    @Schema(description = "Original Data without signature")
    private List<SignatureDataDto> originalData;

    @Schema(description = "Type of validation report returned")
    private VerificationReport verificationReport;

}
