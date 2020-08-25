
 public class AccountTest
{  
   public static void main(String[] args)
   {  
       
       RegularAccount reg = new RegularAccount("Naledi Mufeng", "2234", 50.0);
       
       System.out.println(reg.toString());

       CheckingAccount check = new CheckingAccount("Naledi Mabhena", "0142", 200.0);
       check.deposit(10.0);
       check.deposit(35.0);
       check.withdraw(25.0);
       check.deductFees();
       
       System.out.println(check.getBalance());
       
   }
}
