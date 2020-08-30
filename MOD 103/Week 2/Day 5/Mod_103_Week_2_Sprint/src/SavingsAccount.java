
public class SavingsAccount extends BankAccount
{  

   public SavingsAccount(double rate) 
   {  
      interestRate = rate;
   }

   public void addInterest() throws AccountDepositException
   {  
      double interest = getBalance() * interestRate / 100;
      deposit(interest); 
   }

   private double interestRate;
}
