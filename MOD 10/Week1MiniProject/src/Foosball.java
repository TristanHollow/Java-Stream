import java.sql.*;
import javax.swing.JOptionPane;


public class Foosball {
    public static void main(String[] args) throws Exception {
        Connection conn = null;

        try {
            /*Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/foosball","root","root");
            String sql = "CREATE TABLE Player (" +
                "Player_Id INT PRIMARY KEY, Name VARCHAR(100), Age INT, Matches INT)";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);*/


            //int index = JOptionPane.showInputDialog(null, "What would you like to do?", );


            String[] options = {"Create the table", "Update the table", "Print out the table"};
        
            int chosenOption = JOptionPane.showOptionDialog(null, "What would you like to do? ", "Foosball",
                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            
            //String chosen = "";
            //int calcOption = 0;

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/foosball","root","root");
            String sql = "";
            Statement stmt;
            switch (chosenOption) {
                case 0:
                    //chosen = "withdraw";
                    //calcOption = -1;

                    //Class.forName("com.mysql.cj.jdbc.Driver");
                    //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/foosball","root","root");
                    sql = "CREATE TABLE Player (" +
                    "Player_Id INT PRIMARY KEY, Name VARCHAR(100), Age INT, Matches INT)";

                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql);

                    //conn.close();  
                    break;
                case 1:
                    //chosen = "deposit";
                    //calcOption = 1;

                    sql = "INSERT INTO Player(Name, Age, Matches) VALUES('"+ readInName("Bob") +"','"+ readInAge(18) +"','"+ readInMatches(2) +"')";

                    stmt = conn.createStatement();
            
            
                    stmt.executeUpdate(sql);
                    



                    
                    break;
                case 2:
                    //JOptionPane.showMessageDialog(null, "Transaction successfully cancelled.");
                    //System.exit(0);

                    sql = "SELECT * FROM Foosball";
                        
                    stmt = conn.createStatement();
                    ResultSet result = stmt.executeQuery(sql);

                    while (result.next()) {
                        int playerID = result.getInt("Player_Id");
                        String name = result.getString("Name");
                        int age = result.getInt("Age");
                        int matches = result.getInt("Matches");

                        System.out.println("Player ID: " + String.valueOf(playerID) + "\r\n Name: " + name + "\r\n Age: " + String.valueOf(age) + "\r\n Matches: " +  String.valueOf(matches) );
                    }


                    break;
                default:
                    JOptionPane.showMessageDialog(null, "An error occurred");
                    System.exit(0);
                    break;
            }
    
            
            conn.close();  
             } catch (SQLException ex) {
                System.out.println("An error has occurred.");
             }
    }


    public static String readInName(String input) {
        String name = input;
        try {
            name = JOptionPane.showInputDialog(null, "What is the player's name?");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The player's name has been set to" + input + ".");
        }

        return name;

    }

    public static int readInAge(int input) {
        int age = input;
        try {
            age = Integer.valueOf(JOptionPane.showInputDialog(null, "What is the player's age?"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The player's age has been set to" + input + ".");
        }

        return age;

    }

    public static int readInMatches(int input) {
        int matches = input;
        try {
            matches = Integer.valueOf(JOptionPane.showInputDialog(null, "How many matches has the player participated in?"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The player's age has been set to" + input + ".");
        }

        return matches;

    }

}
