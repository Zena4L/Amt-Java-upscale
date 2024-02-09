import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MortgageCalculator {

    private final float principal;
    private final float annualInterestRate;
    private final byte years;

    public MortgageCalculator(float principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            float principal = getPrincipal(scanner);
            float annualInterestRate = getAnnualInterestRate(scanner);
            byte years = getYears(scanner);

            MortgageCalculator mortgageCalculator = new MortgageCalculator(principal, annualInterestRate, years);
            mortgageCalculator.getMortgage();

            System.out.println("Do you want to do another calculation (yes/no)?");
            String message = scanner.next();

            if ("no".equals(message)) {
                break;
            }
        }

        scanner.close();
    }

    private static byte getYears(Scanner scanner) {
        byte years;

        while (true) {
            System.out.println("Period(Years):");
            try {
                years = scanner.nextByte();
                if (years > 0) {
                    break;
                } else {
                    System.out.println("Enter a positive value for Period(Years).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        return years;
    }

    private static float getAnnualInterestRate(Scanner scanner) {
        float annualInterestRate;

        while (true) {
            System.out.println("Annual Interest Rate:");
            try {
                annualInterestRate = scanner.nextFloat();
                if (annualInterestRate > 0) {
                    break;
                } else {
                    System.out.println("Enter a positive value for Annual Interest Rate.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        return annualInterestRate;
    }

    private static float getPrincipal(Scanner scanner) {
        float principal;

        while (true) {
            System.out.println("Principal:");
            try {
                principal = scanner.nextInt();
                if (principal > 1000 && principal <= 1_000_000) {
                    break;
                } else {
                    System.out.println("Enter a value between 1000 and 1000000");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        return principal;
    }

    public void getMortgage() {
        byte monthsInYears = 12;
        int numberOfPayments = years * monthsInYears;
        byte percent = 100;
        float monthlyInterest = annualInterestRate / percent / monthsInYears;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        System.out.println("Mortgage: $ " + Math.round(mortgage * 100.0) / 100.0);
    }
}
