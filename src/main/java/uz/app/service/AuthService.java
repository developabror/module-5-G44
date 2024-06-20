package uz.app.service;

import uz.app.entity.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AuthService {

    MailSenderService mailSenderService = MailSenderService.getInstance();
    ArrayList<User> users = new ArrayList<>();
    Scanner scanner =new Scanner(System.in);
    Scanner strScanner =new Scanner(System.in);
    public void service(){
        while (true){
            System.out.println("""
                    0 exit 
                    1 sign in
                    2 sign up
                    3 confirm sms
                    """);
            switch (scanner.nextInt()){
                case 0->{
                    System.out.println("bye bye");
                    return;
                }
                case 1->{
                    signIn();
                }
                case 2->{
                    signUp();
                }
                case 3->{
                    confirmSms();
                }
            }
        }
    }

    private void confirmSms() {
        System.out.println("enter email");
        String email = strScanner.nextLine();
        System.out.println("enter code");
        String code = strScanner.nextLine();
        for (User user : users) {
            if (user.getEmail().equals(email)){
                if (user.getCode().equals(code)){
                    user.setConfirmed(true);
                    System.out.println("confirmed");
                    return;
                }else {
                    System.out.println("confirmation code wrong!");
                    return;
                }
            }
        }
        System.out.println("user not found");
    }

    private void signUp() {
        User user =new User();
        System.out.println("enter name");
        user.setName(strScanner.nextLine());
        System.out.println("enter email");
        user.setEmail(strScanner.nextLine());
        System.out.println("enter password");
        user.setPassword(strScanner.nextLine());
        user.setConfirmed(false);
        user.setCode(generateCode());
        mailSenderService.sendMessage(user.getEmail(),user.getCode());
        users.add(user);
    }

    private void signIn() {
        System.out.println("enter email");
        String email = strScanner.nextLine();
        System.out.println("enter password");
        String password = strScanner.nextLine();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                if (user.isConfirmed()){
                    System.out.println("welcome to system");
                    return;
                }else {
                    System.out.println("please confirm your email");
                    return;
                }
            }
        }
        System.out.println("wrong username or passowrd");
    }
    public String generateCode(){
        StringBuilder s =new StringBuilder();
        Random random=new Random();
        for (int i = 0; i < 6; i++) {
            s.append(random.nextInt(10));
        }
        return s.toString();
    }

}
