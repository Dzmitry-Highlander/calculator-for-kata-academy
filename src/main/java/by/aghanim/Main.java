package by.aghanim;

import java.util.Scanner;

public class Main {
    static int result;
    static Validator validator = new Validator();
    static Converter converter = new Converter();

    public static void main(String[] ignoredArgs) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(calc(input));
    }

    public static String calc(String input) {
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
