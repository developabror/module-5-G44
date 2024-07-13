package uz.app;

import lombok.extern.java.Log;
import uz.app.db.Database;
import uz.app.entity.Hotel;
import uz.app.entity.User;
import uz.app.service.AuthService;
import uz.app.service.UserService;
import uz.app.utils.Context;

import java.util.logging.Level;

import static uz.app.utils.Utill.*;

@Log
public class Main {

    static Database database =Database.getInstance();
    static UserService userService = UserService.getInstance();

    public static void main(String[] args) throws Exception {
//        String name = getString("enter hotel name");
//        Integer floor = getInteger("enter floor");
//        Integer room = getInteger("enter room");
        Context.setHotel( new Hotel("hilton",10,25));
//        userService.add(new User("admin","admin","admin","admin"));

        while (true){
            try {
                AuthService.getAuthService().service();
            }catch (Exception e){
                log.log(Level.WARNING,e.getMessage());
            }

        }


//        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//        botsApi.registerBot(new BotMainService());

    }
}

