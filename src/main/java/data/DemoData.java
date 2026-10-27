package data;

import models.Hotel;
import models.Room;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HotelData {

    private final Map<Long, Hotel> hotels = new LinkedHashMap<>();
    private final Map<Long, Room> rooms = new LinkedHashMap<>();
    private long HotelSeq = 1;
    private long RoomSeq = 1;

    public HotelData() {
        saveRoom(new Room(null, "Grand Suite", 1500, 1345678, true));
        saveRoom(new Room(null, "Turpiska", 10, 99, true));
        saveRoom(new Room(null, "Twin", 60, 45, false));
        saveRoom(new Room(null, "Single", 40, 7, false));
        saveRoom(new Room(null, "Double", 12, 67, true)); // +2 power, +1 life (life cap 5)

        saveHotel(new Hotel(null, "Baroness", 7, 4602.0));
        saveHotel(new Hotel());
    }
    public List<Hotel> findAllHotels() {
        return new ArrayList<>(hotels.values());
    }

    public Hotel findHotel(Long id) {
        return hotels.get(id);
    }

    public Hotel saveHotel(Hotel h) {
        if (h.getId() == null) h.setId(HotelSeq++);
        hotels.put(h.getId(), h);
        return h;
    }

    // Rooms
    public List<Room> findAllRooms() {
        return new ArrayList<>(rooms.values());
    }

    public Room findRoom(Long id) {
        return rooms.get(id);
    }

    public Room saveRoom(Room t) {
        if (t.getId() == null) t.setId(RoomSeq++);
        rooms.put(t.getId(), t);
        return t;
    }

    // Kupovina alata: max 3 alata, lifeBoost pojedinačno max 1 (model već to poštuje)
    public boolean bookRoom(Long hotelId, Long RoomId, int price) {
        Hotel h = findHotel(hotelId);
        Room r = findRoom(RoomId);
        if (h == null || r == null) return false;
        if (!h.canAddRoom()) return false;
        if (h.getStars() < price) return false;

        h.setStars(h.getStars() - price);
        h.addRoom(r);
        return true;
    }


}
