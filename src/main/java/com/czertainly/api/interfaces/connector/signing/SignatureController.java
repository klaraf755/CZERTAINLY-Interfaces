package com.czertainly.api.interfaces.connector.signing;


import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.common.ErrorMessageDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.connector.signing.SignRequestDto;
import com.czertainly.api.model.connector.signing.SignatureValidationRequestDto;
import com.czertainly.api.model.core.signature.SignedDataDto;
import com.czertainly.api.model.core.signature.SigningEngineDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/signingProvider")
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
@Tag(name = "Signature Management", description = "Signature Management API")
public interface SignatureController {

    @Operation(summary = "Sign Data")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Data Signed")})
    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"} ,produces = {"application/json"})
    SignedDataDto sign(@RequestBody SignRequestDto signRequestDto);

    @Operation(summary = "List Signature Attributes")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "List of Signature Attributes")})
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    List<BaseAttribute> listSignatureAttributes();

    @Operation(summary = "Validate Signature Attributes")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signature Attributes are valid")})
    @RequestMapping(method = RequestMethod.POST,consumes = {"application/json"}, produces = {"application/json"})
    void validateSignatureAttributes(@RequestBody List<RequestAttributeDto> attributes);

    @Operation(summary = "Validate Signature of Signed Data")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signature is valid")})
    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"} ,produces = {"application/json"})
    void validateSignature(@RequestBody SignatureValidationRequestDto signatureValidationRequestDto);

}
