/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.util.Scanner;

/**
 *
 * @author TristanH
 */
public class Ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // receive a number between 1 and 7 and print out the corresponding day of the week
        // generate a random number if it is not given by the user
        
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
