import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {

        Scanner scanIt = new Scanner(System.in);

        System.out.println("Enter the dividend:");
        int a = scanIt.nextInt();

        System.out.println("Enter the divisor:");
        int b = scanIt.nextInt();

        try {
            System.out.println("The quotient is " + a/b);
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter an Integer value.");
        } catch (ArithmeticException ae) {
            if (b == 0) {
                System.out.println("Cannot divide by zero.");
            }
        } 
    }
}