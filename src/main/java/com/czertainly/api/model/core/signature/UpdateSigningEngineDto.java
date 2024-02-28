package com.czertainly.api.model.core.signature;

import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.client.attribute.ResponseAttributeDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UpdateSigningEngineDto {

    @Schema(description = "List of Signing Engine Attributes",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private List<RequestAttributeDto> attributes = new ArrayList<>();

    @Schema(description = "List of Custom Attributes")
    private List<ResponseAttributeDto> customAttributes;


}
