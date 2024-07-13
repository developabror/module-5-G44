package uz.app.controller;

import uz.app.entity.Booking;
import uz.app.entity.enums.Status;
import uz.app.service.BookingServiceClass;
import uz.app.utils.Context;

import java.time.LocalDate;

import static uz.app.utils.Utill.getInteger;
import static uz.app.utils.Utill.getString;

public class BookingController {
    BookingServiceClass bookingService = BookingServiceClass.getInstance();

    public void add() {
        Booking booking = new Booking();

        if (Context.getUser().getRole().equals("admin")) {
            booking.setUserId(getString("enter full name of user"));
        } else {
            booking.setUserId(Context.getUser().getId());
        }

        booking.setFloor(getInteger("enter floor number"));
        booking.setRoom(getInteger("enter room number"));
        LocalDate start = LocalDate.parse(getString("enter start date as 'yyyy-mm-dd'"));
        LocalDate end = LocalDate.parse(getString("enter end date as 'yyyy-mm-dd'"));
        booking.setFromDate(start);
        booking.setToDate(end);
        booking.setStatus(Status.ACTIVE);
        booking.setActive(true);
        bookingService.save(booking);
    }

    public void edit() {
        Booking booking = new Booking();
        String id = getString("enter booking id to edit");
        booking.setFloor(getInteger("enter floor number"));
        booking.setRoom(getInteger("enter room number"));
        booking.setFromDate(LocalDate.parse(getString("enter start date as 'yyyy-mm-dd'")));
        booking.setToDate(LocalDate.parse(getString("enter end date as 'yyyy-mm-dd'")));
        booking.setStatus(Status.ACTIVE);
        bookingService.editBooking(booking, id);
    }

    public void delete() {
        String id = getString("enter booking id to delete");
        bookingService.delete(id);
    }

    private static BookingController bookingController;

    public static BookingController getInstance() {
        if (bookingController == null) {
            bookingController = new BookingController();
        }
        return bookingController;
    }

}
