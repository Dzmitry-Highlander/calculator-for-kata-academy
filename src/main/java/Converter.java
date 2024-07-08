import java.util.Objects;

class Converter {
    private final String[] convertArray = new String[] {
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    };

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

    public String convertOutput(int input, String notation) {
        StringBuilder output = new StringBuilder();

        if (Objects.equals(notation, ENotations.ARABIC.getNotation())) {
            output = new StringBuilder(String.valueOf(input));
        } else {
            if (input <= 0) {
                try {
                    throw new RuntimeException("Неверный ввод данных! Ознакомьтесь с инструкцией!");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());

                    System.exit(404);
                }
            }

            if (input - 10 <= 0) {
                for (int i = 10; i < convertArray.length; i++) {
                    if (Objects.equals(String.valueOf(input), convertArray[i])) {
                        output = new StringBuilder(convertArray[i - 10]);
                    }
                }
            } else {
                int dozens = input / 10;

                output.append("X".repeat(dozens));

                for (int i = 10; i < convertArray.length; i++) {
                    if (Objects.equals(String.valueOf(input % 10), convertArray[i])) {
                        output.append(convertArray[i - 10]);
                    }
                }
            }
        }

        return output.toString();
    }
}
