package uz.app.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class Car {
    private final String id = UUID.randomUUID().toString();
    private String model;
    private String brand;
    private final Timestamp createdAt = new Timestamp(new Date().getTime());


    public Car() {
    }

    public Car(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    private void test(){
        System.out.println("this is test");
    }
    private void test(String str){
        System.out.println("hello "+str);
    }
    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
