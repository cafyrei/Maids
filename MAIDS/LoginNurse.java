package ALLEN_CODE;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.sql.Connection;         // JDBC Connection for database
import java.sql.DriverManager;      // For establishing a connection
import java.sql.PreparedStatement;  // For executing SQL queries
import java.sql.ResultSet;     
import java.sql.SQLException;       // For handling SQL exceptions
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginNurse extends javax.swing.JFrame {


    public LoginNurse() {
    initComponents();
    try {
            Connectivity();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Add components programmatically after the default ones
    JTextField usernameField = new JTextField(20);
    JPasswordField passwordField = new JPasswordField(20);
    
    JLabel nameLabel = new JLabel("Name:");
    JLabel passLabel = new JLabel("Password:");
    
    // Create the panels or containers for fields
    JPanel panel = new JPanel();
    panel.add(nameLabel);
    panel.add(usernameField);
    panel.add(passLabel);
    panel.add(passwordField);
    
    // Add this panel to your main panel or JFrame
    this.add(panel);
    }

Connection con;
    /* SQL Statement */
    Statement st;
    PreparedStatement pst;
    
    private static final String DBname = "maids_database";
    private static final String DBdriver = "com.mysql.cj.jdbc.Driver";
    private static final String DBurl = "jdbc:mysql://localhost:3306/" + DBname;
    private static final String DBIDNumber = "root";
    private static final String DBPassword = "";

    public void Connectivity() throws SQLException {
        try {
            Class.forName(DBdriver);
            con = DriverManager.getConnection(DBurl,DBIDNumber,DBPassword);
            st = con.createStatement();
            if (con != null) {
                System.out.println("Connected Successfully");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        nurse = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        pass = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ALLEN_CODE/1Untitled-3.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 500));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 500);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        nurse.setFont(new java.awt.Font("Tahoma", 1, 55)); // NOI18N
        nurse.setForeground(new java.awt.Color(255, 255, 255));
        nurse.setText("NURSE");

        name.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Full Name");

        pass.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setText("ID Number");

        Login.setBackground(new java.awt.Color(172, 216, 230));
        Login.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(172, 216, 230));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Credits");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Please enter your credentials");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LOGIN");

        jButton3.setBackground(new java.awt.Color(172, 216, 230));
        jButton3.setText("Account Manager");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                .addComponent(Login, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(116, 116, 116)
                                .addComponent(jButton1))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nurse)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 500);

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
    // Get the Name and Password text
    String nameText = jTextField2.getText();
    String passwordText = new String(jPasswordField1.getPassword());

    // Check if the Name field is empty
    if (nameText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter your name.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Early return
    }
    // Check if the Name contains any numbers
    else if (nameText.matches(".*\\d.*")) {
        JOptionPane.showMessageDialog(this, "Name cannot contain numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Early return
    }
    // Check if the Password field is empty
    else if (passwordText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter your ID Number.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Early return
    }

    String queryLogin = "SELECT * FROM accountdetails WHERE accFull_Name = ? AND accIDNumber = ?";

    try (PreparedStatement pst = con.prepareStatement(queryLogin)) {
        pst.setString(1, nameText);
        pst.setString(2, passwordText);
        ResultSet rs = pst.executeQuery();

        if (!rs.next()) {
            jLabel1.setText("The entered credentials are invalid.");
            jLabel1.setForeground(Color.RED);
        } else {
            String firstName = rs.getString("accFirst_Name");
            String lastName = rs.getString("accLast_Name");
            String employeeName = firstName + " " + lastName;
            JOptionPane.showMessageDialog(null, "Welcome, " + employeeName + "!");
            TempMenu main = new TempMenu(nameText, passwordText);
            main.setLocationRelativeTo(null);
            main.setResizable(false);
            main.setTitle("Nurse Menu");
            this.dispose();
            main.setVisible(true);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Print stack trace for debugging
        jLabel1.setText("An error occurred: " + ex.getMessage());
        jLabel1.setForeground(Color.RED);
    }
}//GEN-LAST:event_LoginActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
            System.out.println("DEBUG");
            Credits main = new Credits();
            main.setLocationRelativeTo(null);
            main.setResizable(false);
            main.setTitle("About Us: The Programmers");
            this.dispose();
            main.setVisible(true);
}

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
            String id = "", pass = "";
            JPanel adminPanel = new JPanel();
            JTextField adminID = new JTextField(10);
            JPasswordField adminPassword = new JPasswordField(10);
            
            adminPanel.add(new JLabel("Admin Account"));
            adminPanel.add(adminID);
            adminPanel.add(new JLabel("Admin Password"));
            adminPanel.add(adminPassword);
            int result = JOptionPane.showConfirmDialog(null, adminPanel, "Admin Login", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            if (result == JOptionPane.OK_OPTION) {
                id = adminID.getText();
                pass = adminPassword.getText();
        }
            String queryLogin = "SELECT userID, password FROM admin WHERE userID = ? AND password = ?";
        
        try {
            pst = con.prepareStatement(queryLogin);
            pst.setString(1, id);   
            pst.setString(2, pass);  
            System.out.println(id);
            ResultSet rs = pst.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Unauthorized Login!");
            } else {
                JOptionPane.showMessageDialog(null, "Welcome, " + id + "!");
                Administrator main = new Administrator();
                main.setLocationRelativeTo(null);
                main.setResizable(false);
                main.setTitle("Authorized Access: ADMIN");
                this.dispose();
                main.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }  

}
        
    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(TempMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TempMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TempMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TempMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginNurse main = new LoginNurse();
                main.setLocationRelativeTo(null);
                main.setResizable(false);
                main.setTitle("Nurse Login");
                main.setVisible(true);
                
            }
        });
    }     

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nurse;
    private javax.swing.JLabel pass;
    // End of variables declaration//GEN-END:variables
}
