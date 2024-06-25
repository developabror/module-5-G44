package uz.app.service;

import uz.app.db.Database;
import uz.app.entity.Category;
import uz.app.entity.Meal;
import uz.app.entity.User;

import java.util.ArrayList;
import java.util.UUID;

import static uz.app.util.Utils.*;

public class AdminService {

    Database db=Database.getInstance();


    private static AdminService adminService;
    public static AdminService getInstance(){
        if (adminService == null){
            adminService=new AdminService();
        }
        return adminService;
    }

    public void service() {
        while (true){
            switch (getInt("""
                    0 exit
                    1 add category
                    2 show category
                    3 add meal
                    """)){
                case 0->{
                    return;
                }
                case 1->{
                    Category category = new Category();
                    category.setName(getText("enter category name"));
                    category.setId(UUID.randomUUID().toString());
                    category.setMeals(new ArrayList<Meal>());
                    db.categoryList.add(category);
                }
                case 2->{
                    for (Category category : db.categoryList) {
                        System.out.println(category);
                    }
                }
                case 3->{
                    Meal meal =new Meal();
                    meal.setId(UUID.randomUUID().toString());
                    meal.setName(getText("enter meal name"));
                    meal.setPrice((double) getInt("enter price"));
                    String id = getText("enter category id");
                    for (Category category : db.categoryList) {
                        if (category.getId().equals(id)) {
                            category.getMeals().add(meal);
                            System.out.println("successfully added");
                            break;
                        }
                    }
                    System.out.println("category not found!");
                }
            }
        }
    }
}
