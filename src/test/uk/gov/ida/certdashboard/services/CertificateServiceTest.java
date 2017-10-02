package uk.gov.ida.certdashboard.services;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.client.Client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class CertificateServiceTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @Test
    public void shouldGetMetadata() throws Exception {
        Client client = new JerseyClientBuilder().build();

        stubFor(get("/metadata")
                .willReturn(ok("<response>Some content</response>")));


        CertificateService certificateService = new CertificateService(client, "http://localhost:8089/metadata");
        assertEquals(certificateService.call(), "<response>Some content</response>");
    }
}
