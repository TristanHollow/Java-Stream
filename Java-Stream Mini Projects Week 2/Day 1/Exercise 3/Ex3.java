import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {
        // receive a number between 1 and 7 and print out the corresponding day of the week
        
        System.out.println("Please input a number between 1 and 7.");
        
        Scanner scanIt = new Scanner(System.in);
        
        int dayNum = scanIt.nextInt();
        
        switch (dayNum) {
            case 1: 
                System.out.println("Monday");
                break;
            case 2: 
                System.out.println("Tuesday");
                break;
            case 3: 
                System.out.println("Wednesday");
                break;
            case 4: 
                System.out.println("Thursday");
                break;
            case 5: 
                System.out.println("Friday");
                break;
            case 6: 
                System.out.println("Saterday");
                break;
            case 7: 
                System.out.println("Sunday");
                break;
            default: 
                System.out.println("Invalid input. Please try again.");
                break;
        }
        
    }
    
}
