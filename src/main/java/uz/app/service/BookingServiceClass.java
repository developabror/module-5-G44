package uz.app.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import uz.app.entity.Booking;
import uz.app.entity.Hotel;
import uz.app.entity.enums.Status;
import uz.app.repository.BookingRepository;
import uz.app.utils.Context;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Log
@AllArgsConstructor
@NoArgsConstructor
public class BookingServiceClass {

    BookingRepository bookingRepository = BookingRepository.getInstance();

    public void save(Booking booking) {
        Hotel hotel = Context.getHotel();
        if (booking.getFloor() > hotel.getFloor() || booking.getFloor() < 1) {
            log.log(Level.WARNING, "floor {0} out of bounds", booking.getFloor());
            return;
        }
        if (booking.getRoom() > hotel.getRoom() || booking.getRoom() < 1) {
            log.log(Level.WARNING, "room {0} out of bounds", booking.getRoom());
            return;
        }
        if (booking.getFromDate().isBefore(LocalDate.now())){
            throw new RuntimeException("you cannot book passed days!");
        }
        if (booking.getFromDate().isAfter(booking.getToDate())){
            throw new RuntimeException("start date should be before end date!");
        }
        List<Booking> earliestBookings = bookingRepository.getBookingsByFloorAndRoom(booking.getFloor(), booking.getRoom());
        if (earliestBookings
                .stream()
                .anyMatch(temp -> {
                    LocalDate fromDate = temp.getFromDate();
                    LocalDate toDate = temp.getToDate();
                    if (booking.getFromDate().isAfter(fromDate) && booking.getFromDate().isBefore(toDate))
                        return true;
                    if (booking.getToDate().isBefore(toDate) && booking.getToDate().isBefore(fromDate)){
                        return true;
                    }
                    if (booking.getFromDate().isBefore(fromDate) && booking.getToDate().isAfter(toDate)){
                        return true;
                    }
                    return false;
                })) {

            throw new RuntimeException("This date already taken by another user");
        }



        bookingRepository.save(booking);
    }

    public Booking getBookingById(String id) {
        Optional<Booking> optionalBooking = bookingRepository.getBookingById(id);
        return optionalBooking.orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.getAllBookings();
    }

    public List<Booking> getAllActiveBookings() {
        return bookingRepository
                .getAllBookings()
                .stream()
                .filter(Booking::getActive)
                .toList();
    }

    public List<Booking> getAllBookingsByUser(String id) {
        return bookingRepository
                .getAllBookings()
                .stream()
                .filter(t -> t.getUserId().equals(id))
                .toList();
    }

    public List<Booking> getAllActiveBookingsByUser(String id) {
        return bookingRepository
                .getAllBookings()
                .stream()
                .filter(t -> t.getUserId().equals(id))
                .filter(Booking::getActive)
                .toList();
    }


    public void editBooking(Booking booking, String id) {
        Optional<Booking> optionalBooking = bookingRepository.getBookingById(id);
        if (optionalBooking.isPresent()) {
            Booking temp = optionalBooking.get();
            temp.setFloor(booking.getFloor());
            temp.setRoom(booking.getRoom());
            temp.setFromDate(booking.getFromDate());
            temp.setToDate(booking.getToDate());
            temp.setStatus(Status.RESCHEDULED);
            /**
             * booking date tekshirilishi kerak!
             */
            bookingRepository.save(booking);
        } else {
            throw new RuntimeException("Booking not found");
        }
    }

    public void cancelBooking(String id) {
        Booking booking = getBookingById(id);
        if (!Context.getUser().getRole().equals("admin"))
            if (!booking.getUserId().equals(Context.getUser().getId()))
                throw new RuntimeException("Booking not found");
        booking.setStatus(Status.CANCELLED);
        bookingRepository.save(booking);
    }

    public void delete(String id) {
        bookingRepository.delete(id);
    }


    private static BookingServiceClass bookingService;

    public static BookingServiceClass getInstance() {
        if (bookingService == null) {
            bookingService = new BookingServiceClass();
        }
        return bookingService;
    }
}
