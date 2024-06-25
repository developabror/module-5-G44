package uz.app.util;

import uz.app.entity.User;

public class Context {
    private static User user;
    public static void setUser(User currentUser){
        user = currentUser;
    }
    public static User getCurrenctUser(){
        return user;
    }
}
