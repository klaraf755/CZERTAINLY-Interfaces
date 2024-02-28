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

    @Schema(description = "Name of Signing Engine associated with Signature Profile")
    private String signingEngineName;

    @Schema(description = "UUID of Signing Engine associated with Signature Profile",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String signingEngineUuid;

    @Schema(description = "List of Signature Profile attributes")
    private List<ResponseAttributeDto> attributes;

    @Schema(description = "List of Custom Attributes")
    private List<ResponseAttributeDto> customAttributes;




}
