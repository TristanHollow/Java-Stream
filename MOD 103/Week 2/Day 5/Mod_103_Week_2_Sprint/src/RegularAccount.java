
public class RegularAccount extends MinimumAccount {

	static public final double MINIMUM = 500.00;
	static public final double PENALTY = 10.00;

	public RegularAccount ( String name, String pin, double initial) throws AccountDepositException{
		super(name, pin, MINIMUM, PENALTY);
		deposit(initial);
	}
		
}
