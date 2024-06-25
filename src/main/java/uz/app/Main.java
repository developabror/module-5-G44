package uz.app;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import uz.app.db.Database;
import uz.app.service.AuthService;

import java.util.Scanner;

@Log
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        new AuthService().service();
    }

}
