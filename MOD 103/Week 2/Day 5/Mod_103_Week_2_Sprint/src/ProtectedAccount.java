
public abstract class ProtectedAccount extends BasicAccount {
	
	private String myPIN;

	public ProtectedAccount ( String name, String pin) {
		super(name);
		myPIN = pin;
	}

	public void deposit( double amount, String pin) throws AccountSecurityException, AccountDepositException {
		if(!myPIN.equals(pin))
			throw new AccountSecurityException("PIN mismatch");

                else
			deposit(amount);
		
	}

	public void withdraw( double amount, String pin) throws AccountSecurityException, AccountBalanceException, AccountWithdrawException{
		if(!myPIN.equals(pin))
			throw new AccountSecurityException("PIN mismatch");

                else
			withdraw(amount);
		
	}	
	
}
