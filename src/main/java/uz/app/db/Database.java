package uz.app.db;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.app.entity.Category;
import uz.app.entity.Meal;
import uz.app.entity.Order;
import uz.app.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Database {
    public List<User> userList = new ArrayList<>();
    public List<Category> categoryList =new ArrayList<>();
    public List<Order> orders =new ArrayList<>();


    private static Database database;
    public static Database getInstance(){
        if (database == null){
            database=new Database();
            database.userList.add(new User("admin","admin","admin"));
            Category category1 = new Category(UUID.randomUUID().toString(),"cold drinks",new ArrayList<>(
                    Arrays.asList(
                            new Meal(UUID.randomUUID().toString(),"ice coffe",15000.0),
                            new Meal(UUID.randomUUID().toString(),"moxito",19000.0),
                            new Meal(UUID.randomUUID().toString(),"milkshake",18000.0)

                    )
            ));
            Category category2 = new Category(UUID.randomUUID().toString(),"fast food",new ArrayList<>(
                    Arrays.asList(
                            new Meal(UUID.randomUUID().toString(),"cheese burger",22000.0),
                            new Meal(UUID.randomUUID().toString(),"hot dog burger",18000.0)

                    )
            ));
            database.categoryList.add(category1);
            database.categoryList.add(category2);
        }
        return database;
    }
}
