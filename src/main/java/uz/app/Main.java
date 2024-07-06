package uz.app;


import uz.app.entity.Car;
import uz.app.entity.Child;

import java.util.Scanner;

public class Main {
//    static Gson gson = new Gson();
    static Scanner scanner = new Scanner(System.in);
    static Scanner strScanner = new Scanner(System.in);
//    static HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {

        Car car =new Car();
        Child child =new Child();
        child.test();



//        Class<Car> carClass = Car.class;
//        Method method = carClass.getDeclaredMethod("test",String.class);
//        method.setAccessible(true);
//        method.invoke(car,"John");


//        System.out.println(car);
//        User user = new User("Ali","Aliyev");


//        Class<User> userClass = User.class;
//        Constructor<User> declaredConstructor = userClass.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        User temp = declaredConstructor.newInstance();
//        System.out.println(temp);
//        Field field = userClass.getDeclaredField("name");
//        field.setAccessible(true);
//        field.set(user,"Jamshid");
//        System.out.println(user);
//        Field[] declaredFields = userClass.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            declaredField.setAccessible(true);
//            System.out.println(declaredField.getType()+"\t"+declaredField.getName()+"\t"+declaredField.get(user));
//        }
//        System.out.println(userClass.getName());
//        Field name = userClass.getDeclaredField("age");
//        System.out.println(name.getType()+"\t"+name.getName());


//        String baseUrl = "http://127.0.0.1:8080/api/users";
//        System.out.println("enter user id");
//        String id = strScanner.nextLine();
//        HttpRequest req = HttpRequest
//                .newBuilder()
//                .uri(new URI(baseUrl+"/"+id))
//                .GET()
//                .build();
//        HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
//        User user = gson.fromJson(send.body(),User.class);
//
//        System.out.println(user);
//        while (true){
//            System.out.println("""
//                    0 exit
//                    1 create user
//                    2 show users
//                    3 show user by id
//                    4 edit user
//                    5 delete user
//                    """);
//            switch (scanner.nextInt()){
//                case 0->{
//                    System.out.println("see you soon");
//                }
//                case 1->{
//                    User user=new User();
//                    System.out.println("enter name");
//                    user.setName(strScanner.nextLine());
//                    System.out.println("enter surname");
//                    user.setSurname(strScanner.nextLine());
//                    System.out.println("enter age");
//                    user.setAge(scanner.nextInt());
//
//                    HttpRequest req = HttpRequest
//                            .newBuilder()
//                            .header("Content-type","application/json")
//                            .uri(new URI(baseUrl))
//                            .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(user)))
//                            .build();
//                    HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
//                    System.out.println(send.body());
//                }
//                case 2->{
//                    HttpRequest req = HttpRequest
//                            .newBuilder()
//                            .uri(new URI(baseUrl))
//                            .GET()
//                            .build();
//                    HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
//                    Type type =new TypeToken<ArrayList<User>>(){}.getType();
//                    ArrayList<User> users = gson.fromJson(send.body(),type);
//                    for (User user : users) {
//                        System.out.println(user);
//                    }
//
//
//                }
//                case 3->{
//                    System.out.println("enter user id");
//                    String id = strScanner.nextLine();
//                    HttpRequest req = HttpRequest
//                            .newBuilder()
//                            .uri(new URI(baseUrl+"/"+id))
//                            .GET()
//                            .build();
//                    HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
//                    User user = gson.fromJson(send.body(),User.class);
//
//                    System.out.println(user);
//
//                }
//                case 4->{
//                    System.out.println("enter user id");
//                    String userId = strScanner.nextLine();
//                    String path = baseUrl+"/"+userId;
//
//                    User user =new User();
//                    System.out.println("enter name");
//                    user.setName(strScanner.nextLine());
//                    System.out.println("enter surname");
//                    user.setSurname(strScanner.nextLine());
//                    System.out.println("enter age");
//                    user.setAge(scanner.nextInt());
//
//                    HttpRequest req = HttpRequest
//                            .newBuilder()
//                            .uri(new URI(path))
//                            .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(user)))
//                            .header("Content-type","application/json")
//                            .build();
//
//                    HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
//                    System.out.println(send.body());
//                }
//                case 5->{
//                    System.out.println("enter user id");
//                    String id = strScanner.nextLine();
//                    HttpRequest req = HttpRequest
//                            .newBuilder()
//                            .uri(new URI(baseUrl+"/"+id))
//                            .DELETE()
//                            .build();
//                    HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
//                    System.out.println(send.body());
//                }
//            }
//        }
    }
}

