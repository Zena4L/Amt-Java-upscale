import java.util.Scanner;


public class FizzBuzzChallenge {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        FizzBuzzCalculator fizzBuzzCalculator = new FizzBuzzCalculator();

        System.out.println("Number:");
        int numberOne = scanner.nextInt();
        String resultOne = fizzBuzzCalculator.calculateFizzBuzz(numberOne);
        System.out.println(resultOne);

        System.out.println("Number:");
        int numberTwo = scanner.nextInt();
        String resultTwo = fizzBuzzCalculator.calculateFizzBuzz(numberTwo);
        System.out.println(resultTwo);

        System.out.println("Number:");
        int numberThree = scanner.nextInt();
        String resultThree = fizzBuzzCalculator.calculateFizzBuzz(numberThree);
        System.out.println(resultThree);

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
