/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.Common;
import main.KabumbuFootballLeage;

/**
 *
 * @author Victor
 */
public class RefereeRegesteredHomePage extends javax.swing.JFrame {

    /**
     * Creates new form RefereeRegesteredHomePage
     */
    public RefereeRegesteredHomePage() {
        initComponents();
        populateReferee();
    }

    public void populateReferee() {

        Vector<String> columnNames = new Vector<>();
        columnNames.add("id");
        columnNames.add("Referee Name");
        columnNames.add("School ID");
        columnNames.add("Phone Number");
        columnNames.add("Email");
        columnNames.add("School From");

        Vector<Vector<Object>> data = new Vector<>();

        String sql = "SELECT * FROM referees;";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector<Object> row = new Vector<>();

                row.add(rs.getInt("id"));
                row.add(rs.getString("firstname") + rs.getString("lastname"));
                row.add(rs.getString("schoolid"));
                row.add(rs.getString("phoneNumber"));
                row.add(rs.getString("emailAddress"));
                row.add(rs.getString("schoolTeam"));

                data.add(row);

            }
            tableReferee.setModel(new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(CoachRegestrationForm.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        refereeRegisterBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReferee = new javax.swing.JTable();
        deleteRecordBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REFEREE REGESTERED");

        refereeRegisterBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        refereeRegisterBtn.setText("Regester Referee");
        refereeRegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refereeRegisterBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        tableReferee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "School Id", "Nationa Id", "Phone Number", "Email Address", "Gender", "Referee Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableReferee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRefereeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableReferee);

        deleteRecordBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        deleteRecordBtn.setText("Delete Record");
        deleteRecordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRecordBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refereeRegisterBtn))
                            .addComponent(deleteRecordBtn, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(deleteRecordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refereeRegisterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        KabumbuFootballLeage.hp.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void refereeRegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refereeRegisterBtnActionPerformed
        // TODO add your handling code here:
        KabumbuFootballLeage.rrf.setVisible(true);
    }//GEN-LAST:event_refereeRegisterBtnActionPerformed

    private void deleteRecordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRecordBtnActionPerformed
        // TODO add your handling code here:
        int row = tableReferee.getSelectedRow();
        int refereeId = Integer.parseInt(tableReferee.getValueAt(row, 0).toString());

        String sql = "DELETE FROM referees WHERE id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, refereeId);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Successfully Deleted!!");
            populateReferee();

        } catch (SQLException ex) {
            Logger.getLogger(KabumbuFootballLeage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteRecordBtnActionPerformed

    private void tableRefereeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRefereeMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            JTable source = (JTable) evt.getSource();
            int row = source.rowAtPoint(evt.getPoint());

            Common.refereeid = Integer.parseInt(source.getModel().getValueAt(row, 0).toString());

            KabumbuFootballLeage.rup.populateRefereeUpdate();

            KabumbuFootballLeage.rup.setVisible(true);
        }

    }//GEN-LAST:event_tableRefereeMouseClicked

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
            java.util.logging.Logger.getLogger(RefereeRegesteredHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RefereeRegesteredHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RefereeRegesteredHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RefereeRegesteredHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RefereeRegesteredHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteRecordBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refereeRegisterBtn;
    private javax.swing.JTable tableReferee;
    // End of variables declaration//GEN-END:variables
}
