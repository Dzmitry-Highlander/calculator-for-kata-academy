package service.impl;

import service.api.ICalculator;

public class Calculator implements ICalculator {
    private int result;
    Validator validator = new Validator();
    Converter converter = new Converter();

    @Override
    public String calc(String input) {
        String[] validated = validator.validation(input);
        String[] converted = converter.convertInput(validated);

        switch (converted[2]) {
            case "+" -> result = Integer.parseInt(converted[0]) + Integer.parseInt(converted[1]);
            case "-" -> result = Integer.parseInt(converted[0]) - Integer.parseInt(converted[1]);
            case "*" -> result = Integer.parseInt(converted[0]) * Integer.parseInt(converted[1]);
            case "/" -> result = Integer.parseInt(converted[0]) / Integer.parseInt(converted[1]);
        }

        return converter.convertOutput(result, converted[3]);
    }
}
