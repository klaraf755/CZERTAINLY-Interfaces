package com.czertainly.api.interfaces.connector.signing;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.common.ErrorMessageDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.connector.authority.*;
import com.czertainly.api.model.connector.signing.SigningEngineDto;
import com.czertainly.api.model.connector.signing.SigningEngineRequestDto;
import com.czertainly.api.model.connector.signing.SigningEngineUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/signingProvider/signingEngines")
@ApiResponses(
        value = {
                @ApiResponse(
                        responseCode = "400",
                        description = "Bad Request",
                        content = @Content(schema = @Schema(implementation = ErrorMessageDto.class))
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
@Tag(name = "Signing Engine Management", description = "Signing Engine Management API")
public interface SigningEngineController {

    @Operation(summary = "List Signing Engines")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signing Engine list retrieved")})
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    List<SigningEngineDto> listSigningEngines();

    @Operation(summary = "Get Signing Engine details")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signing Engine details retrieved")})
    @RequestMapping(path = "/{uuid}", method = RequestMethod.GET, produces = {"application/json"})
    SigningEngineDto getSingingEngine(@Parameter(description = "Signing Engine UUID") @PathVariable String uuid) throws NotFoundException;

    @Operation(summary = "Create Signing Engine")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signing Engine created")})
    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    SigningEngineDto createSigningEngine(@RequestBody SigningEngineRequestDto request);

    @Operation(summary = "Update Signing Engine")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signing Engine updated")})
    @RequestMapping(path = "/{uuid}", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    SigningEngineDto updateSigningEngine(@Parameter(description = "Signing Engine UUID") @PathVariable String uuid, @RequestBody SigningEngineUpdateDto request) throws NotFoundException;

    @Operation(summary = "Remove Signing Engine")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Signing Engine removed")})
    @RequestMapping(path = "/{uuid}", method = RequestMethod.DELETE)
    void removeSigningEngine(@Parameter(description = "Signing Engine UUID") @PathVariable String uuid) throws NotFoundException;

    @Operation(summary = "Check status of Signing Engine connection")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Signing Engine connected")})
    @RequestMapping(path = "/{signingEngineUuid}/connection", method = RequestMethod.GET, produces = {"application/json"})
    void checkSigningEngineConnection(@Parameter(description = "Signing Engine UUID") @PathVariable String signingEngineUuid);

    @Operation(summary = "List Signature Profile Attributes")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
                            description = "Signature Profile Attributes retrieved"
                    )
            })
    @RequestMapping(path = "/{uuid}/signatureProfile/attributes", method = RequestMethod.GET, produces = {"application/json"})
    List<BaseAttribute> listSignatureProfileAttributes(@Parameter(description = "Signing Engine UUID") @PathVariable String uuid) throws NotFoundException;

    @Operation(summary = "Validate Signature Profile attributes")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Signature Profile Attributes information validated"
                    )
            })
    @RequestMapping(path = "/{uuid}/signatureProfile/attributes/validate", method = RequestMethod.POST, consumes = {"application/json"})
    void validateSignatureProfileAttributes(@Parameter(description = "Signing Engine UUID") @PathVariable String uuid, @RequestBody List<RequestAttributeDto> attributes) throws ValidationException, NotFoundException;


}