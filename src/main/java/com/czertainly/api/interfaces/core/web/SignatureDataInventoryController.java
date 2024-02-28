package com.czertainly.api.interfaces.core.web;


import com.czertainly.api.model.common.AuthenticationServiceExceptionDto;
import com.czertainly.api.model.common.ErrorMessageDto;
import com.czertainly.api.model.core.signature.SignedDataDto;
import com.czertainly.api.model.core.signature.SignedDataRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/signedData")
@Tag(name = "Signed Data Inventory Management", description = "Signed Data Inventory Management API")
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
    SignedDataDto uploadSignedData(@RequestBody SignedDataRequestDto signedDataRequestDto);

    @Operation(summary = "Delete Signed Data or Data waiting to be signed")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Data deleted")})
    @RequestMapping(path = "/uuid", produces = {"application/json"}, method = RequestMethod.DELETE)
    void deleteSignedData(@Parameter(description = "Signed Data UUID") @PathVariable String uuid);


}
