package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.client.attribute.ResponseAttributeDto;
import com.czertainly.api.model.common.NameAndUuidDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AddSigningEngineDto {

    @Schema(description = "Signing Engine name",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "List of Signing Engine Attributes",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private List<RequestAttributeDto> attributes = new ArrayList<>();

    @Schema(description = "List of Custom Attributes")
    private List<ResponseAttributeDto> customAttributes;

    @Schema(description = "UUID of Signature provider",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String connectorUuid;

    @Schema(description = "Signing Engine Kind",
            example = "Czertainly, SignServer, etc.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String kind;

}
