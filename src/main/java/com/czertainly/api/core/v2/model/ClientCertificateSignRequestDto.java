package com.czertainly.api.core.v2.model;

import com.czertainly.api.model.AttributeDefinition;
import com.czertainly.api.model.ClientAttributeDefinition;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * Class representing a request to sign CSR
 */
public class ClientCertificateSignRequestDto {

    @Schema(description = "Certificate sign request (PKCS#10) encoded as Base64 string",
            required = true)
    private String pkcs10;

    @Schema(description = "List of Attributes to issue Certificate",
            required = true)
    private List<ClientAttributeDefinition> attributes;

    public String getPkcs10() {
        return pkcs10;
    }

    public void setPkcs10(String pkcs10) {
        this.pkcs10 = pkcs10;
    }

    public List<ClientAttributeDefinition> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ClientAttributeDefinition> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("pkcs10", pkcs10)
                .append("attributes", attributes)
                .toString();
    }
}
