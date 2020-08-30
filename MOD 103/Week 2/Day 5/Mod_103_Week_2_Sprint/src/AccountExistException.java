
public class AccountExistException extends Exception {
    private String message = "";
    
    public AccountExistException(String message) {
        this.message = message;
    }
    
    public String toString() {
        return message;
    }
}
