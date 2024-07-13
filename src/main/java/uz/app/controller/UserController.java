package uz.app.controller;

import uz.app.service.BookingServiceClass;
import uz.app.service.UserService;
import uz.app.utils.Context;

import static uz.app.utils.Utill.getInteger;
import static uz.app.utils.Utill.getString;

public class UserController {
    BookingController bookingController = BookingController.getInstance();
    BookingServiceClass bookingService = BookingServiceClass.getInstance();
    public void service(){
        while (true){
            switch (getInteger("""
                    0 exit
                    1 my bookings
                    2 active bookings
                    3 booking
                    4 cancel booking
                    5 balance
                    """)){
                case 0->{
                    return;
                }
                case 1->{
                    bookingService.getAllBookingsByUser(Context.getUser().getId());
                }
                case 2->{
                    bookingService.getAllActiveBookingsByUser(Context.getUser().getId());
                }
                case 3->{
                    bookingController.add();
                }
                case 4->{
                    bookingService.cancelBooking(getString("enter booking id"));
                }
                case 5->{
                    System.out.println("sizni pulingiz yo'qku!");
                }
            }
        }
    }
    private static UserController userController;
    public static UserController getInstance(){
        if (userController == null){
            userController = new UserController();
        }
        return userController;
    }
}
