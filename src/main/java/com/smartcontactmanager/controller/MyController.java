package com.smartcontactmanager.controller;

import com.smartcontactmanager.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","Home - Smart Contact Manager");
        return "Home";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title","About - Smart Contact Manager");
        return "About";
    }


    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title","Register - Smart Contact Manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    //handler for registering user

    @RequestMapping(value="/do_register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, @RequestParam(value= "agreement", defaultValue = "false") boolean agreement, Model model ){
        System.out.println("Agreement"+agreement);
        System.out.println("User"+user);
        return "signup";
    }



}
