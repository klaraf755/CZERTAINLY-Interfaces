package com.czertainly.api.model.connector.signing;

import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SignatureValidationRequestDto {

    @Schema(description = "Signature Profile Attributes", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<BaseAttribute> signatureProfileAttributes;

    @Schema(description = "Signed Data with signature to be verified")
    private Serializable data;

}
