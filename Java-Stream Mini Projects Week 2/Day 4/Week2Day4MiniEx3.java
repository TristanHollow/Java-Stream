import java.util.Scanner;

public class Week2Day4MiniEx3 {

    public static void main(String[] args) {
        // find the index value of an array element
    
        String outPut = "";
                    
        int arrLength = 0;
        
        Scanner scanSomething = new Scanner(System.in);

              
                System.out.println("Enter length of array.");
                
                arrLength = scanSomething.nextInt();
                
                System.out.println("Enter the array values.");
                
                String[] stringArr = new String[arrLength];
                
                for (int i = 0; i < stringArr.length; i++) {
                    stringArr[i] = scanSomething.next();
                }
                
                System.out.println("Enter the sought value.");
                
                String sought = scanSomething.next();
                
                
                for (int i = 0; i < stringArr.length; i++) {
                    if (stringArr[i].equals(sought)) {
                        outPut = String.valueOf(i);
                        break;
                    }
                }
                
        
        
        System.out.println(outPut);
    }
    
}
