package com.czertainly.api.model.connector.signing;

import com.czertainly.api.model.common.NameAndUuidDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SigningEngineDto extends NameAndUuidDto {

    @Schema(description = "List of Signing Engine Attributes",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private List<BaseAttribute> attributes;


}
