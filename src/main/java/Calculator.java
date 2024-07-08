class Calculator {
    private static int result;
    static Validator validator = new Validator();
    static Converter converter = new Converter();

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
