import service.impl.Calculator;

import java.util.Scanner;

public static void main() {
    Scanner scanner = new Scanner(System.in);
    Calculator calculator = new Calculator();

    System.out.println(calculator.calc(scanner.nextLine()));
}


