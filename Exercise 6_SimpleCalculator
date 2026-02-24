/**
 * Write a description of class Simple Calculator here.
 *
 * @author (Group 10)
 * @version (05/02/2026)
 */
import java.util.Scanner;
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple Calculator ===\n");

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        double result;
        boolean validOperation = true;

        switch (operation) {
            case '+':
                result = num1 + num2;
                System.out.printf("%.2f + %.2f = %.2f%n", num1, num2, result);
                break;
            case '-':
                result = num1 - num2;
                System.out.printf("%.2f - %.2f = %.2f%n", num1, num2, result);
                break;
            case '*':
                result = num1 * num2;
                System.out.printf("%.2f * %.2f = %.2f%n", num1, num2, result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.printf("%.2f / %.2f = %.2f%n", num1, num2, result);
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                }
                break;
            default:
                System.out.println("Error: Invalid operation!");
                validOperation = false;
        }

        scanner.close();
    }
}


