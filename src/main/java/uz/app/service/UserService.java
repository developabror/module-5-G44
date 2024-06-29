package uz.app.service;

import uz.app.db.Database;
import uz.app.entity.Category;
import uz.app.entity.Meal;
import uz.app.entity.Order;
import uz.app.entity.User;
import uz.app.util.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static uz.app.util.Utils.getInt;
import static uz.app.util.Utils.getText;

public class UserService {

    Database db = Database.getInstance();
    Map<User, Order> userOrder = new HashMap<>();

    public void service() {

        while (true) {
            int option = getInt("""
                    0 exit
                    1 sow menu
                    2 order
                    3 confirm order
                    4 history
                    """);
            switch (option) {
                case 0 -> {
                    System.out.println("bye bye");
                    return;
                }
                case 1 -> {
                    showMenu();

                }
                case 2 -> {
                    String mealId = getText("enter meal id");
                    for (Category category : db.categoryList) {
                        for (Meal meal : category.getMeals()) {
                            if (meal.getId().equals(mealId)) {
                                if (userOrder.containsKey(Context.getCurrenctUser())) {
                                    Order order = userOrder.get(Context.getCurrenctUser());
                                    order.getMeals().add(meal);
                                } else {
                                    Order order = new Order();
                                    order.setUser(Context.getCurrenctUser());
                                    order.setStatus(false);
                                    order.setMeals(new ArrayList<Meal>());
                                    order.getMeals().add(meal);
                                    order.setId(UUID.randomUUID().toString());
                                    userOrder.put(Context.getCurrenctUser(),order);
                                }
                            }
                        }
                    }
                }
                case 3 -> {
                    double sum = 0;
                    Order order = userOrder.get(Context.getCurrenctUser());
                    for (Meal meal : order.getMeals()) {
                        sum += meal.getPrice();
                        System.out.println(meal);
                    }
                    db.orders.add(order);
                    order.setStatus(true);
                    userOrder.remove(Context.getCurrenctUser());
                }
                case 4 -> {
                    for (Order order : db.orders) {
                        User currenctUser = Context.getCurrenctUser();
                        if (order.getUser().equals(currenctUser)) {
                            System.out.println(order);
                        }
                    }
                }
            }
        }
    }

    private void showMenu() {

        while (true)
            switch (getInt("""
                    0 exit
                    1 show meal by category
                    """)) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    for (Category category : db.categoryList) {
                        System.out.println(category);
                    }
                    String id = getText("Enter Id");
                    for (Category category : db.categoryList) {
                        if (id.equals(category.getId())) {
                            for (Meal meal : category.getMeals()) {
                                System.out.println(meal);
                            }
                        }
                    }
                }
            }

    }


    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }
}
