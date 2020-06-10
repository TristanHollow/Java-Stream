/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2day3miniex1;

import java.util.Scanner;

/**
 *
 * @author TristanH
 */
public class Week2Day3MiniEx1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // calculate average
        // check password validity
        
        System.out.println("To calculate the average of 3 numbers, press 1.");
        System.out.println("To check password validation, press 2.");
        
        Scanner scanIt = new Scanner(System.in);
        
        switch (scanIt.nextInt()) {
        
            case 1: 
                System.out.println("Average is " + showAverage());
                break;
            case 2: 
                System.out.println(passwordValidation());
                break;
            default:
                System.out.println("Invalid input.");
                break;
        
        }
        
        
        
        
    }
    
    
    public static double showAverage() {
        System.out.println("Please enter 3 numbers to determine their average.");
        
        Scanner scanIt = new Scanner(System.in);
        
        double answer = 0;
        
        for (int i = 0; i < 3; i++) {
            answer = answer + scanIt.nextDouble();
        }
        
        return (answer/3);
    }
    
    public static String passwordValidation() {
    
        System.out.println("Please enter password for validation.");
        
        Scanner scanIt = new Scanner(System.in);
        
        String str = scanIt.nextLine();
        String answer = "";
        
        int countNum = 0;
        int countChar = 0;
        
  
        
        if (str.length() < 8) {
            answer = "Password is invalid: " + str;
        } else {
        
            for (int i = 0; i < str.length(); i++) {
                if ('0'<=str.charAt(i) && str.charAt(i)<='9') {
                    countNum++;
                } 
                
                
                else  if (('a'>=str.charAt(i) && str.charAt(i)<='z') || 
                ('A'>=str.charAt(i) && str.charAt(i)<='Z')) {
                        countChar++;
                    }
                
                
            }
            
            if ( ( (countNum + countChar) ==  str.length() ) && (countNum >= 2) ) {
                answer = "Password is valid: " + str;
            } else {
                answer = "Password is invalid: " + str;
            }
            
        }
        
        return answer;
    }
    
}
