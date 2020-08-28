
public class Exercise1{
    
    public class DivisionByZero extends ArithmeticException{

        String message = "";

        public DivisionByZero(String message) {
            this.message = message;
        }

        public String toString() {
            return message;
        }

    }

    public static void main(String[] args) throws DivisionByZero {
        
        Exercise1 ex1 = new Exercise1();

        int a = 3;
        int b = 0;

        try{

            if (b == 0) {
                throw ex1.new DivisionByZero("Cannot divide by zero."); 
            }

            System.out.println(a/b);

        } catch (DivisionByZero dbz) {
            System.out.println(dbz.toString());
        }

    }
}