package org.example.models;

public class Room {

    private Long id;
    private String roomNumber;
    private String type;          // npr. Single, Double, Suite
    private int capacity;
    private double pricePerNight;
    private boolean booked;
    private String guestName;

    // Strana "N" u relaciji 1:N - svaka soba pripada jednom hotelu
    private Hotel hotel;

    public Room(Long id, String roomNumber, String type, int capacity,
                double pricePerNight, Hotel hotel) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.hotel = hotel;
        this.booked = false;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }

    public boolean isBooked() { return booked; }
    public void setBooked(boolean booked) { this.booked = booked; }

    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; }

    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }
}