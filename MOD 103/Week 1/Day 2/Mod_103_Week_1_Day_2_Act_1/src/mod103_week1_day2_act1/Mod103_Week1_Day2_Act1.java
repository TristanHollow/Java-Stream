/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod103_week1_day2_act1;

/**
 *
 * @author John
 */
public class Mod103_Week1_Day2_Act1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        A studA = new A(78, 64, 45);
        studA.getPercentage();
        
        B studB = new B(78, 64, 45, 88);
        studB.getPercentage();
    }
    
}

abstract class Marks{
    abstract void getPercentage();
}

class A extends Marks{

    private int mark1 = 0;
    private int mark2 = 0;
    private int mark3 = 0;
    
    @Override
    void getPercentage() {
        double percentage = ((double)mark1+(double)mark2+(double)mark3)/(double)3;
        System.out.println("Student A has an average of: "+String.format("%1.1f",percentage)+"% for 3 subjects.");//percentage);
                //
    }
     
    
    
    public A(int mark1, int mark2, int mark3){
         this.mark1 = mark1;
         this.mark2 = mark2;
         this.mark3 = mark3;
     }
}
class B extends Marks{

    private int mark1 = 0;
    private int mark2 = 0;
    private int mark3 = 0;
    private int mark4 = 0;
    
    @Override
    void getPercentage() {
        double percentage = ((double)mark1+(double)mark2+(double)mark3+(double)mark4)/(double)4;
        System.out.println("Student B has an average of: "+String.format("%1.1f",percentage)+"% for 4 subjects.");
                
    }
     
    
    
    public B(int mark1, int mark2, int mark3, int mark4){
         this.mark1 = mark1;
         this.mark2 = mark2;
         this.mark3 = mark3;
         this.mark4 = mark4;
     }
}