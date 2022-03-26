package pl.pjatk.maczag.Models;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public ExampleNonSpringPojoClass exampleNonSpringPojoClass() {
        return new ExampleNonSpringPojoClass();
    }

    @Bean
    public List<String> defaultData() {
        List<String> defaultData = List.of("String 1", "String 2", "String 3", "String 4", "String 5");
        System.out.println("test " + defaultData);
        return defaultData;
    }

    @Bean
//    @ConditionalOnProperty(name = "some.property", havingValue = true)
    public HomeworkClass homeworkClass() {
        return new HomeworkClass();
    }
}
