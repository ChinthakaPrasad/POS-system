/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import static java.awt.Component.CENTER_ALIGNMENT;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Chinthaka Prasad
 */
public class AllCustomerForm extends javax.swing.JFrame {

    /**
     * Creates new form AllCustomerForm
     */
    public AllCustomerForm() {
        initComponents();
        setLocationRelativeTo(null);

        Order temp[] = DBConnection.getOrderList().toArray();
        DefaultTableModel dtm= (DefaultTableModel) allCustomerTable.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        allCustomerTable.setDefaultRenderer(String.class, centerRenderer);
        allCustomerTable.setDefaultRenderer(Integer.class, centerRenderer);
        allCustomerTable.setDefaultRenderer(Double.class, centerRenderer);
        
        JTableHeader header = allCustomerTable.getTableHeader();
        header.setDefaultRenderer(centerRenderer);

        String tempNumForAll[] = new String[0];
        int tempQtyForAll[] = new int[6];
        double tempAmountForAll[] = new double[6];
        for (int i = 0; i < temp.length; ++i) {
            boolean notAdd = true;
            for (int j = 0; j < tempNumForAll.length; ++j) {
                if (temp[i].getPNum().equals(tempNumForAll[j])) {
                    notAdd = false;
                    continue;
                }
            }
            if (notAdd) {
                tempNumForAll = OrderController.extendStringArray(tempNumForAll);
                tempNumForAll[tempNumForAll.length - 1] = temp[i].getPNum();
            }
        }

        int totalQtyForAll[] = new int[tempNumForAll.length];
        double totalAmountForAll[] = new double[tempNumForAll.length];
        for (int i = 0; i < tempNumForAll.length; ++i) {
            for (int z = 0; z < 6; ++z) {
                tempQtyForAll[z] = 0;
                tempAmountForAll[z] = 0;
            }

            for (int j = 0; j < temp.length; ++j) {
                if (tempNumForAll[i].equals(temp[j].getPNum())) {
                    switch (temp[j].getSize()) {
                        case "XS":
                            tempQtyForAll[0] += temp[j].getQty();
                            tempAmountForAll[0] += temp[j].getAmount();
                            break;
                        case "S":
                            tempQtyForAll[1] += temp[j].getQty();
                            tempAmountForAll[1] += temp[j].getAmount();
                            break;
                        case "M":
                            tempQtyForAll[2] += temp[j].getQty();
                            tempAmountForAll[2] += temp[j].getAmount();
                            break;
                        case "L":
                            tempQtyForAll[3] += temp[j].getQty();
                            tempAmountForAll[3] += temp[j].getAmount();
                            break;
                        case "XL":
                            tempQtyForAll[4] += temp[j].getQty();
                            tempAmountForAll[4] += temp[j].getAmount();
                            break;
                        case "XXL":
                            tempQtyForAll[5] += temp[j].getQty();
                            tempAmountForAll[5] += temp[j].getAmount();
                            break;
                    }
                }
            }
            double totalForAll = 0;
            for (int k = 0; k < 6; ++k) {
                totalForAll += tempAmountForAll[k];
            }

            Object[] dataRow = {tempNumForAll[i], tempQtyForAll[0], tempQtyForAll[1], tempQtyForAll[2], tempQtyForAll[3], tempQtyForAll[4], tempQtyForAll[5], totalForAll};
            dtm.addRow(dataRow);
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

        jLabel7 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        allCustomerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("All Orders");

        jLabel7.setBackground(new java.awt.Color(51, 51, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fashion Shop");
        jLabel7.setOpaque(true);

        backBtn.setBackground(new java.awt.Color(255, 153, 153));
        backBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        allCustomerTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        allCustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "XS", "S", "M", "L", "XL", "XXL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        allCustomerTable.setRowHeight(24);
        jScrollPane1.setViewportView(allCustomerTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AllCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllCustomerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allCustomerTable;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}