import java.util.Arrays;
import java.util.Scanner;

public class Week2Day4AllMiniEx {

    public static void main(String[] args) {
        // sort numerical and string arrays
        // calculate the sum of a numerical array
        // find the index value of an array element
        
        System.out.println("Press 1 to sort a numeric array.");
        System.out.println("Press 2 to sort a string array.");
        System.out.println("Press 3 to determine the sum of a numeric array.");
        System.out.println("Press 4 to find the index value of an array element.");
        
        Scanner scanIt = new Scanner(System.in);

        
        switch (scanIt.nextInt()) {
            case 1: 
                System.out.println(sortIntArr());
                break;
            case 2:
                System.out.println(sortStringArr());
                break;
            case 3:
                System.out.println(sumIntArr());
                break;
            case 4: 
                System.out.println(findStringIndex());
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
        
    }
    
    public static String sortIntArr() {
        
        int arrLength = 0;
        
        Scanner scanSomething = new Scanner(System.in);

              
                System.out.println("Enter length of array.");
                
                arrLength = scanSomething.nextInt();
                
                System.out.println("Enter the numeric array values.");
                
                int[] intArr = new int[arrLength];
                
                for (int i = 0; i < arrLength; i++) {
                    intArr[i] = scanSomething.nextInt();
                }
                
           int temp = 0;
        
         for (int i = 0; i < intArr.length - 1; i++) {
            for (int j = 0; j < intArr.length - i - 1; j++) {
               
                
                
                if (intArr[j] > intArr[j + 1]) {
                    temp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = temp;
                }
            }
        }
        
        String outPut =  Arrays.toString(intArr);
         
        return outPut;
    }
    
    public static String sortStringArr() {
                
        int arrLength = 0;
        
        Scanner scanSomething = new Scanner(System.in);

              
                System.out.println("Enter length of array.");
                
                arrLength = scanSomething.nextInt();
                
                System.out.println("Enter the string array values.");
                
                String[] stringArr = new String[arrLength];
                
                for (int i = 0; i < arrLength; i++) {
                    stringArr[i] = scanSomething.next();
                }
                
        String temp =  "";
         for (int i = 0; i < stringArr.length - 1; i++) {
            for (int j = 0; j < stringArr.length - i - 1; j++) {
                
                if (stringArr[j].compareToIgnoreCase(stringArr[j + 1]) > 0) {
                    temp = stringArr[j];
                    stringArr[j] = stringArr[j + 1];
                    stringArr[j + 1] = temp;
                }
            }
        }
        
        String outPut =  Arrays.toString(stringArr);
         
        return outPut;
    }
    
    public static int sumIntArr() {
        
        int outPut = 0;
        
        int arrLength = 0;
        
        Scanner scanSomething = new Scanner(System.in);

              
                System.out.println("Enter length of array.");
                
                arrLength = scanSomething.nextInt();
                
                System.out.println("Enter the numeric array values.");
                
                int[] intArr = new int[arrLength];
                
                for (int i = 0; i < intArr.length; i++) {
                    intArr[i] = scanSomething.nextInt();
                }
                
                for (int i = 0; i < intArr.length; i++) {
                    outPut = outPut + intArr[i];
                }
                

        
        
        return outPut;
    }
    
    public static String findStringIndex() {
    
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
                
        
        
        return outPut;
    }
    
}
