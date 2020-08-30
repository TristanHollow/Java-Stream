
public class AccountWithdrawException extends Exception {

    private String message = "";
    
    public AccountWithdrawException(String negative_withdraw_amount) {
        this.message = negative_withdraw_amount;
    }
    
    public String toString() {
        return message;
    }
    
}
