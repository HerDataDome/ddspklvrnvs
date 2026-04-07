package bnp.cdx.utils;

import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import java.io.File;

public class CertificateConfig {

    // These values are injected at runtime, never hardcoded.
    private static final String CERT_PATH = System.getProperty("CERT_PATH");
    private static final String CERT_SECRET = System.getProperty("CERT_SECRET");

    /**
     * Generates the REST Assured configuration containing the SSL KeyStore.
     */
    public static RestAssuredConfig getSslConfig() {
        validateProperties();

        return RestAssuredConfig.config()
                .sslConfig(SSLConfig.sslConfig()
                        .with()
                        .keyStore(new File(CERT_PATH), CERT_SECRET)
                        .relaxedHTTPSValidation());
    }

    private static void validateProperties() {
        if (CERT_PATH == null || CERT_SECRET == null) {
            throw new IllegalArgumentException(
                "System properties 'CERT_PATH' and 'CERT_SECRET' are missing. " +
                "Ensure they are passed at runtime (e.g., -DCERT_PATH=... -DCERT_SECRET=...)"
            );
        }
    }
}
