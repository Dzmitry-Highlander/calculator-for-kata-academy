package service.impl;

import service.api.ICalculator;

public class Calculator implements ICalculator {
    private int result;

    @Override
    public int addition(int a, int b) {
        result = a + b;

        return result;
    }

    @Override
    public int subtraction(int a, int b) {
        result = a - b;

        return result;
    }

    @Override
    public int multiplication(int a, int b) {
        result = a * b;

        return result;
    }

    @Override
    public int division(int a, int b) {
        result = a / b;

        return result;
    }
}
