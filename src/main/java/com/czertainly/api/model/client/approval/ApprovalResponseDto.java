package com.czertainly.api.model.client.approval;

import com.czertainly.api.model.core.scheduler.PaginationResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ApprovalResponseDto extends PaginationResponseDto {

    @Schema(
            description = "List of the Approvals",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private List<ApprovalDto> approvals;

}
