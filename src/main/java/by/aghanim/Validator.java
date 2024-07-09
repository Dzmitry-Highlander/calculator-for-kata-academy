package by.aghanim;

import java.util.Objects;

class Validator {
    private final String[] arabicArray = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private final String[] romanArray = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private final String[] operandsArray = new String[] {"+", "-", "*", "/"};

    public String[] validation(String input) {
        String[] validated = new String[4];
        String[] validationArray = input.toUpperCase().split(" ");

        validated[3] = ENotations.ERROR.getNotation();

        if (validationArray.length != 3) {
            error();
        }

        for (String number : arabicArray) {
            if (Objects.equals(validationArray[0], number)) {
                validated[0] = number;
                validated[3] = ENotations.ARABIC.getNotation();

                break;
            }
        }

        for (String number : romanArray) {
            if (Objects.equals(validationArray[0], number)) {
                validated[0] = number;
                validated[3] = ENotations.ROMAN.getNotation();

                break;
            }
        }

        if (Objects.equals(validated[3], ENotations.ARABIC.getNotation())) {
            validated[3] = ENotations.ERROR.getNotation();

            for (String number : arabicArray) {
                if (Objects.equals(validationArray[2], number)) {
                    validated[1] = number;
                    validated[3] = ENotations.ARABIC.getNotation();

                    break;
                }
            }

            if (Objects.equals(validated[3], ENotations.ERROR.getNotation())) {
                error();
            }

            validated[3] = ENotations.ERROR.getNotation();

            for (String operand : operandsArray) {
                if (Objects.equals(validationArray[1], operand)) {
                    validated[2] = operand;
                    validated[3] = ENotations.ARABIC.getNotation();

                    break;
                }
            }

            if (Objects.equals(validated[3], ENotations.ERROR.getNotation())) {
                error();
            }
        } else if (Objects.equals(validated[3], ENotations.ROMAN.getNotation())) {
            validated[3] = ENotations.ERROR.getNotation();

            for (String number : romanArray) {
                if (Objects.equals(validationArray[2], number)) {
                    validated[1] = number;
                    validated[3] = ENotations.ROMAN.getNotation();

                    break;
                }
            }

            if (Objects.equals(validated[3], ENotations.ERROR.getNotation())) {
                error();
            }

            validated[3] = ENotations.ERROR.getNotation();

            for (String operand : operandsArray) {
                if (Objects.equals(validationArray[1], operand)) {
                    validated[2] = operand;
                    validated[3] = ENotations.ROMAN.getNotation();

                    break;
                }
            }

            if (Objects.equals(validated[3], ENotations.ERROR.getNotation())) {
                error();
            }
        } else {
            error();
        }

        return validated;
    }

    private void error() {
        try {
            throw new RuntimeException("Неверный ввод данных! Ознакомьтесь с инструкцией!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

            System.exit(404);
        }
    }
}
