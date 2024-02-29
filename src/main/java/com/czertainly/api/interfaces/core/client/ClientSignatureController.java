package com.czertainly.api.interfaces.core.client;


import com.czertainly.api.model.client.signing.ClientSignRequestDto;
import com.czertainly.api.model.connector.signing.SignatureVerificationRequestDto;
import com.czertainly.api.model.core.signature.SignatureDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/operations/signatures")
@Tag(name = "Signed Data Inventory Management", description = "Signed Data Inventory Management API")
public interface ClientSignatureController {

    @Operation(summary = "Sign Data")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Data Signed")})
    @RequestMapping(path = "/{uuid}/sign", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    SignatureDto sign(@Parameter(description = "Signature Profile UUID") @PathVariable String uuid, @RequestBody ClientSignRequestDto signRequestDto);


    @Operation(summary = "Verify Signature of Signed Data")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Signature is valid")})
    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    void verifySignature(@RequestBody SignatureVerificationRequestDto signatureVerificationRequestDto);

}
