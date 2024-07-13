package uz.app.service;

import uz.app.controller.AdminController;
import uz.app.controller.UserController;
import uz.app.entity.User;
import uz.app.utils.Context;

import java.util.Optional;

import static uz.app.utils.Utill.getInteger;
import static uz.app.utils.Utill.getString;

public class AuthService {
    UserService userService=UserService.getInstance();
    AdminController adminController= AdminController.getInstance();
    UserController userController=UserController.getInstance();
    public void service(){
        while (true){
            switch (getInteger("""
                    0 exit
                    1 sign in
                    2 sign up
                    """)){
                case 0->{
                    System.out.println("bye bye, see you never!");
                    return;
                }
                case 1->{
                    signIn();
                }
                case 2->{
                    signUp();
                }
            }
        }
    }
    public void signIn(){
        String email = getString("enter email");
        String password = getString("enter email");
        Optional<User> optionalUser = userService.getUser(email);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = optionalUser.get();
        if (user.getPassword().equals(password)) {
            Context.setUser(user);
            if (user.getRole().equals("admin")){
                adminController.service();
            }else {
                userController.service();
            }
        }
    }
    public void signUp(){
        userService.add(new User(getString("enter name"),
                getString("enter email"),
                getString("enter password"),
                "user"));
    }

    private static AuthService authService;
    public static AuthService getAuthService() {
        if (authService == null) {
            authService = new AuthService();
        }
        return authService;

    }
}
