package dk.vip.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dk.vip.client.presentation.IInputReader;

/**
 * @author Sigurd Traberg Moth
 * 
 * The client application handles every connected users input and transmit as
 * well as receives answers back from the VIP platform.
 * 
 * The application is set up with the use of Spring @Autowired and @Service
 * allowing for more easily connecting interfaces to their implementations.
 */
@SpringBootApplication
public class ClientApplication implements ApplicationRunner {

	@Autowired
	private IInputReader inputReader;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		inputReader.start();
	}
}
