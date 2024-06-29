package uz.app.util;

import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner strScanner = new Scanner(System.in);


    public static String getText(String text) {
        System.out.println(text);
        return strScanner.nextLine();
    }


    public static int getInt(String text) {
        System.out.println(text);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner = new Scanner(System.in);
        }
        return getInt(text);
    }


}
