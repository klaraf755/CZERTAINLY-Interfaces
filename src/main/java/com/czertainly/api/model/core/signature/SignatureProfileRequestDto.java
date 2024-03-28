package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.client.attribute.ResponseAttributeDto;
import com.czertainly.api.model.common.NameAndUuidDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class SignatureProfileRequestDto {

    @Schema(description = "Signature Profile Name",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;


    @Schema(description = "Signature Profile description")
    private String description;

    @Schema(description = "UUID of Signing Engine associated with Signature Profile",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String signingEngineUuid;

    @Schema(description = "Format of signature")
    private SignatureFormat signatureFormat;

    @Schema(description = "Level of signature")
    private SignatureLevel signatureLevel;

    @Schema(description = "Signature Algorithm used to sign data")
    private SignatureAlgorithm signatureAlgorithm;

    @Schema(description = "Packaging option")
    private PackagingOption packagingOption;

    @Schema(description = "List of Signature Profile attributes")
    private List<ResponseAttributeDto> attributes;

    @Schema(description = "List of Custom Attributes")
    private List<ResponseAttributeDto> customAttributes;

    @Schema(description = "Signed data will be saved")
    boolean saveData;




}
