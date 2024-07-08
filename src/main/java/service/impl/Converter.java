package service.impl;

import service.api.IConverter;
import service.enums.ENotations;

import java.util.Objects;

public class Converter implements IConverter {
    private final String[] convertArray = new String[] {
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    };

    @Override
    public String[] convertInput(String[] input) {
        String[] converted = new String[input.length];

        if (Objects.equals(input[3], ENotations.ARABIC.getNotation())) {
            converted = input;
        } else if (Objects.equals(input[3], ENotations.ROMAN.getNotation())) {
            for (int i = 0; i < input.length - 2; i++) {
                for (int j = 0; j < convertArray.length / 2; j++) {
                    if (Objects.equals(input[i], convertArray[j])) {
                        converted[i] = convertArray[j + 10];
                    }
                }
            }

            converted[converted.length - 1] = input[input.length - 1];
            converted[converted.length - 2] = input[input.length - 2];
        }

        return converted;
    }

    @Override
    public String convertOutput(int output, String notation) {
        return "";
    }
}
