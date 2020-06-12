/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.util.Scanner;

/**
 *
 * @author TristanH
 */
public class Ex2 {

    /**
     * @param args the command line arguments
     */
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
