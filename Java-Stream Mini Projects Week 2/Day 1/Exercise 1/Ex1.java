import java.util.Scanner;


public class Ex1 {

    public static void main(String[] args) {
        // receive input from user and determine whether positive or negative
        
        System.out.println("Please input a whole number to determine whether it is negative or positive.");
        
        Scanner scanIt = new Scanner(System.in);
        
        int received = scanIt.nextInt();
        
        if (received >= 0) {
            System.out.println("Positive");
        } else if (received < 0){
            System.out.println("Negative");
        }
        
    }
    
}
