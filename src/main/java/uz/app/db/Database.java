package uz.app.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import uz.app.entity.Category;
import uz.app.entity.Meal;
import uz.app.entity.Order;
import uz.app.entity.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Database {
    public List<User> userList = new ArrayList<>();
    public List<Category> categoryList = new ArrayList<>();
    public List<Order> orders = new ArrayList<>();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final File usersFile = new File("src/main/resources/users.json");

    private static Database database;

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    {
        try {
            Type type =new TypeToken<ArrayList<User>>(){}.getType();
            userList = gson.fromJson(new FileReader(usersFile),type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static {
        database = new Database();
//        database.addUser(new User("admin", "admin", "admin"));
        Category category1 = new Category(UUID.randomUUID().toString(), "cold drinks", new ArrayList<>(
                Arrays.asList(
                        new Meal(UUID.randomUUID().toString(), "ice coffe", 15000.0),
                        new Meal(UUID.randomUUID().toString(), "moxito", 19000.0),
                        new Meal(UUID.randomUUID().toString(), "milkshake", 18000.0)

                )
        ));
        Category category2 = new Category(UUID.randomUUID().toString(), "fast food", new ArrayList<>(
                Arrays.asList(
                        new Meal(UUID.randomUUID().toString(), "cheese burger", 22000.0),
                        new Meal(UUID.randomUUID().toString(), "hot dog burger", 18000.0)

                )
        ));
        database.categoryList.add(category1);
        database.categoryList.add(category2);
    }

    public void addUser(User user) {
        userList.add(user);
        try {
            @Cleanup BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile));
            writer.write(gson.toJson(userList));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getUsers() {
        return userList;
    }
}

