package com.czertainly.api.model.client.signing;

import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ClientSignRequestDto {

    @Schema(description = "Signature Attributes", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<RequestAttributeDto> signatureAttributes;

    @Schema(description = "Data to be signed")
    private byte[] data;

    @Schema(description = "Signed data is saved")
    private boolean saveData;
}
