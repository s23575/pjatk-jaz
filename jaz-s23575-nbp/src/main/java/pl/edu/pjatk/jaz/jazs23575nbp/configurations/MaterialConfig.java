package pl.edu.pjatk.jaz.jazs23575nbp.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MaterialConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
