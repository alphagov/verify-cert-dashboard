package uk.gov.ida.certdashboard.resources;

import org.glassfish.jersey.client.JerseyClientBuilder;
import uk.gov.ida.certdashboard.services.CertificateService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class CertificateResource {

    Client client = new JerseyClientBuilder().build();
    private String metadataUrl = "https://www.signin.service.gov.uk/SAML2/metadata/federation";
    private CertificateService certificateService = new CertificateService(client, metadataUrl);

    @GET
    public String getCertificateInformation() {
        // request metadata
        String certificateResponse = certificateService.call();

        // parse xml

        return certificateResponse;
    }
}
