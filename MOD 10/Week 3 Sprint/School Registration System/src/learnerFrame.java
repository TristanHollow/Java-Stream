import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tristan
 */
public class learnerFrame extends javax.swing.JFrame {

    /**
     * Creates new form learnerFrame
     */
    public learnerFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgHomelanguage = new javax.swing.ButtonGroup();
        bgFAL = new javax.swing.ButtonGroup();
        bgMath = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tfName = new javax.swing.JTextField();
        tfSurname = new javax.swing.JTextField();
        tfLearnerID = new javax.swing.JTextField();
        tfGender = new javax.swing.JTextField();
        tfDOB = new javax.swing.JTextField();
        tfParentID = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblLearnerID = new javax.swing.JLabel();
        lblParentID = new javax.swing.JLabel();
        lblDOB = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblGrade = new javax.swing.JLabel();
        tfGrade = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        rgbAfrMain = new javax.swing.JRadioButton();
        rgbEngMain = new javax.swing.JRadioButton();
        lblHomeLanguage = new javax.swing.JLabel();
        lblFAL = new javax.swing.JLabel();
        rgbFALEng = new javax.swing.JRadioButton();
        rgbFALAfr = new javax.swing.JRadioButton();
        rgbMathLit = new javax.swing.JRadioButton();
        rgbMath = new javax.swing.JRadioButton();
        lblMath = new javax.swing.JLabel();
        tfMandatorySubjects = new javax.swing.JTextField();
        tfChosen3 = new javax.swing.JTextField();
        tfChosen2 = new javax.swing.JTextField();
        tfChosen1 = new javax.swing.JTextField();
        lblChosenSubjects = new javax.swing.JLabel();
        lblMandatory = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        tfAge = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    /*    tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
*/
        lblName.setText("Name");

        lblSurname.setText("Surname");

        lblLearnerID.setText("Learner ID");

        lblParentID.setText("Parent ID");

        lblDOB.setText("Date Of Birth");

        lblGender.setText("Gender");

        lblGrade.setText("Grade");

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        bgHomelanguage.add(rgbAfrMain);
        rgbAfrMain.setText("Afrikaans");

        bgHomelanguage.add(rgbEngMain);
        rgbEngMain.setText("English");

        lblHomeLanguage.setText("Home Language");

        lblFAL.setText("First Additional Language");

        bgFAL.add(rgbFALEng);
        rgbFALEng.setText("English");

        bgFAL.add(rgbFALAfr);
        rgbFALAfr.setText("Afrikaans");

        bgMath.add(rgbMathLit);
        rgbMathLit.setText("Math Literacy");

        bgMath.add(rgbMath);
        rgbMath.setText("Mathematics");

        lblMath.setText("Maths");

        tfMandatorySubjects.setEditable(false);
        tfMandatorySubjects.setText("Life Orientation");

        lblChosenSubjects.setText("Chosen Subjects");

        lblMandatory.setText("Madatory Subject");

        lblAge.setText("Age");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rgbEngMain)
                    .addComponent(rgbAfrMain)
                    .addComponent(lblHomeLanguage))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFAL)
                        .addGap(38, 38, 38)
                        .addComponent(lblMath)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rgbFALAfr)
                            .addComponent(rgbFALEng))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfMandatorySubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMandatory))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rgbMath)
                                    .addComponent(rgbMathLit)
                                    .addComponent(lblChosenSubjects, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                    .addComponent(tfChosen1)
                                    .addComponent(tfChosen2)
                                    .addComponent(tfChosen3))
                                .addGap(53, 53, 53))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lblName)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGender)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfGrade)
                                .addComponent(tfGender, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblGrade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInsert)
                            .addComponent(tfDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSurname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfLearnerID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblParentID)
                                    .addComponent(lblLearnerID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfParentID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(lblSurname)
                    .addComponent(lblDOB)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblAge))
                    .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(lblSurname)
                            .addComponent(lblLearnerID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfLearnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParentID)
                            .addComponent(lblDOB)
                            .addComponent(lblGender))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfParentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblChosenSubjects)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfChosen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfChosen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfChosen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAge)
                            .addComponent(lblGrade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tfMandatorySubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMandatory)
                        .addGap(32, 32, 32)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHomeLanguage)
                    .addComponent(lblFAL)
                    .addComponent(lblMath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rgbEngMain)
                    .addComponent(rgbFALEng)
                    .addComponent(rgbMathLit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rgbAfrMain)
                    .addComponent(rgbFALAfr)
                    .addComponent(rgbMath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnUpdate.setVisible(false);
            tfLearnerID.setVisible(false);
            lblLearnerID.setVisible(false);


            rgbEngMain.setSelected(true);
            rgbFALEng.setSelected(true);
            rgbMath.setSelected(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   // private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
 //   }//GEN-LAST:event_tfNameActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        tableInsertRecords();
        OptionFrame.tablePrintRecords("default");
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void rgbEngMainActionPerformed(java.awt.event.ActionEvent evt) {                                           
        rgbFALAfr.setSelected(true);
    }                                          

    private void rgbAfrMainActionPerformed(java.awt.event.ActionEvent evt) {                                           
        rgbFALEng.setSelected(true);
    }                                          

    private void rgbFALEngActionPerformed(java.awt.event.ActionEvent evt) {                                          
        rgbAfrMain.setSelected(true);
    }                                         

    private void rgbFALAfrActionPerformed(java.awt.event.ActionEvent evt) {                                          
        rgbFALEng.setSelected(true);
    }   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(learnerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(learnerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(learnerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(learnerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new learnerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgFAL;
    private javax.swing.ButtonGroup bgHomelanguage;
    private javax.swing.ButtonGroup bgMath;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblChosenSubjects;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblFAL;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGrade;
    private javax.swing.JLabel lblHomeLanguage;
    private javax.swing.JLabel lblLearnerID;
    private javax.swing.JLabel lblMandatory;
    private javax.swing.JLabel lblMath;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblParentID;
    private javax.swing.JLabel lblSurname;
    private static javax.swing.JRadioButton rgbAfrMain;
    private static javax.swing.JRadioButton rgbEngMain;
    private static javax.swing.JRadioButton rgbFALAfr;
    private static javax.swing.JRadioButton rgbFALEng;
    private static javax.swing.JRadioButton rgbMath;
    private static javax.swing.JRadioButton rgbMathLit;
    private static javax.swing.JTextField tfAge;
    private static javax.swing.JTextField tfChosen1;
    private static javax.swing.JTextField tfChosen2;
    private static javax.swing.JTextField tfChosen3;
    private static javax.swing.JTextField tfDOB;
    private static javax.swing.JTextField tfGender;
    private static javax.swing.JTextField tfGrade;
    private static javax.swing.JTextField tfLearnerID;
    private static javax.swing.JTextField tfMandatorySubjects;
    private static javax.swing.JTextField tfName;
    private static javax.swing.JTextField tfParentID;
    private static javax.swing.JTextField tfSurname;
    // End of variables declaration//GEN-END:variables

            ///update TRUE 


            public static void tableUpdateRecords(){
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
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + MethodFile.databaseName,"root","root");
        
        
                    switch (MethodFile.table) {
                        case "learner_tbl":
        
                        parentID = 0;
        
                        if (MethodFile.isNull(String.valueOf(parentID)) == true) {
                            return;
                        }
        
                        names = "";//readInNames("learner");
        
                        if (MethodFile.isNull(names) == true) {
                            return;
                        }
        
                        surname = "";//readInSurname("learner");
        
                        if (MethodFile.isNull(surname) == true) {
                            return;
                        }
        
                        dob = "";//readInBirthdate();
        
                        if (MethodFile.isNull(dob) == true) {
                            return;
                        }
        
                        gender = "";//readInGender();
        
                        if (MethodFile.isNull(gender) == true) {
                            return;
                        }
        
                        grade = 0;//readInGrade();
        
                        if (MethodFile.isNull(String.valueOf(grade)) == true) {
                            return;
                        }
        
                        /*sql = "INSERT INTO learner_tbl( parent_id, names, last_name, date_of_birth, gender, grade ) VALUES('" + parentID +
                        "','" + names +
                        "','"+ surname +"','"+ dob +"','"+ gender +"','"+ grade +"')";*/
        
                            sql = "UPDATE learner_tbl SET " + 
                            "parent_id = " + parentID + ", names = " + names + ", " + 
                            "last_name = " + surname + ", date_of_birth = " + dob + ", " + 
                            "gender = " + gender + ", grade = " + grade + " WHERE learner_id = " + MethodFile.recordID;
                        
        
                            break;
                        case "parent_tbl":
        
                            userName = "";
        
                            if (MethodFile.isNull(userName) == true) {
                                return;
                            }
        
                            passWord = "";
        
                            if (MethodFile.isNull(passWord) == true) {
                                return;
                            }
        
                            names = "";//readInNames("parent");
        
                            if (MethodFile.isNull(names) == true) {
                                return;
                            }
        
                            surname = "";//readInSurname("parent");
        
                            if (MethodFile.isNull(surname) == true) {
                                return;
                            }
        
                            address = "";//readInAddress();
        
                            if (MethodFile.isNull(address) == true) {
                                return;
                            }
        
                            contactNo = "";//readInContactNo();
        
                            if (MethodFile.isNull(contactNo) == true) {
                                return;
                            }
        
                            numChildren = 0;//readInNumChildren();
        
                            if (MethodFile.isNull(String.valueOf(numChildren)) == true) {
                                return;
                            }
                            
                            /*sql = "INSERT INTO parent_tbl(names, last_name, address, contact_no, num_children) VALUES('"+ names +
                            "','"+ surname +"','"+ address +"','"+ contactNo +"','"+ numChildren +"')";*/  
        
                            sql = "UPDATE parent_tbl SET " + 
                            "names = " + names + ", " + 
                            "last_name = " + surname + ", address = " + address + ", " + 
                            "contact_no = " + contactNo + ", num_children = " + numChildren + 
                            ", username = " + userName + ", password = " + passWord + 
                            " WHERE parent_id = " + MethodFile.recordID;
                            break;
                        case "teacher_tbl":
        
                            userName = "";
        
                            if (MethodFile.isNull(userName) == true) {
                                return;
                            }
        
                            passWord = "";
        
                            if (MethodFile.isNull(passWord) == true) {
                                return;
                            }
        
                            /*sql = "INSERT INTO teacher_tbl(username, password) VALUES('"+ username +
                            "','"+ password +"')";*/
                            
                            sql = "UPDATE teacher SET " +
                            "names = " + names + ", " + 
                            "last_name = " + surname + ", address = " + address + ", " + 
                            "contact_no = " + contactNo + 
                            "username = " + userName + ", " + 
                            "password = " + passWord + " WHERE teacher_id = " + MethodFile.recordID;
        
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

        public static void tableInsertRecords(){
            Connection conn = null;
    
            String sql = "";
                //learner + parent
                String names = "";
                String surname = "";
                //parent
                /*String userName = "";
                String passWord = "";
                String address = "";
                String contactNo = "";
                int numChildren = 0;*/
                //learner
                String dob = "";
                String gender = "";
                int grade = 0;
                int parentID = 0;
                
                int age = 0;
                String subject1 = "";
                String subject2 = "";
                String subject3 = "";
                String subject4 = "";
                String subject5 = "";
                String subject6 = "";
                String subject7 = "";
    
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + MethodFile.databaseName,"root","root");
    
    
                switch (MethodFile.table) {
                    case "learner_tbl":
    
                    parentID = Integer.valueOf(tfParentID.getText());
    
                    if (MethodFile.isNull(String.valueOf(parentID)) == true) {
                        return;
                    }
    
                    names = tfName.getText();
    
                    if (MethodFile.isNull(names) == true) {
                        return;
                    }
    
                    surname = tfSurname.getText();
    
                    if (MethodFile.isNull(surname) == true) {
                        return;
                    }
    
                    dob = tfDOB.getText();
    
                    if (MethodFile.isNull(dob) == true) {
                        return;
                    }
    
                    gender = tfGender.getText();
    
                    if (MethodFile.isNull(gender) == true) {
                        return;
                    }
    
                    grade = Integer.parseInt(tfGrade.getText());
    
                    if (MethodFile.isNull(String.valueOf(grade)) == true) {
                        return;
                    }

                    age = Integer.parseInt(tfAge.getText());
    
                    if (MethodFile.isNull(String.valueOf(age)) == true) {
                        return;
                    }


                    //subject1 (HL)
                    if(rgbAfrMain.isSelected()){
                    subject1 = "Afrikaans HL";
                        subject2 = "English FAL";
                }
                else{
                    subject1 = "English HL";
                    subject2 = "Afrikaans FAL";
                }

                    //subject2 (FAL)

                    //subject3 (Maths)
                    if(rgbMath.isSelected()){
                        subject3 = "Mathematics";
                            
                    }
                    else{
                        subject3 = "Math Literacy";
                    }

                    subject4 = "Life Orientation";

                    subject5 = tfChosen1.getText();
    
                    if (MethodFile.isNull(subject5) == true) {
                        return;
                    }

                    subject6 = tfChosen2.getText();
    
                    if (MethodFile.isNull(subject6) == true) {
                        return;
                    }

                    subject7 = tfChosen3.getText();
    
                    if (MethodFile.isNull(subject7) == true) {
                        return;
                    }
                    

                    
    
                    sql = "INSERT INTO learner_tbl( parent_id, names, last_name, date_of_birth, gender, grade, age, subject1, subject2, subject3, subject4, subject5, subject6, subject7 ) VALUES('" + parentID +
                    "','" + names +
                    "','"+ surname +"','"+ dob +"','"+ gender +"','"+ grade +"','"+ age +"','"+ subject1 +"','"+ subject2 +"','"+ subject3 +
                    "','"+ subject4 +"','"+ subject5 +"','"+ subject6 +"','"+ subject7 +"')";
    
                        break;
                    
                }
    
    
                Statement stmt = conn.createStatement();
        
        
                stmt.executeUpdate(sql);
    
                conn.close();

                JOptionPane.showMessageDialog(null, "Learner has been added to the database.");
    
            } catch (Exception e) {
                System.out.println("An error has occurred.");
                e.printStackTrace();
            }
    
        }
    
      
        
        
}
