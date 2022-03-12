package pl.pjatk.maczag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import pl.pjatk.maczag.Models.User;
import pl.pjatk.maczag.Models.UserGroup;

@Configuration
@ImportResource("classpath:beans.xml")
@SpringBootApplication
public class MaczagApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaczagApplication.class, args);

	}

}
