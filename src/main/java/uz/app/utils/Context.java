package uz.app.utils;

import uz.app.entity.Hotel;
import uz.app.entity.User;

public class Context {
    private static User user;
    public static User getUser() {
        return user;
    }
    public static void setUser(User currentUser) {
        user = currentUser;
    }

    private static Hotel currentHotel;
    public static Hotel getHotel() {
        return currentHotel;
    }
    public static void setHotel(Hotel hotel) {
        currentHotel = hotel;
    }
}
