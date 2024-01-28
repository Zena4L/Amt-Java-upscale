import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    private final int principal;
    private final float annualInterestRate;
    private final byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public void getMortgage() {
        byte MONTHS_IN_YEAR = 12;
        int numberOfPayments = years * MONTHS_IN_YEAR;
        byte PERCENT = 100;
        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        System.out.println("Mortgage:$ " +  Math.round(mortgage * 100.0) / 100.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int principal;
        float annualInterestRate;
        byte years;

        while (true) {
            System.out.println("Principal:");
            try {
                principal = scanner.nextInt();
                if (principal > 1000 && principal <= 1_000_000) {
                    break;
                } else {
                    System.out.println("Enter a value between 1000 and 1000000");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.println("Annual Interest Rate:");
            try {
                annualInterestRate = scanner.nextFloat();
                if (annualInterestRate > 0) {
                    break;
                } else {
                    System.out.println("Enter a positive value for Annual Interest Rate.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.println("Period(Years):");
            try {
                years = scanner.nextByte();
                if (years > 0) {
                    break;
                } else {
                    System.out.println("Enter a positive value for Period(Years).");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        MortgageCalculator mortgageCalculator = new MortgageCalculator(principal, annualInterestRate, years);
        mortgageCalculator.getMortgage();

        scanner.close();
    }
}
