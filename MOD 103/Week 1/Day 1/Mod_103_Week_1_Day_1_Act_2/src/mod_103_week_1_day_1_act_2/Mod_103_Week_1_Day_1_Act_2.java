
package mod_103_week_1_day_1_act_2;

import java.util.Scanner;

public class Mod_103_Week_1_Day_1_Act_2 {

    public static void main(String[] args) {
        Scanner scanIt = new Scanner(System.in);
        
        System.out.println("Weighted item or counted item? Type either 'weight' or 'count'.");
        
        String choice = scanIt.next();
        
        
        
        if (choice.equalsIgnoreCase("weight")) {
            System.out.println("Enter weight(kg).");
            double mass = Double.valueOf(scanIt.next());
            
            weighedItem wei = new weighedItem(mass);
            System.out.println("R " + String.valueOf(wei.getPrice()));
        }
        
        if (choice.equalsIgnoreCase("count")) {
            System.out.println("Enter amount of items.");
            int count = Integer.valueOf(scanIt.next());
            
            countedItem cou = new countedItem(count);
            
            System.out.println("R " + String.valueOf(cou.getPrice()));
        }
        
    }
    
}

class purchaseItem{
    private String name;
    private double unitPrice;
    
    purchaseItem() {
        name = "no item";
        unitPrice = 0;
    }
    
    public double getPrice() {
        return this.unitPrice;
    }
    
}

class weighedItem extends purchaseItem{
    
    private double weight;
    
    public weighedItem(double weight) {
        super();
        this.weight = weight;
        
    }
    
    @Override
    public double getPrice() {
        return weight*super.getPrice();
    }
    
}

class countedItem extends purchaseItem{
    
    private int quantity; 
    
    public countedItem(int quantity) {
        super();
        this.quantity = quantity;
        
    }
    
    @Override
    public double getPrice() {
        return quantity*super.getPrice();
    }
    
}
