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
public class ItemsByAmountForm extends javax.swing.JFrame {

    /**
     * Creates new form ItemsByAmount
     */
    public ItemsByAmountForm() {
        initComponents();
        setLocationRelativeTo(null);

        Order temp[] = DBConnection.getOrderList().toArray();
        DefaultTableModel dtm = (DefaultTableModel) itemsByAmountTable.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        itemsByAmountTable.setDefaultRenderer(String.class, centerRenderer);
        itemsByAmountTable.setDefaultRenderer(Integer.class, centerRenderer);
        itemsByAmountTable.setDefaultRenderer(Double.class, centerRenderer);

        JTableHeader header = itemsByAmountTable.getTableHeader();
        header.setDefaultRenderer(centerRenderer);

        String tempSize2[] = new String[6];
        int tempQty2[] = new int[6];
        double tempTotal2[] = new double[6];
        int j = 0;
        for (String a : OrderController.tShirtSizes) {
            tempSize2[j] = a;
            j++;
        }

        for (int i = 0; i < temp.length; ++i) {
            String tempSizeEach2 = temp[i].getSize();
            switch (tempSizeEach2) {
                case "XS":
                    tempQty2[0] += temp[i].getQty();
                    tempTotal2[0] += temp[i].getAmount();
                    break;
                case "S":
                    tempQty2[1] += temp[i].getQty();
                    tempTotal2[1] += temp[i].getAmount();
                    break;
                case "M":
                    tempQty2[2] += temp[i].getQty();
                    tempTotal2[2] += temp[i].getAmount();
                    break;
                case "L":
                    tempQty2[3] += temp[i].getQty();
                    tempTotal2[3] += temp[i].getAmount();
                    break;
                case "XL":
                    tempQty2[4] += temp[i].getQty();
                    tempTotal2[4] += temp[i].getAmount();
                    break;
                case "XXL":
                    tempQty2[5] += temp[i].getQty();
                    tempTotal2[5] += temp[i].getAmount();
                    break;
                default:
                    continue;
            }
        }
        for (int i = 0; i < 6; ++i) {
            for (int k = 0; k < 5; ++k) {
                if (tempTotal2[k] < tempTotal2[k + 1]) {
                    double tempA2 = tempTotal2[k];
                    tempTotal2[k] = tempTotal2[k + 1];
                    tempTotal2[k + 1] = tempA2;
                    int temp2 = tempQty2[k];
                    tempQty2[k] = tempQty2[k + 1];
                    tempQty2[k + 1] = temp2;
                    String tempS2 = tempSize2[k];
                    tempSize2[k] = tempSize2[k + 1];
                    tempSize2[k + 1] = tempS2;

                }
            }
        }

        for (int i = 0; i < 6; ++i) {
            Object[] dataRow = {tempSize2[i], tempQty2[i], tempTotal2[i]};
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
        itemsByAmountTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Items By Amounts");

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

        itemsByAmountTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemsByAmountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Size", "QTY", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        itemsByAmountTable.setRowHeight(65);
        jScrollPane1.setViewportView(itemsByAmountTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(ItemsByAmountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemsByAmountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemsByAmountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemsByAmountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemsByAmountForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTable itemsByAmountTable;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}