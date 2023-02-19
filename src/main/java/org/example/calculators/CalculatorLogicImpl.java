package org.example.calculators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CalculatorLogicImpl implements CalculatorLogic {
    private List<String> history = Collections.synchronizedList(new ArrayList<>());

    { System.out.println("CalculatorLogic is being created"); }

    @Override
    public int calculate(int number1, int number2, String operation) {
        int result = switch (operation) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "/" -> number1 / number2;
            case "%" -> number1 % number2;
            default -> throw new IllegalArgumentException("Not supported operation " + operation);
        };
        history.add(String.format("%d %s %d = %d", number1, operation, number2, result));
        return result;
    }

    @Override
    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
