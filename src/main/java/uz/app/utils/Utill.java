package uz.app.utils;

import java.util.Scanner;

public interface Utill {
    static Scanner strScanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.println(prompt);
        return strScanner.nextLine();
    }

    public static Integer getInteger(String prompt) {
        System.out.println(prompt);
        try {
            return Integer.parseInt(strScanner.nextLine());
        }catch (Exception e){
            return getInteger(prompt);
        }
    }
}
