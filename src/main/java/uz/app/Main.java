package uz.app;


import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    @SneakyThrows
    public static void main(String[] args){
        ArrayList<Taqvim> taqvim;
        Scanner scanner =new Scanner(System.in);
//        URL url = new URL("https://islomapi.uz/api/present/day?region=Toshkent");
//        URL url = new URL("https://islomapi.uz/api/present/week?region=Toshkent");
        URL url = new URL(" https://islomapi.uz/api/monthly?region=Toshkent&month=7");
        taqvim = getTaqvims(url);
//        ArrayList<Taqvim> comments=gson.fromJson(new InputStreamReader(inputStream),type);




        while (true){
            System.out.println("""
                    0 exit
                    1 choose day
                    2 show all
                    3 choose month
                    4 show date
                    """);
            switch (scanner.nextInt()){
                case 0->{
                    System.out.println("bye bye");
                    return;
                }
                case 1->{
                    System.out.println("1-day");
                    int day = scanner.nextInt()-1;
                    System.out.println(taqvim.get(day));
                }
                case 2->{
                    for (Taqvim taqvim1 : taqvim) {
                        System.out.println(taqvim1);
                    }
                }
                case 3->{
                    System.out.println("choose month between 1-12");
                    int month = scanner.nextInt();
                    String uri = "https://islomapi.uz/api/monthly?region=Toshkent&month="+month;
                    taqvim = getTaqvims(new URL(uri));
                }
//                case 2->{
//                    System.out.println(taqvim.getHijriDate());
//                }
//                case 3->{
//                    System.out.println(taqvim.getWeekday());
//                }
//                case 4->{
//                    System.out.println(taqvim.getDate());
//                }
            }
        }
//        Gson gson =new Gson();
//        Type type =new TypeToken<ArrayList<Comment>>(){}.getType();
//
//
//        URL url = new URL("https://jsonplaceholder.org/comments");
//        URLConnection urlConnection = url.openConnection();
//        InputStream inputStream = urlConnection.getInputStream();
//        ArrayList<Comment> comments=gson.fromJson(new InputStreamReader(inputStream),type);
//        for (Comment comment : comments) {
//            System.out.println(comment.getId());
//            System.out.println(comment.getComment());
//            System.out.println("-----------------");
//        }
//        System.out.println(url.getProtocol());
//        System.out.println(url.getHost());
//        System.out.println(url.getPort());
//        System.out.println("file = "+url.getFile());
//        System.out.println("query = "+url.getQuery());





//        Type type =new TypeToken<ArrayList<Post>>(){}.getType();
//        ArrayList<Post> posts = gson.fromJson(new FileReader("posts.json"), type);
//        for (Post post : posts) {
//            System.out.println(post);
//        }
    }

    private static ArrayList<Taqvim> getTaqvims(URL url) throws IOException {
        ArrayList<Taqvim> taqvim;
        Type type =new TypeToken<ArrayList<Taqvim>>(){}.getType();
        Gson gson =new Gson();
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        taqvim = gson.fromJson(new InputStreamReader(inputStream), type);
        return taqvim;
    }
}

