package pl.pjatk.maczag.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:beans.xml")
@SpringBootApplication
//@ComponentScan(basePackages = "pl.pjatk.maczag.test")
// @ComponentScan(basePackages = "pl.pjatk.maczag.sandbox")
// @ComponentScan(basePackages = "pl.pjatk.maczag")

public class MaczagApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaczagApplication.class, args);

	}

}
