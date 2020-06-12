/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.Scanner;

/**
 *
 * @author TristanH
 */
public class Ex1 {

    /**
     * @param args the command line arguments
     */
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
