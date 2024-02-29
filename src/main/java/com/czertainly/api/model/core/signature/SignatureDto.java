package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.client.attribute.ResponseAttributeDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.core.auth.UserDto;
import com.czertainly.api.model.core.certificate.group.GroupDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SignatureDto {

    @Schema(description = "UUID of Signature")
    private String uuid;

    @Schema(description = "Signed Data or data waiting to be signed")
    private byte[] data;

    @Schema(description = "Description of Signed Data or data waiting to be signed")
    private String dataDescription;

    @Schema(description = "UUID of Signature Profile used to sign the data",
        requiredMode = Schema.RequiredMode.REQUIRED)
    private String signatureProfileUuid;

    @Schema(description = "Owner of the signed data",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private UserDto creator;

    @Schema(description = "Group assigned to the signed data")
    private GroupDto group;

    @Schema(description = "Indicator whether data has already been signed",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private SignatureStatus status;

    @Schema(description = "Date when the data has been signed")
    private Date signedAt;

    @Schema(description = "Date when the signature has been requested")
    private Date createdAt;

    @Schema(description = "Attributes of the signature",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private List<ResponseAttributeDto> signatureAttributes;
}
