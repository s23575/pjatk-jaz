package pl.pjatk.maczag.Models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class FirstComponent {
    public FirstComponent(@Value("${my.own.value}") String valueFromProperties) {
        System.out.println("test FirstComponent");
        System.out.println(valueFromProperties);
    }

    public void printFirstComponent() {
        System.out.println("FirstComponent printFirstComponent");
    }
}
