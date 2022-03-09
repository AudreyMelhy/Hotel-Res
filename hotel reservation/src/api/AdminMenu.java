package api;

import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class AdminMenu {

    private static CustomerService customerService = CustomerService.getInstance();
    private static ReservationService reservationService = ReservationService.getInstance();
    private static AdminResource adminResource = AdminResource.getInstance();
    private static HotelResource hotelResource = HotelResource.getINSTANCE();

    public static void start() {

        System.out.println("Welcome to the admin menu.");
        boolean keepRunning = true;

        try (Scanner scanner = new Scanner(System.in)) {

            while (keepRunning) {
                try {
                    System.out.println("Please choose from the following options to start:");
                    ;
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to Main Menu");

                    int selection = Integer.parseInt(scanner.nextLine());

                    if (selection == 1) {
                        System.out.println("Here are all the current customers:");
                        System.out.println(" ");
                        Collection<Customer> customerList = adminResource.getAllCustomers();
                        System.out.println(" ");

                        for (Customer c : customerList) {
                            System.out.println("Customer Name: " + c.getFirstName() + " " + c.getLastName());
                            System.out.println("Customer Email: " + " " + c.getEmail());
                            System.out.println(" ");
                        }

                    } else if (selection == 2) {

                        System.out.println("Here are all rooms in our Hotel:");
                        Collection<IRoom> roomList = adminResource.getAllRooms();
                        System.out.println(" ");

                        for (IRoom r : roomList) {
                            System.out.println("Room Number: " + r.getRoomNumber());
                            System.out.println("Room Type: " + r.getRoomType());
                            System.out.println("Price per night: $" + r.getRoomPrice());
                            System.out.println(" ");
                        }


                    } else if (selection == 3) {

                        System.out.println("Here are all the current reservations:");
                        System.out.println(" ");
                        adminResource.displayAllReservations();

                    } else if (selection == 4) {
                        System.out.println("Please enter the room number: ");
                        String roomNumber = scanner.nextLine();
                        System.out.println("Please enter the room price: ");
                        Double roomPrice = Double.parseDouble(scanner.nextLine());
                        System.out.println("Please choose the room type: Enter 1 for DOUBLE or 2 for SINGLE");
                        RoomType roomType = RoomType.SINGLE;
                        Integer roomChoice = Integer.parseInt(scanner.nextLine());
                        if (roomChoice == 1) {
                            roomType = RoomType.DOUBLE;
                        }

                        IRoom room = new Room(roomNumber, roomPrice, roomType);
                        adminResource.addRoom(room);

                    } else if (selection == 5) {
                        MainMenu.start();

                    } else {
                        System.out.println("Please enter a number between 1 and 5");
                    }

                } catch (Exception ex) {
                    System.out.println("\nError - Invalid Input\n");
                }
            }
        }
    }

}







