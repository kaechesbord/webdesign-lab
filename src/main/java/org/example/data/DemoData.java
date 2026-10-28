package org.example.data;


import org.example.models.Hotel;
import org.example.models.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * In-memory podaci - aplikacija radi bez baze.
 * Podaci se kreiraju jednom, pri pokretanju aplikacije.
 */
public class DemoData {

    private static final List<Hotel> HOTELS = new ArrayList<>();
    private static final List<Room> ROOMS = new ArrayList<>();

    static {
        Hotel h1 = new Hotel(1L, "Hotel Sarajevo Centar", "Sarajevo", 4, "Ferhadija 12");
        Hotel h2 = new Hotel(2L, "Hotel Mostar Bridge", "Mostar", 3, "Kujundžiluk 5");
        Hotel h3 = new Hotel(3L, "Hotel Jahorina Lodge", "Jahorina", 5, "Olimpijska 1");

        HOTELS.add(h1);
        HOTELS.add(h2);
        HOTELS.add(h3);

        addRoom(1L, "101", "Single", 1, 80.0, h1);
        addRoom(2L, "102", "Double", 2, 120.0, h1);
        addRoom(3L, "201", "Suite", 4, 250.0, h1);

        addRoom(4L, "11", "Single", 1, 55.0, h2);
        addRoom(5L, "12", "Double", 2, 90.0, h2);

        addRoom(6L, "301", "Double", 2, 160.0, h3);
        addRoom(7L, "302", "Family", 4, 220.0, h3);
        addRoom(8L, "401", "Suite", 6, 380.0, h3);

        // Jedna soba je vec rezervisana da se odmah vidi razlika u prikazu
        ROOMS.get(1).setBooked(true);
        ROOMS.get(1).setGuestName("Amar Hadžić");
    }

    // Kreira sobu i povezuje je s hotelom (u oba smjera)
    private static void addRoom(Long id, String number, String type, int capacity,
                                double price, Hotel hotel) {
        Room room = new Room(id, number, type, capacity, price, hotel);
        ROOMS.add(room);
        hotel.getRooms().add(room);
    }

    public static List<Hotel> getHotels() {
        return HOTELS;
    }

    public static List<Room> getRooms() {
        return ROOMS;
    }

    public static Optional<Hotel> findHotelById(Long id) {
        return HOTELS.stream().filter(h -> h.getId().equals(id)).findFirst();
    }

    public static Optional<Room> findRoomById(Long id) {
        return ROOMS.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}