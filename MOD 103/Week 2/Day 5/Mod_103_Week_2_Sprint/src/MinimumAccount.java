
public abstract class MinimumAccount extends ProtectedAccount {
	
	private double myMinimum;
	private double myPenalty;
	private boolean chargePenalty;
	
	public MinimumAccount ( String name, String pin, double min, double penalty) {
		super(name,pin);
		myMinimum = min;
		myPenalty = penalty;
		chargePenalty = false;
	}

	public void withdraw( double amount, String pin) throws AccountBalanceException, AccountSecurityException, AccountWithdrawException {
		super.withdraw(amount, pin);
		if(balance() < myMinimum)
			chargePenalty = true;
	}	

	public double computeFees() throws AccountBalanceException{
		double fee = super.computeFees();
		if(chargePenalty)
			fee += myPenalty;

		chargePenalty = false;
		
		return fee;
	}	
	
}
