
package mod_103_week_1_day_1_act_1;

public class Mod_103_Week_1_Day_1_Act_1 {

    public static void main(String[] args) {
        Vehicle veh = new Vehicle();
       
        Bicycle bic = new Bicycle();
       
        PoweredVehicle pow = new PoweredVehicle();
       
        System.out.println(veh.word);
        System.out.println(bic.word);
        System.out.println(pow.word);
    }
}
class Vehicle{
        String word = "Petrol";
    };
    
    class Bicycle extends Vehicle{};
    
    class PoweredVehicle extends Vehicle{}; 