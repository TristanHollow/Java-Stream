
public class AutoPayAccount extends CheckingAccount {
    
    private String namePaid = "";
    private String name = "";
    private int months = 0;
    private int currMonths = 1;
    private double amount = 0;
    private double initialBalance = 0;
    private double totAmount = 0;
    
    
    public AutoPayAccount(String name, String pin, double initialBalance) {
        super(name, pin, initialBalance);
        this.name = name;
    }

    public void autoPayments(String name, int months, double amount) {
        this.namePaid = name;
        this.months = months;
        this.amount = amount;
    }
    
    @Override
    public void deductFees() {
        if(currMonths >= months) {
            super.deductFees(); 
            super.withdraw(amount);
            totAmount += amount;
            currMonths = 1;
        
        } else {
            currMonths++;
        }
    }

    @Override
    public String toString() {
        return name + " paid " + namePaid + " " + totAmount;
    }
    
    
}
