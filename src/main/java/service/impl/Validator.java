package service.impl;

import service.api.IValidator;
import service.enums.EErrors;
import service.enums.ENotation;
import service.exception.ValidationException;

import java.util.Arrays;
import java.util.Objects;

public class Validator implements IValidator {
    private final String[] arabicArray = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private final String[] romanArray = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private final String[] operandsArray = new String[] {"+", "-", "*", "/"};

    @Override
    public String[] validation(String input) {
        String[] validated = new String[2];
        boolean existingFlag = false;
        String notationFlag = "";

        String[] validationArray =  input.toUpperCase().split(" ");

        if (validationArray.length > 3) {
            throw new ValidationException(EErrors.InputError.getMessage());
        }

        for (int i = 0; i < validationArray.length; i = i + 2) {
            for (String arabic : arabicArray) {
                if (Objects.equals(arabic, validationArray[i])) {
                    existingFlag = true;
                    notationFlag = ENotation.ARABIC.getNotation();

                    break;
                } else {
                    throw new ValidationException(EErrors.InputError.getMessage());
                }
            }
        }

        for (int i = 0; i < validationArray.length; i = i + 2) {
            for (String roman : romanArray) {
                if (Objects.equals(roman, validationArray[i])) {
                    existingFlag = true;
                    notationFlag = ENotation.ROMAN.getNotation();

                    break;
                } else {
                    throw new ValidationException(EErrors.InputError.getMessage());
                }
            }
        }

        if (existingFlag) {
            for (int i = 1; i < validationArray.length; i = i + 2) {
                for (String operand : operandsArray) {
                    if (Objects.equals(operand, validationArray[i])) {
                        validated[0] = Arrays.toString(validationArray);
                        validated[1] = notationFlag;
                    } else {
                        throw new ValidationException(EErrors.InputError.getMessage());
                    }
                }
            }
        } else {
            throw new ValidationException(EErrors.InputError.getMessage());
        }

        return validated;
    }
}
