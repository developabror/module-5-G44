package uz.app;

import uz.app.service.AuthService;
import uz.app.service.MailSenderService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Scanner strScanner =new Scanner(System.in);
        MailSenderService mailSenderService = MailSenderService.getInstance();
        while (true){
            System.out.println("1 send\n2 finish");
            switch (scanner.nextInt()){
                case 1->{
                    System.out.println("enter email");
                    String email = strScanner.nextLine();
                    System.out.println("enter file path");
                    String path = strScanner.nextLine();
                    mailSenderService.sendMedia(email,path);

                }
                case 2->{
                    return;
                }
            }
        }
//        new AuthService().service();
    }
}
