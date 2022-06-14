package pl.edu.pjatk.jaz.nbp.rates.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
