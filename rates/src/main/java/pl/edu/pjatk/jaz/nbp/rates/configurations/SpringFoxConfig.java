package pl.edu.pjatk.jaz.nbp.rates.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Timestamp;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.edu.pjatk.jaz.nbp.rates.controllers"))
                .paths(PathSelectors.ant("/nbprates/**"))
                .build()
                .apiInfo(apiInfo())
                .directModelSubstitute(Timestamp.class, Long.class)
                // https://stackoverflow.com/questions/46118593/swagger-timestamp-weird-representation
                .useDefaultResponseMessages(false);
                // https://stackoverflow.com/questions/30047129/swagger-springfox-always-generates-some-response-
                // messages-401-403-by-defa
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "NBP average exchange rates",
                "Average exchange rates of foreign currencies provided by Narodowy Bank Polski",
                "Terms of service",
                "Terms of service",
                new Contact("Maciej Zagórski", "https://github.com/s23575/pjatk-jaz/tree/main/rates",
                        "s23575@pjwstk.edu.pl"),
                "License of API", "API license URL", Collections.emptyList());
    }
}