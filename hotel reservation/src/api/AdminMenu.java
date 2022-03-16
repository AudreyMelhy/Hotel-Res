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
        boolean continueRunning = true;

        try (Scanner scanner = new Scanner(System.in)) {

            while (continueRunning) {
                try {
                    System.out.println("Please choose from the following options:");
                    ;
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to Main Menu");

                    int selection = Integer.parseInt(scanner.nextLine());

                    switch (selection) {
                        case 1 : {
                            System.out.println("Here are all the current customers:");
                            System.out.println(" ");
                            Collection<Customer> customerList = adminResource.getAllCustomers();
                            System.out.println(" ");

                            for (Customer c : customerList) {
                                System.out.println("Customer Name: " + c.getFirstName() + " " + c.getLastName());
                                System.out.println("Customer Email: " + " " + c.getEmail());
                                System.out.println(" ");
                            }
                            System.out.println("What would you like to do next?");
                            break;

                        }
                        case 2 : {

                            System.out.println("Here are all the rooms in our Hotel:");
                            Collection<IRoom> roomList = adminResource.getAllRooms();
                            System.out.println(" ");

                            for (IRoom r : roomList) {
                                System.out.println("Room Number: " + r.getRoomNumber());
                                System.out.println("Room Type: " + r.getRoomType());
                                System.out.println("Price per night: $" + r.getRoomPrice());
                                System.out.println(" ");
                            }
                            System.out.println("What would you like to do next?");
                            break;

                        }
                        case 3 : {

                            System.out.println("Here are all the current reservations:");
                            System.out.println(" ");
                            adminResource.displayAllReservations();
                            System.out.println("What would you like to do next?");
                            break;

                        }
                        case 4 : {

                            Boolean addNewRoom = true;
                            while (addNewRoom) {
                                System.out.println("Please enter the room number: ");
                                String roomNumber = scanner.nextLine();
                                System.out.println("Please enter the room price: ");
                                Double roomPrice = Double.parseDouble(scanner.nextLine());
                                System.out.println("Please choose the room type: Enter 1 for SINGLE or 2 for DOUBLE");
                                RoomType roomType;
                                Integer roomChoice = Integer.parseInt(scanner.nextLine());
                                while (roomChoice != 1 && roomChoice != 2) {
                                    System.out.println("You have entered an invalid choice. Please enter 1 for SINGLE or 2 for DOUBLE:");
                                    roomChoice = Integer.parseInt(scanner.nextLine());
                                }
                                if (roomChoice == 1) {
                                    roomType = RoomType.SINGLE;
                                } else {
                                    roomType = RoomType.DOUBLE;
                                }

                                IRoom room = new Room(roomNumber, roomPrice, roomType);
                                adminResource.addRoom(room);

                                System.out.println("Would you like to add another room?");
                                System.out.println("Please enter 'no' to go back to the admin menu or press any other key to add another room.");
                                String keepAdding = scanner.nextLine();
                                if (keepAdding.equals("no")) {
                                    addNewRoom = false;
                                }

                            }
                            break;

                        }
                        case 5 : {
                            MainMenu.start();
                            continueRunning = false;
                            break;

                        }
                        default : {
                            System.out.println("Please enter a number between 1 and 5");
                        }

                    }
                }catch(Exception ex){
                        System.out.println("\nError - Invalid Input\n");
                    }
                }
            }

    }

}







