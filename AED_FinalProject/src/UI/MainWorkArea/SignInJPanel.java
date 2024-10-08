/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.MainWorkArea;

import Business.Business;
import Business.UserAccount.UserAccount;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author tianshiyun
 */
public class SignInJPanel extends javax.swing.JPanel {
        Business business;
        UserAccount userAccount;
        JFrame mainJ;
    /**
     * Creates new form SignInJPanel
     */
    public SignInJPanel() {
        initComponents();
    }
    
    public SignInJPanel(Business business, UserAccount userAccount , JFrame mainJ) {
        initComponents();
        this.business = business;
        this.userAccount = userAccount;
        this.mainJ=mainJ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        signinBtn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(225, 217, 200));
        setMaximumSize(new java.awt.Dimension(300, 1300));
        setMinimumSize(new java.awt.Dimension(300, 1300));
        setPreferredSize(new java.awt.Dimension(300, 1300));
        setSize(new java.awt.Dimension(300, 1300));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("InaiMathi", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Enter Password");
        add(jLabel1);
        jLabel1.setBounds(76, 211, 98, 33);

        password.setBackground(new java.awt.Color(204, 204, 204));
        password.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(password);
        password.setBounds(192, 209, 202, 33);

        jLabel2.setFont(new java.awt.Font("InaiMathi", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("User Name");
        add(jLabel2);
        jLabel2.setBounds(76, 158, 66, 33);

        userName.setBackground(new java.awt.Color(204, 204, 204));
        userName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(userName);
        userName.setBounds(192, 156, 202, 33);

        signinBtn.setBackground(new java.awt.Color(51, 51, 51));
        signinBtn.setForeground(new java.awt.Color(204, 204, 204));
        signinBtn.setText("SIGN IN");
        signinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinBtnActionPerformed(evt);
            }
        });
        add(signinBtn);
        signinBtn.setBounds(80, 440, 318, 35);

        jComboBox1.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "System_Manager", "Customer", "Ad_Admin", "Delivery_Admin", "Validation_Admin", "Merchant", "Live_Admin", "Delivery_Company" }));
        add(jComboBox1);
        jComboBox1.setBounds(192, 272, 202, 23);

        jLabel3.setFont(new java.awt.Font("InaiMathi", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Select Role");
        add(jLabel3);
        jLabel3.setBounds(76, 269, 98, 33);
    }// </editor-fold>//GEN-END:initComponents

    private void signinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinBtnActionPerformed
        String usern = userName.getText();
        String passw = password.getText();
        String role = (String) jComboBox1.getSelectedItem();
        if(this.business.getUserAccountDirectory().accountLogExists(usern, passw, role)){
            UserAccount user1 = this.business.getUserAccountDirectory().getUserAccount(usern, passw, role);
            
            mainJ.setVisible(false);
            user1.getWorkArea(role, this.business, user1).setVisible(true);
    
        }else{
            JOptionPane.showMessageDialog(null, "invalid credentials");

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_signinBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField password;
    private javax.swing.JButton signinBtn;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
