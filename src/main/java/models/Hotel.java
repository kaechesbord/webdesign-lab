package models;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private Long id;
    private String name;
    private int kapacitet;
    private double stars;

    private List<Room> rooms = new ArrayList<>();

    public Hotel(){}

    public Hotel(Long id, String name, int kapacitet, double stars) {
        this.id = id;
        this.name = name;
        this.kapacitet = kapacitet;
        this.stars = stars;
    }


    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
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


    public boolean canAddRoom(){return rooms.size() < this.kapacitet;}

    public void addRoom(Room r){
        if(canAddRoom()){
            rooms.add(r);
        }
    }
    public boolean removeRoom(Long roomId) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getId().equals(roomId)) {
                rooms.remove(i);
                return true;
            }
        }
        return false;
    }


}
