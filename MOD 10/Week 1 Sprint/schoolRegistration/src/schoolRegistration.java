
import java.sql.*;
import javax.swing.JOptionPane;

public class schoolRegistration {
    public static void main(String[] args) {

        String databaseName = "tristan";
        
        
        boolean bAccess = true;

        bb:

        while (bAccess == true) {

        String[] optionsNormal = {"Search", "Print", "Admin features", "Exit"};
        
        int chosenNormalOption = JOptionPane.showOptionDialog(null, "What would you like to do?", "Mzamomtsha School Registration",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsNormal, optionsNormal[0]);

        switch (chosenNormalOption) {
            case 0:
                //search
                    //learner table
                    //parent table

                    String[] optionsNormalSearch = {"Learner Table", "Parent Table", "Cancel"};
            
                    int chosenNormalSearchOption = JOptionPane.showOptionDialog(null, "Which table would you like to access?", "Mzamomtsha School Registration",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsNormalSearch, optionsNormalSearch[0]);

                    switch (chosenNormalSearchOption) {
                        case 0:

                        //learner

                        int learnerID = getRecordID("learner");
    
                        if (recordExists(learnerID, databaseName, "learner_tbl") == true) {

                            String[] optionsNormalDo = {"YES", "NO"};
                            
                            JOptionPane.showMessageDialog(null, "The learner exists!");

                            int chosenOptionsNormalDo = JOptionPane.showOptionDialog(null, "Would you like to print out the learner's record?", "Mzamomtsha School Registration",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsNormalDo, optionsNormalDo[0]);
        
                            switch (chosenOptionsNormalDo) {
                                case 0:
                                    tablePrintAllRecords(String.valueOf(learnerID), databaseName, "learner_tbl");
                                    break;
                                case 1:
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "An error has occurred.");
                                    System.exit(0);
                            }   

                        } else {
                            JOptionPane.showMessageDialog(null, "The learner could not be found.");
                        }

                            break;
                        case 1:

                        //parent

                        int parentID = getRecordID("parent");
    
                        if (recordExists(parentID, databaseName, "parent_tbl") == true) {

                            String[] optionsNormalDo = {"YES", "NO"};
                            
                            JOptionPane.showMessageDialog(null, "The parent exists!");

                            int chosenOptionsNormalDo = JOptionPane.showOptionDialog(null, "Would you like to print out the parent's record?", "Mzamomtsha School Registration",
                                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsNormalDo, optionsNormalDo[0]);
        
                            switch (chosenOptionsNormalDo) {
                                case 0:
                                    tablePrintAllRecords(String.valueOf(parentID), databaseName, "parent_tbl");
                                    break;
                                case 1:
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "An error has occurred.");
                                    System.exit(0);
                            }   

                        } else {
                            JOptionPane.showMessageDialog(null, "The parent could not be found.");
                        }

                            break;
                        case 2:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "An error has occurred.");
                            System.exit(0);
                    }

                continue;
            case 1:
                //print
                    //learner table
                    //parent table

                    String[] optionsNormalPrint = {"Learner Table", "Parent Table", "Cancel"};
            
                    int chosenNormalPrintOption = JOptionPane.showOptionDialog(null, "Which table would you like to access?", "Mzamomtsha School Registration",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsNormalPrint, optionsNormalPrint[0]);

                    switch (chosenNormalPrintOption) {
                        case 0:
                            tablePrintAllRecords("all", databaseName, "learner_tbl");
                            break;
                        case 1:
                            tablePrintAllRecords("all", databaseName, "parent_tbl");
                            break;
                        case 2:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "An error has occurred.");
                            System.exit(0);
                    }

                continue;
            case 2:
                //admin method
                adminFeatures(databaseName);
                continue bb;
            case 3:
                bAccess = false;
                continue;
            default:   
                //default
                JOptionPane.showMessageDialog(null, "An error has occurred.");
                System.exit(0);
        }
        
    }
    JOptionPane.showMessageDialog(null, "Program successfully terminated.");
    System.exit(0);


    }

    // username & password function => for Admins

    public static boolean testAdmin(String input) {

        String testIt = "";

        switch (input) {
            case "username":
                testIt = "userName";
                break;
            case "password":
                testIt = "passWord";
                break;
            default:
                System.out.println("Undeclared value");
                System.exit(0);

        }


        String scanned = "";

        try {
 
            scanned = JOptionPane.showInputDialog(null, "What is your "+ input +"?");
            if (testIt.equals(scanned)) {

                return true;
            } else {
                
                return false;
            }


        } catch (Exception e) {
            System.out.println("Invalid " + input + ".");
            e.printStackTrace();
        }

        return false;
    }

    // Admins can insert records (INSERT INTO, DELETE)

    public static void tableCreate(String input, String databaseName){

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");

            String sql = "";

            switch(input) {
                case "learner_tbl":
                    sql = "CREATE TABLE " + input + "(" +
                    "learner_id INT AUTO_INCREMENT NOT NULL, names VARCHAR(100), last_name VARCHAR(100), date_of_birth VARCHAR(10), gender VARCHAR(10), grade INT, PRIMARY KEY(learner_id))";
                    break;
                case "parent_tbl":
                    sql = "CREATE TABLE " + input + "(" +
                    "parent_id INT AUTO_INCREMENT NOT NULL, names VARCHAR(100), last_name VARCHAR(100), address VARCHAR(50), contact_no VARCHAR(50), num_children INT, PRIMARY KEY(parent_id))";
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

    public static void tableInsert(String input, String databaseName, String table, String recordID){

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");

            String sql = "";

            if (table.equals("learner_tbl")) {

            switch (input) {
                case "insert":
                    sql = "INSERT INTO learner_tbl(names, last_name, date_of_birth, gender, grade) VALUES('"+ readInNames("learner") +
                    "','"+ readInSurname("learner") +"','"+ readInBirthdate() +"','"+ readInGender() +"','"+ readInGrade() +"')";
                    
                    break;
              
                case "delete":
                    sql = "DELETE FROM learner_tbl WHERE(learner_id = " + recordID + ")"; //delete
                    break;
            }
            } else if (table.equals("parent_tbl")) {
                switch (input) {
                    case "insert":
                        sql = "INSERT INTO parent_tbl(names, last_name, address, contact_no, num_children) VALUES('"+ readInNames("parent") +
                        "','"+ readInSurname("parent") +"','"+ readInAddress() +"','"+ readInContactNo() +"','"+ readInNumChildren() +"')";
                        
                        break;
                   
                    case "delete":
                        sql = "DELETE FROM parent_tbl WHERE(parent_id = " + recordID + ")"; //delete
                        break;
                }
            }


            Statement stmt = conn.createStatement();
    
    
            stmt.executeUpdate(sql);
        

            conn.close();  
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("An error has occurred.");
            ex.printStackTrace();
        }
    }


    public static String readInNames(String person) {
        String name = "";
        try {
            name = JOptionPane.showInputDialog(null, "What is the "+ person +"'s name?");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The "+ person +"'s name is invalid.");
            e.printStackTrace();
        }

        return name;

    }
    
    public static String readInSurname(String person) {
        String surname = "";
        try {
            surname = JOptionPane.showInputDialog(null, "What is the "+ person +"'s surname?");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The "+ person +"'s surname is invalid.");
            e.printStackTrace();
        }

        return surname;

    }

    public static String readInBirthdate() {


        String dob = "";
        String dD = "";
        String mM = "";
        String yYYY = "";

        try {
            dD = JOptionPane.showInputDialog(null, "What day was the learner born?");

            switch (dD) {
                case "1":
                    dD = "01";
                    break;
                case "2":
                    dD = "02";
                    break;
                case "3":
                    dD = "03";
                    break;
                case "4":
                    dD = "04";
                    break;
                case "5":
                    dD = "05";
                    break;
                case "6":
                    dD = "06";
                    break;
                case "7":
                    dD = "07";
                    break;
                case "8":
                    dD = "08";
                    break;
                case "9":
                    dD = "09";
                    break;
            }

            mM = JOptionPane.showInputDialog(null, "What month was the learner born?");

            switch (mM.toLowerCase()) {
                case "1":
                    mM = "01";
                    break;
                case "2":
                    mM = "02";
                    break;
                case "3":
                    mM = "03";
                    break;
                case "4":
                    mM = "04";
                    break;
                case "5":
                    mM = "05";
                    break;
                case "6":
                    mM = "06";
                    break;
                case "7":
                    mM = "07";
                    break;
                case "8":
                    mM = "08";
                    break;
                case "9":
                    mM = "09";
                    break;
                case "10":
                    mM = "10";
                    break;
                case "11":
                    mM = "11";
                    break;
                case "12":
                    mM = "12";
                    break;

                case "january":
                    mM = "01";
                    break;
                case "february":
                    mM = "02";
                    break;
                case "martch":
                    mM = "03";
                    break;
                case "april":
                    mM = "04";
                    break;
                case "may":
                    mM = "05";
                    break;
                case "june":
                    mM = "06";
                    break;
                case "july":
                    mM = "07";
                    break;
                case "august":
                    mM = "08";
                    break;
                case "september":
                    mM = "09";
                    break;
                case "october":
                    mM = "10";
                    break;
                case "november":
                    mM = "11";
                    break;
                case "december":
                    mM = "12";
                    break;
            }

            yYYY = JOptionPane.showInputDialog(null, "What year was the learner born?");

            dob = dD + "/" + mM + "/" + yYYY;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The learner's date-of-birth is invalid.");
            e.printStackTrace();

        }

        return dob;

    }

    public static String readInGender() {
        String gender = "";
        try {
            gender = JOptionPane.showInputDialog(null, "What is the learner's gender?");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The learner's gender is invalid.");
            e.printStackTrace();
        }

        return gender;

    }

    public static String readInAddress() {
        String address = "";
        try {
            address = JOptionPane.showInputDialog(null, "What is the parent's address?");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The parent's address is invalid.");
            e.printStackTrace();
        }

        return address;

    }

    public static String readInContactNo() {
        String contactNo = "";
        try {
            contactNo = JOptionPane.showInputDialog(null, "What is the parent's contact number?");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The parent's contact number is invalid.");
            e.printStackTrace();
        }

        return contactNo;

    }

    public static int readInGrade() {
        int grade = 0;
        try {
            grade = Integer.valueOf(JOptionPane.showInputDialog(null, "What is the learner's current grade?"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The learner's grade is invalid.");
            e.printStackTrace();
        }

        return grade;

    }

    public static int readInNumChildren() {
        int numChildren = 0;
        try {
            numChildren = Integer.valueOf(JOptionPane.showInputDialog(null, "What is the parent's number of children?"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The parent's number of children is invalid.");
            e.printStackTrace();
        }

        return numChildren;

    }

    public static int getRecordID(String person) {
        int output = 0;
        try {
            output = Integer.valueOf(JOptionPane.showInputDialog(null, "What is the "+ person +"'s "+person+" ID?"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The "+ person +"'s "+person+" ID is invalid.");
            e.printStackTrace();
            System.exit(0);
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
            System.exit(0);
        }
        
        
        return bTrue;
    }


    public static void tablePrintAllRecords(String recordID, String databaseName, String table){
        
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");
            String sql = "";

            if (table.equals("learner_tbl")) {
                if (recordID.equals("all")) {
                    sql = "SELECT * FROM learner_tbl";
                } else if (testRecord(recordID) == true) {
                    sql = "SELECT * FROM learner_tbl  WHERE(learner_id = "+ Integer.valueOf(recordID)+")";
                }
            } else if (table.equals("parent_tbl")) {
                if (recordID.equals("all")) {
                    sql = "SELECT * FROM parent_tbl";
                } else if (testRecord(recordID) == true) {
                    sql = "SELECT * FROM parent_tbl  WHERE(parent_id = " + Integer.valueOf(recordID)+")";
                }
            }

                        
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            if (table.equals("learner_tbl")) {

                if (recordID.equals("all")) {
                
                    while (result.next()) {
                        int learnerID = result.getInt("learner_id");
                        String name = result.getString("names");
                        String surname = result.getString("last_name");
                        String birthdate = result.getString("date_of_birth");
                        String gender = result.getString("gender");
                        String grade = String.valueOf(result.getInt("grade"));

                        System.out.println(" Learner ID: " + learnerID + "\r\n Full Name: " + name + " " + surname + "\r\n Date Of Birth: " + birthdate + "\r\n Gender: " + gender + "\r\n Grade: " + grade);
                        System.out.println("");
                    }
            } else if (testRecord(recordID) == true) {

                if (result.next()) {
                    int learnerID = result.getInt("learner_id");
                    String name = result.getString("names");
                    String surname = result.getString("last_name");
                    String birthdate = result.getString("date_of_birth");
                    String gender = result.getString("gender");
                    String grade = String.valueOf(result.getInt("grade"));

                    System.out.println(" Learner ID: " + learnerID + "\r\n Full Name: " + name + " " + surname + "\r\n Date Of Birth: " + birthdate + "\r\n Gender: " + gender + "\r\n Grade: " + grade); 
                    System.out.println("");
                }

                
            }

            } else if (table.equals("parent_tbl")) {
                if (recordID.equals("all")) {
            
                    while (result.next()) {
                        int parentID = result.getInt("parent_id");
                        String name = result.getString("names");
                        String surname = result.getString("last_name");
                        String address = result.getString("address");
                        String contactNo = result.getString("contact_no");
                        String numChildren = String.valueOf(result.getInt("num_children"));

                        System.out.println(" Parent ID: " + parentID + "\r\n Full Name: " + name + " " + surname + "\r\n Address: " + address + "\r\n Contact Number: " + contactNo + "\r\n Number of Children: " + numChildren);
                        System.out.println("");
                    }
            } else if (testRecord(recordID) == true) {
                
                if (result.next()) {
                    int parentID = result.getInt("parent_id");
                    String name = result.getString("names");
                    String surname = result.getString("last_name");
                    String address = result.getString("address");
                    String contactNo = result.getString("contact_no");
                    String numChildren = String.valueOf(result.getInt("num_children"));

                    System.out.println(" Parent ID: " + parentID + "\r\n Full Name: " + name + " " + surname + "\r\n Address: " + address + "\r\n Contact Number: " + contactNo + "\r\n Number of Children: " + numChildren);
                    System.out.println("");
                }
            }
            }

            

            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("An error has occurred.");
            ex.printStackTrace();
        }
            
    }

    

    public static boolean recordExists(int recordID, String databaseName, String tabel){
        
        Boolean bExists = false;

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");

            String sql = "";

            switch(tabel) {
                case "learner_tbl":
                    sql = "SELECT COUNT(1) FROM learner_tbl WHERE(learner_id = "+ Integer.valueOf(recordID)+")";
                    break;
                case "parent_tbl":
                    sql = "SELECT COUNT(1) FROM parent_tbl WHERE(parent_id = "+ Integer.valueOf(recordID)+")";
                    break;
            }


            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            if (result.next()) {
                int i = result.getInt(1);
                if (i == 1) {
                    bExists = true;
                } else {
                    bExists = false;
                }
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("An error has occurred.");
            ex.printStackTrace();
        }
        
        
        
        return bExists;
    }


    public static void adminFeatures(String databaseName) {
        
        boolean bAdmin = true;
        
        // test the admin username and password
        
        aa:
        
        while (bAdmin == true) {
            
            boolean bUsername = testAdmin("username");
            boolean bPassword = testAdmin("password");

    
            if ((bUsername == true) && (bPassword == true)) {
                
                while(true){
                String[] options = {"Learner Table", "Parent Table", "Back"};
            
                int chosenOption = JOptionPane.showOptionDialog(null, "Which table would you like to access?", "Mzamomtsha School Registration",
                        JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    
                switch (chosenOption) {
                    case 0:
                        //learner table
    
                        String[] optionsLearnerExist = {"Yes", "No", "Back"};
            
                        int chosenLearnerExist = JOptionPane.showOptionDialog(null, "Does the learner tabel exist?", "Mzamomtsha School Registration",
                                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsLearnerExist, optionsLearnerExist[0]);
    
                        switch (chosenLearnerExist) {
                            case 0:
                                JOptionPane.showMessageDialog(null, "Great!");
                                break;
                            case 1:
                                tableCreate("learner_tbl", databaseName);
                                break;
                            case 2:
                                continue;
                            default:
                                JOptionPane.showMessageDialog(null, "An error has occurred.");
                                System.exit(0);
                        }
    
                        //create
                        
                        String[] optionsLearner = {"Add New Learners", "Print Out All Learners", "Search For A Specific Learner", "Back"};
            
                        int chosenLearnerOption = JOptionPane.showOptionDialog(null, "Which action would you like to perform?", "Mzamomtsha School Registration",
                                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsLearner, optionsLearner[0]);
    
                            switch (chosenLearnerOption) {
                                case 0:
                                    JOptionPane.showMessageDialog(null, "Please answer the following questions...");
                                    tableInsert("insert", databaseName, "learner_tbl", "");
                                    JOptionPane.showMessageDialog(null, "Learner has been successfully added to the database.");
                                    
                                    continue;
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Printing out learners...");
                                    tablePrintAllRecords("all", databaseName, "learner_tbl");                                  
                                    
                                    continue;
                                case 2:
    
                                    int learnerID = getRecordID("learner");
    
                                    if (recordExists(learnerID, databaseName, "learner_tbl") == true) {
        
                                        String[] optionsDo = {"Print Out", "Delete", "Cancel"};
                                        
                                        JOptionPane.showMessageDialog(null, "The learner exists!");
    
                                        int chosenOptionsDo = JOptionPane.showOptionDialog(null, "What would you like to do with the learner's record?", "Mzamomtsha School Registration",
                                                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsDo, optionsDo[0]);
                    
                                        switch (chosenOptionsDo) {
                                            case 0:
                                                tablePrintAllRecords(String.valueOf(learnerID), databaseName, "learner_tbl");
                                          
                                                continue;
                                            case 1:
                                                tableInsert("delete", databaseName, "learner_tbl", String.valueOf(learnerID)); //...
                                                JOptionPane.showMessageDialog(null, "Learner was successfully removed from the database.");
                                                
                                                continue;
                                            case 2:
                                                
                                                System.exit(0);
                                                
                                                continue;
                                            default:
                                                JOptionPane.showMessageDialog(null, "An error has occurred.");
                                                System.exit(0);
                                        }   
    
                                    } else {
                                        JOptionPane.showMessageDialog(null, "The learner could not be found.");
                                        System.exit(0);
                                    }
                                    
                                    break;
                                case 3:
                                    
                                    continue;
                                default:
                                    JOptionPane.showMessageDialog(null, "An error has occurred.");
                                    System.exit(0);
                            }
    
    
                        break;
                    case 1:
                        //parent table
                        
                        String[] optionsParentExist = {"Yes", "No", "Back"};
            
                        int chosenParentExist = JOptionPane.showOptionDialog(null, "Does the parent tabel exist?", "Mzamomtsha School Registration",
                                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsParentExist, optionsParentExist[0]);
    
                        switch (chosenParentExist) {
                            case 0:
                                JOptionPane.showMessageDialog(null, "Great!");
                                break;
                            case 1:
                                tableCreate("parent_tbl", databaseName);
                                
                                break;
                            case 2:
                                
                                continue;
                            default:
                                JOptionPane.showMessageDialog(null, "An error has occurred.");
                                System.exit(0);
                        }
    
                        //create 
    
                        String[] optionsParent = {"Add New Parents", "Print Out All Parents", "Search For A Specific Parent", "Cancel"};
            
                        int chosenParentOption = JOptionPane.showOptionDialog(null, "Which action would you like to perform?", "Mzamomtsha School Registration",
                                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsParent, optionsParent[0]);
    
                            switch (chosenParentOption) {
                                case 0:
                                    JOptionPane.showMessageDialog(null, "Please answer the following questions...");
                                    tableInsert("insert", databaseName, "parent_tbl", "");
                                    JOptionPane.showMessageDialog(null, "Parent has been successfully added to the database.");
                                    
                                    continue;
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Printing out parents...");
                                    tablePrintAllRecords("all", databaseName, "parent_tbl");                                  
                                    
                                    continue;
                                case 2:
    
                                    int parentID = getRecordID("parent");
    
                                    if (recordExists(parentID, databaseName, "parent_tbl") == true) {
        
                                        String[] optionsDo = {"Print Out", "Delete", "Cancel"};
                                        
                                        JOptionPane.showMessageDialog(null, "The parent exists!");
    
                                        int chosenOptionsDo = JOptionPane.showOptionDialog(null, "What would you like to do with the parent's record?", "Mzamomtsha School Registration",
                                                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsDo, optionsDo[0]);
                    
                                        switch (chosenOptionsDo) {
                                            case 0:
                                                tablePrintAllRecords(String.valueOf(parentID), databaseName, "parent_tbl");
                                                
                                                continue;
                                            case 1:
                                                tableInsert("delete", databaseName, "parent_tbl", String.valueOf(parentID)); //...
                                                JOptionPane.showMessageDialog(null, "Parent was successfully removed from the database.");
                                                
                                                continue;
                                            case 2:
                                                
                                                continue;
                                            default:
                                                JOptionPane.showMessageDialog(null, "An error has occurred.");
                                                System.exit(0);
                                        }   
    
                                    } else {
                                        JOptionPane.showMessageDialog(null, "The parent could not be found.");
                                        
                                        continue;
                                    }
                                    
                                    break;
                                case 3:
                                   
                                    continue;
                                default:
                                    JOptionPane.showMessageDialog(null, "An error has occurred.");
                                    System.exit(0);
                            }
    
    
                        break;
                    case 2:

                        bAdmin = false;
                        continue aa;

                    default:
                        JOptionPane.showMessageDialog(null, "An error has occurred.");
                        
                        bAdmin = false;
                        continue aa;
                        
                }
                
    
            }
             
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username/password.");
                bAdmin = false;
                continue aa;
                
            }
            
        }
    }

}
