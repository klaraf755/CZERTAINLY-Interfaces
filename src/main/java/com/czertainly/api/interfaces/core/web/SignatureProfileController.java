package com.czertainly.api.interfaces.core.web;

import com.czertainly.api.model.common.AuthenticationServiceExceptionDto;
import com.czertainly.api.model.core.raprofile.RaProfileDto;
import com.czertainly.api.model.core.signature.SignatureProfileDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
@Tag(name = "Signature Profile Management", description = "Signature Profile Management API")
@ApiResponses(
        value = {
                @ApiResponse(
                        responseCode = "400",
                        description = "Bad Request",
                        content = @Content(schema = @Schema(implementation = AuthenticationServiceExceptionDto.class))
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unauthorized",
                        content = @Content(schema = @Schema())
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Not Found",
                        content = @Content(schema = @Schema(implementation = AuthenticationServiceExceptionDto.class))
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal Server Error",
                        content = @Content
                )
        })
public interface SignatureProfileController {

    @Operation(summary = "List of available Signature Profiles")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Singnature Profiles retrieved")})
    @RequestMapping(path = "/signatureProfiles", method = RequestMethod.GET, produces = {"application/json"})
    List<SignatureProfileDto> listSignatureProfiles();

}
