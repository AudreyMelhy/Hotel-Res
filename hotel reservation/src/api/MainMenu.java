package api;

import Utility.ObjectCreation;
import model.*;
import service.CustomerService;
import service.ReservationService;

import java.time.LocalDate;
import java.util.*;

import static model.RoomType.DOUBLE;

public class MainMenu {

    private static CustomerService customerService = CustomerService.getInstance();
    private static ReservationService reservationService = ReservationService.getInstance();
    private static AdminResource adminResource = AdminResource.getInstance();
    private static HotelResource hotelResource = HotelResource.getINSTANCE();
    public static int exitApp = 5;



    public static void main(String[] args) {

        ObjectCreation.createObject();


        boolean keepRunning = true;
        //Scanner scanner = new Scanner(System.in);
        try (Scanner scanner = new Scanner(System.in)) {
            while (keepRunning) {
                try {

                    System.out.println("Welcome to Pacific Hotel Reservations System");

                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" +
                            "-------------------------------------");
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    System.out.println("Please enter your selection");

                    int selection = Integer.parseInt(scanner.nextLine());


                    if (selection == 1) {
                        System.out.println("Please enter Email: ");
                        String email = scanner.nextLine();

                        System.out.println("Please provide your checkInDate");
                        LocalDate checkInDate = LocalDate.parse(scanner.next());

                        System.out.println("Please provide checkOutDate");

                        LocalDate checkOutDate = LocalDate.parse(scanner.next());

                        IRoom room7 = new Room("233A", 170.50, DOUBLE);
                        hotelResource.bookARoom(email, room7, checkInDate, checkOutDate);

                       keepRunning = false;


                    } else if (selection == 2) {

                        System.out.println("See my reservations");

                        System.out.println("Email: ");
                        String email = scanner.nextLine();
                        hotelResource.getCustomersReservations(email);
                        System.out.println("We have the following reservation on file for you: ");
                        for (Reservation r1: hotelResource.getCustomersReservations(email)) {
                            System.out.println(r1);
                        }



                       // keepRunning = false;

                    } else if (selection == 3) {

                        System.out.println("Create an account");
                        System.out.println("Please enter email");
                        String myEmail = scanner.nextLine();
                        System.out.println("Please enter first name..");
                        String myFirstName = scanner.nextLine();
                        System.out.println("Please enter last name..");
                        String myLastName = scanner.nextLine();
                        Customer newCustomer = hotelResource.createACustomer(myEmail,myFirstName,myLastName);
                       System.out.println("A new account has been created for the following customer:");
                        System.out.println("First Name: " + newCustomer.getFirstName());
                        System.out.println("Last Name: " + newCustomer.getLastName());
                        System.out.println("Email: " + newCustomer.getEmail());


                      //  keepRunning = false;
                    } else if (selection == 4) {
                        System.out.println("opening Admin menu");
                        System.out.println("1. See all Customers");
                        System.out.println("2. See all Rooms");
                        System.out.println("3. See all Reservations");
                        System.out.println("4. Add a Room");
                        System.out.println("5. Back to Main Menu");
                        System.out.println(adminResource.getAllCustomers());
                        System.out.println(adminResource.getAllRooms());


                        keepRunning = false;
                    } else if (selection == 5) {
                        System.out.println("You're about to exit, Good bye!");
                        keepRunning = false;
                    } else {
                        System.out.println("Please enter a number between 1 and 5");
                    }

                } catch (Exception ex) {
                    System.out.println("\nError - Invalid Input\n");
                    // }
                }
            }

        }
    }

    public void start() {
    }
}

