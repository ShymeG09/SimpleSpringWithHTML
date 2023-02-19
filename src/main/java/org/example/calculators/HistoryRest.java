package org.example.calculators;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/history.json")
public class HistoryRest {
    private CalculatorLogic calculatorLogic;

    { System.out.println("HistoryRest is being created"); }

    public HistoryRest(CalculatorLogic calculatorLogic) {
        this.calculatorLogic = calculatorLogic;
    }

    @GetMapping
    @ResponseBody
    public List<String> getHistory() {
        return calculatorLogic.getHistory();
    }

}
