import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package tristanmod10week2frames;

/**
 *
 * @author John
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGender)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfGrade)
                                .addComponent(tfGender, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblGrade)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName)
                                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfDOB)
                            .addComponent(lblSurname)
                            .addComponent(lblDOB)
                            .addComponent(tfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnInsert))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblParentID)
                        .addComponent(lblLearnerID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfLearnerID)
                        .addComponent(tfParentID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
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
                    .addComponent(tfParentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGrade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        tableInsertRecords();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

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
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGrade;
    private javax.swing.JLabel lblLearnerID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblParentID;
    private javax.swing.JLabel lblSurname;
    private static javax.swing.JTextField tfDOB;
    private static javax.swing.JTextField tfGender;
    private static javax.swing.JTextField tfGrade;
    private static javax.swing.JTextField tfLearnerID;
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
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Mod10Week2Sprint.databaseName,"root","root");
        
        
                    switch (Mod10Week2Sprint.table) {
                        case "learner_tbl":
        
                        parentID = 0;
        
                        if (Mod10Week2Sprint.isNull(String.valueOf(parentID)) == true) {
                            return;
                        }
        
                        names = "";//readInNames("learner");
        
                        if (Mod10Week2Sprint.isNull(names) == true) {
                            return;
                        }
        
                        surname = "";//readInSurname("learner");
        
                        if (Mod10Week2Sprint.isNull(surname) == true) {
                            return;
                        }
        
                        dob = "";//readInBirthdate();
        
                        if (Mod10Week2Sprint.isNull(dob) == true) {
                            return;
                        }
        
                        gender = "";//readInGender();
        
                        if (Mod10Week2Sprint.isNull(gender) == true) {
                            return;
                        }
        
                        grade = 0;//readInGrade();
        
                        if (Mod10Week2Sprint.isNull(String.valueOf(grade)) == true) {
                            return;
                        }
        
                        /*sql = "INSERT INTO learner_tbl( parent_id, names, last_name, date_of_birth, gender, grade ) VALUES('" + parentID +
                        "','" + names +
                        "','"+ surname +"','"+ dob +"','"+ gender +"','"+ grade +"')";*/
        
                            sql = "UPDATE learner_tbl SET " + 
                            "parent_id = " + parentID + ", names = " + names + ", " + 
                            "last_name = " + surname + ", date_of_birth = " + dob + ", " + 
                            "gender = " + gender + ", grade = " + grade + " WHERE learner_id = " + Mod10Week2Sprint.recordID;
                        
        
                            break;
                        case "parent_tbl":
        
                            userName = "";
        
                            if (Mod10Week2Sprint.isNull(userName) == true) {
                                return;
                            }
        
                            passWord = "";
        
                            if (Mod10Week2Sprint.isNull(passWord) == true) {
                                return;
                            }
        
                            names = "";//readInNames("parent");
        
                            if (Mod10Week2Sprint.isNull(names) == true) {
                                return;
                            }
        
                            surname = "";//readInSurname("parent");
        
                            if (Mod10Week2Sprint.isNull(surname) == true) {
                                return;
                            }
        
                            address = "";//readInAddress();
        
                            if (Mod10Week2Sprint.isNull(address) == true) {
                                return;
                            }
        
                            contactNo = "";//readInContactNo();
        
                            if (Mod10Week2Sprint.isNull(contactNo) == true) {
                                return;
                            }
        
                            numChildren = 0;//readInNumChildren();
        
                            if (Mod10Week2Sprint.isNull(String.valueOf(numChildren)) == true) {
                                return;
                            }
                            
                            /*sql = "INSERT INTO parent_tbl(names, last_name, address, contact_no, num_children) VALUES('"+ names +
                            "','"+ surname +"','"+ address +"','"+ contactNo +"','"+ numChildren +"')";*/  
        
                            sql = "UPDATE parent_tbl SET " + 
                            "names = " + names + ", " + 
                            "last_name = " + surname + ", address = " + address + ", " + 
                            "contact_no = " + contactNo + ", num_children = " + numChildren + 
                            ", username = " + userName + ", password = " + passWord + 
                            " WHERE parent_id = " + Mod10Week2Sprint.recordID;
                            break;
                        case "teacher_tbl":
        
                            userName = "";
        
                            if (Mod10Week2Sprint.isNull(userName) == true) {
                                return;
                            }
        
                            passWord = "";
        
                            if (Mod10Week2Sprint.isNull(passWord) == true) {
                                return;
                            }
        
                            /*sql = "INSERT INTO teacher_tbl(username, password) VALUES('"+ username +
                            "','"+ password +"')";*/
                            
                            sql = "UPDATE teacher SET " +
                            "names = " + names + ", " + 
                            "last_name = " + surname + ", address = " + address + ", " + 
                            "contact_no = " + contactNo + 
                            "username = " + userName + ", " + 
                            "password = " + passWord + " WHERE teacher_id = " + Mod10Week2Sprint.recordID;
        
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
    
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Mod10Week2Sprint.databaseName,"root","root");
    
    
                switch (Mod10Week2Sprint.table) {
                    case "learner_tbl":
    
                    parentID = Integer.valueOf(tfParentID.getText());
    
                    if (Mod10Week2Sprint.isNull(String.valueOf(parentID)) == true) {
                        return;
                    }
    
                    names = tfName.getText();
    
                    if (Mod10Week2Sprint.isNull(names) == true) {
                        return;
                    }
    
                    surname = tfSurname.getText();
    
                    if (Mod10Week2Sprint.isNull(surname) == true) {
                        return;
                    }
    
                    dob = tfDOB.getText();
    
                    if (Mod10Week2Sprint.isNull(dob) == true) {
                        return;
                    }
    
                    gender = tfGender.getText();
    
                    if (Mod10Week2Sprint.isNull(gender) == true) {
                        return;
                    }
    
                    grade = Integer.parseInt(tfGrade.getText());
    
                    if (Mod10Week2Sprint.isNull(String.valueOf(grade)) == true) {
                        return;
                    }
    
                    sql = "INSERT INTO learner_tbl( parent_id, names, last_name, date_of_birth, gender, grade ) VALUES('" + parentID +
                    "','" + names +
                    "','"+ surname +"','"+ dob +"','"+ gender +"','"+ grade +"')";
    
                        break;
                    
                    /*case "parent_tbl":
    
                        userName = tfUsername.getText();
    
                        if (Mod10Week2Sprint.isNull(userName) == true) {
                            return;
                        }
    
                        passWord = tfPassword.getText();
    
                        if (Mod10Week2Sprint.isNull(passWord) == true) {
                            return;
                        }
    
                        names = tfName.getText();
    
                        if (Mod10Week2Sprint.isNull(names) == true) {
                            return;
                        }
    
                        surname = tfSurname.getText();
    
                        if (Mod10Week2Sprint.isNull(surname) == true) {
                            return;
                        }
    
                        address = tfAddress.getText();
    
                        if (Mod10Week2Sprint.isNull(address) == true) {
                            return;
                        }
    
                        contactNo = tfContactNo.getText();
    
                        if (Mod10Week2Sprint.isNull(contactNo) == true) {
                            return;
                        }
    
                        numChildren = Integer.valueOf(tfNumChildren.getText());
    
                        if (Mod10Week2Sprint.isNull(String.valueOf(numChildren)) == true) {
                            return;
                        }
                        
                        sql = "INSERT INTO parent_tbl(names, last_name, address, contact_no, num_children, username, password) VALUES('"+ names +
                        "','"+ surname +"','"+ address +"','"+ contactNo +"','"+ numChildren +"','"+ userName +"','"+ passWord +"')";    
    
                        break;
                    case "teacher_tbl":
    
                    userName = tfUsername.getText();
    
                    if (Mod10Week2Sprint.isNull(userName) == true) {
                        return;
                    }

                    passWord = tfPassword.getText();

                    if (Mod10Week2Sprint.isNull(passWord) == true) {
                        return;
                    }

                    names = tfName.getText();

                    if (Mod10Week2Sprint.isNull(names) == true) {
                        return;
                    }

                    surname = tfSurname.getText();

                    if (Mod10Week2Sprint.isNull(surname) == true) {
                        return;
                    }

                    address = tfAddress.getText();

                    if (Mod10Week2Sprint.isNull(address) == true) {
                        return;
                    }

                    contactNo = tfContactNo.getText();

                    if (Mod10Week2Sprint.isNull(contactNo) == true) {
                        return;
                    }
    
                        
                        sql = "INSERT INTO teacher_tbl(names, last_name, address, contact_no, username, password) VALUES('"+ names +
                        "','"+ surname +"','"+ address +"','"+ contactNo +"','"+ userName +"','"+ passWord +"')"; 
    
                        break;*/
                }
    
    
                Statement stmt = conn.createStatement();
        
        
                stmt.executeUpdate(sql);
    
                conn.close();
    
            } catch (Exception e) {
                System.out.println("An error has occurred.");
                e.printStackTrace();
            }
    
        }
    
      
        
        
}
