package controller;

import data.HotelData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelController {

    private final HotelData data;


    public HotelController(HotelData data) {
        this.data = data;
    }


    @GetMapping("/")
    public String home() {
        return "redirect:/hotels";
    }

    @GetMapping("/hotels")
    public String hotels(Model model) {
        model.addAttribute("hotels", data.findAllHotels());
        return "hotels";
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", data.findAllRooms());
        model.addAttribute("hotels", data.findAllHotels());
        return "rooms";
    }

    @PostMapping("/rooms/book")
    public String bookRoom(@RequestParam Long hotelId, @RequestParam Long roomId) {
        data.bookRoom(hotelId, roomId, 1);
        return "redirect:/rooms";
    }

}