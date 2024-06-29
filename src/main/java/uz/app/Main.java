package uz.app;

<<<<<<< HEAD
import lombok.SneakyThrows;
import uz.app.service.AuthService;

public class Main {
    @SneakyThrows
=======

import com.sun.source.util.Trees;
import uz.app.entity.Booking;
import uz.app.entity.Product;
import uz.app.entity.User;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Booking currentBooking;
    static List<Booking> bookings = new ArrayList<>();

    static List<Product> products = Arrays.asList(
            new Product("iPhone 11", 500.0),
            new Product("iPhone 12", 550.0),
            new Product("iPhone 13", 600.0),
            new Product("iPhone 14", 650.0),
            new Product("iPhone 11 pro", 600.0),
            new Product("iPhone 12 pro", 650.0),
            new Product("iPhone 13 pro", 700.0),
            new Product("iPhone 14 pro", 750.0)
    );

>>>>>>> 0e1ce699f124b6f63179c54dcc396ef3cfd17973
    public static void main(String[] args) {

//        List<List<String>> names = new ArrayList<>();
//
//        names.add(Arrays.asList(/*"Ali",*/ "Vali", "Nodir", "Bobir"));
//        names.add(Arrays.asList("Jamshid", "Sardor", "Rustam", "Asqar"));
//        names.add(Arrays.asList("Aqida", "Nodira", "Mumtoza", "Munisa"));
//        names.add(Arrays.asList("Mahmud", "Jasur", "Aziz", "Bahrom"));
//        names.add(Arrays.asList("Abdulloh", "Hasan", "Asror", "Kamol"));
//
//        Optional<String> first = names
//                .stream()
//                .parallel()
//                .flatMap(strings -> strings.stream())
//                .filter(s -> s.startsWith("A"))
//                .peek(s -> {
//                    Thread thread = Thread.currentThread();
//                    System.out.println(thread.getName() + "\t" + s);
//                })
//                .findAny();
//        System.out.println(first.get());


//        Optional<Double> reduce = products
//                .stream()
//                .map(product -> product.getPrice())
//                .reduce((aDouble, aDouble2) -> aDouble + aDouble2);
//        System.out.println(reduce.get());
//        String[][] n ={
//                {"Ali", "Vali", "Nodir", "Bobir"},
//                {"Jamshid", "Asqar", "Sardor", "Rustam"},
//                {"Aqida", "Nodira", "Mumtoza", "Munisa"},
//                {"Mahmud", "Jasur", "Aziz", "Bahrom"}
//        };
//        String[][] n2 ={
//                {"Ali", "Vali", "Nodir", "Bobir"},
//                {"Jamshid", "Asqar", "Sardor", "Rustam"},
//                {"Aqida", "Nodira", "Mumtoza", "Munisa"},
//                {"Mahmud", "Jasur", "Aziz", "Bahrom"}
//        };
//        String[][] n1 ={
//                {"Ali", "Vali", "Nodir", "Bobir","Jamshid", "Asqar", "Sardor", "Rustam","Aqida", "Nodira", "Mumtoza", "Munisa","Mahmud", "Jasur", "Aziz", "Bahrom"}
//        };

//        long count = names
//                .stream()
//                .flatMap(strings -> strings.stream())
//                .filter(s -> s.startsWith("A"))
//                .count();
//        int c = 0;
//        for (List<String> name : names) {
//            for (String s : name) {
//                if (s.startsWith("A")) c++;
//            }
//        }
//        System.out.println("a harfi bilan boshlanadigan ismlar " + c + " ta");

//
//        while (true){
//            System.out.println("""
//                    0 exit
//                    1 show products
//                    2 buy products
//                    3 confirm booking
//                    4 show basket
//                    5 history
//                    6 max amount
//                    """);
//            switch (scanner.nextInt()){
//                case 0->{}
//                case 1->{
//                    showProducts();
//                }
//                case 2->{
//                    showProducts();
//                    System.out.println("enter index");
//                    int index = scanner.nextInt();
//                    Product product = products.get(index - 1);
//                    if (currentBooking == null) {
//                        currentBooking = new Booking();
//                        currentBooking.setProducts(new ArrayList<Product>());
//                        System.out.println("enter date of booking");
//                        currentBooking.setDate(String.valueOf(scanner.nextInt()));
//                    }
//                    currentBooking.getProducts().add(product);
//                }
//                case 3->{
//                    System.out.println("order confirmed successfully");
//                    bookings.add(currentBooking);
//                    currentBooking=null;
//                }
//                case 4->{
//                    if (currentBooking == null){
//                        System.out.println("you have not any active bookings!");
//                        break;
//                    }
//                    System.out.println("your booking!");
//                    for (Product product : currentBooking.getProducts()) {
//                        System.out.println(product);
//                    }
//                }
//                case 5->{
//                    for (Booking booking : bookings) {
//                        System.out.println(booking.getDate());
//                        for (Product product : booking.getProducts()) {
//                            System.out.println("\t\t"+product);
//                        }
//                    }
//                }
//                case 6->{
//                    List<Double> list = bookings
//                            .stream()
//                            .flatMap(booking -> booking.getProducts().stream())
//                            .map(product -> product.getPrice())
//                            .toList();
//
////                    Optional<Double> max = products.stream().map(product -> product.getPrice()).max((o1, o2) -> o1.compareTo(o2));
////                    System.out.println(max.get());
//                }
//            }
//        }


//        =======================================================================
//        List<Integer> nums = new ArrayList<>(Arrays.asList(
//                21,
//                1,
//                35,
//                47,
//                73,
//                39,
//                85
//        ));
//
//
//        boolean b = nums
//                .stream()
//                .allMatch(n -> n % 2 == 1);
//        System.out.println(b);

//        List<User> users = new ArrayList<>(Arrays.asList(
//                new User("Ali", "ali@gmail.com", "root123", 20),
//                new User("Vali", "vali@gmail.com", "root123", 22),
//                new User("Sobir", "sobir@gmail.com", "root123", 19),
//                new User("Bobir", "bobir@gmail.com", "root123", 24),
//                new User("Nodir", "nodir@gmail.com", "root123", 23),
//                new User("Mushtariy", "mushtariy@gmail.com", "root123", 22),
//                new User("Mubina", "mubina@gmail.com", "root123", 12),
//                new User("Mumtoza", "mumtoza@gmail.com", "root123", 8),
//                new User("Nodira", "nodira@gmail.com", "root123", 17)
//        ));

//        users
//                .stream()
////                .peek(user -> System.out.println(user))
//                .filter(u -> u.getAge() >= 20)
//                .map(u -> u.getEmail())
//                .sorted()
//                .peek(s -> System.out.println(s))
//                .count();

//        Random random = new Random();
//        Supplier<Integer> supplier = () -> {
//            return random.nextInt(1, 10000);
//        };
//
//        List<Integer> list = Stream
//                .generate(() -> random.nextInt(1, 1000000))
//                .limit(500)
//                .peek(integer -> System.out.println(integer))
//                .toList();
//        System.out.println(list.size());


//        User userArray[] = new User[9];
//        userArray[0] = new User("Ali", "ali@gmail.com", "root123", 20);
//        userArray[1] = new User("Vali", "vali@gmail.com", "root123", 22);
//        userArray[2] = new User("Sobir", "sobir@gmail.com", "root123", 19);
//        userArray[3] = new User("Bobir", "bobir@gmail.com", "root123", 24);
//        userArray[4] = new User("Nodir", "nodir@gmail.com", "root123", 23);
//        userArray[5] = new User("Mushtariy", "mushtariy@gmail.com", "root123", 10);
//        userArray[6] = new User("Mubina", "mubina@gmail.com", "root123", 12);
//        userArray[7] = new User("Mumtoza", "mumtoza@gmail.com", "root123", 8);
//        userArray[8] = new User("Nodira", "nodira@gmail.com", "root123", 17);


//        System.out.println("the end");
//        System.out.println("all possible users "+count);


//        List<User> userList = new ArrayList<>();
//        for (User user : users) {
//            if (user.getAge()>=20) {
//                userList.add(user);
//            }
//        }


//        Predicate<String> predicate = s -> {
//            return s.startsWith("A");
//        };
//
//        Consumer<String> consumer = s->{
//            System.out.println(s);
//        };
//
//        Function<String,Integer> function=s->{
//            return Integer.parseInt(s);
//        };
//
//        Supplier<String> supplier = ()->{
//            return "";
//        };


//        List<String> names = new ArrayList<>(Arrays.asList(
//                "Alisher",
//                "Rustam",
//                "Nodir",
//                "Anvar",
//                "Sardor",
//                "Asqar",
//                "Sherzod"
//        ));


//        names.forEach(consumer);
//        names.forEach(s-> System.out.println(s));
//        names.removeIf(s -> s.startsWith("A"));
//
//        for (String name : names) {
//            System.out.println(name);
//        }

    }
<<<<<<< HEAD
=======

    private static void showProducts() {

        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, products.get(i));
        }
    }
>>>>>>> 0e1ce699f124b6f63179c54dcc396ef3cfd17973
}


