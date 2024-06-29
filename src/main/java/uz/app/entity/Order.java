package uz.app.entity;

import lombok.Data;

import java.util.List;


@Data
public class Order {

    private String id;
    private List<Meal> meals;
    private User user;
    private Boolean status;

}
