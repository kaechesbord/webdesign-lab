package org.example.controller;


import org.example.data.DemoData;
import org.example.models.Hotel;
import org.example.models.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HotelController {

    // ---------- Pocetna ----------
    @GetMapping("/")
    public String home() {
        return "redirect:/a";
    }

    // ---------- Student A: lista hotela (Model A) ----------
    @GetMapping("/a")
    public String listHotels(Model model) {
        model.addAttribute("hotels", DemoData.getHotels());
        return "listA";
    }

    // ---------- Student B: lista soba (Model B) ----------
    @GetMapping("/b")
    public String listRooms(Model model) {
        model.addAttribute("rooms", DemoData.getRooms());
        return "listB";
    }

    // ---------- Zajednicka akcija: stranica hotela sa sobama za rezervaciju ----------
    @GetMapping("/a/action/{id}")
    public String hotelAction(@PathVariable Long id, Model model) {
        Optional<Hotel> hotel = DemoData.findHotelById(id);
        if (hotel.isEmpty()) {
            return "redirect:/a";   // nepostojeci hotel -> nazad na listu
        }
        model.addAttribute("hotel", hotel.get());
        return "action";
    }

    // ---------- Rezervacija sobe ----------
    @PostMapping("/b/book/{roomId}")
    public String bookRoom(@PathVariable Long roomId,
                           @RequestParam String guestName) {
        Optional<Room> room = DemoData.findRoomById(roomId);
        if (room.isEmpty()) {
            return "redirect:/a";
        }
        Room r = room.get();
        if (!r.isBooked() && !guestName.isBlank()) {
            r.setBooked(true);
            r.setGuestName(guestName.trim());
        }
        return "redirect:/a/action/" + r.getHotel().getId();
    }

    // ---------- Otkazivanje rezervacije ----------
    @PostMapping("/b/cancel/{roomId}")
    public String cancelBooking(@PathVariable Long roomId) {
        Optional<Room> room = DemoData.findRoomById(roomId);
        if (room.isEmpty()) {
            return "redirect:/a";
        }
        Room r = room.get();
        r.setBooked(false);
        r.setGuestName(null);
        return "redirect:/a/action/" + r.getHotel().getId();
    }
}