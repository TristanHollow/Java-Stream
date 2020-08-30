
 public class AccountTest
{  
     
     public static int i = -1; 
     
     public static String[] names = new String[100];
     
     public static String name = "";
    public static boolean answer = false;
    
     public static void testAccount() throws AccountExistException {
        
         answer = false;
         
         for (int k = 0; k <= i; k++) {
               if (names[k].equals(name)) {
                   answer = true;
                   throw new AccountExistException("Account already exists.");
               }
           }
         
         
     }
     
     
   public static void main(String[] args) throws AccountDepositException, AccountBalanceException, AccountSecurityException, AccountWithdrawException, AccountExistException 
   {  
       
       try {
           
           RegularAccount regular = new RegularAccount("Naledi Mufeng", "2234", 50.0);
           i++;
           names[i] = regular.name();
       
           
           
           name = "haha";
           testAccount();
           
        
           
           RegularAccount regular2 = new RegularAccount(name, "2134", 250.0);
           i++;
           names[i] = regular2.name();
           

           System.out.println(regular2.toString());
           
           //add account
           
           name = "ja";
           testAccount();
           
           RegularAccount regular3 = new RegularAccount(name, "2034", 500.0);
           i++;
           names[i] = regular3.name();
           
        
           System.out.println(regular3.toString());
           
           //add account end
           
           //test
           
           name = "haha";
           testAccount();
           
           RegularAccount regular4 = new RegularAccount(name, "1934", 500.0);
           i++;
           names[i] = regular4.name();
           System.out.println(regular4.toString());
       
           //test end
           
       System.out.println(regular.toString());
       regular.withdraw(10, "2234");
       System.out.println(regular.toString());

       CheckingAccount check = new CheckingAccount("Naledi Mabhena", "0142", 200.0);
       check.deposit(10.0);
       check.deposit(35.0);
       check.withdraw(25.0);
       check.deductFees();
       
       System.out.println(check.getBalance());
       } catch (AccountDepositException ade) {
           System.out.println(ade.toString());
       } catch (AccountBalanceException abe) {
           System.out.println(abe.toString());
       } catch (AccountSecurityException ase) {
           System.out.println(ase.toString());
       } catch (AccountWithdrawException awe) {
           System.out.println(awe.toString());
       } catch (AccountExistException aee) {
           System.out.println(aee.toString());
       }
       
     
   }
}
