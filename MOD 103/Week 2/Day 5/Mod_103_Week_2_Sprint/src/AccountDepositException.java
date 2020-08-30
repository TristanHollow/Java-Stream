
public class AccountDepositException extends Exception {

    private String message = "";
    
    public AccountDepositException(String negative_deposit_amount) {
        this.message = negative_deposit_amount;
    }
    
    public String toString() {
        return message;
    }
    
}
