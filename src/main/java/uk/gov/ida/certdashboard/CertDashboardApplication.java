package uk.gov.ida.certdashboard;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.client.JerseyClientBuilder;
import uk.gov.ida.certdashboard.resources.CertificateResource;

import javax.ws.rs.client.Client;

public class CertDashboardApplication extends Application<CertDashboardConfiguration> {
    public static void main(String[] args) throws Exception {
        new CertDashboardApplication().run(args);
    }

    @Override
    public String getName() {
        return "cert-dashboard";
    }

    @Override
    public void run(CertDashboardConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new CertificateResource());
        Client client = new JerseyClientBuilder().build();

    }
}
