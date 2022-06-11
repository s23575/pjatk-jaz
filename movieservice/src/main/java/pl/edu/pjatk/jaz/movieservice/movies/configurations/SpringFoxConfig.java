package pl.edu.pjatk.jaz.movieservice.movies.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.edu.pjatk.jaz.movieservice.movies.controllers"))
                .paths(PathSelectors.ant("/movieservice/**"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API MovieService",
                "Description / Documentation of MovieService REST API.",
                "Terms of service",
                "Terms of service",
                new Contact("Maciej Zagórski", "https://github.com/s23575/pjatk-jaz","s23575@pjwstk.edu.pl"),
                "License of API", "API license URL", Collections.emptyList());
    }
}