// ========================================================
    // TEMPORARY TEST METHOD - DELETE AFTER VERIFYING
    // ========================================================
    public static void main(String[] args) {
        // 1. Manually set the properties just for this quick test
        System.setProperty("CERT_PATH", "src/main/resources/certs/39090-TestingToolClient-MSA1.p12"); // Ensure this filename is correct!
        System.setProperty("CERT_SECRET", "PUT_YOUR_REAL_PASSWORD_HERE");

        try {
            System.out.println("Attempting to load certificate from: " + System.getProperty("CERT_PATH"));
            
            // 2. Call your method
            io.restassured.config.RestAssuredConfig config = getSslConfig();
            
            // 3. If we get here without an error, it worked!
            System.out.println("✅ SUCCESS! The certificate was found, the password is correct, and the SSL Config is built.");
            
        } catch (Exception e) {
            System.err.println("❌ FAILED! Something went wrong.");
            e.printStackTrace();
        }
    }
