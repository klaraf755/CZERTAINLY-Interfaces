package com.czertainly.api.interfaces.core.web;


import com.czertainly.api.model.client.signing.SignatureDataDto;
import com.czertainly.api.model.common.AuthenticationServiceExceptionDto;
import com.czertainly.api.model.common.ErrorMessageDto;
import com.czertainly.api.model.core.signature.SignatureDetailDto;
import com.czertainly.api.model.core.signature.SignatureDto;
import com.czertainly.api.model.core.signature.SignatureEventHistoryDto;
import com.czertainly.api.model.core.signature.SignedDataRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/signedData")
@Tag(name = "Signed Data Inventory Management", description = "Signature Inventory Management API")
@ApiResponses(
        value = {
                @ApiResponse(
                        responseCode = "400",
                        description = "Bad Request",
                        content = @Content(schema = @Schema(implementation = ErrorMessageDto.class))
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unauthorized",
                        content = @Content(schema = @Schema())
                ),
                @ApiResponse(
                        responseCode = "403",
                        description = "Forbidden",
                        content = @Content(schema = @Schema(implementation = AuthenticationServiceExceptionDto.class))
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Not Found",
                        content = @Content(schema = @Schema(implementation = ErrorMessageDto.class))
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal Server Error",
                        content = @Content
                )
        })
public interface SignatureDataInventoryController {

    @Operation(summary = "Upload Signed Data or Data waiting to be signed")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Data uploaded")})
    @RequestMapping(produces = {"application/json"}, method = RequestMethod.POST)
    SignatureDetailDto uploadSignedData(@RequestBody SignedDataRequestDto signedDataRequestDto);

    @Operation(summary = "Delete Signed Data or Data waiting to be signed")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Data deleted")})
    @RequestMapping(path = "/uuid", produces = {"application/json"}, method = RequestMethod.DELETE)
    void deleteSignedData(@Parameter(description = "Signed Data UUID") @PathVariable String uuid);

    @Operation(summary = "List all Signatures")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "List of Signatures retrieved")})
    @RequestMapping(produces = {"application/json"}, method = RequestMethod.GET)
    List<SignatureDto> listSignatures();

    @Operation(summary = "Edit Signature")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signature updated")})
    @RequestMapping(path = "/uuid", produces = {"application/json"}, method = RequestMethod.PUT)
    SignatureDetailDto updateSignature(@Parameter(description = "Signature UUID") @PathVariable String uuid, @RequestBody UpdateSignatureRequestDto request);

    @Operation(summary = "Download Signed Data")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signed Data retrieved")})
    @RequestMapping(path = "/uuid", produces = {"application/json"}, method = RequestMethod.GET)
    List<SignatureDataDto> downloadSignedData(@Parameter(description = "Signature UUID") @PathVariable String uuid);

    @Operation(summary = "Get Signature event history")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signature event history retrieved")})
    @GetMapping(path = "/{uuid}/history", produces = {MediaType.APPLICATION_JSON_VALUE})
    List<SignatureEventHistoryDto> getSignatureEventHistory(@Parameter(description = "Signature UUID") @PathVariable String uuid);


}
