package com.example.Seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarSeatController {

    @Autowired
    CarSeatRepository carSeatRepository;

    @GetMapping("/carSeat/list")
    public String showBabyCarriageList(Model model) {
        Iterable<CarSeat> carSeats = carSeatRepository.findAll();
        model.addAttribute("carSeats", carSeats);
        return "carSeat/list";
    }

    @GetMapping("/carSeat/add")
    public String showAddBabyCarriageForm(Model model) {
        model.addAttribute("carSeat", new CarSeat());
        return "carSeat/add";
    }

    @PostMapping("/carSeat/add")
    public String addCarSeatForm(@ModelAttribute CarSeat carSeat) {
        carSeatRepository.save(carSeat);
        return "redirect:/carSeat/list";
    }

}

