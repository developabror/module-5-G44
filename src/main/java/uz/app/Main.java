package uz.app;

import lombok.SneakyThrows;
import uz.app.service.AuthService;

public class Main {


    @SneakyThrows
    public static void main(String[] args) {
        new AuthService().service();
    }
}

