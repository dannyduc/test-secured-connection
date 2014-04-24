import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

/***
 * java -Djavax.net.debug=ssl:handshake -Djavax.net.ssl.trustStore=/Users/danny/Desktop/cacerts TestSecuredConnection
 */
public class TestSecuredConnection {

    public static void main(String[] args) {
        TestSecuredConnection tester = new TestSecuredConnection();
        try {
//            tester.testConnectionTo("https://www.google.com");
//            tester.testConnectionTo("https://ionreporter.lifetechnologies.com");
            tester.testConnectionTo("https://ionreporter.lifetechnologies.com/ir/index.html");
//            tester.testConnectionTo("https://api.ingenuity.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testConnectionTo(String aURL) throws Exception {
        URL destinationURL = new URL(aURL);
        HttpsURLConnection conn = (HttpsURLConnection) destinationURL
                .openConnection();
        conn.connect();
//        Certificate[] certs = conn.getServerCertificates();
//        for (Certificate cert : certs) {
//            System.out.println("Certificate is: " + cert);
//            if(cert instanceof X509Certificate) {
//                try {
//                    ( (X509Certificate) cert).checkValidity();
//                    System.out.println("Certificate is active for current date");
//                } catch(CertificateExpiredException cee) {
//                    System.out.println("Certificate is expired");
//                }
//            }
//        }
    }
}
