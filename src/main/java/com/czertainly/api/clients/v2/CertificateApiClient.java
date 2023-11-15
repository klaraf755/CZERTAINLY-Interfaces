package com.czertainly.api.clients.v2;

import com.czertainly.api.clients.BaseApiClient;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.connector.v2.*;
import com.czertainly.api.model.core.connector.ConnectorDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.net.ssl.TrustManager;
import java.util.List;

public class CertificateApiClient extends BaseApiClient {

    private static final String CERTIFICATE_BASE_CONTEXT = "/v2/authorityProvider/authorities/{uuid}/certificates";

    private static final String CERTIFICATE_ISSUE_CONTEXT = CERTIFICATE_BASE_CONTEXT + "/issue";
    private static final String CERTIFICATE_ISSUE_ATTRIBUTES_CONTEXT = CERTIFICATE_ISSUE_CONTEXT + "/attributes";
    private static final String CERTIFICATE_ISSUE_ATTRIBUTES_VALIDATE_CONTEXT = CERTIFICATE_ISSUE_ATTRIBUTES_CONTEXT + "/validate";

    private static final String CERTIFICATE_RENEW_CONTEXT = CERTIFICATE_BASE_CONTEXT + "/renew";

    private static final String CERTIFICATE_REVOKE_ATTRIBUTES_CONTEXT = CERTIFICATE_BASE_CONTEXT + "/revoke/attributes";
    private static final String CERTIFICATE_REVOKE_ATTRIBUTES_VALIDATE_CONTEXT = CERTIFICATE_REVOKE_ATTRIBUTES_CONTEXT + "/validate";

    private static final String CERTIFICATE_REVOKE_CONTEXT = CERTIFICATE_BASE_CONTEXT + "/revoke";
    private static final String CERTIFICATE_IDENTIFY_CONTEXT = CERTIFICATE_BASE_CONTEXT + "/identify";

    private static final ParameterizedTypeReference<List<RequestAttributeDto>> ATTRIBUTE_LIST_TYPE_REF = new ParameterizedTypeReference<>() {
    };

    public CertificateApiClient(WebClient webClient, TrustManager[] defaultTrustManagers) {
        this.webClient = webClient;
        this.defaultTrustManagers = defaultTrustManagers;
    }

    public List<BaseAttribute> listIssueCertificateAttributes(ConnectorDto connector, String authorityUuid) throws ConnectorException {
        WebClient.RequestBodyUriSpec request = prepareRequest(HttpMethod.GET, connector, true);

        return processRequest(r -> r
                .uri(connector.getUrl() + CERTIFICATE_ISSUE_ATTRIBUTES_CONTEXT, authorityUuid)
                .retrieve()
                .toEntityList(BaseAttribute.class)
                .block().getBody(),
                request,
                connector);
    }

    public Boolean validateIssueCertificateAttributes(ConnectorDto connector, String authorityUuid, List<RequestAttributeDto> attributes) throws ValidationException, ConnectorException {
        WebClient.RequestBodyUriSpec request = prepareRequest(HttpMethod.POST, connector, true);

        return processRequest(r -> r
                .uri(connector.getUrl() + CERTIFICATE_ISSUE_ATTRIBUTES_VALIDATE_CONTEXT, authorityUuid)
                .body(Mono.just(attributes), ATTRIBUTE_LIST_TYPE_REF)
                .retrieve()
                .toEntity(Boolean.class)
                .block().getBody(),
                request,
                connector);
    }

    public CertificateDataResponseDto issueCertificate(ConnectorDto connector, String authorityUuid, CertificateSignRequestDto requestDto) throws ConnectorException {
        WebClient.RequestBodyUriSpec request = prepareRequest(HttpMethod.POST, connector, true);

        return processRequest(r -> r
                .uri(connector.getUrl() + CERTIFICATE_ISSUE_CONTEXT, authorityUuid)
                .body(Mono.just(requestDto), CertificateSignRequestDto.class)
                .retrieve()
                .toEntity(CertificateDataResponseDto.class)
                .block().getBody(),
                request,
                connector);
    }

    public CertificateDataResponseDto renewCertificate(ConnectorDto connector, String authorityUuid, CertificateRenewRequestDto requestDto) throws ConnectorException {
        WebClient.RequestBodyUriSpec request = prepareRequest(HttpMethod.POST, connector, true);

        return processRequest(r -> r
                .uri(connector.getUrl() + CERTIFICATE_RENEW_CONTEXT, authorityUuid)
                .body(Mono.just(requestDto), CertificateRenewRequestDto.class)
                .retrieve()
                .toEntity(CertificateDataResponseDto.class)
                .block().getBody(),
                request,
                connector);
    }

    public List<BaseAttribute> listRevokeCertificateAttributes(ConnectorDto connector, String authorityUuid) throws ConnectorException {
        WebClient.RequestBodyUriSpec request = prepareRequest(HttpMethod.GET, connector, true);

        return processRequest(r -> r
                .uri(connector.getUrl() + CERTIFICATE_REVOKE_ATTRIBUTES_CONTEXT, authorityUuid)
                .retrieve()
                .toEntityList(BaseAttribute.class)
                .block().getBody(),
                request,
                connector);
    }

    public Boolean validateRevokeCertificateAttributes(ConnectorDto connector, String authorityUuid, List<RequestAttributeDto> attributes) throws ValidationException, ConnectorException {
        WebClient.RequestBodyUriSpec request = prepareRequest(HttpMethod.POST, connector, true);

        return processRequest(r -> r
                .uri(connector.getUrl() + CERTIFICATE_REVOKE_ATTRIBUTES_VALIDATE_CONTEXT, authorityUuid)
                .body(Mono.just(attributes), ATTRIBUTE_LIST_TYPE_REF)
                .retrieve()
                .toEntity(Boolean.class)
                .block().getBody(),
                request,
                connector);
    }

    public void revokeCertificate(ConnectorDto connector, String authorityUuid, CertRevocationDto requestDto) throws ConnectorException {
        WebClient.RequestBodyUriSpec request = prepareRequest(HttpMethod.POST, connector, true);

        processRequest(r -> r
                .uri(connector.getUrl() + CERTIFICATE_REVOKE_CONTEXT, authorityUuid)
                .body(Mono.just(requestDto), CertRevocationDto.class)
                .retrieve()
                .toEntity(Void.class)
                .block().getBody(),
                request,
                connector);
    }

    public CertificateIdentificationResponseDto identifyCertificate(ConnectorDto connector, String authorityUuid, CertificateIdentificationRequestDto requestDto) throws ValidationException, ConnectorException {
        WebClient.RequestBodyUriSpec request = prepareRequest(HttpMethod.POST, connector, true);

        return processRequest(r -> r
                        .uri(connector.getUrl() + CERTIFICATE_IDENTIFY_CONTEXT, authorityUuid)
                        .body(Mono.just(requestDto), CertificateSignRequestDto.class)
                        .retrieve()
                        .toEntity(CertificateIdentificationResponseDto.class)
                        .block().getBody(),
                request,
                connector);
    }
}
