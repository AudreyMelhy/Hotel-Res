package service;

import model.*;

import java.time.LocalDate;
import java.util.*;

public class ReservationService {

    private static ReservationService INSTANCE;

    public static ReservationService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ReservationService();
        }
        return INSTANCE;
    }

    public List<Reservation> reservationList = new ArrayList<>();

    public Map<String, IRoom> roomsMap = new HashMap<>();

    public Map<String, List<Reservation>> reservedRoomsMap = new HashMap<>();// String is roomID

    public Map<String, IRoom> unavailableRoomsAccordingToDates = new HashMap<>();


    private static void displayCurrentLocalDate() {
        Calendar calendar = Calendar.getInstance();
      //  LocalDate checkInDate = new java.util.Scanner();
    }



    public void addRoom(IRoom room) {
        roomsMap.putIfAbsent(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomID) {
        return roomsMap.get(roomID);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {

        if (reservedRoomsMap.containsKey(room.getRoomNumber())) {
            for (Reservation r1 : reservedRoomsMap.get(room.getRoomNumber())) {
                if (checkInDate.compareTo(r1.getCheckOutDate())<0)
                    return null;
            }
            Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
            customer.getCustomerReservationList().add(newReservation);
            reservationList.add(newReservation);
            reservedRoomsMap.get(room.getRoomNumber()).add(newReservation);
            reservedRoomsMap.put(room.getRoomNumber(), reservedRoomsMap.get(room.getRoomNumber()));

            return newReservation;
        }


         else {
            Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);

            customer.getCustomerReservationList().add(newReservation);
            reservedRoomsMap.put(room.getRoomNumber(), customer.getCustomerReservationList());
            reservationList.add(newReservation);
            return newReservation;
        }

    }


            public Collection<IRoom> findRooms(LocalDate checkInDate,LocalDate checkOutDate) {
                return findRooms (checkInDate, checkOutDate);
            }

            public Collection<Reservation> getCustomersReservation(Customer customer) {


               return customer.getCustomerReservationList();


            }

    public List<Reservation> getAllReservation() {

        return reservationList;
    }
}




