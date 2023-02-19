package org.example.calculators;

import java.util.List;

public interface CalculatorLogic {

    int calculate(int numer1, int number2, String operation);

    List<String> getHistory();

}