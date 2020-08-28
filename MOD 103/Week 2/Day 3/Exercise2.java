public class Exercise2 {
    public static void main(String[] args) {

        int a = 3;
        int b = 0;

        try {
            System.out.println(a/b);
        } catch (ArithmeticException e) {
            if (b == 0) {
                System.out.println("Cannot divide by zero.");
            }
        } 
    }
}