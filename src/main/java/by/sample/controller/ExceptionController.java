package by.sample.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointer(NullPointerException npe, Model model){
        String message = npe.getMessage();
        model.addAttribute("message", message);
        return "error";
    }
}
