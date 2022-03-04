package api;

import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;

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

    public void addRoom(List<IRoom> rooms) {
        for (IRoom room : rooms) {
            reservationService.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return reservationService.roomsMap.values();
    }

    public Collection<Customer> getAllCustomers(){return customerService.getAllCustomers();
    }

    public void displayAllReservations(){
        reservationService.printAllReservation();
    }
}




