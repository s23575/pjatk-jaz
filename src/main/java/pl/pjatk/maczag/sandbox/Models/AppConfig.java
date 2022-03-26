package pl.pjatk.maczag.sandbox.Models;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "pl.pjatk.maczag.test.*")
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
    @ConditionalOnProperty(value="homework.value", havingValue="true")
    public HomeworkClass homeworkClass() {
        return new HomeworkClass();
    }

}
