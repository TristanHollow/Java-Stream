import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        // determine max of 3 inputs
        
        System.out.println("Please input 3 whole numbers to determine their maximum.");
        
        Scanner scanIt = new Scanner(System.in);
        
        int firstOne = scanIt.nextInt();
        int secondOne = scanIt.nextInt();
        int thirdOne = scanIt.nextInt();
        
        System.out.println(Math.max(firstOne, Math.max(secondOne, thirdOne)));
        
    }
    
}
