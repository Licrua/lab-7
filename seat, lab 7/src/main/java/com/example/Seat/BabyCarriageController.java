package com.example.Seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BabyCarriageController {

    @Autowired
    BabyCarriageRepository babyCarriageRepository;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/babyCarriage/list")
    public String showBabyCarriageList(Model model) {
        Iterable<BabyCarriage> babyCarriages = babyCarriageRepository.findAll();
        model.addAttribute("carriages", babyCarriages);
        return "babyCarriage/list";
    }

    @GetMapping("/babyCarriage/add")
    public String showAddBabyCarriageForm(Model model) {
        model.addAttribute("babyCarriage", new BabyCarriage());
        return "babyCarriage/add";
    }

    @PostMapping("/babyCarriage/add")
    public String addBabyCarriageForm(@ModelAttribute BabyCarriage babyCarriage) {
        babyCarriageRepository.save(babyCarriage);
        return "redirect:/babyCarriage/list";
    }

}
