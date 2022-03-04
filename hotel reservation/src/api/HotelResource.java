package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.time.LocalDate;
import java.util.Collection;

public class HotelResource {

    private static HotelResource INSTANCE;

    public static HotelResource getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new HotelResource();
        }
        return INSTANCE;
    }

    private final CustomerService customerService = CustomerService.getInstance();
    private final ReservationService reservationService = ReservationService.getInstance();

    public Customer getCustomer (String email) {
        return customerService.getCustomer(email);
    }

    public Customer createACustomer (String email, String firstName, String lastName) {
        return customerService.addCustomer(email, firstName, lastName);

    }

    public IRoom getRoom (String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom (String customerEmail, IRoom room, LocalDate checkInDate, LocalDate checkOutDate ) {
        Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations (String customerEmail) {
        return reservationService.getCustomersReservation(customerService.getCustomer(customerEmail));
    }
    public Collection<IRoom> findARoom (LocalDate checkInDate, LocalDate checkOutDate) {
        return reservationService.findRooms(checkInDate, checkOutDate);
    }
}



