package uz.app.entity;
public class User {
    private String id;
    private String name;
    private String surname;
    private Integer age;

    private User(){

    }
    public User(String name,String surname){
        this.name = name;
        this.surname = surname;
    }

    public static User getInstance(){
        return new User();
    }
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
