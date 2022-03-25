package pl.pjatk.maczag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:beans.xml")
@SpringBootApplication
public class MaczagApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaczagApplication.class, args);

	}

}
