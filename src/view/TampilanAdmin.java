/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.TampilanAdminController;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.UserModel;

/**
 *
 * @author Asus
 */
public class TampilanAdmin extends javax.swing.JFrame {

    private TampilanAdminController controller;
    
    public TampilanAdmin() {
        initComponents();
        controller = new TampilanAdminController(this);
    }
    
    public void setTabel(List<UserModel> list){
        var model = (DefaultTableModel) dataPetugas.getModel();
        model.setRowCount(0);
        for(var user: list){
            model.addRow(new Object[]{
                user.getId(),
                user.getUsername(),
                user.getPassword()
            });
        }
    }
    
      public void showError(String pesan){
        JOptionPane.showMessageDialog(this, pesan);
    }
      
     public void setSelected(UserModel user){
         if(user == null){
            User.setText("");
            Pass.setText("");
         }else{
         User.setText(user.getUsername());
         Pass.setText(user.getPassword());
         }
     }

    public JButton getBtnTambahMobil() {
        return btnTambahMobil;
    }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        dataPetugas = new javax.swing.JTable();
        User = new javax.swing.JTextField();
        Pass = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TambahP = new javax.swing.JButton();
        EditP = new javax.swing.JButton();
        DeleteP = new javax.swing.JButton();
        btnTambahMobil = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard Admin");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        dataPetugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Username", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataPetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataPetugasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataPetugas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        User.setMinimumSize(new java.awt.Dimension(60, 30));
        User.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 20);
        getContentPane().add(User, gridBagConstraints);

        Pass.setMinimumSize(new java.awt.Dimension(60, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 20);
        getContentPane().add(Pass, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        TambahP.setBackground(new java.awt.Color(51, 211, 19));
        TambahP.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        TambahP.setText("Tambah");
        TambahP.setMinimumSize(new java.awt.Dimension(72, 27));
        TambahP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 0, 20);
        getContentPane().add(TambahP, gridBagConstraints);

        EditP.setBackground(new java.awt.Color(51, 221, 211));
        EditP.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        EditP.setText("Edit");
        EditP.setMinimumSize(new java.awt.Dimension(72, 27));
        EditP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 20);
        getContentPane().add(EditP, gridBagConstraints);

        DeleteP.setBackground(new java.awt.Color(255, 5, 79));
        DeleteP.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        DeleteP.setText("Delete");
        DeleteP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        DeleteP.setMinimumSize(new java.awt.Dimension(72, 27));
        DeleteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 20);
        getContentPane().add(DeleteP, gridBagConstraints);

        btnTambahMobil.setBackground(new java.awt.Color(51, 102, 255));
        btnTambahMobil.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnTambahMobil.setText("Tambahkan Mobil");
        btnTambahMobil.setMaximumSize(new java.awt.Dimension(72, 23));
        btnTambahMobil.setMinimumSize(new java.awt.Dimension(75, 30));
        btnTambahMobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMobilMouseClicked(evt);
            }
        });
        btnTambahMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahMobilActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(30, 10, 0, 20);
        getContentPane().add(btnTambahMobil, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Tambahkan Petugas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jLabel3, gridBagConstraints);

        setSize(new java.awt.Dimension(624, 388));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EditPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditPActionPerformed
      controller.edit(User.getText(), Pass.getText());
    }//GEN-LAST:event_EditPActionPerformed

    private void DeletePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePActionPerformed
       controller.delete();
    }//GEN-LAST:event_DeletePActionPerformed

    private void TambahPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPActionPerformed
    controller.add(User.getText(), Pass.getText());
    }//GEN-LAST:event_TambahPActionPerformed

    private void dataPetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataPetugasMouseClicked
        controller.updateSelected(dataPetugas.getSelectedRow());
    }//GEN-LAST:event_dataPetugasMouseClicked

    private void btnTambahMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahMobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahMobilActionPerformed

    private void btnTambahMobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMobilMouseClicked
        controller.TambahkanMobil();
    }//GEN-LAST:event_btnTambahMobilMouseClicked

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
            java.util.logging.Logger.getLogger(TampilanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TampilanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TampilanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TampilanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TampilanAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteP;
    private javax.swing.JButton EditP;
    private javax.swing.JTextField Pass;
    private javax.swing.JButton TambahP;
    private javax.swing.JTextField User;
    private javax.swing.JButton btnTambahMobil;
    private javax.swing.JTable dataPetugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
