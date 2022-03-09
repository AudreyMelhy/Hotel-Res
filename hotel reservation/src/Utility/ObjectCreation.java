package Utility;

import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import static model.RoomType.DOUBLE;
import static model.RoomType.SINGLE;

public class ObjectCreation {

    private final CustomerService customerService = CustomerService.getInstance();
    private final ReservationService reservationService = ReservationService.getInstance();

    public static void createObject () {
        final CustomerService customerService = CustomerService.getInstance();
        final ReservationService reservationService = ReservationService.getInstance();

        IRoom room1 = new Room("100A", 100.50, DOUBLE);
        IRoom room2 = new Room("299C", 150.99, DOUBLE);
      IRoom room3 = new Room("300D", 75.99, SINGLE);
       IRoom room4 = new Room("144B", 75.99, SINGLE);
      IRoom room5 = new Room("200F", 50.99, SINGLE);
      IRoom room6 = new Room("33A", 60.00, SINGLE);

        Customer customer1 = new Customer("cp@gmail.com", "Charly", "Pilar");
        Customer customer2 = new Customer("pa@gmail.com", "Alexandre", "Papa");
        Customer customer3 = new Customer("mp@gmail.com", "Michel", "Perry");
        Customer customer4 = new Customer("dv@gmail.com", "Dave", "Perry");




   }
}
