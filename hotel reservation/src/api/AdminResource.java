package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import static model.Tester.reservationService;

public class AdminResource {

    private static AdminResource INSTANCE;

    public static AdminResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AdminResource();
        }
        return INSTANCE;
    }

    private final CustomerService customerService = CustomerService.getInstance();

    private final ReservationService reservationService = ReservationService.getInstance();


    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void addRoom(IRoom room) {
            reservationService.addRoom(room);
    }


    public Collection<IRoom> getAllRooms() {
        return reservationService.roomsMap.values();
    }

    public Collection<Customer> getAllCustomers(){return customerService.getAllCustomers();
    }

    public void displayAllReservations(){

        List<Reservation> reservationList = reservationService.getAllReservation();
        for(Reservation r : reservationList){
            System.out.println("Customer Name: " + r.getCustomer().getFirstName() + " " + r.getCustomer().getLastName());
            System.out.println("Customer Email: "+ r.getCustomer().getEmail());
            System.out.println("Room number: " + r.getRoom().getRoomNumber());
            System.out.println("Room Price: " + r.getRoom().getRoomPrice());
            System.out.println("Room Type: " + r.getRoom().getRoomType());
            System.out.println("Check In Date: " + r.getCheckInDate());
            System.out.println("Check Out Date: " + r.getCheckOutDate());
            System.out.println(" ");
        }
    }
}




