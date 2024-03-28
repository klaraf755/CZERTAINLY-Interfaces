package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.client.attribute.ResponseAttributeDto;
import com.czertainly.api.model.core.certificate.group.GroupDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class SignatureDto {

    @Schema(description = "UUID of Signature")
    private String uuid;

    @Schema(description = "UUID of Signature Profile used to sign the data",
        requiredMode = Schema.RequiredMode.REQUIRED)
    private String signatureProfileUuid;

    @Schema(description = "Signature Algorithm used to signed data")
    private SignatureAlgorithm signatureAlgorithm;

    @Schema(description = "Format of signature")
    private SignatureFormat signatureFormat;

    @Schema(description = "Level of signature")
    private SignatureLevel signatureLevel;

    @Schema(description = "Packaging option")
    private PackagingOption packagingOption;

    @Schema(description = "Indicator whether data has already been signed",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private SignatureStatus status;

    @Schema(description = "Owner of the signed data",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String creator;

    @Schema(description = "Group assigned to the signed data")
    private GroupDto group;


}
