
public class ChristmasAccount extends SavingsAccount {
    
    private int months = 1;
    private int currMonths = 1;
    private double interestRate = 0;

    public ChristmasAccount() {
        super(20);
        interestRate = 20;
    }

    @Override
    public void addInterest() {
        if (currMonths <= 11) {
            super.addInterest();
            currMonths++;
        } else {
            interestRate = 0;
        } 
    }

    @Override
    public void withdraw(double amount) {
        if (currMonths >= 12) {
            super.withdraw(amount);
        } 
    }

}
