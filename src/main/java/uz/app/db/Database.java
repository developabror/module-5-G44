package uz.app.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import uz.app.entity.Booking;
import uz.app.entity.User;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private String bookingFilePath = "src/main/resources/bookings.json";
    private String userFilePath = "src/main/resources/users.json";
    Gson gson =new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();

    public void saveBookings(List<Booking> bookings){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookingFilePath))){
            writer.write(gson.toJson(bookings));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveUsers(List<User> users){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFilePath))){
            writer.write(gson.toJson(users));
        } catch (IOException e) {
        }
    }
    public List<Booking> getBookings(){
        List<Booking> bookings = new ArrayList<>();
        try {
            Type type =new TypeToken<List<Booking>>() {}.getType();
            return gson.fromJson(new FileReader(bookingFilePath),type);
        } catch (FileNotFoundException e) {}
        return new ArrayList<>();
    }
    public List<User> getUsers(){
        List<User> users= new ArrayList<>();
        try {
            Type type =new TypeToken<List<User>>() {}.getType();
            return gson.fromJson(new FileReader(userFilePath),type);
        } catch (FileNotFoundException e) {}
        return new ArrayList<>();
    }


    private static Database database;
    public static Database getInstance(){
        if(database == null){
            database = new Database();
        }
        return database;
    }
}
 class LocalDateAdapter extends TypeAdapter<LocalDate> {
    @Override
    public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
        jsonWriter.value(localDate.toString());
    }

    @Override
    public LocalDate read(JsonReader jsonReader) throws IOException {
        return LocalDate.parse(jsonReader.nextString());
    }
}
