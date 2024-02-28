package com.czertainly.api.model.connector.signing;

import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SignRequestDto {

    @Schema(description = "Signature Profile Attributes", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<BaseAttribute> signatureProfileAttributes;

    @Schema(description = "Signature Attributes", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<BaseAttribute> signatureAttributes;

    @Schema(description = "Data to be signed")
    private Serializable data;

    @Schema(description = "Signed data is saved")
    private boolean saveData;

}
