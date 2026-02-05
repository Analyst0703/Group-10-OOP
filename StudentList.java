import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Simple Calculator here.
 *
 * @author (Group 10)
 * @version (05/02/2026)
 */

public class StudentList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        int choice;

        System.out.println("=== Student List Manager ===\n");

        do {
    
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. View all students");
            System.out.println("4. Search for a student");
            System.out.println("5. Count total students");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice (1-6): ");

            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:

                    System.out.print("Enter student name: ");
                    String nameToAdd = scanner.nextLine();
                    students.add(nameToAdd);
                    System.out.println("✓ " + nameToAdd + " added successfully!");
                    break;

                case 2:
            
                    if (students.isEmpty()) {
                        System.out.println("No students to remove!");
                    } else {
                        System.out.print("Enter student name to remove: ");
                        String nameToRemove = scanner.nextLine();
                        if (students.remove(nameToRemove)) {
                            System.out.println("✓ " + nameToRemove + " removed successfully!");
                        } else {
                            System.out.println("✗ Student not found!");
                        }
                    }
                    break;

                case 3:
                
                    if (students.isEmpty()) {
                        System.out.println("No students in the list.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println((i + 1) + ". " + students.get(i));
                        }
                    }
                    break;

                case 4:
            
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    if (students.contains(searchName)) {
                        int index = students.indexOf(searchName);
                        System.out.println("✓ Found! " + searchName + " is at position " + (index + 1));
                    } else {
                        System.out.println("✗ Student not found!");
                    }
                    break;

                case 5:
                    
                    System.out.println("Total students: " + students.size());
                    break;

                case 6:
                    
                    System.out.println("\nThank you for using Student List Manager!");
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-6.");
            }

        } while (choice != 6);

        scanner.close();
    }
}


