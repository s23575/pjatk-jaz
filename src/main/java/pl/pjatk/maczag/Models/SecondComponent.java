package pl.pjatk.maczag.Models;

import org.springframework.stereotype.Component;

@Component
public class SecondComponent {
    private FirstComponent firstComponent;

    public SecondComponent(FirstComponent firstComponent) {
        this.firstComponent = firstComponent;
        System.out.println("test SecondComponent");
    }

    public void printSecondComponent() {
        System.out.println("SecondComponent printSecondComponent");
    }

    public FirstComponent getFirstComponent() {
        return firstComponent;
    }

    public void setFirstComponent(FirstComponent firstComponent) {
        this.firstComponent = firstComponent;
    }

}
