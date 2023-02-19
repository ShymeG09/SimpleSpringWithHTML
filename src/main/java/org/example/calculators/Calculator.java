package org.example.calculators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class Calculator {
    @Autowired
    private CalculatorLogic calculatorLogic;

    { System.out.println("Calculator controller is being created"); }

    @GetMapping
    public String calculatorGet() {
        return "calculator.html";
    }

    @PostMapping
    public String kalkulatorPost(Integer number1, Integer number2, String operation, Model model) {
        try {
            int result = calculatorLogic.calculate(number1, number2, operation);
            model.addAttribute("result", result);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }

        return "calculator.html";
    }

    @GetMapping("/history")
    public String historyHtml(Model model) {
        model.addAttribute("history", calculatorLogic.getHistory());
        return "history.html";
    }
}
