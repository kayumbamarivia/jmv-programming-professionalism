package vowels;
import java.util.Scanner;
public class Main {
    static  String removeVowels(String str){
        return str.replaceAll("[aeiou|AEIOU]","");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Java String Vowel Removal Program!");
        System.out.println("This program removes any vowel from a string");

        while (true) {
            System.out.print("\nEnter a string to validate (or type 'quit' to exit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the program. Goodbye! 👋");
                break;
            }

            String consonant = removeVowels(input);
            if (consonant.isEmpty()) {
                System.out.println("Consonant is not valid. Please try again.");
            }else{
                System.out.println("Here it is "+consonant);
            }
        }

        scanner.close();
    }
}
