import java.util.InputMismatchException;
import java.util.Scanner;


public class FizzBuzzChallenge {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        FizzBuzzCalculator fizzBuzzCalculator = new FizzBuzzCalculator();

        while (true) {
            System.out.println("Enter a number ");
            int number = scanner.nextInt();
            try {
                System.out.println(fizzBuzzCalculator.calculateFizzBuzz(number));
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }

            System.out.println("Do you want to do another challenge (yes/no)?");
            String message = scanner.next();

            if ("no".equals(message)) {
                break;
            }
        }

        scanner.close();
    }
}


class FizzBuzzCalculator {
    public String calculateFizzBuzz(int number) {
        if (number % 5 == 0 && number % 3 == 0) {
            return "FizzBuzz";
        } else if (number % 5 == 0) {
            return "Fizz";
        } else if (number % 3 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
}
