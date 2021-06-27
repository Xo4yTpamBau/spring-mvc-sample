package by.sample.controller;

import by.sample.entity.User;
import by.sample.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class HomeController {


    @GetMapping
    public String home(@RequestParam(value = "name", defaultValue = "Guest") String name, Model model){
        model.addAttribute("name", name);
        return "home";
    }

    @PostMapping
    public String home2(User user){
        System.out.println(user);
        return "redirect:/";
    }
}
