package view;

import controller.RentalController;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.MobilComboItem;
import model.MobilModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author USER
 */
public class Rental extends javax.swing.JFrame {

    private RentalController controller;

    public Rental() {
        initComponents();
        TanggalSewa.setDateFormatString("yyy/MM/dd");
        TanggalBalik.setDateFormatString("yyy/MM/dd");
        controller = new RentalController(this);
        controller.loadMobilToComboBox();
    }

    public void setMobilComboBoxItems(List<MobilComboItem> listMobil) {
        cCarID.removeAllItems();
        for (MobilComboItem item : listMobil) {
            cCarID.addItem(item); 
        }
    }

    public String getCustID() {
        return CustID.getText();
    }

    public void setNamaCustomer(String nama) {
        NamaCust.setText(nama);
    }

    public void setDateAwal() {
        LocalDate now = LocalDate.now();
        Date dateNow = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());

        TanggalSewa.setDate(dateNow);
        TanggalBalik.setDate(dateNow);

    }

    public JComboBox<MobilComboItem> getcCarID() {
        return cCarID;
    }

    public void setBiayaRental(String biaya) {
        biayaRental.setText(biaya);
    }

    public Date getTanggalSewa() {
        return TanggalSewa.getDate();
    }

    public Date getTanggalBalik() {
        return TanggalBalik.getDate();
    }

    public void showError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void showMessage(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void resetForm() {
        CustID.setText("");
        cCarID.setSelectedIndex(0);
        NamaCust.setText("");
        TanggalSewa.setDate(null);
        TanggalBalik.setDate(null);
        biayaRental.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        biayaRental = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cCarID = new javax.swing.JComboBox<>();
        CustID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NamaCust = new javax.swing.JTextField();
        TanggalSewa = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        TanggalBalik = new com.toedter.calendar.JDateChooser();
        btnRental = new javax.swing.JButton();
        Clear = new javax.swing.JButton();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Form Rental");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Rental"));

        biayaRental.setMinimumSize(new java.awt.Dimension(0, 30));
        biayaRental.setPreferredSize(new java.awt.Dimension(50, 30));
        biayaRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biayaRentalActionPerformed(evt);
            }
        });

        jLabel6.setText("Biaya Rental");

        jLabel7.setText("Tanggal Sewa");

        cCarID.setMinimumSize(new java.awt.Dimension(0, 30));
        cCarID.setPreferredSize(new java.awt.Dimension(50, 30));
        cCarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCarIDActionPerformed(evt);
            }
        });

        CustID.setMinimumSize(new java.awt.Dimension(0, 30));
        CustID.setPreferredSize(new java.awt.Dimension(50, 30));
        CustID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustIDActionPerformed(evt);
            }
        });
        CustID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CustIDKeyPressed(evt);
            }
        });

        jLabel2.setText("Customer ID");

        jLabel3.setText("Car ID");

        jLabel4.setText("Nama Customer");

        NamaCust.setMinimumSize(new java.awt.Dimension(0, 30));
        NamaCust.setPreferredSize(new java.awt.Dimension(50, 30));
        NamaCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaCustActionPerformed(evt);
            }
        });

        TanggalSewa.setMinimumSize(new java.awt.Dimension(0, 30));
        TanggalSewa.setPreferredSize(new java.awt.Dimension(50, 30));

        jLabel16.setText("Tanggal Kembali");

        TanggalBalik.setMinimumSize(new java.awt.Dimension(0, 30));
        TanggalBalik.setPreferredSize(new java.awt.Dimension(50, 30));

        btnRental.setBackground(new java.awt.Color(47, 129, 255));
        btnRental.setText("Submit");
        btnRental.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRentalMouseClicked(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(255, 0, 110));
        Clear.setText("Cancel");
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearMouseClicked(evt);
            }
        });
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TanggalBalik, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TanggalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(biayaRental, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NamaCust, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCarID, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustID, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRental, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Clear)
                .addGap(91, 91, 91))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CustID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cCarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NamaCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(biayaRental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TanggalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TanggalBalik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRental, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NamaCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaCustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaCustActionPerformed

    private void biayaRentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biayaRentalActionPerformed

    }//GEN-LAST:event_biayaRentalActionPerformed

    private void cCarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCarIDActionPerformed
        controller.loadHargaDanHitungTotal();
    }//GEN-LAST:event_cCarIDActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed

    }//GEN-LAST:event_ClearActionPerformed

    private void CustIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustIDActionPerformed
        controller.loadCustomerName();
    }//GEN-LAST:event_CustIDActionPerformed

    private void CustIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustIDKeyPressed

    }//GEN-LAST:event_CustIDKeyPressed

    private void btnRentalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRentalMouseClicked
        try {
            MobilComboItem selectedMobil = (MobilComboItem) cCarID.getSelectedItem();
            int mobilId = selectedMobil.getId();
            int Biaya = Integer.parseInt(biayaRental.getText());
            int custId = Integer.parseInt(CustID.getText());

            Date tglSewa = TanggalSewa.getDate();
            Date tglBalik = TanggalBalik.getDate();

            if (tglSewa == null || tglBalik == null) {
                JOptionPane.showMessageDialog(null, "Tanggal sewa dan tanggal balik harus diisi!");
                return;
            }
            controller.add(
                    mobilId,
                    custId,
                    tglSewa,
                    tglBalik,
                    Biaya
            );
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Harga sewa dan ID harus berupa angka!");
        }

    }//GEN-LAST:event_btnRentalMouseClicked

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
        dispose();
        new MainPage().setVisible(true);
    }//GEN-LAST:event_ClearMouseClicked

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
            java.util.logging.Logger.getLogger(Rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rental().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JTextField CustID;
    private javax.swing.JTextField NamaCust;
    private com.toedter.calendar.JDateChooser TanggalBalik;
    private com.toedter.calendar.JDateChooser TanggalSewa;
    private javax.swing.JTextField biayaRental;
    private javax.swing.JButton btnRental;
    private javax.swing.JComboBox<MobilComboItem> cCarID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    // End of variables declaration//GEN-END:variables
}
