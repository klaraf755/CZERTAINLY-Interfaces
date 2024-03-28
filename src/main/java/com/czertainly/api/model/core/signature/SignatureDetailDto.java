package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.client.attribute.ResponseAttributeDto;
import com.czertainly.api.model.client.signing.SignatureDataDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SignatureDetailDto extends SignatureDto {

    @Schema(description = "Data to be signed")
    private List<SignatureDataDto> dataToBeSigned;

    @Schema(description = "Signed Data")
    private List<SignatureDataDto> signedData;

    @Schema(description = "Description of Signed Data or data waiting to be signed")
    private String dataDescription;

    @Schema(description = "Attributes of the signature",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private List<ResponseAttributeDto> signatureAttributes;


}
