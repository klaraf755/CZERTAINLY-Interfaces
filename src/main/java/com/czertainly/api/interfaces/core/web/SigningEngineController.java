package com.czertainly.api.interfaces.core.web;


import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.model.client.raprofile.AddRaProfileRequestDto;
import com.czertainly.api.model.common.AuthenticationServiceExceptionDto;
import com.czertainly.api.model.common.UuidDto;
import com.czertainly.api.model.core.raprofile.RaProfileDto;
import com.czertainly.api.model.core.signature.AddSigningEngineDto;
import com.czertainly.api.model.core.signature.SigningEngineDto;


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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
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
    @RequestMapping(path = "/signingEngine", method = RequestMethod.GET, produces = {"application/json"})
    List<SigningEngineDto> listSigningEngine();


    @Operation(summary =  "Create Signing Engine Instance")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description =  "Signing Engine added")})
    @RequestMapping(path = "/signingEngine/add", method = RequestMethod.GET, produces = {"application/json"})
    List<AddSigningEngineDto> createSigningEngineInstance();

    // Operation(summary = "Create Signing Engine Instance")
    // @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Signing Engine added", content = @Content(schema = @Schema(implementation = UuidDto.class))),
    //         @ApiResponse(responseCode = "422", description = "Unprocessible Entity", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
    //                 examples = {@ExampleObject(value = "[\"Error Message 1\",\"Error Message 2\"]")}))})
    // @RequestMapping(path = "/authorities/{authorityUuid}/raProfiles", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    // ResponseEntity<?> createRaProfile(@Parameter(description = "Authority Instance UUID") @PathVariable String authorityUuid, @RequestBody AddRaProfileRequestDto request)
    //         throws AlreadyExistException, ValidationException, ConnectorException;


}


// listSigningEngineInstances
// createSigningEngineInstance
// getSigningEngineInstance
// deleteSigninEngineInstance
// updateSigningEngineInstance	