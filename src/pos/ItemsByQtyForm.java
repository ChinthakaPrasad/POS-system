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
public class ItemsByQtyForm extends javax.swing.JFrame {

    /**
     * Creates new form ItemsByQtyForm
     */
    public ItemsByQtyForm() {
        initComponents();
        setLocationRelativeTo(null);

        Order temp[] = DBConnection.getOrderList().toArray();
        DefaultTableModel dtm = (DefaultTableModel) itemsByQtyTable.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        itemsByQtyTable.setDefaultRenderer(String.class, centerRenderer);
        itemsByQtyTable.setDefaultRenderer(Integer.class, centerRenderer);
        itemsByQtyTable.setDefaultRenderer(Double.class, centerRenderer);
        
        JTableHeader header = itemsByQtyTable.getTableHeader();
        header.setDefaultRenderer(centerRenderer);
        

        String tempSize[] = new String[6];
        int tempQty[] = new int[6];
        double tempTotal[] = new double[6];
        int j = 0;
        for (String a : OrderController.tShirtSizes) {
            tempSize[j] = a;
            j++;
        }

        for (int i = 0; i < temp.length; ++i) {
            String tempSizeEach = temp[i].getSize();
            switch (tempSizeEach) {
                case "XS":
                    tempQty[0] += temp[i].getQty();
                    tempTotal[0] += temp[i].getAmount();
                    break;
                case "S":
                    tempQty[1] += temp[i].getQty();
                    tempTotal[1] += temp[i].getAmount();
                    break;
                case "M":
                    tempQty[2] += temp[i].getQty();
                    tempTotal[2] += temp[i].getAmount();
                    break;
                case "L":
                    tempQty[3] += temp[i].getQty();
                    tempTotal[3] += temp[i].getAmount();
                    break;
                case "XL":
                    tempQty[4] += temp[i].getQty();
                    tempTotal[4] += temp[i].getAmount();
                    break;
                case "XXL":
                    tempQty[5] += temp[i].getQty();
                    tempTotal[5] += temp[i].getAmount();
                    break;
                default:
                    continue;
            }
        }
        for (int i = 0; i < 6; ++i) {
            for (int k = 0; k < 5; ++k) {
                if (tempQty[k] < tempQty[k + 1]) {
                    int tempQ = tempQty[k];
                    tempQty[k] = tempQty[k + 1];
                    tempQty[k + 1] = tempQ;
                    String tempS = tempSize[k];
                    tempSize[k] = tempSize[k + 1];
                    tempSize[k + 1] = tempS;
                    double tempA = tempTotal[k];
                    tempTotal[k] = tempTotal[k + 1];
                    tempTotal[k + 1] = tempA;
                }
            }
        }

        for (int i = 0; i < 6; ++i) {
            Object[] rowData = {tempSize[i], tempQty[i], tempTotal[i]};
            dtm.addRow(rowData);

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
        itemsByQtyTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Items By QTY");

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

        itemsByQtyTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemsByQtyTable.setModel(new javax.swing.table.DefaultTableModel(
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
        itemsByQtyTable.setRowHeight(65);
        jScrollPane1.setViewportView(itemsByQtyTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(ItemsByQtyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemsByQtyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemsByQtyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemsByQtyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemsByQtyForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTable itemsByQtyTable;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
