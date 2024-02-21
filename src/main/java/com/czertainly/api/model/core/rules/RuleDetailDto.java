package com.czertainly.api.model.core.rules;

import com.czertainly.api.model.common.attribute.v1.ResponseAttributeDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RuleDetailDto extends RuleDto {

    @Schema(
            description = "Attributes of the Rule"
    )
    private List<ResponseAttributeDto> attributes;

    @Schema(
            description = "List of conditions in the Rule"
    )
    private List<RuleConditionDto> conditions;

    @Schema(
            description = "List of condition groups in the Rule"
    )
    private List<RuleConditionGroupDto> conditionGroups;

}