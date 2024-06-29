package uz.app.util;

import lombok.Setter;
import uz.app.entity.User;

public class Context {
    @Setter
    private static User user;

    public static User getCurrenctUser(){
        return user;
    }
}

