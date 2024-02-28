package com.czertainly.api.model.connector.signing;

import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class SigningEngineUpdateDto {

    @Schema(description = "List of Signing Engine Attributes",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private List<RequestAttributeDto> attributes;

}
