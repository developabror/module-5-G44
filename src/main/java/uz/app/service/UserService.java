package uz.app.service;

import uz.app.controller.BookingController;
import uz.app.db.Database;
import uz.app.entity.Booking;
import uz.app.entity.User;
import uz.app.utils.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    Database database =Database.getInstance();
    List<User> users =new ArrayList<>();

    public void add(User user) {
        if (getUser(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }
        users.add(user);
        database.saveUsers(users);
    }

    public Optional<User> getUser(String email){
        users = database.getUsers();
        if (users == null) {
            users =new ArrayList<>();
        }
        return users.stream().filter(t -> t.getEmail().equals(email)).findFirst();
    }



    private static UserService userService;
    public static UserService getInstance() {
        if (userService == null){
            userService = new UserService();
        }
        return userService;
    }

}
