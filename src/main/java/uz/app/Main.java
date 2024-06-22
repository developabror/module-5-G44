package uz.app;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.val;

import java.util.Scanner;
import java.util.logging.Level;

@Log
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Scanner strScanner = new Scanner(System.in);

    @SneakyThrows
    public static void main(String[] args) {

        val test="hello";

        System.out.println(test);
//        test = test+" world";
//        System.out.println(test);
//        test();
//        File file = new File("D:\\image.jpg");
//        @Cleanup FileReader fileReader = new FileReader(file);


//        Person person1=new Person("Ali","Aliyev","male","UZB");
//        Person person2=new Person("Kim","Son","male","JP");
//
//
//
//        System.out.println(person1);
//        System.out.println(person2);

//        User user1=new User();
//        System.out.println(user1);user1.setUsername("ali");
//        System.out.println(user1.getUsername());

//        User user = User
//                .builder()
//                .age("21")
//                .build();
//        System.out.println(user);


//        User user = User.getInstance();

//        User user1 = new User("Ali","root123","20","01.01.2001");
//        User user2 = new User("Ali","root123","20","05.01.2001");
//        System.out.println(user1.equals(user2));

//        System.out.println("enter username");
//        String username = strScanner.nextLine();
//
//        System.out.println("enter password");
//        String password = strScanner.nextLine();
//
//        User  user=new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        System.out.println(user);
//        user.setUsernmae(username);
//        user.setPassword(password);

//        Base64.Encoder encoder = Base64.getEncoder();
//        encoder.encode(user.getUsername()+":"+user.getPassword());
    }

    @SneakyThrows(value = {ArrayIndexOutOfBoundsException.class, InterruptedException.class})
    public static void test() {

        log.log(Level.INFO, "info message");
        System.out.println("processing...");
        Thread.sleep(1000);
        System.out.println("finished...");
    }
}
