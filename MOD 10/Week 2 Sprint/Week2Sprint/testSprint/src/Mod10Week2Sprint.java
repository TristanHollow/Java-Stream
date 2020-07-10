/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
*/
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




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

    ////insert TRUE
/*
    public static void tableInsertRecords(){
        Connection conn = null;

        String sql = "";
            //learner + parent
            String names = "";
            String surname = "";
            //parent
            String userName = "";
            String passWord = "";
            String address = "";
            String contactNo = "";
            int numChildren = 0;
            //learner
            String dob = "";
            String gender = "";
            int grade = 0;
            int parentID = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");


            switch (table) {
                case "learner_tbl":

                parentID = 0;

                if (isNull(String.valueOf(parentID)) == true) {
                    return;
                }

                names = "";//readInNames("learner");

                if (isNull(names) == true) {
                    return;
                }

                surname = "";//readInSurname("learner");

                if (isNull(surname) == true) {
                    return;
                }

                dob = "";//readInBirthdate();

                if (isNull(dob) == true) {
                    return;
                }

                gender = "";//readInGender();

                if (isNull(gender) == true) {
                    return;
                }

                grade = 0;//readInGrade();

                if (isNull(String.valueOf(grade)) == true) {
                    return;
                }

                sql = "INSERT INTO learner_tbl( parent_id, names, last_name, date_of_birth, gender, grade ) VALUES('" + parentID +
                "','" + names +
                "','"+ surname +"','"+ dob +"','"+ gender +"','"+ grade +"')";

                    break;
                case "parent_tbl":

                    userName = "";

                    if (isNull(userName) == true) {
                        return;
                    }

                    passWord = "";

                    if (isNull(passWord) == true) {
                        return;
                    }

                    names = "";//readInNames("parent");

                    if (isNull(names) == true) {
                        return;
                    }

                    surname = "";//readInSurname("parent");

                    if (isNull(surname) == true) {
                        return;
                    }

                    address = "";//readInAddress();

                    if (isNull(address) == true) {
                        return;
                    }

                    contactNo = "";//readInContactNo();

                    if (isNull(contactNo) == true) {
                        return;
                    }

                    numChildren = 0;//readInNumChildren();

                    if (isNull(String.valueOf(numChildren)) == true) {
                        return;
                    }
                    
                    sql = "INSERT INTO parent_tbl(names, last_name, address, contact_no, num_children, username, password) VALUES('"+ names +
                    "','"+ surname +"','"+ address +"','"+ contactNo +"','"+ numChildren +"','"+ userName +"','"+ passWord +"')";    

                    break;
                case "teacher_tbl":

                    username = "";

                    if (isNull(username) == true) {
                        return;
                    }

                    password = "";

                    if (isNull(password) == true) {
                        return;
                    }

                    sql = "INSERT INTO teacher_tbl(username, password) VALUES('"+ username +
                    "','"+ password +"')";    

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

  */  ///getRecordID from user

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


    ///update TRUE 

/*
    public static void tableUpdateRecords(){
        Connection conn = null;

        String sql = "";
            //learner + parent
            String names = "";
            String surname = "";
            //parent
            String username = "";
            String password = "";
            String address = "";
            String contactNo = "";
            int numChildren = 0;
            //learner
            String dob = "";
            String gender = "";
            int grade = 0;
            int parentID = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");


            switch (table) {
                case "learner_tbl":

                parentID = 0;

                if (isNull(String.valueOf(parentID)) == true) {
                    return;
                }

                names = "";//readInNames("learner");

                if (isNull(names) == true) {
                    return;
                }

                surname = "";//readInSurname("learner");

                if (isNull(surname) == true) {
                    return;
                }

                dob = "";//readInBirthdate();

                if (isNull(dob) == true) {
                    return;
                }

                gender = "";//readInGender();

                if (isNull(gender) == true) {
                    return;
                }

                grade = 0;//readInGrade();

                if (isNull(String.valueOf(grade)) == true) {
                    return;
                }

                

                    sql = "UPDATE learner_tbl SET " + 
                    "parent_id = " + parentID + ", names = " + names + ", " + 
                    "last_name = " + surname + ", date_of_birth = " + dob + ", " + 
                    "gender = " + gender + ", grade = " + grade + " WHERE learner_id = " + recordID;
                

                    break;
                case "parent_tbl":

                    username = "";

                    if (isNull(username) == true) {
                        return;
                    }

                    password = "";

                    if (isNull(password) == true) {
                        return;
                    }

                    names = "";//readInNames("parent");

                    if (isNull(names) == true) {
                        return;
                    }

                    surname = "";//readInSurname("parent");

                    if (isNull(surname) == true) {
                        return;
                    }

                    address = "";//readInAddress();

                    if (isNull(address) == true) {
                        return;
                    }

                    contactNo = "";//readInContactNo();

                    if (isNull(contactNo) == true) {
                        return;
                    }

                    numChildren = 0;//readInNumChildren();

                    if (isNull(String.valueOf(numChildren)) == true) {
                        return;
                    }
                    

                    sql = "UPDATE learner_tbl SET " + 
                    "names = " + names + ", " + 
                    "last_name = " + surname + ", address = " + address + ", " + 
                    "contact_no = " + contactNo + ", num_children = " + numChildren + " WHERE parent_id = " + recordID;

                    break;
                case "teacher_tbl":

                    username = "";

                    if (isNull(username) == true) {
                        return;
                    }

                    password = "";

                    if (isNull(password) == true) {
                        return;
                    }

                    
                    sql = "UPDATE learner_tbl SET " + 
                    "username = " + username + ", " + 
                    "password = " + password + " WHERE teacher_id = " + recordID;

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

*/
    ///login TRUE

    /*public static void loginForm(String userName, String passWord){

        username = userName;
        password = passWord;
        

            if (recordExists("login") == true) {
                
                //go to next page
                //LoginForm.setVisible(False)

             OptionFrame options = new OptionFrame();
             options.setVisible(true);
            
            } else if (recordExists("login") == false) {
                JOptionPane.showMessageDialog(null, "Login Failed \r\n Username/password invalid.");
            }
         

    }*/
            


    ///print TRUE
/*
    public static void tablePrintRecords(String input){
        
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");
            String sql = "";

            /*if (table.equals("learner_tbl")) {
                if (input.equals("all")) {
                    sql = "SELECT * FROM learner_tbl";
                } else if (testRecord(input) == true) {
                    sql = "SELECT * FROM learner_tbl  WHERE(learner_id = "+ Integer.valueOf(input)+")";
                }
            } else if (table.equals("parent_tbl")) {
                if (input.equals("all")) {
                    sql = "SELECT * FROM parent_tbl";
                } else if (testRecord(input) == true) {
                    sql = "SELECT * FROM parent_tbl  WHERE(parent_id = " + Integer.valueOf(input)+")";
                }
            }*/





            //latest version

/*
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            JFrame jf = new JFrame();
            JPanel panel = new JPanel();
            JTable jt = new JTable();

            DefaultTableModel model = new DefaultTableModel(new String[]{"Learner ID", "Parent ID", "Name", "Surname", "Date of Birth", "Gender", "Grade"}, 0);

            if (input.equals("default")) { //login and table change
            
                if (table.equals("learner_tbl")) {

                    model = new DefaultTableModel(new String[]{"Learner ID", "Parent ID", "Name", "Surname", "Date of Birth", "Gender", "Grade"}, 0);

                    if (loginPerson.equals("parent")) {
                        sql = "SELECT learner_id, parent_id, names, last_name, date_of_birth, gender, grade FROM learner_tbl " + 
                        "WHERE(parent_id = " + loginID+")";
                    } else if (loginPerson.equals("teacher")) {
                        sql = "SELECT * FROM learner_tbl";
                    } else if (loginPerson.equals("admin")) {
                        sql = "SELECT * FROM learner_tbl";
                    }

                    while(result.next()) {

                        String learnerID = String.valueOf(result.getInt("learner_id"));
                        String parentID = String.valueOf(result.getInt("parent_id"));
                        String name = result.getString("names");
                        String surname = result.getString("last_name");
                        String birthdate = result.getString("date_of_birth");
                        String gender = result.getString("gender");
                        String grade = String.valueOf(result.getInt("grade"));
                
                        model.addRow(new Object[]{learnerID, parentID, name, surname, birthdate, gender, grade});
                    }

                } else if (table.equals("parent_tbl")) {

                    

                    if (loginPerson.equals("teacher")) {
                        
                        model = new DefaultTableModel(new String[]{"Parent ID", "Name", "Surname", "Address", "Contact No", "Number of Children"}, 0);
                        
                        sql = "SELECT  FROM parent_tbl";

                        while (result.next()) {
                            String parentID = String.valueOf(result.getInt("parent_id"));
                            String name = result.getString("names");
                            String surname = result.getString("last_name");
                            String address = result.getString("address");
                            String contactNo = result.getString("contact_no");
                            String numChildren = String.valueOf(result.getInt("num_children"));

                            model.addRow(new Object[]{parentID, name, surname, address, contactNo, numChildren});
                        }


                    } else if (loginPerson.equals("admin")) {
                        model = new DefaultTableModel(new String[]{"Parent ID", "Name", "Surname", "Address", "Contact No", "Number of Children", "Username", "Password"}, 0);

                        sql = "SELECT * FROM parent_tbl";

                        while (result.next()) {
                            String parentID = String.valueOf(result.getInt("parent_id"));
                            String name = result.getString("names");
                            String surname = result.getString("last_name");
                            String address = result.getString("address");
                            String contactNo = result.getString("contact_no");
                            String numChildren = String.valueOf(result.getInt("num_children"));
                            String usernameModel = result.getString("username");
                            String passwordModel = result.getString("password");

                            model.addRow(new Object[]{parentID, name, surname, address, contactNo, numChildren, usernameModel, passwordModel});
                        }
                    }

                    

                } else if (table.equals("teacher_tbl")) {
                    if (loginPerson.equals("admin")) {

                        model = new DefaultTableModel(new String[]{"Teacher ID", "Username", "Password"}, 0);

                        sql = "SELECT * FROM teacher_tbl";

                        while (result.next()) {
                            String teacherID = String.valueOf(result.getInt("parent_id"));
                            String usernameModel = result.getString("username");
                            String passwordModel = result.getString("password");

                            model.addRow(new Object[]{teacherID, usernameModel, passwordModel});
                        }
                    }
                }

            } else if (input.equals("search")) { //search button

                if (testRecord(String.valueOf( getRecordID() )) == true) {
                    if (recordExists("default") == true) {

                        if (table.equals("learner_tbl")) {
                            model = new DefaultTableModel(new String[]{"Learner ID", "Parent ID", "Name", "Surname", "Date of Birth", "Gender", "Grade"}, 0);

                            if (loginPerson.equals("parent")) {
                                sql = "SELECT learner_id, parent_id, names, last_name, date_of_birth, gender, grade FROM learner_tbl " + 
                                "WHERE(parent_id = " + loginID+")";
                            } else if (loginPerson.equals("teacher")) {
                                sql = "SELECT * FROM learner_tbl";
                            } else if (loginPerson.equals("admin")) {
                                sql = "SELECT * FROM learner_tbl";
                            }
        
                            if(result.next()) {
        
                                String learnerID = String.valueOf(result.getInt("learner_id"));
                                String parentID = String.valueOf(result.getInt("parent_id"));
                                String name = result.getString("names");
                                String surname = result.getString("last_name");
                                String birthdate = result.getString("date_of_birth");
                                String gender = result.getString("gender");
                                String grade = String.valueOf(result.getInt("grade"));
                        
                                model.addRow(new Object[]{learnerID, parentID, name, surname, birthdate, gender, grade});
                            }
                                                
                        } else if (table.equals("parent_tbl")) {
                            
                            if (loginPerson.equals("teacher")) {
                        
                                model = new DefaultTableModel(new String[]{"Parent ID", "Name", "Surname", "Address", "Contact No", "Number of Children"}, 0);
                                
                                sql = "SELECT  FROM parent_tbl";
        
                                if (result.next()) {
                                    String parentID = String.valueOf(result.getInt("parent_id"));
                                    String name = result.getString("names");
                                    String surname = result.getString("last_name");
                                    String address = result.getString("address");
                                    String contactNo = result.getString("contact_no");
                                    String numChildren = String.valueOf(result.getInt("num_children"));
        
                                    model.addRow(new Object[]{parentID, name, surname, address, contactNo, numChildren});
                                }
        
        
                            } else if (loginPerson.equals("admin")) {
                                model = new DefaultTableModel(new String[]{"Parent ID", "Name", "Surname", "Address", "Contact No", "Number of Children", "Username", "Password"}, 0);
        
                                sql = "SELECT * FROM parent_tbl";
        
                                if (result.next()) {
                                    String parentID = String.valueOf(result.getInt("parent_id"));
                                    String name = result.getString("names");
                                    String surname = result.getString("last_name");
                                    String address = result.getString("address");
                                    String contactNo = result.getString("contact_no");
                                    String numChildren = String.valueOf(result.getInt("num_children"));
                                    String usernameModel = result.getString("username");
                                    String passwordModel = result.getString("password");
        
                                    model.addRow(new Object[]{parentID, name, surname, address, contactNo, numChildren, usernameModel, passwordModel});
                                }
                            }

                        } else if (table.equals("teacher_tbl")) {
                            if (loginPerson.equals("admin")) {

                                model = new DefaultTableModel(new String[]{"Teacher ID", "Username", "Password"}, 0);
        
                                sql = "SELECT * FROM teacher_tbl";
        
                                if (result.next()) {
                                    String teacherID = String.valueOf(result.getInt("parent_id"));
                                    String usernameModel = result.getString("username");
                                    String passwordModel = result.getString("password");
        
                                    model.addRow(new Object[]{teacherID, usernameModel, passwordModel});
                                }
                            
                            }
                        }


                    } else {
                        /////////////sss
                    }
                    
                } 

            }
*/
            //////////////////////////////////////////////////////
            /*
                        
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            JFrame jf = new JFrame();
            JPanel panel = new JPanel();
            JTable jt = new JTable();

            DefaultTableModel model = new DefaultTableModel(new String[]{"Learner ID", "Name", "Surname", "Date of Birth", "Gender", "Grade"}, 0);;

            if (table.equals("learner_tbl")) {

                model = new DefaultTableModel(new String[]{"Learner ID", "Name", "Surname", "Date of Birth", "Gender", "Grade"}, 0);

                if (input.equals("all")) {
                    
                    while(result.next()) {

                        int learnerID = result.getInt("learner_id");
                        int parentID = result.getInt("parent_id");
                        String name = result.getString("names");
                        String surname = result.getString("last_name");
                        String birthdate = result.getString("date_of_birth");
                        String gender = result.getString("gender");
                        String grade = String.valueOf(result.getInt("grade"));
                
                        model.addRow(new Object[]{learnerID, name, surname, birthdate, gender, grade});
                    }


            } else if (testRecord(input) == true) {

                if (result.next()) {
                    int learnerID = result.getInt("learner_id");
                    String name = result.getString("names");
                    String surname = result.getString("last_name");
                    String birthdate = result.getString("date_of_birth");
                    String gender = result.getString("gender");
                    String grade = String.valueOf(result.getInt("grade"));

                    model.addRow(new Object[]{learnerID, name, surname, birthdate, gender, grade});
                }

                
            }

            } else if (table.equals("parent_tbl")) {

                model = new DefaultTableModel(new String[]{"Parent ID", "Name", "Surname", "Address", "Contact No", "Number of Children"}, 0);

                if (input.equals("all")) {
            
                    while (result.next()) {
                        int parentID = result.getInt("parent_id");
                        String name = result.getString("names");
                        String surname = result.getString("last_name");
                        String address = result.getString("address");
                        String contactNo = result.getString("contact_no");
                        String numChildren = String.valueOf(result.getInt("num_children"));

                        model.addRow(new Object[]{parentID, name, surname, address, contactNo, numChildren});
                    }
            } else if (testRecord(input) == true) {
                
                if (result.next()) {
                    int parentID = result.getInt("parent_id");
                    String name = result.getString("names");
                    String surname = result.getString("last_name");
                    String address = result.getString("address");
                    String contactNo = result.getString("contact_no");
                    String numChildren = String.valueOf(result.getInt("num_children"));

                    model.addRow(new Object[]{parentID, name, surname, address, contactNo, numChildren});
                }
            }
            }*/


            /////////////////////////////////////////
                 //   OptionFrame.tblOutput.setModel(model);
                    
                    /*JScrollPane jscroll = new JScrollPane(jt);
                    
                    panel.add(jscroll);
                    jscroll.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    jscroll.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    //panel.add(jscroll);
                    jf.add(panel);
                    jf.setSize(500, 500);
                    jf.setVisible(true);*/

/*
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("An error has occurred.");
            ex.printStackTrace();
            return;
        }
            
    }

*/
    ///JTabel output

    /*private static void aidanTestRun() {
        Connection conn = null;
        String databaseName = "testschool";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");
            String sql = "SELECT parent_name, learner_id, learner_name " + 
            "FROM testschool.parent_tbl " +
            "INNER JOIN learner_tbl ON parent_tbl.parent_id = learner_tbl.parent_id";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            DefaultTableModel model = new DefaultTableModel(new String[]{"Learner Name", "Parent Name", "LearnerId"}, 0);
            while(result.next())
            {
                String d = result.getString("parent_name");
                String e = result.getString("learner_name");
                //String f = result.getString("parent_id");
                String g = String.valueOf(result.getInt("learner_id"));
                model.addRow(new Object[]{d, e, g});
            }
            JFrame jf = new JFrame();
            JPanel panel = new JPanel();
            JTable table = new JTable();
            table.setModel(model);
            //table.setSize(300, 300);
            JScrollPane jscroll = new JScrollPane(table);
            //panel.setSize(300, 300);
           panel.add(jscroll);
            jscroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            jscroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            //panel.add(jscroll);
            jf.add(panel);
            jf.setSize(300, 300);
            jf.setVisible(true);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }*/

    ///isNull()

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

        //int searchCount = 0;

        if (bAdmin == true) {

                if (username.equals("username") && password.equals("password")) {
                    loginPerson = "admin";
                    return true;
                } else {
                    bAdmin = false;
                }

             }
            else if ((bParent == true) && (bTeacher == true) && (bAdmin == false)) {
                conn = null;
               try { 
                

                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");


                sql = "SELECT COUNT(1) FROM parent_tbl WHERE(username = "+ username + " AND password = " + password + ")";
                

                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(sql);

                if (result.next()) {
                    int i = result.getInt(1);
                    if (i == 1) {
                        loginPerson = "parent";
                        return true;
                        
                    } else {
                        bParent = false;
                    }
                }
    
                conn.close();

                } catch (Exception e) {
                    //TODO: handle exception
                    }
            } else if ((bParent == false) && (bTeacher == true) && (bAdmin == false)) {
                conn = null;
                try { 
                    
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");
 
 
                 sql = "SELECT COUNT(1) FROM teacher_tbl WHERE(username = "+ username + " AND password = " + password + ")";
                 
 
                 Statement stmt = conn.createStatement();
                 ResultSet result = stmt.executeQuery(sql);
 
                 if (result.next()) {
                     int i = result.getInt(1);
                     if (i == 1) {
                         loginPerson = "teacher";
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

        /*if (isNull(String.valueOf(input)) == true) {
            return false;
        }*/

        Boolean bExists = false;

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");

            String sql = "";

            if (input.equals("login")) {
                if ((loginSearch() == true) && (loginPerson.equals("parent"))) {
                    sql = "SELECT parent_id FROM parent_tbl WHERE(username = "+ username + " AND password = " + password + ")";
                } else if ((loginSearch() == true) && (loginPerson.equals("teacher"))) {
                    sql = "SELECT teacher_id FROM teacher_tbl WHERE(username = "+ username + " AND password = " + password + ")";
                }  else if ((loginSearch() == true) && (loginPerson.equals("admin"))) {
                    conn.close();
                    return true;
                }
                else {
                    //JOptionPane.showMessageDialog(null, "Invalid username/password.");
                    return false;
                }

            }

/*
    add short method to iterate through tables when calles by recordExists("login")

*/


                /*(table) {
                    
                    case "parent_tbl":
                        sql = "SELECT parent_id, COUNT(1) AS Found FROM parent_tbl WHERE(username = "+ username + ", password = " + password + ")";
                        loginPerson = "parent";
                        
                        break;
                    case "teacher_tbl":
                        sql = "SELECT teacher_id, COUNT(1) AS Found FROM teacher_tbl WHERE(username = "+ username + ", password = " + password + ")";
                        loginPerson = "teacher";
                        
                        break;
                    default:
                        return false;
                }

            }*//*else if (input.equals("loginPerson")) {

                switch(table) {
                    
                    case "parent_tbl":
                        sql = "SELECT parent_id, parent_id FROM parent_tbl WHERE(username = "+ username + ", password = " + password + ")";
                        loginPerson = "parent";
                        
                        break;
                    case "teacher_tbl":
                        sql = "SELECT teacher_id FROM teacher_tbl WHERE(username = "+ username + ", password = " + password + ")";
                        loginPerson = "teacher";
                        
                        break;
                    default:
                        return false;
                }

            }*/else if (input.equals("default")) {
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

            /*switch(table) {
                case "learner_tbl":
                    sql = "SELECT COUNT(1) FROM learner_tbl WHERE(learner_id = "+ Integer.valueOf(input)+")";
                    /*loginAs = "parent";
                    loginID = Integer.valueOf(input);*/
                    /*break;
                case "parent_tbl":
                    sql = "SELECT COUNT(1) FROM parent_tbl WHERE(parent_id = "+ Integer.valueOf(input)+")";
                    loginPerson = "parent";
                    loginID = Integer.valueOf(input);
                    break;
                case "teacher_tbl":
                    sql = "SELECT COUNT(1) FROM parent_tbl WHERE(teacher_id = "+ Integer.valueOf(input)+")";
                    loginPerson = "teacher";
                    loginID = Integer.valueOf(input);
                    break;
                default:
                    return false;
            }*/



            
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);


            if (input.equals("login")) {
            switch (loginPerson) {
                case "parent":
                    loginID = result.getInt("parent_id");
                    bExists = true;
                    break;
                case "teacher":
                    loginID = result.getInt("teacher_id");
                    bExists = true;
                    break;
                case "admin":
                    bExists = true;
                    break;
                }
            } 
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
