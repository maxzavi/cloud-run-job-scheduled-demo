package pe.maxz.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class HelloworldApplication implements CommandLineRunner {

	@Value("${timeout_seconds}")
	private int timeoutSeconds;
	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Starting, timeout : " + timeoutSeconds + " seconds");
		Thread.sleep(timeoutSeconds*1000);
		log.info("End");
	}

}
