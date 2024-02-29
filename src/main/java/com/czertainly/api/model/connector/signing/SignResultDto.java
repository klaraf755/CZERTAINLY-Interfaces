package com.czertainly.api.model.connector.signing;

import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.common.attribute.v2.MetadataAttribute;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class SignResultDto {


    @Schema(description = "Signed Data or data waiting to be signed")
    private byte[] data;

    @Schema(description = "Metadata of the signature",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private List<MetadataAttribute> meta;

}
