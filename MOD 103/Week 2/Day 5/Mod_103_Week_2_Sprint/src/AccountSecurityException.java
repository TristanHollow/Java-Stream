
public class AccountSecurityException extends Exception {

    private String message = "";
    
    public AccountSecurityException(String pin_mismatch) {
        this.message = pin_mismatch;
    }
    
    public String toString() {
        return message;
    }
    
}
