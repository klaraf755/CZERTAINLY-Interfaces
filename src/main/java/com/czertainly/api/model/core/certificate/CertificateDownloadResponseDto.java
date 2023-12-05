package com.czertainly.api.model.core.certificate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class CertificateDownloadResponseDto {

    @Schema(
            description = "Format of the downloaded certificate",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private CertificateFormat format;

    @Schema(
            description = "Encoding of the downloaded certificate",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private CertificateFormatEncoding encoding;

    @Schema(
            description = "Base64 encoded certificate in the specified format",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String content;

}
