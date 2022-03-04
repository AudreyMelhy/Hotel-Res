package model;

public class Room implements IRoom {
    private String roomNumber; // also equal roomID
    private Double price;
    private RoomType roomType;

    private static int roomCounter = 0;

    public Room(String roomNumber, Double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
        roomCounter++;
    }


    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    public void setRoomNumber (String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPrice (Double price) {
        this.price = price;
    }

    public void setRoomType (RoomType roomType) {
        this.roomType = roomType;
    }

    public static int getRoomCounter () {
        return roomCounter;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", RoomType=" + roomType +
                '}';
    }
}


