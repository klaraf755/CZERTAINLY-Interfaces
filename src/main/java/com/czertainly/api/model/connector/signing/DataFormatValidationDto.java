package com.czertainly.api.model.connector.signing;

import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DataFormatValidationDto {

    @Schema(description = "Data for format validation")
    private byte[] data;

    @Schema(description = "Signature Profile attributes")
    private List<BaseAttribute> signatureProfileAttributes;
}
