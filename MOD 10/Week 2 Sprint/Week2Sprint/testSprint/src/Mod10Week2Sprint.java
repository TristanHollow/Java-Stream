
import java.sql.*;

import javax.swing.JOptionPane;


public class Mod10Week2Sprint {

    public static String databaseName = "week2sprint";
    public static String table = "learner_tbl";
    public static int recordID = 1;
    public static String person = "person";
    public static String loginPerson = "admin";
    public static int loginID = 1;
    public static String username = "";
    public static String password = "";

    public static void main(String[] args) throws Exception {
        
                //login form (JFrame)

            //as parent
                //learner_tbl
                    //search learner (automatically)
                        //if
                            //true
                                //print
                            //false
                                //showMessage: "... not found"
    
            //as teacher
               //learner_tbl
                //parent_tbl




            //as admin (latest)
                //learner_tbl
                    //search learner (option 0)
                        //if
                            //true
                                //print
                                //buttons:
                                    //update
                                    //delete
                                    //back
                            //false
                                //showMessage: "... not found"
                    //insert learner (option 1)
                //parent_tbl
                    //search parent (option 0)
                        //if
                            //true
                                //print
                                //buttons:
                                    //update
                                    //delete
                                    //back
                            //false
                                //showMessage: "... not found"

                    //insert parent (option 1)
                //teacher_tbl
                    //search teacher (option 0)
                        //if
                            //true
                                //print
                                //buttons:
                                    //update
                                    //delete
                                    //back
                            //false
                                //showMessage: "... not found"

                    //insert teacher (option 1)

        /* 
            //btnCreate
            tableCreate(); 
        */

        /*
            //btnDelete
            tableDeleteAllRecords(recordID);
        */

        /*
            //btnInsert
            tableInsertAllRecords();
        */

        /*
            //btnUpdate
            tableUpdateAllRecords();
        */
    
    
    }


    ///create TRUE

    public static void tableCreate(){

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");

            String sql = "";

            switch(table) {
                case "learner_tbl":
                    sql = "CREATE TABLE IF NOT EXISTS " + table + "(" +
                    "learner_id INT AUTO_INCREMENT NOT NULL, parent_id INT, names VARCHAR(100), last_name VARCHAR(100), date_of_birth VARCHAR(10), gender VARCHAR(10), grade INT, PRIMARY KEY(learner_id), FOREIGN KEY(parent_id) REFERENCES parent_tbl(parent_id))";
                    break;
                case "parent_tbl":
                    sql = "CREATE TABLE IF NOT EXISTS " + table + "(" +
                    "parent_id INT AUTO_INCREMENT NOT NULL, username VARCHAR(100) NOT NULL, password VARCHAR(100) NOT NULL, names VARCHAR(100), last_name VARCHAR(100), address VARCHAR(50), contact_no VARCHAR(50), num_children INT, PRIMARY KEY(parent_id), UNIQUE(username))";
                    break;
                case "teacher_tbl":
                    sql = "CREATE TABLE IF NOT EXISTS " + table + "(" +
                    "teacher_id INT AUTO_INCREMENT NOT NULL, username VARCHAR(100) NOT NULL, password VARCHAR(100) NOT NULL, names VARCHAR(100), last_name VARCHAR(100), address VARCHAR(50), contact_no VARCHAR(50), PRIMARY KEY(teacher_id), UNIQUE(username))";
                    break;
            }

            Statement stmt = conn.createStatement();
        
            stmt.executeUpdate(sql);

            conn.close();  
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("An error has occurred.");
            ex.printStackTrace();
        }

    }

    ////delete TRUE

    public static void tableDeleteRecords(){
        Connection conn = null;
        String sql = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");

            switch (table) {
                case "learner_tbl":
                    sql = "DELETE FROM learner_tbl WHERE(learner_id = " + recordID + ")";
                    break;
                case "parent_tbl":
                    sql = "DELETE FROM parent_tbl WHERE(parent_id = " + recordID + ")";
                    break;
                case "teacher_tbl":
                    sql = "DELETE FROM teacher_tbl WHERE(teacher_id = " + recordID + ")";
                    break;
            }


            Statement stmt = conn.createStatement();
    
    
            stmt.executeUpdate(sql);

            conn.close();

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }

  ///getRecordID from user

    public static int getRecordID() {
        int output = -1;
        

        try {
            String testNull = JOptionPane.showInputDialog(null, "What is the "+ person +"'s "+person+" ID?");

            if (testNull == null) {
                output = -2;
            } else if (testNull == "") {
                output = -1;
            } else {
                output = Integer.valueOf(testNull);
            }

        } catch (Exception e) {
            
           // e.printStackTrace();
        }

        return output;
    }

    public static boolean testRecord(String recordID) {
        boolean bTrue = false;
        try {
            if (0 <= Integer.valueOf(recordID)) {
                bTrue = true;
            } else {
                bTrue = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The ID is invalid.");
            e.printStackTrace();
            
        }
        
        
        return bTrue;
    }



    public static boolean isNull(String test) {
        if ((test == null) || (test != null && ("".equals(test)) )) {
            return true;
        }

        return false;
    }


    public static boolean loginSearch() {
        
        Connection conn = null;
        String sql = "";

        boolean bParent = true;
        boolean bTeacher = true;
        boolean bAdmin = true;

        

        if (bAdmin == true) {

                if (username.equals("username") && password.equals("password")) {
                    loginPerson = "admin";
                    return true;
                } else {
                    bAdmin = false;
                }

             }
            //else 
            if ((bParent == true) && (bTeacher == true) && (bAdmin == false)) {
                conn = null;
               try { 
                

                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");


                sql = "SELECT COUNT(1), parent_id FROM parent_tbl WHERE username = '"+ username + "' AND password = '" + password + "'";
                

                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(sql);

                if (result.next()) {
                    int i = result.getInt(1);
                    if (i == 1) {
                        loginPerson = "parent";
                        loginID = result.getInt("parent_id");
                        return true;
                        
                    } else {
                        bParent = false;
                    }
                }
    
                conn.close();

                } catch (Exception e) {
                    //TODO: handle exception
                    }
            } //else 
            if ((bParent == false) && (bTeacher == true) && (bAdmin == false)) {
                conn = null;
                try { 
                    
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");
 
 
                 sql = "SELECT COUNT(1), teacher_id FROM teacher_tbl WHERE(username = '"+ username + "' AND password = '" + password + "')";
                 
 
                 Statement stmt = conn.createStatement();
                 ResultSet result = stmt.executeQuery(sql);
 
                 if (result.next()) {
                     int i = result.getInt(1);
                     if (i == 1) {
                         loginPerson = "teacher";
                         loginID = result.getInt("teacher_id");
                         return true;
                         
                     } else {
                         bTeacher = false;
                     }
                 }
     
                 conn.close();
 
                 } catch (Exception e) {
                     //TODO: handle exception
                     }
             }
        
        if ((bAdmin == false) && (bParent == false) && (bTeacher == false)) {
            //JOptionPane.showMessageDialog(null, "Invalid username/password.");
        return false;
        }
        //JOptionPane.showMessageDialog(null, "Invalid username/password.");
        return false;
    
    }

    ///record exists TRUE

    public static boolean recordExists(String input){


        Boolean bExists = false;

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");

            String sql = "";


            
            if (input.equals("default")) {
                switch(table) {
                    case "learner_tbl":
                        sql = "SELECT COUNT(1) FROM learner_tbl WHERE(learner_id = "+ recordID +")";
                        
                        break;
                    case "parent_tbl":
                        sql = "SELECT COUNT(1) FROM parent_tbl WHERE(parent_id = "+ recordID +")";
                        
                        break;
                    case "teacher_tbl":
                        sql = "SELECT COUNT(1) FROM teacher_tbl WHERE(teacher_id = "+ recordID +")";
                        
                        break;
                    default:
                        return false;
                }
            }



            
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);


            if (input.equals("default")) {
            if (result.next()) {
                int i = result.getInt(1);
                if (i == 1) {
                    bExists = true;
                } else {
                    bExists = false;
                }
            }
        }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("An error has occurred.");
            ex.printStackTrace();
        }
        
        return bExists;
    }

}
