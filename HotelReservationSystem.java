import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private boolean isReserved;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isReserved = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        isReserved = true;
    }

    public void cancelReservation() {
        isReserved = false;
    }
}

class Hotel {
    private List<Room> rooms;

    public Hotel(int numberOfRooms) {
        rooms = new ArrayList<>();
        for (int i = 1; i <= numberOfRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isReserved()) {
                System.out.println("Room " + room.getRoomNumber());
            }
        }
    }

    public void makeReservation(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isReserved()) {
                room.reserve();
                System.out.println("Reservation successful for Room " + roomNumber);
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is not available for reservation.");
    }

    public void cancelReservation(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isReserved()) {
                room.cancelReservation();
                System.out.println("Reservation canceled for Room " + roomNumber);
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is not reserved.");
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rooms in the hotel: ");
        int numberOfRooms = scanner.nextInt();
        Hotel hotel = new Hotel(numberOfRooms);

        int choice;
        do {
            System.out.println("\n1. Display available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. Cancel reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter the room number for reservation: ");
                    int roomNumber = scanner.nextInt();
                    hotel.makeReservation(roomNumber);
                    break;
                case 3:
                    System.out.print("Enter the room number for cancellation: ");
                    int cancelRoomNumber = scanner.nextInt();
                    hotel.cancelReservation(cancelRoomNumber);
                    break;
                case 4:
                    System.out.println("Exiting the Hotel Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
