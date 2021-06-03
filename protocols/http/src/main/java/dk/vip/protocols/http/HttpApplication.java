package dk.vip.protocols.http;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dk.vip.protocolbroker.proxies.ProtocolPublisher;
import dk.vip.protocolbroker.proxies.RestProtocolPublisher;

@SpringBootApplication
public class HttpApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(HttpApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ProtocolPublisher protocol = new RestProtocolPublisher("http", "http://localhost:42323/http", "http://localhost:42322");
		protocol.publish();
	}

}
