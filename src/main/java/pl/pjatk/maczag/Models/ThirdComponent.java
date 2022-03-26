package pl.pjatk.maczag.Models;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ThirdComponent {
    private ApplicationContext context;

    public ThirdComponent(ApplicationContext context) {
        this.context = context;
//        SecondComponent SecondComponent = (SecondComponent) context.getBean("secondComponent");
//        FirstComponent firstComponent = (FirstComponent) context.getBean("firstComponent");

        SecondComponent secondComponent = context.getBean("secondComponent", SecondComponent.class);
        FirstComponent firstComponent = context.getBean("firstComponent", FirstComponent.class);

        secondComponent.printSecondComponent();
        firstComponent.printFirstComponent();

    }
}
