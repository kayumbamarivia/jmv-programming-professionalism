package example;

import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Java String Validation Program!");
        System.out.println("This program checks if a string consists only of letters (A-Z, a-z).");

        while (true) {
            System.out.print("\nEnter a string to validate (or type 'exit' to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program. Goodbye! 👋");
                break;
            }

            if (input.matches("^[a-zA-Z]+$")) {
                System.out.println("✅ '" + input + "' is a valid string.");
            } else {
                System.out.println("❌ '" + input + "' is not valid. Only letters are allowed.");
            }
        }

        scanner.close();
    }
}
