package pl.pjatk.maczag.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ScanMe {

//    public ScanMe() {
//        System.out.println("test ScanMeConstructor");
//    }

    @Bean
    public String test() {
        System.out.println("test ScanMe");
        return "test";
    }

}
