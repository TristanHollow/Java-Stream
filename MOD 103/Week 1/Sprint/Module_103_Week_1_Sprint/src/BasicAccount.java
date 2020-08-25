
public abstract class BasicAccount {
	
	private String myName;
	private double myBalance;
	private double myRate;

	public BasicAccount ( String name) {
		myBalance = 0.0;
		myRate = 0.0;
		myName = name;
	}

	public String name () {
		return myName;
	}

	public double balance () {
		return myBalance;
	}

	public double rate () {
		return myRate;
	}

	protected void deposit( double amount) {
		if(amount < 0.0)
			
                    System.out.println("Negative deposit amount");
		myBalance += amount;
	}
	

	protected void withdraw( double amount) {
		if(amount < 0.0)
			
                    System.out.println("Negative withdraw amount");
                         
		if(myBalance < amount)
			
                     System.out.println("Overdraft");
		myBalance -= amount;
	}

	protected void setRate( double rate) {
		myRate = rate;
	}

	public void monthly_update() {
		double adjustBy = computeInterest() - computeFees();
		
		myBalance += adjustBy;
	}

	public double computeFees() {
		
		double tenPercent = Math.max(0.0, myBalance * .1);
		double fee = Math.min(10.00, tenPercent);
		return fee;
	}

	public double computeInterest() {
		double monthRate = myRate/12;
		double interest = myBalance * monthRate;
		interest = Math.max(0.0, interest);
		return interest;
	}
	
	public String toString(){
		return  myName + " has balance " + myBalance;
	}
	
}
