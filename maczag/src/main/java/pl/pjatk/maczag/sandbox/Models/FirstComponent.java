package pl.pjatk.maczag.sandbox.Models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FirstComponent {

    public FirstComponent(@Value("${my.custom.property}") String valueFromProperties,
                          @Value("${my.non-existing.property:Hello from non-existing property}") String valueNotFromProperties) {
        System.out.println("test FirstComponent");
        System.out.println(valueFromProperties);
        System.out.println(valueNotFromProperties);
    }

    public void printFirstComponent() {
        System.out.println("FirstComponent printFirstComponent");
    }
}
