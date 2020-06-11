/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2day4miniex2;

import java.util.Scanner;

/**
 *
 * @author TristanH
 */
public class Week2Day4MiniEx2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // calculate the sum of a numerical array
            
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
                

        
        
        System.out.println(outPut);
    }
}