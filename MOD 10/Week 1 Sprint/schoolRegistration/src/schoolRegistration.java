
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

                        if (learnerID == -2) {
                            break;
                        }

                        if (learnerID == -1) {
                            break;
                        }

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
                                    
                                    break;
                            }   

                        } else {
                            JOptionPane.showMessageDialog(null, "The learner could not be found.");
                        }

                            break;
                        case 1:

                        //parent

                        int parentID = getRecordID("parent");

                        if (parentID == -2) {
                            break;
                        }

                        if (parentID == -1) {
                            break;
                        }
    
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
                                    
                                    break;
                            }   

                        } else {
                            JOptionPane.showMessageDialog(null, "The parent could not be found.");
                        }

                            break;
                        case 2:
                            break;
                        default:
                            
                            break;
                    }
                    //JOptionPane.showMessageDialog(null, "Invalid input entered.");
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
                            
                            break;
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
                
                bAccess = false;
                continue;
        }
        
    }

    JOptionPane.showMessageDialog(null, "Closing program...");
    System.exit(0);

    }

    // username & password function => for Admins

    public static boolean cancelTrue(boolean input) {
        return input;
    }


    public static String askAdmin(String input) {
        
        String scanned = JOptionPane.showInputDialog(null, "What is your "+ input +"?");

        return scanned;

    }


    public static boolean testAdmin(String option, String input) {

        String testIt = "";

        switch (option) {
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
 
            scanned = input;

            if (testIt.equals(scanned)) {

                return true;
            } else {
                
                return false;
            }


        } catch (Exception e) {
            System.out.println("Invalid " + option + ".");
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
                    sql = "CREATE TABLE IF NOT EXISTS " + input + "(" +
                    "learner_id INT AUTO_INCREMENT NOT NULL, names VARCHAR(100), last_name VARCHAR(100), date_of_birth VARCHAR(10), gender VARCHAR(10), grade INT, PRIMARY KEY(learner_id))";
                    break;
                case "parent_tbl":
                    sql = "CREATE TABLE IF NOT EXISTS " + input + "(" +
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

        JOptionPane.showMessageDialog(null, "Please answer the following questions...");

        boolean bParent = false;
        boolean bLearner = false;
        boolean bInsert = false;
        boolean bDelete = false;

        String returnMessage = "";

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","root");

            String sql = "";
            //learner + parent
            String names = "";
            String surname = "";
            //parent
            String address = "";
            String contactNo = "";
            int numChildren = 0;
            //learner
            String dob = "";
            String gender = "";
            int grade = 0;


            if (table.equals("learner_tbl")) {

                bLearner = true;

            switch (input) {
                case "insert":

                    bInsert = true;

                    names = readInNames("learner");

                    if (isNull(names) == true) {
                        return;
                    }

                    surname = readInSurname("learner");

                    if (isNull(surname) == true) {
                        return;
                    }

                    dob = readInBirthdate();

                    if (isNull(dob) == true) {
                        return;
                    }

                    gender = readInGender();

                    if (isNull(gender) == true) {
                        return;
                    }

                    grade = readInGrade();

                    if (isNull(String.valueOf(grade)) == true) {
                        return;
                    }

                    sql = "INSERT INTO learner_tbl(names, last_name, date_of_birth, gender, grade) VALUES('"+ names +
                    "','"+ surname +"','"+ dob +"','"+ gender +"','"+ grade +"')";
                    
                    break;
              
                case "delete":

                    bDelete = true;

                    sql = "DELETE FROM learner_tbl WHERE(learner_id = " + recordID + ")"; //delete
                    break;
            }
            } else if (table.equals("parent_tbl")) {

                bParent = true;
                switch (input) {
                    case "insert":

                        bInsert = true;

                        names = readInNames("parent");

                        if (isNull(names) == true) {
                            return;
                        }

                        surname = readInSurname("parent");

                        if (isNull(surname) == true) {
                            return;
                        }

                        address = readInAddress();

                        if (isNull(address) == true) {
                            return;
                        }

                        contactNo = readInContactNo();

                        if (isNull(contactNo) == true) {
                            return;
                        }

                        numChildren = readInNumChildren();

                        if (isNull(String.valueOf(numChildren)) == true) {
                            return;
                        }
                        
                        sql = "INSERT INTO parent_tbl(names, last_name, address, contact_no, num_children) VALUES('"+ names +
                        "','"+ surname +"','"+ address +"','"+ contactNo +"','"+ numChildren +"')";

                        break;
                   
                    case "delete":

                        bDelete = true;

                        sql = "DELETE FROM parent_tbl WHERE(parent_id = " + recordID + ")"; //delete
                        break;
                }
            }


            Statement stmt = conn.createStatement();
    
    
            stmt.executeUpdate(sql);

            if ((bParent == true) && (bDelete == true)) {
                returnMessage = "Parent was successfully removed from the database.";
            } else if ((bParent == true) && (bInsert == true)) {
                returnMessage = "Parent has been successfully added to the database.";
            } else if ((bLearner == true) && (bDelete == true)) {
                returnMessage = "Learner was successfully removed from the database.";
            } else if ((bLearner == true) && (bInsert == true)) {
                returnMessage = "Learner has been successfully added to the database.";
            }
        

            conn.close();  
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("An error has occurred.");
            ex.printStackTrace();
        }

        if (isNull(returnMessage) == true) {
            return;
        }
        
        JOptionPane.showMessageDialog(null, returnMessage);
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

            if (isNull(dD) == true) {
                return "";
            }

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

            if (isNull(mM) == true) {
                return "";
            }

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
                default:
                    return "";
            }

            yYYY = JOptionPane.showInputDialog(null, "What year was the learner born?");

            if (isNull(yYYY) == true) {
                return "";
            }

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

                        System.out.println("");
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

                    System.out.println("");
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

                        System.out.println("");
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

                    System.out.println("");
                    System.out.println(" Parent ID: " + parentID + "\r\n Full Name: " + name + " " + surname + "\r\n Address: " + address + "\r\n Contact Number: " + contactNo + "\r\n Number of Children: " + numChildren);
                    System.out.println("");
                }
            }
            }

            

            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("An error has occurred.");
            ex.printStackTrace();
            return;
        }
            
    }

    

    public static boolean recordExists(int recordID, String databaseName, String tabel){
        
        if (isNull(String.valueOf(recordID)) == true) {
            return false;
        }

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
            
            String username = askAdmin("username");

            if (username == null) {
                return;
            }
            
            boolean bUsername = testAdmin("username", username);

            

            String password = askAdmin("password");

            if (password == null) {
                return;
            }

            boolean bPassword = testAdmin("password", password);

    
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
                        }
    
                        //create
                        
                        String[] optionsLearner = {"Add New Learners", "Print Out All Learners", "Search For A Specific Learner", "Back"};
            
                        int chosenLearnerOption = JOptionPane.showOptionDialog(null, "Which action would you like to perform?", "Mzamomtsha School Registration",
                                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsLearner, optionsLearner[0]);
    
                            switch (chosenLearnerOption) {
                                case 0:
                                    
                                    tableInsert("insert", databaseName, "learner_tbl", "");
                                    
                                    continue;
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Printing out learners...");
                                    tablePrintAllRecords("all", databaseName, "learner_tbl");                                  
                                    
                                    continue;
                                case 2:
    
                                    int learnerID = getRecordID("learner");

                                    if (learnerID == -2) {
                                        break;
                                    }
                                    
                                    if (learnerID == -1) {
                                        JOptionPane.showMessageDialog(null, "Invalid input.");
                                        break;
                                    }
    
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
                                                tableInsert("delete", databaseName, "learner_tbl", String.valueOf(learnerID));
                                                
                                                continue;
                                            case 2:
                                                
                                                //System.exit(0);
                                                
                                                continue;
                                            default:
                                                JOptionPane.showMessageDialog(null, "An error has occurred.");
                                                //System.exit(0);
                                        }   
    
                                    } else {
                                        JOptionPane.showMessageDialog(null, "The learner could not be found.");
                                        //System.exit(0);
                                    }
                                    
                                    break;
                                case 3:
                                    
                                    continue;
                                default:
                                    JOptionPane.showMessageDialog(null, "An error has occurred.");
                                    //System.exit(0);
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
                        }
    
                        //create 
    
                        String[] optionsParent = {"Add New Parents", "Print Out All Parents", "Search For A Specific Parent", "Cancel"};
            
                        int chosenParentOption = JOptionPane.showOptionDialog(null, "Which action would you like to perform?", "Mzamomtsha School Registration",
                                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsParent, optionsParent[0]);
    
                            switch (chosenParentOption) {
                                case 0:
                                    tableInsert("insert", databaseName, "parent_tbl", "");
                                    
                                    continue;
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Printing out parents...");
                                    tablePrintAllRecords("all", databaseName, "parent_tbl");                                  
                                    
                                    continue;
                                case 2:

                                    int parentID = getRecordID("parent");

                                    if (parentID == -2) {
                                        break;
                                    }

                                    if (parentID == -1) {
                                        JOptionPane.showMessageDialog(null, "Invalid input.");
                                        break;
                                    }
    
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
                                                tableInsert("delete", databaseName, "parent_tbl", String.valueOf(parentID));
                                                
                                                continue;
                                            case 2:
                                                
                                                continue;
                                        }   
    
                                    } else {
                                        JOptionPane.showMessageDialog(null, "The parent could not be found.");
                                        
                                        continue;
                                    }
                                    
                                    break;
                                case 3:
                                   
                                    continue;
                              
                            }
    
    
                        break;
                    case 2:

                        bAdmin = false;
                        continue aa;

                    default:
                        
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

    public static boolean isNull(String test) {
        if ((test == null) || (test != null && ("".equals(test)) )) {
            return true;
        }

        return false;
    }

}
