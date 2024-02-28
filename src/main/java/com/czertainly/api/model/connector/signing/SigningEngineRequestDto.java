package com.czertainly.api.model.connector.signing;

import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@Data
public class SigningEngineRequestDto {

    @Schema(description = "Signing Engine name",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Kind of Signing Engine",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String kind;

    @Schema(description = "List of Signing Engine Attributes",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private List<RequestAttributeDto> attributes;

}
