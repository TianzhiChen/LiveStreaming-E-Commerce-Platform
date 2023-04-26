/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.AdvertisementWorkArea;

import Business.Business;
import Business.Delivery.DeliveryAgent;
import Business.Merchant.Merchant;
import Business.ProductSchedule.Schedule;
import Business.UserAccount.UserAccount;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tianzhichen
 */
public class ViewAdJPanel extends javax.swing.JPanel {

    Business business;
    UserAccount userAccount;
    DefaultTableModel tableModel;

    /**
     * Creates new form ViewAdJPanel
     */
    public ViewAdJPanel() {
        initComponents();
    }

    public ViewAdJPanel(Business business, UserAccount userAccount) {
        initComponents();
        this.business = business;
        this.userAccount = userAccount;
        this.tableModel = (DefaultTableModel) viewAdTable.getModel();
        populate();
    }

    public void populate() {
        tableModel.setRowCount(0);
        Merchant m = this.business.getMerchantDirectory().findMerchantByName(this.userAccount.getUsername());
        for (Schedule s : m.getScheduleDirectory().getScheduleList()) {
            
            Object[] row = new Object[4];
            row[0] = s;
            row[1] = s.getMerchant();
            row[2] = s.getAdvertisement();
            row[3] = s.getAdvertisement().getPopularity();
            
            tableModel.addRow(row);
        }
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
        viewAdTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewAdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Schedule", "Merchant", "Ad ", "Popularity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(viewAdTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 51, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable viewAdTable;
    // End of variables declaration//GEN-END:variables
}
