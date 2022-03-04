package model;
import api.MainMenu;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import service.CustomerService;
import service.ReservationService;

import java.util.*;
import java.util.regex.Pattern;

import static model.RoomType.DOUBLE;
import static model.RoomType.SINGLE;

public class Tester {



    private static final CustomerService customerService = CustomerService.getInstance();

   private static final ReservationService reservationService = ReservationService.getInstance();

    public static void main (String [] args) {

//
//        IRoom room1 = new Room("100A", 100.50, DOUBLE);
//        IRoom room2 = new Room("299C", 150.99, DOUBLE);
//        IRoom room3 = new Room("300D", 75.99, SINGLE);
//        IRoom room4 = new Room("144B", 75.99, SINGLE);
//        IRoom room5 = new Room("200F", 50.99, SINGLE);
//        IRoom room6 = new Room("33A", 60.00, SINGLE);
//        System.out.println(room5);
//        System.out.println(room4.getRoomType());
//        room2.setPrice(500.00);
//        System.out.println(room2.getRoomPrice());
//        System.out.println(room3.getRoomNumber());

        //add new customer under customer class
//
      Customer customer1 = new Customer("cp@gmail.com", "Charly", "Pilar");
      Customer customer2 = new Customer("pa@gmail.com", "Alexandre", "Papa");
      Customer customer3 = new Customer("mp@gmail.com", "Michel", "Perry");
      Customer customer4 = new Customer("dv@gmail.com", "Dave", "Perry");

        customerService.customerMap.putIfAbsent("cp@gmail.com", customer1);
        customerService.customerMap.putIfAbsent("pa@gmail.com", customer2);
        customerService.customerMap.putIfAbsent("mp@gmail.com", customer3);
        customerService.customerMap.putIfAbsent("dp@gmail.com", customer4);
//
//        System.out.println(customer3);
//

        //testing CustomerService methods
//
//        customerService.addCustomer ("Deborah", "Vidal", "dv@gmail.com");
//        customerService.addCustomer ("Victor", "Papa", "vp@gmail.com");
//        customerService.addCustomer ("Samuel", "Eto","se@gmail.com" );
//        customerService.addCustomer ("Aurelie", "Noelle", "an@gmail.com");
//        customerService.addCustomer ("Larry", "Fuller", "lf@gmail.com");
//
       System.out.println("Printing all customers in the Map...");

      System.out.println(customerService.getAllCustomers());

        //retrieving customer by email
        //System.out.println(customerService.getCustomer("se@gmail.com"));

        //testing reservation service methods

        //add room

//        reservationService.addRoom(room1);
//        reservationService.addRoom(room2);
//        reservationService.addRoom(room3);
//        reservationService.addRoom(room4);
//        reservationService.addRoom(room5);
//        reservationService.addRoom(room6);

       // System.out.println(reservationService.getARoom("33A"));

        //new reservation

       //reservationService.reserveARoom(customer1,)
       // System.out.println(reservationService.reservedRoomsMap.get("300D"));







    }

}
