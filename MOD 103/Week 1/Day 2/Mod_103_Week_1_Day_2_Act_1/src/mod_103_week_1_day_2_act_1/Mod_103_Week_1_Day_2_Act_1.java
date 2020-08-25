
package mod_103_week_1_day_2_act_1;

public class Mod_103_Week_1_Day_2_Act_1 {

    public static void main(String[] args) {
        
        A studA = new A(72, 48, 90);
        studA.getPercentage();
        
        B studB = new B(65, 77, 81, 78);
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
        System.out.println("Student A has an average of: "+String.format("%1.1f",percentage)+"% for 3 subjects.");
                
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