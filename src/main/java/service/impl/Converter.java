package service.impl;

import service.api.IConverter;
import service.enums.EErrors;
import service.enums.ENotations;
import service.exception.ValidationException;

import java.util.Objects;

public class Converter implements IConverter {
    private final String[] convertArray = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] converted;
    boolean existingFlag = false;

    @Override
    public String[] convertInput(String[] input) {
        if (Objects.equals(input[1], ENotations.ARABIC.getNotation())) {
            converted = input[0].split("");

            return converted;
        } else if (Objects.equals(input[1], ENotations.ROMAN.getNotation())) {
            converted = input[0].split("");

            for (int i = 0; i < converted.length; i = i + 2) {
                for (String roman : convertArray) {
                    if (Objects.equals(roman, converted[i])) {
                        existingFlag = true;

                        break;
                    }
                }

                if (existingFlag) {
                    converted[i] = convertArray[i + 10];
                }
            }

            return converted;
        } else {
            throw new ValidationException(EErrors.InputError.getMessage());
        }
    }

    @Override
    public String convertOutput(int output, String notation) {
        return "";
    }
}
