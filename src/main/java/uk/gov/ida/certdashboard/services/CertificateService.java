package uk.gov.ida.certdashboard.services;

import javax.ws.rs.GET;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

public class CertificateService {
    private final Client httpClient;
    private final String metadataUrl;

    public CertificateService(Client httpClient, String metadataUrl) {
        this.httpClient = httpClient;
        this.metadataUrl = metadataUrl;
    }

    public String call() {
        return httpClient
                .target(metadataUrl)
                .request()
                .buildGet()
                .invoke(String.class);
    }
}
