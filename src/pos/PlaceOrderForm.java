/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Chinthaka Prasad
 */
public class PlaceOrderForm extends javax.swing.JFrame {

    /**
     * Creates new form PlaceOrderForm
     */
    public PlaceOrderForm() {
        initComponents();
        setLocationRelativeTo(null);
        orderIdGenarateLabel.setText(OrderController.genarateOrderId());

        DocumentListener documentListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                if (OrderController.checkSize(sizeText.getText())) {
                    amountCheck();
                } else {
                    amountGenarateLabel.setText("");
                }

            }

            public void changedUpdate(DocumentEvent e) {
                if (OrderController.checkSize(sizeText.getText())) {
                    amountCheck();
                } else {
                    amountGenarateLabel.setText("");
                }
            }

            public void removeUpdate(DocumentEvent e) {
                if (OrderController.checkSize(sizeText.getText())) {
                    amountCheck();
                } else {
                    amountGenarateLabel.setText("");
                }
            }

            private void amountCheck() {

                String tempQty = qtyText.getText();
                String tempSize = sizeText.getText();

                if (!qtyText.getText().isEmpty() && (!sizeText.getText().isEmpty())) {
                    String str = Double.toString(OrderController.calculateAmount(sizeText.getText().toUpperCase(), Integer.parseInt(qtyText.getText())));
                    amountGenarateLabel.setText(str);
                } else {
                    amountGenarateLabel.setText("");
                }

            }

        };

        qtyText.getDocument().addDocumentListener(documentListener);
        sizeText.getDocument().addDocumentListener(documentListener);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        amountGenarateLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sizeText = new javax.swing.JTextField();
        customerIdText = new javax.swing.JTextField();
        qtyText = new javax.swing.JTextField();
        placeBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        orderIdGenarateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Place Order");

        backBtn.setBackground(new java.awt.Color(255, 153, 153));
        backBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        amountGenarateLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        amountGenarateLabel.setText("0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Size                  :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Amount           :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Customer ID  :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("QTY                  :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Order ID        :");

        sizeText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sizeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeTextActionPerformed(evt);
            }
        });

        customerIdText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customerIdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIdTextActionPerformed(evt);
            }
        });

        qtyText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        qtyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyTextActionPerformed(evt);
            }
        });
        qtyText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyTextKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyTextKeyTyped(evt);
            }
        });

        placeBtn.setBackground(new java.awt.Color(0, 153, 153));
        placeBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        placeBtn.setForeground(new java.awt.Color(255, 255, 255));
        placeBtn.setText("Place");
        placeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeBtnActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(51, 51, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fashion Shop");
        jLabel7.setOpaque(true);

        orderIdGenarateLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        orderIdGenarateLabel.setText("ODR#00001");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qtyText, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sizeText, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountGenarateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderIdGenarateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(placeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderIdGenarateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtyText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountGenarateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(placeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void sizeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeTextActionPerformed
        // TODO add your handling code here:      
    }//GEN-LAST:event_sizeTextActionPerformed

    private void customerIdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIdTextActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_customerIdTextActionPerformed

    private void qtyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyTextActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_qtyTextActionPerformed

    private void placeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeBtnActionPerformed
        // TODO add your handling code here:

        boolean isValidNum = OrderController.checkNum(customerIdText.getText());
        boolean isValidSize = OrderController.checkSize(sizeText.getText());

        if (!customerIdText.getText().isEmpty()) {
            if (!isValidNum) {
                JOptionPane.showMessageDialog(this, "Invalid Number..Re-check!");
                customerIdText.setText("");
            } else {
                if (!sizeText.getText().isEmpty()) {
                    if (!isValidSize) {
                        JOptionPane.showMessageDialog(this, "Invalid Size..Re-chek!");
                        sizeText.setText("");
                    } else {
                        String customerId = customerIdText.getText();
                        String size = sizeText.getText().toUpperCase();
                        int qty = Integer.parseInt(qtyText.getText());
                        Order order = new Order(orderIdGenarateLabel.getText(), customerId, size, qty, Double.parseDouble(amountGenarateLabel.getText()), OrderController.orderStatus[0]);
                        boolean isAdded= OrderController.addOrder(order);
                        if(isAdded){
                            JOptionPane.showMessageDialog(this, "Order Placed..");
                            dispose();
                        }

                    }
                }
            }
        }


    }//GEN-LAST:event_placeBtnActionPerformed

    private void qtyTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyTextKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_qtyTextKeyTyped

    private void qtyTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyTextKeyReleased
        // TODO add your handling code here:
        try {
            Integer.parseInt(qtyText.getText());

        } catch (NumberFormatException e) {
            qtyText.setText("");
        }
        int qty = Integer.parseInt(qtyText.getText());

        if (qty <= 0) {
            qtyText.setText("");
        }
    }//GEN-LAST:event_qtyTextKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
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
            java.util.logging.Logger.getLogger(PlaceOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                new PlaceOrderForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountGenarateLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField customerIdText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel orderIdGenarateLabel;
    private javax.swing.JButton placeBtn;
    private javax.swing.JTextField qtyText;
    private javax.swing.JTextField sizeText;
    // End of variables declaration//GEN-END:variables
}
