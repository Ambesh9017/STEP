import java.util.*;

/**
 * ============================================================
 * CLASS - Reservation
 * Represents a booking request
 * ============================================================
 */
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

/**
 * ============================================================
 * CLASS - RoomInventory
 * Maintains room availability
 * ============================================================
 */
class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public boolean isAvailable(String type) {
        return inventory.getOrDefault(type, 0) > 0;
    }

    public void decrement(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }

    public void displayInventory() {
        System.out.println("Current Inventory: " + inventory);
    }
}

/**
 * ============================================================
 * CLASS - RoomAllocationService
 * Handles safe allocation of rooms
 * ============================================================
 */
class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;
    private Map<String, Integer> roomCounters;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
        roomCounters = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();

        System.out.println("\nProcessing reservation for: " + reservation.getGuestName());

        // Check availability
        if (!inventory.isAvailable(roomType)) {
            System.out.println("No rooms available for type: " + roomType);
            return;
        }

        // Generate unique room ID
        String roomId = generateRoomId(roomType);

        // Atomic logical operation (assignment + inventory update)
        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.decrement(roomType);

        // Confirmation
        System.out.println("Reservation CONFIRMED for " + reservation.getGuestName());
        System.out.println("Room Type: " + roomType + " | Assigned Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {
        int count = roomCounters.getOrDefault(roomType, 0) + 1;
        roomCounters.put(roomType, count);

        String roomId = roomType.substring(0, 1).toUpperCase() + count;

        // Ensure uniqueness (extra safety)
        while (allocatedRoomIds.contains(roomId)) {
            count++;
            roomCounters.put(roomType, count);
            roomId = roomType.substring(0, 1).toUpperCase() + count;
        }

        return roomId;
    }

    public void displayAllocations() {
        System.out.println("\nAllocated Rooms By Type:");
        for (String type : assignedRoomsByType.keySet()) {
            System.out.println(type + " -> " + assignedRoomsByType.get(type));
        }
    }
}

/**
 * ============================================================
 * MAIN CLASS - UseCase6RoomAllocationService
 * ============================================================
 */
public class HotelBookingApp {

    public static void main(String[] args) {

        // Step 1: Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 2);
        inventory.addRoomType("Double", 2);

        // Step 2: Create booking queue (FIFO)
        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Alice", "Single"));
        bookingQueue.add(new Reservation("Bob", "Double"));
        bookingQueue.add(new Reservation("Charlie", "Single"));
        bookingQueue.add(new Reservation("David", "Single")); // Should fail if full

        // Step 3: Allocation service
        RoomAllocationService allocationService = new RoomAllocationService();

        // Step 4: Process bookings in FIFO order
        while (!bookingQueue.isEmpty()) {
            Reservation reservation = bookingQueue.poll();
            allocationService.allocateRoom(reservation, inventory);
            inventory.displayInventory();
        }

        // Step 5: Final report
        allocationService.displayAllocations();
    }
}