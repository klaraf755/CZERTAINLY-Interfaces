package com.czertainly.api.model.client.signing;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ClientSignRequestDto {

    @Schema(description = "Data to be signed")
    private List<SignatureDataDto> data;

}
