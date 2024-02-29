package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.core.auth.UserDto;
import com.czertainly.api.model.core.certificate.group.GroupDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Data
public class SignedDataRequestDto {


    @Schema(description = "Signed Data or data waiting to be signed")
    private byte[] data;

    @Schema(description = "Description of Signed Data or data waiting to be signed")
    private String dataDescription;

    @Schema(description = "UUID of Signature Profile used to sign the data",
        requiredMode = Schema.RequiredMode.REQUIRED)
    private String signatureProfileUuid;

    @Schema(description = "Owner of the signed data",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private UserDto owner;

    @Schema(description = "Group assigned to the signed data")
    private GroupDto group;

    @Schema(description = "Indicator whether data has already been signed",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private boolean signed;

    @Schema(description = "Date when the data has been signed")
    private Date signatureDate;

    @Schema(description = "Attributes of the signature",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private List<BaseAttribute> signatureAttributes;
}
