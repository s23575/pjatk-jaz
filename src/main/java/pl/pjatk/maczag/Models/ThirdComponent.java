package pl.pjatk.maczag.Models;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ThirdComponent {
    private ApplicationContext context;

    public ThirdComponent(ApplicationContext context) {
        this.context = context;
//        User user = (User) context.getBean("user");
//        UserGroup userGroup = (UserGroup) context.getBean("userGroup");

        User user = context.getBean("user", User.class);
        UserGroup userGroup = context.getBean("userGroup", UserGroup.class);

        user.printUser();
        userGroup.printUserGroup();
    }
}
