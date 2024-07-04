package uz.app;


import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import uz.app.currencyConverter.Currency;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    static Gson gson = new Gson();
    static Scanner scanner = new Scanner(System.in);
    static Scanner strScanner = new Scanner(System.in);
    static HttpClient client = HttpClient.newHttpClient();
    @SneakyThrows
    public static void main(String[] args) {

        HttpRequest request = HttpRequest.newBuilder().GET()
                .headers("","").uri(new URI("https://cbu.uz/oz/arkhiv-kursov-valyut/json/")).build();

        ArrayList<Currency> currencies1 = getCurrencies(request);
        ArrayList<Currency> currencies = getCurrencies(new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/"));
        while (true){
            System.out.println("""
                    0 exit
                    1 to uzs
                    2 to any
                    """);
            switch (scanner.nextInt()){
                case 0->{
                    System.out.println("bye bye");
                    return;
                }
                case 1->{
                    Optional<Currency> optionalCurrency = getCurrency(currencies);
                    if (optionalCurrency.isPresent()) {
                        Currency currency = optionalCurrency.get();
                        System.out.println("enter amount");
                        double amount = scanner.nextDouble();
                        System.out.printf("%f usd is %f in uzs\n",amount,amount*Double.parseDouble(currency.getRate()));

                    }else {
                        System.out.println("currency not found!");
                    }
                }
                case 2->{
                    Optional<Currency> optionalCurrency = getCurrency(currencies);
                    if (optionalCurrency.isPresent()) {
                        Currency currency = optionalCurrency.get();
                        System.out.println("enter amount");
                        double amount = scanner.nextDouble();
                        System.out.printf("%f usd is %f in uzs\n",amount,amount/Double.parseDouble(currency.getRate()));
                    }else {
                        System.out.println("currency not found!");
                    }
                }
            }
        }
    }

    private static Optional<Currency> getCurrency(ArrayList<Currency> currencies) {
        currencies.forEach(currency -> System.out.print(currency.getCcy()+"\t"));
        System.out.println();
        System.out.println("choose currency");
        String currency = strScanner.nextLine();
        Optional<Currency> first = currencies.stream().filter(cur -> cur.getCcy().equals(currency)).findFirst();
        return first;
    }

    private static ArrayList<Currency> getCurrencies(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        Type type = new TypeToken<ArrayList<Currency>>() {
        }.getType();
        return gson.fromJson(new InputStreamReader(urlConnection.getInputStream()), type);
    }
    @SneakyThrows
    private static ArrayList<Currency> getCurrencies(HttpRequest request)  {

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Type type = new TypeToken<ArrayList<Currency>>() {
        }.getType();
        return gson.fromJson(response.body(),type);
//        URLConnection urlConnection = url.openConnection();
//        return gson.fromJson(new InputStreamReader(urlConnection.getInputStream()), type);
    }
}

