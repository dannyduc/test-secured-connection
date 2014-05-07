import javax.net.ssl.HttpsURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
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
//            tester.testConnectionTo("https://ionreporter.lifetechnologies.com/ir/index.html");
            tester.testConnectionTo("https://ionreporter.lifetechnologies.com:443/webservices_40/rest/wsVerRestExt/uploadKmResults");
//            tester.testConnectionTo("https://api.ingenuity.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testConnectionTo(String aURL) throws Exception {


        // for proxy settings...
        Proxy proxy = null;
//        SocketAddress sa = new InetSocketAddress("myproxyserver", 3128);
//      proxy = new Proxy(Proxy.Type.HTTP, sa);

        URL destinationURL = new URL(aURL);
        HttpsURLConnection conn = (HttpsURLConnection) destinationURL
                .openConnection(proxy);
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
