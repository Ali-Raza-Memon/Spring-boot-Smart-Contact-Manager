package com.smartcontactmanager.controller;

import com.smartcontactmanager.helper.Message;
import com.smartcontactmanager.models.User;
import com.smartcontactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    @Autowired
    private UserRepository userRepository;

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
    public String registerUser(@ModelAttribute("user") User user, @RequestParam(value= "agreement", defaultValue = "false") boolean agreement, Model model, HttpSession session ){

        try{
            if(!agreement){
                System.out.println("You have not agreed the terms and conditions");
                throw new Exception("You have not agreed the terms and conditions");
            }
            user.setRoll("ROLE_USER");
            user.setEnabled(true);
            user.setImageUrl("default.png");
            System.out.println("Agreement"+agreement);
            System.out.println("User"+user);
            User result = this.userRepository.save(user);
            model.addAttribute("user",new User());
            session.setAttribute("message", new Message("Successfully registered","alert-success"));
            return "signup";


        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("user",user);
            session.setAttribute("message", new Message("Something went wrong"+e.getMessage(),"alert-danger"));
            return "signup";
        }

    }



}
