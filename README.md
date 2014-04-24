# Test Secured Connection in Java

Sample process to add trusted certificate to Java trust store

## FireFox
	Cmd-,
	Advanced
	Certificates
	View Certificates
	Authorities
	COMODO High-Assurance Secure Server CA
	Export

##Setup

Copy default Java cacerts file.

	cp /Library/Java/JavaVirtualMachines/1.6.0_32-b05-420.jdk/Contents/Home/lib/security/cacerts ./cacerts

Change ownership

	sudo chown danny cacerts

Import the certificate

	keytool -importcert -keystore cacerts -storepass changeit -alias COMODOHigh-AssuranceSecureServerCA -file "COMODOHigh-AssuranceSecureServerCA.cer"
	
## Verify

	java -Djavax.net.debug=ssl:handshake -Djavax.net.ssl.trustStore=/Users/danny/Desktop/test-secured-connection/cacerts TestSecuredConnection

some other useful debug option

    -Djavax.net.debug=all

## References

http://java.dzone.com/articles/how-analyze-java-ssl-errors

http://www.herongyang.com/PKI/HTTPS-Java-PKIX-Path-Building-Failed-No-CA-Certificate.html

https://support.comodo.com/index.php?_m=knowledgebase&_a=viewarticle&kbarticleid=1204

http://jcalcote.wordpress.com/2010/06/22/managing-a-dynamic-java-trust-store/

http://www.sslshopper.com/article-most-common-java-keytool-keystore-commands.html


	