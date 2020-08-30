
public class CheckingAccount extends BankAccount
{  
   public CheckingAccount(String name, String pin, double initialBalance)
   {  
      super(initialBalance);
      
      transactionCount = 0; 
 
   }
  
   public void deposit(double amount) throws AccountDepositException
   {  
      transactionCount++;

      super.deposit(amount); 
   }
   
   public void withdraw(double amount) throws AccountBalanceException, AccountWithdrawException
   {  
      transactionCount++;

      super.withdraw(amount); 
   }

   public void deductFees() throws AccountBalanceException, AccountWithdrawException
   {  
      if (transactionCount > FREE_TRANSACTIONS)
      {  
         double fees = TRANSACTION_FEE *
            (transactionCount - FREE_TRANSACTIONS);
         super.withdraw(fees);
      }
      transactionCount = 0;
   }

   private int transactionCount;

   private static final int FREE_TRANSACTIONS = 3;
   private static final double TRANSACTION_FEE = 2.0;
}
