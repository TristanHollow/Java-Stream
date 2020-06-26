import java.sql.*;
import java.util.Scanner;

public class learnerParentCaptured {
    public static void main(String[] args) throws Exception {
        Scanner scanIt = new Scanner(System.in);
        System.out.println("Are you a learner or a parent?");
        
        String answer = scanIt.nextLine();

        if((answer.toLowerCase()).equals("learner")){

            

            System.out.println("Would you like to 'read' from/'write' to the database?");
            
            answer = scanIt.nextLine();
            
            if (answer.toLowerCase().equals("read")) {
                learnerOutput(); 
            } else if (answer.toLowerCase().equals("write")) {
                learnerInput();
                learnerOutput(); 
            } else {
                System.out.println("Invalid input.");
            }

           
        }
        else if((answer.toLowerCase()).equals("parent")){

            System.out.println("Would you like to 'read' from/'write' to the database?");

            answer = scanIt.nextLine();

            if (answer.toLowerCase().equals("read")) {
                parentOutput(); 
            } else if (answer.toLowerCase().equals("write")) {
                parentInput();
                parentOutput(); 
            } else {
                System.out.println("Invalid input.");
            }

        }
       else{
           System.out.println("Invalid input.");
       }
       scanIt.close();
}
    public static void parentInput(){
        String databaseURL = "jdbc:ucanaccess://C:\\Users\\John\\Desktop\\Tristan Work\\Java\\Tech Training\\learnerParentCapturing\\learnerParentCapturing.accdb";
                try {
                    Connection con = DriverManager.getConnection(databaseURL);

                    Scanner scanIt = new Scanner(System.in);

                    System.out.println("Enter your Name");
                    String name = scanIt.nextLine();

                    System.out.println("Enter your Surname");
                    String surname = scanIt.nextLine();

                    System.out.println("Enter your Contact Number");
                    String contactNo = scanIt.nextLine();

                    System.out.println("Enter your Address");
                    String address = scanIt.nextLine();
                
                    System.out.println("Enter how many of your children are attending this school");
                    String numChildren = scanIt.nextLine();
            
                    scanIt.close();
            
                    String sql = "INSERT INTO Parent(Names, Surname, Address, ContactNo, NumberOfChildren) VALUES('"+ name +"','"+ surname +"','"+ address +"','"+ contactNo +"','"+ numChildren +"')";

                    Statement stmt=con.createStatement();
                
                
                    stmt.executeUpdate(sql);
            
                    con.close();
                
                } catch (SQLException e) {
                    System.out.println("An error has occurred.");
                    e.printStackTrace();
                }

            }

    public static void learnerInput(){
        String databaseURL = "jdbc:ucanaccess://C:\\Users\\John\\Desktop\\Tristan Work\\Java\\Tech Training\\learnerParentCapturing\\learnerParentCapturing.accdb";
                try {
                    Connection con = DriverManager.getConnection(databaseURL);

                    Scanner scanIt = new Scanner(System.in);

                    System.out.println("Enter your Name");
                    String name = scanIt.nextLine();

                    System.out.println("Enter your Surname");
                    String surname = scanIt.nextLine();
            
                    System.out.println("Enter your Date of Birth");
                    String dob = scanIt.nextLine();
            
                    System.out.println("Enter your Gender");
                    String gender = scanIt.nextLine();
            
                    System.out.println("Enter your Grade");
                    String grade = scanIt.nextLine();
        
                    scanIt.close();
           
                    String sql = "INSERT INTO Learner(Names, Surname, DateOfBirth, Gender, Grade) VALUES('"+ name +"','"+ surname +"','"+ dob +"','"+ gender +"','"+ grade +"')";

                    Statement stmt=con.createStatement();
            
            
                    stmt.executeUpdate(sql);
        
                    con.close();
             
                } catch (SQLException e) {
                    System.out.println("An error has occurred.");
                    e.printStackTrace();
                }

            }

    public static void parentOutput(){
        String databaseURL = "jdbc:ucanaccess://C:\\Users\\John\\Desktop\\Tristan Work\\Java\\Tech Training\\learnerParentCapturing\\learnerParentCapturing.accdb";
                try {
                   Connection con = DriverManager.getConnection(databaseURL);
       
                   String sql;
       
                   sql = "SELECT * FROM Parent";
                    
                   Statement statement = con.createStatement();
                   ResultSet result = statement.executeQuery(sql);
                    
                    while (result.next()) {
                       String name = result.getString("Names");
                       String surname = result.getString("Surname");
                       String contactNo = result.getString("ContactNo");
                       String address = result.getString("Address");
                       String numChildren = result.getString("NumberOfChildren");
                        
                       System.out.println(" Parent Name: " + name + "\r\n Parent Surname: " + surname + "\r\n Contact Number: " + contactNo + "\r\n Address: " + address + "\r\n Number of Children Enrolled: " + numChildren + "\r\n");
                    }
                    con.close();
                } catch (SQLException e) {
                   System.out.println("An error has occurred.");
                   e.printStackTrace();
                }
       
       
            } 

    public static void learnerOutput(){
        String databaseURL = "jdbc:ucanaccess://C:\\Users\\John\\Desktop\\Tristan Work\\Java\\Tech Training\\learnerParentCapturing\\learnerParentCapturing.accdb";
                try {
                    Connection con = DriverManager.getConnection(databaseURL);

                    String sql;

                    sql = "SELECT * FROM Learner";
             
                    Statement statement = con.createStatement();
                    ResultSet result = statement.executeQuery(sql);
             
                    while (result.next()) {
                        String name = result.getString("Names");
                        String surname = result.getString("Surname");
                        String dateOfBirth = result.getString("DateOfBirth");
                        String gender = result.getString("Gender");
                        String grade = result.getString("Grade");
                 
                        System.out.println(" Student Name: " + name + "\r\n" + " Student Surname: " + surname + "\r\n" + " Date of Birth: " + 
                        dateOfBirth + "\r\n" + " Gender: " + gender + "\r\n" + " Grade: " + grade + "\r\n");
                    }
                    con.close();
                } catch (SQLException e) {
                    System.out.println("An has error occurred.");
                    e.printStackTrace();
                }


            } 



}
