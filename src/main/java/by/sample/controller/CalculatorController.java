package by.sample.controller;

import by.sample.entity.Operation;
import by.sample.entity.User;
import by.sample.storage.CalculatorStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorStorage calculatorStorage;

    @GetMapping
    public ModelAndView calculator(ModelAndView modelAndView) {
        modelAndView.addObject("operation", new Operation());
        modelAndView.setViewName("calculator");
        return modelAndView;
    }


    @PostMapping
    public String calculator2(@Valid Operation operation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
            }
        } else {
            if (operation.getOperationName().equals("SUM")) {
                calculatorStorage.sum(operation);
            }
            if (operation.getOperationName().equals("SUB")) {
                calculatorStorage.sub(operation);
            }
            if (operation.getOperationName().equals("MOD")) {
                calculatorStorage.mod(operation);
            }
            if (operation.getOperationName().equals("DIV")) {
                calculatorStorage.div(operation);
            }
            model.addAttribute("result", operation.getResult());
        }
        return "calculator";
    }

    @GetMapping("/history")
    public String history(Model model) {
        List<Operation> history = calculatorStorage.history();
        model.addAttribute("history", history);
        return "history";
    }
}
