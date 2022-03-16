package api;

import Utility.ObjectCreation;
import model.*;
import service.CustomerService;
import service.ReservationService;

import java.security.Key;
import java.time.LocalDate;
import java.util.*;

import static model.RoomType.DOUBLE;

public class MainMenu {

    private static CustomerService customerService = CustomerService.getInstance();
    private static ReservationService reservationService = ReservationService.getInstance();
    private static AdminResource adminResource = AdminResource.getInstance();
    private static HotelResource hotelResource = HotelResource.getINSTANCE();



    public static void main(String[] args) {

        ObjectCreation.createObject();
        start();
    }

    public static void start(){
        boolean keepRunning = true;

        System.out.println("Welcome to Pacific Hotel Reservations System");
        try (Scanner scanner = new Scanner(System.in)) {
            while (keepRunning) {
                try {

                    System.out.println("Please choose from the following menu:");
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    System.out.println("Please enter your selection");

                    int selection = Integer.parseInt(scanner.nextLine());

                    switch (selection) {
                        case 1: {
                            Random rand = new Random();
                            System.out.println("Please enter Email: ");
                            String email = scanner.nextLine();

                            System.out.println("Please provide your checkInDate");
                            String inputDate = scanner.nextLine();
                            LocalDate checkInDate = LocalDate.parse(inputDate);

                            System.out.println("Please provide checkOutDate");

                            String outputDate = scanner.nextLine();
                            LocalDate checkOutDate = LocalDate.parse(outputDate);
                            // System.out.println(checkOutDate);

                            System.out.println("Here are the rooms that we have in our hotel: ");
                            System.out.println(" ");
                            for (IRoom room : reservationService.roomsMap.values()) {
                                System.out.println("Room Number: " + room.getRoomNumber());
                                System.out.println("Room Type: " + room.getRoomType());
                                System.out.println("Price per night: " + room.getRoomPrice());
                                System.out.println(" ");
                            }

                            System.out.println("Please enter your desired Room Number: ");
                            String roomNumberChosen = scanner.nextLine();
                            IRoom roomChosen = reservationService.roomsMap.get(roomNumberChosen);

                            Reservation myReservation = hotelResource.bookARoom(email, roomChosen, checkInDate, checkOutDate);

                            if (myReservation == null) {
                                System.out.println("The room is booked at this time. Please change your booking time.");
                            } else {
                                System.out.println(" ");
                                System.out.println("Your room has been reserved.");
                                System.out.println("Your confirmation number is: PH" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10));
                                System.out.println("Your reservation details are:");
                                System.out.println("Room Number: " + roomChosen.getRoomNumber());
                                System.out.println("Room Type: " + roomChosen.getRoomType());
                                System.out.println("Price per night: $" + roomChosen.getRoomPrice());
                                System.out.println("Check in Date: " + checkInDate);
                                System.out.println("Check out Date: " + checkOutDate);
                                System.out.println("");
                                System.out.println("Thank you for choosing Pacific Hotel. We look forward to seeing you during your stay with us.");
                                System.out.println(" ");
                                System.out.println("What would you like to do next?");
                            }
                            break;
                        }
                        case 2: {

                            System.out.println("See my reservations");

                            System.out.println("Email: ");
                            String email = scanner.nextLine();
                            if (hotelResource.getCustomersReservations(email) == null) {
                                System.out.println("Sorry. We do not have any reservation on file for you. You can make a reservation now.");
                            } else {
                                hotelResource.getCustomersReservations(email);
                                System.out.println(" ");
                                System.out.println("We have the following reservation on file for you. ");
                                int roomCount = 1;
                                for (Reservation r1 : hotelResource.getCustomersReservations(email)) {
                                    System.out.println(" ");
                                    System.out.println("ROOM " + roomCount + " has the following details:");
                                    System.out.println("Room number: " + r1.getRoom().getRoomNumber());
                                    System.out.println("Room Type: " + r1.getRoom().getRoomType());
                                    System.out.println("Price per night: " + r1.getRoom().getRoomPrice());
                                    System.out.println("Check in Date: " + r1.getCheckInDate());
                                    System.out.println("Check out Date: " + r1.getCheckOutDate());
                                    roomCount = roomCount + 1;
                                }
                            }

                            System.out.println("Thank you for being a loyal customer.");
                            System.out.println("What would you like to do next?");
                            break;
                        }

                        case 3: {
                            System.out.println("Please provide your information in order to create your account");
                            System.out.println("Please enter email:");
                            String myEmail = scanner.nextLine();
                            System.out.println("Please enter first name:");
                            String myFirstName = scanner.nextLine();
                            System.out.println("Please enter last name:");
                            String myLastName = scanner.nextLine();
                            Customer newCustomer = hotelResource.createACustomer(myEmail, myFirstName, myLastName);
                            System.out.println(" ");
                            System.out.println("Thank you " + myFirstName + " " + myLastName);
                            System.out.println("Your account has been successfully created.");
                            System.out.println("You can use your email (" + myEmail + ") to retrieve your account and make a reservation.");
                            System.out.println(" ");
                            System.out.println("What would you like to do next?");
                            break;
                        }

                        case 4: {
                            System.out.println("Opening Admin menu .......");
                            keepRunning = false;
                            AdminMenu.start();
                            break;
                        }
                        case 5: {
                            System.out.println("You're about to exit, Good bye!");
                            keepRunning = false;
                            break;
                        }

                        default:
                            System.out.println("Please enter a number between 1 and 5");

                    }

                } catch(Exception ex){
                        System.out.println("\nError - Invalid Input\n");
                        keepRunning = false;

                    }
                }
            }

        }

}

