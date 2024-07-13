package uz.app.controller;

import uz.app.service.BookingServiceClass;
import uz.app.utils.Context;

import static uz.app.utils.Utill.getInteger;
import static uz.app.utils.Utill.getString;

public class AdminController {
    BookingController bookingController = BookingController.getInstance();
    BookingServiceClass bookingService = BookingServiceClass.getInstance();

    public void service(){
        while (true){
            switch (getInteger("""
                    0 exit
                    1 booking
                    2 cancel booking
                    3 history
                    4 active bookings
                    """)){
                case 0->{
                    System.out.println("bye bye "+ Context.getUser().getName());
                    return;
                }
                case 1->{
                    bookingController.add();
                }
                case 2->{
                    bookingService.cancelBooking(getString("enter booking id"));
                }
                case 3->{
                    bookingService.getAllBookings().forEach(System.out::println);
                }
                case 4->{
                    bookingService.getAllActiveBookings().forEach(System.out::println);
                }
            }
        }
    }
    private static AdminController adminController;

    public static AdminController getInstance() {
        if (adminController == null) {
            adminController = new AdminController();
        }
        return adminController;
    }
}
