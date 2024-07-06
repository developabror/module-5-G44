package uz.app;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.app.entity.Payload;
import uz.app.entity.User;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Gson gson = new Gson();
    static Scanner scanner = new Scanner(System.in);
    static Scanner strScanner = new Scanner(System.in);
    static HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
        String baseUrl = "http://127.0.0.1:8080/api/users";
        while (true){
            System.out.println("""
                    0 exit
                    1 create user
                    2 show users
                    3 show user by id
                    4 edit user
                    5 delete user
                    """);
            switch (scanner.nextInt()){
                case 0->{
                    System.out.println("see you soon");
                }
                case 1->{
                    User user=new User();
                    System.out.println("enter name");
                    user.setName(strScanner.nextLine());
                    System.out.println("enter surname");
                    user.setSurname(strScanner.nextLine());
                    System.out.println("enter age");
                    user.setAge(scanner.nextInt());

                    HttpRequest req = HttpRequest
                            .newBuilder()
                            .header("Content-type","application/json")
                            .uri(new URI(baseUrl))
                            .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(user)))
                            .build();
                    HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
                    System.out.println(send.body());
                }
                case 2->{
                    HttpRequest req = HttpRequest
                            .newBuilder()
                            .uri(new URI(baseUrl))
                            .GET()
                            .build();
                    HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
                    Type type =new TypeToken<ArrayList<User>>(){}.getType();
                    ArrayList<User> users = gson.fromJson(send.body(),type);
                    for (User user : users) {
                        System.out.println(user);
                    }


                }
                case 3->{
                    System.out.println("enter user id");
                    String id = strScanner.nextLine();
                    HttpRequest req = HttpRequest
                            .newBuilder()
                            .uri(new URI(baseUrl+"/"+id))
                            .GET()
                            .build();
                    HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
                    User user = gson.fromJson(send.body(),User.class);

                    System.out.println(user);

                }
                case 4->{
                    System.out.println("enter user id");
                    String userId = strScanner.nextLine();
                    String path = baseUrl+"/"+userId;

                    User user =new User();
                    System.out.println("enter name");
                    user.setName(strScanner.nextLine());
                    System.out.println("enter surname");
                    user.setSurname(strScanner.nextLine());
                    System.out.println("enter age");
                    user.setAge(scanner.nextInt());

                    HttpRequest req = HttpRequest
                            .newBuilder()
                            .uri(new URI(path))
                            .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(user)))
                            .header("Content-type","application/json")
                            .build();

                    HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
                    System.out.println(send.body());
                }
                case 5->{
                    System.out.println("enter user id");
                    String id = strScanner.nextLine();
                    HttpRequest req = HttpRequest
                            .newBuilder()
                            .uri(new URI(baseUrl+"/"+id))
                            .DELETE()
                            .build();
                    HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
                    System.out.println(send.body());
                }
            }
        }
    }
}

