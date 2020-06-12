import java.util.Scanner;

public class TristanJavaStreamWeek1MiniProgram1 {

    public static void main(String[] args) {
        // count to specific value
        // count amount odd
        // count amount even
        // count in multiples
    

        
        System.out.println("To display all numbers from start to end, press A.");
        System.out.println("To display odd numbers between start and end, press B.");
        System.out.println("To display even numbers between start and end, press C.");
        System.out.println("To display multiples of a number from start to end, press D.");
        
        Scanner chosenOption = new Scanner(System.in);
        
        String numVariant = "";
        int count = 0;
        
        switch (chosenOption.nextLine()) {
            case "A":
                {
                    numVariant = "all"; 
                    
                    System.out.println("Please enter starting number.");
                    Scanner num = new Scanner(System.in);
                    int startNum = num.nextInt();
                    System.out.println("Please enter ending number.");
                    int endNum = num.nextInt();
                    
                                        
                    System.out.println("xxxxxxxxxxxxxxxxxxx");
                    
                    
                    for (int i = startNum; i <= endNum; i++ ) {
                        System.out.println(i);
                        count++;
                    }
                    
                                        
                    System.out.println("xxxxxxxxxxxxxxxxxxx");
                    
                    break;
                }
            case "B":
                {
                    numVariant = "even"; 
                    
                    System.out.println("Please enter starting number.");
                    Scanner num = new Scanner(System.in);
                    int startNum = num.nextInt();
                    System.out.println("Please enter ending number.");
                    int endNum = num.nextInt();
                    
                                        
                    System.out.println("xxxxxxxxxxxxxxxxxxx");
                    
                    
                    for (int i = startNum; i <= endNum; i++ ) {
                        if ((i % 2) == 0) {
                            System.out.println(i);
                            count++;
                        }
                    }
                    
                                        
                    System.out.println("xxxxxxxxxxxxxxxxxxx");
                    
                    break;
                }
            case "C":
                {
                    numVariant = "odd"; 
                    
                    System.out.println("Please enter starting number.");
                    Scanner num = new Scanner(System.in);
                    int startNum = num.nextInt();
                    System.out.println("Please enter ending number.");
                    int endNum = num.nextInt();
                    
                                        
                    System.out.println("xxxxxxxxxxxxxxxxxxx");
                    
                    
                    for (int i = startNum; i <= endNum; i++ ) {
                        if ((i % 2) != 0) {
                            System.out.println(i);
                            count++;
                        }
                    }
                    
                                        
                    System.out.println("xxxxxxxxxxxxxxxxxxx");
                    
                    break;
                }
            case "D":
                {
                    numVariant = "multiples"; 
                    
                    System.out.println("Please enter starting number.");
                    Scanner num = new Scanner(System.in);
                    int startNum = num.nextInt();
                    System.out.println("Please enter ending number.");
                    int endNum = num.nextInt();
                    System.out.println("Please enter number to be used as the multiple.");
                    int multipleNum = num.nextInt();
                    
                    System.out.println("xxxxxxxxxxxxxxxxxxx");
                    
                    for (int i = startNum; i <= endNum; i++ ) {
                        if ((i % multipleNum) == 0) {
                            System.out.println(i);
                            count++;
                        }
                    }
                    
                                        
                    System.out.println("xxxxxxxxxxxxxxxxxxx");
                    
                    break;
                }
            default:
                break;
        }
        
        System.out.println("Total number of " + numVariant + " numbers is " + count);
        
        
    }
    
    
    
}
