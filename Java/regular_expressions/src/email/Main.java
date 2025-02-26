package email;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static  boolean validateEmail(String email){
        return Pattern.matches("^[a-zA-Z0-9._+%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Java for Email Validating Program!");
        System.out.println("This program that validates Emails");

        while (true) {
            // Test emails
            String[] testEmails = {
                    "user@example.com",
                    "john.doe@email.co.uk",
                    "invalid-email@",
                    "hello@world@domain.com",
                    "test@.com",
            };
            System.out.print("\nEnter a email to validate (or type 'leave' to exit): ");
            String email = scanner.nextLine().trim();
            if (email.equalsIgnoreCase("leave")) {
                System.out.println("Exiting the program. Goodbye! 👋");
                break;
            }
            if (email.isEmpty()) {
                System.out.println("Email is not valid. Please try again.");
            }else{
                System.out.println(email+" -> "+(validateEmail(email) ? "✅ Valid" : "❌ Invalid"));
            }
        }

        scanner.close();
    }
}

