package com.czertainly.api.interfaces.core.web;


import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.model.client.attribute.ResponseAttributeDto;
import com.czertainly.api.model.client.raprofile.AddRaProfileRequestDto;
import com.czertainly.api.model.common.AuthenticationServiceExceptionDto;
import com.czertainly.api.model.common.UuidDto;
import com.czertainly.api.model.core.raprofile.RaProfileDto;
import com.czertainly.api.model.core.signature.*;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/signingEngine")
@Tag(name = "Signing Engine Management", description = "Signature Engine Management API")
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
public interface SigningEngineController {

    @Operation(summary = "List of available Signing Engines")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signing Engine retrieved")})
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    List<SigningEngineDto> listSigningEngine();


    @Operation(summary =  "Create Signing Engine Instance")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description =  "Signing Engine added")})
    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    SigningEngineDto createSigningEngineInstance(@RequestBody AddSigningEngineDto addSigningEngineDto);

    @Operation(summary =  "Get Signing Engine Instance Details")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description =  "Signing Engine details retrieved")})
    @RequestMapping(path = "/{signingEngineUuid}", method = RequestMethod.GET, produces = {"application/json"})
    SigningEngineDto getSigningEngineInstance(@Parameter(description = "Signature Profile UUID") @PathVariable String signingEngineUuid);

    @Operation(summary = "Update Signing Engine")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signing Engine updated.")})
    @RequestMapping(path = "/{signingEngineUuid}", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    SigningEngineDto updateSignatureProfile(@Parameter(description = "Signing Engine UUID") @PathVariable String signingEngineUuid, @RequestBody UpdateSigningEngineDto updateSigningEngineDto);

    @Operation(summary = "Delete Signing Engine")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Signing Engine deleted.")})
    @RequestMapping(path = "/{signingEngineUuid}", method = RequestMethod.DELETE)
    void deleteSigningEngine(@Parameter(description = "Signing Engine UUID") @PathVariable String signingEngineUuid);


}

