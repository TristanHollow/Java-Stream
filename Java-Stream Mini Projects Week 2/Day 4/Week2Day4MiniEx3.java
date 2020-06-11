/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2day4miniex3;

import java.util.Scanner;

/**
 *
 * @author TristanH
 */
public class Week2Day4MiniEx3 {

    /**
     * @param args the command line arguments
     */
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
