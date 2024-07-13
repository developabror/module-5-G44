package uz.app.repository;

import uz.app.db.Database;
import uz.app.entity.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BookingRepository {
    Database database = Database.getInstance();
    List<Booking> bookings = new ArrayList<>();

    public void save(Booking booking) {
        Optional<Booking> any = bookings.stream().filter(t -> t.getId().equals(booking.getId())).findAny();
        if (any.isEmpty()) {
            bookings.add(booking);
        }
        database.saveBookings(bookings);
    }

    public Optional<Booking> getBookingById(String id) {
        return getAllBookings().stream().filter(booking -> booking.getId().equals(id)).findFirst();
    }

    public List<Booking> getAllBookings() {
        bookings = database.getBookings();
        if (bookings == null) {
            bookings = new ArrayList<>();
        }
        return bookings;
    }


    public void delete(String id) {
        Optional<Booking> optionalBooking = getBookingById(id);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            bookings.remove(booking);
            database.saveBookings(bookings);
        }
    }

    public List<Booking> getBookingsByFloorAndRoom(Integer floor, Integer room) {
        bookings = database.getBookings();
        if (bookings == null) {
            bookings = new ArrayList<>();
        }
        return bookings
                .stream()
                .filter(booking -> booking.getFloor().equals(floor) &&
                        booking.getRoom().equals(room))
                .toList();

    }


    private static BookingRepository bookingRepository;

    public static BookingRepository getInstance() {
        if (bookingRepository == null) {
            bookingRepository = new BookingRepository();
        }
        return bookingRepository;
    }
}
