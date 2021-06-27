package by.sample.controller;

import by.sample.entity.User;
import by.sample.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserStorage userStorage;

    @GetMapping("/registration") //localhost:8080/user/registration
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @GetMapping("/authorization")
    public String authorization2() {
        return "authorization";
    }

    @PostMapping("/authorization")
    public String authorization(User user, HttpSession httpSession) {
        User byLogin = userStorage.getByLogin(user.getLogin());
        if (byLogin.getPassword().equals(user.getPassword())) {
            httpSession.setAttribute("user", byLogin);
        }
        return "redirect:/";
    }

    @PostMapping("/registration")
    public String registration2(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            userStorage.save(user);
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

//    @PostMapping("/updateName")
//    public String updateName(@Valid String newName, HttpSession httpSession){
//        User user = (User) httpSession.getAttribute("user");
//        userStorage.updateName(newName, user.getLogin());
//        return "redirect:/";
//    }
//
//    @PostMapping("/updateName")
//    public String updatePassword(@Valid String newPassword, HttpSession httpSession){
//        User user = (User) httpSession.getAttribute("user");
//        userStorage.updatePassword(newPassword, user.getLogin());
//        return "redirect:/";
//    }
}
