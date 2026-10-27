package models;

public class Room {
    private Long id;
    private String name;
    private double pricePerNight;
    private boolean available;
    private int roomNumber;

    public Room(Long id, String name, double pricePerNight, int roomNumber, boolean available) {
        this.id = id;
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.available = available;
        this.roomNumber = roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
