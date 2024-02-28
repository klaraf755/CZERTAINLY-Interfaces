package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.client.attribute.ResponseAttributeDto;
import com.czertainly.api.model.common.NameAndUuidDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SigningEngineDto {

    @Schema(description = "Signing Engine name",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Signing Engine UUID",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String uuid;

    @Schema(description = "List of Signing Engine Attributes",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private List<ResponseAttributeDto> attributes = new ArrayList<>();

    @Schema(description = "List of Custom Attributes")
    private List<ResponseAttributeDto> customAttributes;

    @Schema(description = "Status of Authority instance",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String status;

    @Schema(description = "UUID of Signature provider",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String connectorUuid;

    @Schema(description = "Name of Signature provider",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String connectorName;

    @Schema(description = "Signing Engine Kind",
            example = "Czertainly, SignServer, etc.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String kind;


}
