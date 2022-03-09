package api;

import model.IRoom;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminMenu {

    private static CustomerService customerService = CustomerService.getInstance();
    private static ReservationService reservationService = ReservationService.getInstance();
    private static AdminResource adminResource = AdminResource.getInstance();
    private static HotelResource hotelResource = HotelResource.getINSTANCE();

    public static void start () {

        System.out.println("Welcome to the admin menu.");
        boolean keepRunning = true;

        try (Scanner scanner = new Scanner(System.in)) {

            while (keepRunning){
                try {
                    System.out.println("Please choose from the following options to start:");;
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to Main Menu");

                    int selection = Integer.parseInt(scanner.nextLine());

                    if (selection == 1) {
                        System.out.println("See all Customers");
                        System.out.println(adminResource.getAllCustomers());

                        keepRunning = false;

                    } else if (selection == 2) {
                        System.out.println("See all Rooms");
                        System.out.println(adminResource.getAllRooms());
                        keepRunning = false;

                    } else if (selection == 3) {
                        System.out.println("See all Reservations");
                        keepRunning = false;

                    } else if (selection == 4) {
                        System.out.println("Add a Room");
                        addARoom("scanner");


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

    private static void addARoom(String input2) {
        AdminResource adminResource = AdminResource.getInstance();
        Scanner input = new Scanner(System.in) ;

        String addRoom;
        int type;

        do {
            RoomType roomType = null;
            input.nextLine();
            System.out.println("Enter room number");
            String roomNumber = input.nextLine();
            System.out.println("Enter price per night");
            Double price = input.nextDouble();
            do {
                System.out.println("Enter room type:1 - single bed, 2- double bed");
                type = input.nextInt();
                if (type == 1) {
                    roomType = RoomType.SINGLE;
                } else if (type == 2) {
                    roomType = RoomType.DOUBLE;
                } else {
                    System.out.println("Invalid Input");
                }
            } while (type != 1 && type != 2);

            IRoom room = new Room(roomNumber, price, roomType);

            Map<String, IRoom> roomsMap = new HashMap<>();
            roomsMap.putIfAbsent(roomNumber, room);
            adminResource.addRoom((List<IRoom>) adminResource.getAllRooms());

            do {
                System.out.println("Would you like to add another room? y/n");
                addRoom = input.next().toLowerCase().trim();
            } while (!addRoom.equals("y") && !addRoom.equals("n"));

            } while (addRoom.equals("y"));


        }
    }







