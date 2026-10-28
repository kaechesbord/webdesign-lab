package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private Long id;
    private String name;
    private String city;
    private int stars;
    private String address;

    // Strana "1" u relaciji 1:N - jedan hotel ima vise soba
    private List<Room> rooms = new ArrayList<>();

    public Hotel(Long id, String name, String city, int stars, String address) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.stars = stars;
        this.address = address;
    }

    // Pomocna metoda za prikaz u View-u
    public long getFreeRoomsCount() {
        return rooms.stream().filter(r -> !r.isBooked()).count();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public int getStars() { return stars; }
    public void setStars(int stars) { this.stars = stars; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public List<Room> getRooms() { return rooms; }
    public void setRooms(List<Room> rooms) { this.rooms = rooms; }
}