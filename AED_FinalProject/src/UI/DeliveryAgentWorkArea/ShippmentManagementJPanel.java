/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.DeliveryAgentWorkArea;

import Business.Business;
import Business.Customer.Customer;
import Business.Customer.Order;
import Business.UserAccount.UserAccount;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tianzhichen
 */
public class ShippmentManagementJPanel extends javax.swing.JPanel {

    Business business;
    UserAccount userAccount;
    DefaultTableModel deliveryTableModel;

    /**
     * Creates new form ShippmentManagementJPanel
     */
    public ShippmentManagementJPanel() {
        initComponents();
    }

    public ShippmentManagementJPanel(Business business, UserAccount userAccount) {
        initComponents();
        this.business = business;
        this.userAccount = userAccount;


        this.deliveryTableModel = (DefaultTableModel) deliveryTable.getModel();
        populateDelivey();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        deliveryTable = new javax.swing.JTable();
        sentBtn = new javax.swing.JButton();
        deliveredBtn = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deliveryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order", "Customer", "Merchant", "Status"
            }
        ));
        jScrollPane1.setViewportView(deliveryTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 400, 310));

        sentBtn.setText("SENT");
        sentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sentBtnActionPerformed(evt);
            }
        });
        add(sentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 110, 30));

        deliveredBtn.setText("DELIVERED");
        deliveredBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveredBtnActionPerformed(evt);
            }
        });
        add(deliveredBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 110, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void deliveredBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveredBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = deliveryTable.getSelectedRow();

        Order o = (Order) deliveryTable.getValueAt(selectedRow, 0);

        o.setStatus(Order.Status.DELIVERED);
        populateDelivey();
    }//GEN-LAST:event_deliveredBtnActionPerformed

    private void sentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sentBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = deliveryTable.getSelectedRow();

        Order o = (Order) deliveryTable.getValueAt(selectedRow, 0);

        o.setStatus(Order.Status.DELIVERING);
        populateDelivey();
    }//GEN-LAST:event_sentBtnActionPerformed

     public void populateDelivey() {
        deliveryTableModel.setRowCount(0);
//        for (Order o : this.business.getAllOrders().getOrderList()) {
//            System.out.println(this.business.getAllOrders().getOrderList().size());
//
//            Object[] row = new Object[4];
//
//            row[0] = o;
//            row[1] = o.getCustomer().getName();
//            row[2] = o.getMerchant().getMerchantName();
//            row[3] = o.getStatus();
//
//            deliveryTableModel.addRow(row);
//        }
        for(Customer c : this.business.getCustomerDirectory().getCustomerDirectory()){
                for (Order o : c.getOrderList()) {
                     Object[] row = new Object[4];
                    row[0] = o;
                    row[1] = o.getCustomer().getName();
                    row[2] = o.getMerchant().getMerchantName();
                    row[3] = o.getStatus();
                    deliveryTableModel.addRow(row);
             }
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deliveredBtn;
    private javax.swing.JTable deliveryTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sentBtn;
    // End of variables declaration//GEN-END:variables
}
