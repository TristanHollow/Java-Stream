
public class AccountBalanceException extends Exception {

    private String message = "";
    
    public AccountBalanceException(String overdraft) {
        this.message = overdraft;
    }
    
    public String toString() {
        return message;
    }
    
}
