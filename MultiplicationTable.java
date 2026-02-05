import java.util.Scanner;
/**
 * Write a description of class Multiplication Table here.
 *
 * @author (Group 10)
 * @version (05/02/2026)
 */

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Multiplication Table Generator ===\n");

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("\nMultiplication Table for " + number + ":");
        System.out.println("================================");

        for (int i = 1; i <= 12; i++) {
            int result = number * i;
            System.out.printf("%d x %2d = %3d%n", number, i, result);
        }

        System.out.println("================================");

        scanner.close();
    }
}
