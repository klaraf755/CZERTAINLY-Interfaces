package com.czertainly.api.interfaces.core.web;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.client.attribute.ResponseAttributeDto;
import com.czertainly.api.model.common.AuthenticationServiceExceptionDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.core.raprofile.RaProfileDto;
import com.czertainly.api.model.core.signature.SignatureProfileDto;
import com.czertainly.api.model.core.signature.SignatureProfileRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

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
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signature Profiles retrieved")})
    @RequestMapping(path = "/signatureProfiles", method = RequestMethod.GET, produces = {"application/json"})
    List<SignatureProfileDto> listSignatureProfiles();

    @Operation(summary = "Create a Signature Profiles")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Signature Profile created")})
    @RequestMapping(path = "/signatureProfiles", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    SignatureProfileDto createSignatureProfile(@RequestBody SignatureProfileRequestDto signatureProfileRequestDto);

    @Operation(summary = "Get Signature Profile Details")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signature Profile details retrieved")})
    @RequestMapping(path = "/signatureProfiles/{signatureProfileUuid}", method = RequestMethod.GET, produces = {"application/json"})
    SignatureProfileDto getSignatureProfileDetails(@Parameter(description = "Signature Profile UUID") @PathVariable String signatureProfileUuid);


    @Operation(summary = "Update Signature Profile")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signature Profile updated.")})
    @RequestMapping(path = "/signatureProfiles/{signatureProfileUuid}", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    SignatureProfileDto updateSignatureProfile(@Parameter(description = "Signature Profile UUID") @PathVariable String signatureProfileUuid, @RequestBody SignatureProfileRequestDto signatureProfileRequestDto);

    @Operation(summary = "Delete Signature Profile")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Signature Profile deleted.")})
    @RequestMapping(path = "/signatureProfiles/{signatureProfileUuid}", method = RequestMethod.DELETE)
    void deleteSignatureProfile(@Parameter(description = "Signature Profile UUID") @PathVariable String signatureProfileUuid);

    @Operation(summary = "List Signature Profile attributes")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signature Profile attributes retrieved")})
    @RequestMapping(path = "/signatureProfiles/{signatureProfileUuid}/attributes", method = RequestMethod.GET, produces = {"application/json"})
    List<ResponseAttributeDto> listSignatureProfileAttributes(@Parameter(description = "Signature Profile UUID") @PathVariable String signatureProfileUuid);

    @Operation(summary = "Validate Signature Profile attributes")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signature Profile Attributes information validated")})
    @RequestMapping(path = "/{uuid}/signatureProfile/attributes/validate", method = RequestMethod.POST, consumes = {"application/json"})
    void validateSignatureProfileAttributes(@Parameter(description = "Signing Engine UUID") @PathVariable String uuid, @RequestBody List<RequestAttributeDto> attributes) throws ValidationException, NotFoundException;

}
