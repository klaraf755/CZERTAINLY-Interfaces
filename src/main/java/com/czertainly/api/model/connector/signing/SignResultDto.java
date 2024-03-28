package com.czertainly.api.model.connector.signing;

import com.czertainly.api.model.client.signing.SignatureDataDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.common.attribute.v2.MetadataAttribute;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class SignResultDto {


    @Schema(description = "Signed Data or data waiting to be signed")
    private List<SignatureDataDto> data;

    @Schema(description = "Metadata of the signature",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private List<MetadataAttribute> meta;

}
