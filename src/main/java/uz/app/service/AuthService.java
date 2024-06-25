package uz.app.service;

import uz.app.db.Database;
import uz.app.entity.User;
import uz.app.util.Context;

import static uz.app.util.Utils.getInt;
import static uz.app.util.Utils.getText;

public class AuthService {
    Database database = Database.getInstance();

    AdminService adminService = AdminService.getInstance();
    UserService userService = UserService.getInstance();

    public void signUp() {
        User user = new User();
        user.setUsername(getText("entre username"));
        user.setPassword(getText("entre password"));
        user.setRole("user");
        database.userList.add(user);
    }

    public void signIn() {
        String username = getText("enter username");
        String password = getText("enter password");
        for (User user : database.userList) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {
                Context.setUser(user);
                if (user.getRole().equals("admin")) {
                    adminService.service();
                } else {
                    userService.service();
                }
                return;
            }
        }
        System.out.println("user not found!");


    }

    public void service() {
        while (true) {
         switch (getInt("""
                 0 exit
                 1 sign in
                 2 sign up
                 """)){
             case 0->{
                 System.out.println("bye bye");
                 return;
             }
             case 1->{
                 signIn();
             }
             case 2-> {
                 signUp();
             }
         }
        }
    }
}
