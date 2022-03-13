package com.bolsadeideas.springboot.inouttimeinterceptor.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InOutTimeController {

    @Value("${config.intime}")
    private Integer inTime;

    @Value("${config.outtime}")
    private Integer outTime;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "Welcome to the client portal");
        return "index";
    }

    @GetMapping("/closed")
    public String closed(Model model) {
        String message = "We are closed, please try again between " + inTime + ":00 and " + outTime + ":00. Have a grate day!";
        model.addAttribute("title", "Out of opening times");
        model.addAttribute("message", message);
        return "closed";
    }
}
