package com.czertainly.api.interfaces.connector.v2;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.model.common.AttributeDefinition;
import com.czertainly.api.model.common.RequestAttributeDto;
import com.czertainly.api.model.connector.v2.CertRevocationDto;
import com.czertainly.api.model.connector.v2.CertificateDataResponseDto;
import com.czertainly.api.model.connector.v2.CertificateRenewRequestDto;
import com.czertainly.api.model.connector.v2.CertificateSignRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/authorityProvider/authorities/{uuid}/certificates")
@Tag(name = "Certificate Management API", description = "Certificate Management API")
public interface CertificateController {

    @Operation(
            summary = "List of Attributes to issue Certificate"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Attribute list retrieved"
                    )
    })
    @RequestMapping(path = "/issue/attributes", method = RequestMethod.GET)
    List<AttributeDefinition> listIssueCertificateAttributes(
            @PathVariable String uuid) throws NotFoundException;

    @Operation(
            summary = "Validate list of Attributes to issue Certificate"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Attributes validated"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Unprocessable Entity",
                            content = @Content(schema = @Schema(implementation = ValidationException.class)
                    ))
            })
    @RequestMapping(path = "/issue/attributes/validate", method = RequestMethod.POST)
    boolean validateIssueCertificateAttributes(
            @PathVariable String uuid,
            @RequestBody List<RequestAttributeDto> attributes) throws NotFoundException, ValidationException;

    @Operation(
            summary = "Issue Certificate"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Certificate issued"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Unprocessable Entity",
                            content = @Content(schema = @Schema(implementation = ValidationException.class)
                            ))
            })
    @RequestMapping(path = "/issue", method = RequestMethod.POST)
    CertificateDataResponseDto issueCertificate(
            @PathVariable String uuid,
            @RequestBody CertificateSignRequestDto request) throws NotFoundException;

    @Operation(
            summary = "Renew Certificate"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Certificate renewed"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Unprocessable Entity",
                            content = @Content(schema = @Schema(implementation = ValidationException.class)
                            ))
            })
    @RequestMapping(path = "/{certificateId}/renew", method = RequestMethod.POST)
    CertificateDataResponseDto renewCertificate(
            @PathVariable String uuid,
            @PathVariable String certificateId,
            @RequestBody CertificateRenewRequestDto request) throws NotFoundException;

    @Operation(
            summary = "List of Attributes to revoke Certificate"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Attribute list retrieved"
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Unprocessable Entity",
                            content = @Content(schema = @Schema(implementation = ValidationException.class)
                            ))
            })
    @RequestMapping(path = "/revoke/attributes", method = RequestMethod.GET)
    List<AttributeDefinition> listRevokeCertificateAttributes(
            @PathVariable String uuid) throws NotFoundException;

    @Operation(
            summary = "Validate list of Attributes to revoke certificate"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Attributes validated"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Unprocessable Entity",
                            content = @Content(schema = @Schema(implementation = ValidationException.class)
                            ))
            })
    @RequestMapping(path = "/revoke/attributes/validate", method = RequestMethod.POST)
    boolean validateRevokeCertificateAttributes(
            @PathVariable String uuid,
            @RequestBody List<RequestAttributeDto> attributes) throws NotFoundException, ValidationException;

    @Operation(
            summary = "Revoke Certificate"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Certificate revoked"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Unprocessable Entity",
                            content = @Content(schema = @Schema(implementation = ValidationException.class)
                            ))
            })
    @RequestMapping(path = "/{certificateId}/revoke", method = RequestMethod.POST)
    void revokeCertificate(
            @PathVariable String uuid,
            @PathVariable String certificateId,
            @RequestBody CertRevocationDto request) throws NotFoundException;
}
