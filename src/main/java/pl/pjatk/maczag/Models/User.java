package pl.pjatk.maczag.Models;

import org.springframework.stereotype.Component;

@Component
public class User {
    private UserGroup userGroup;

    public User(UserGroup userGroup) {
        this.userGroup = userGroup;
        System.out.println("test User");
    }

    public void printUser() {
        System.out.println("User printUser");
    }

}
