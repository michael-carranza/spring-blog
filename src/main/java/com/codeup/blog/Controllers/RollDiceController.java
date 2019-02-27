package com.codeup.blog.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
class RollDiceController {

    @RequestMapping("/rolldice/")
    public String rollDice() {
        return "rolldice/show";
    }
    @RequestMapping("/rolldice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int random = (int) Math.ceil(Math.random() * 6);
        model.addAttribute("random", random);
        model.addAttribute("guess", guess);
        return "rolldice";
    }
}