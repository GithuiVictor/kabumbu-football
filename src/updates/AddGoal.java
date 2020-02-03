/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.Common;
import static main.Common.CURRENT_SCHOOL;
import main.KabumbuFootballLeage;
import view.CoachRegestrationForm;

/**
 *
 * @author Victor
 */
public class AddGoal extends javax.swing.JFrame {

    /**
     * Creates new form AddGoal
     */
    public AddGoal() {
        initComponents();
        populateSchoolPlaying();
        popultePlayers();
        
    }
    
    
    
    public void populateSchoolPlaying(){
        selectSch.removeAllItems();
        String sql = "SELECT h.schoolname AS homeName, h.schoolid AS homeId, a.schoolname AS awayName, a.schoolid AS awayId "
                + "FROM schools h, schools a, fixtures f "
                + "WHERE h.schoolid  = f.homeTeam "
                + "AND a.schoolid = f.awayTeam "
                + "AND  f.matchid = ? ;";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Common.matchid);
            ResultSet rs = pstmt.executeQuery();
            String schoolH = "";
            int schoolHID = 0;
            String schoolA = "";
            int schoolAID = 0;
            while (rs.next()) {
                schoolHID = rs.getInt("homeId");
                schoolH = rs.getString("homeName");
                schoolAID = rs.getInt("awayId");
                schoolA = rs.getString("awayName");
                selectSch.addItem(schoolHID + ". " + schoolH);
                selectSch.addItem(schoolAID + ". " + schoolA);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CoachRegestrationForm.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    public void popultePlayers(){
        selectscorer.removeAllItems();
        String sql = "SELECT id, firstName, lastName FROM students where schoolid = ?;";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Common.schoolid);
            ResultSet rs = pstmt.executeQuery();
            int schoolID = 0;
            while (rs.next()) {
                schoolID = rs.getInt("id");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastName");
                selectscorer.addItem(schoolID + ". " + firstName +" " + lastName);

            }

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
        selectSch = new javax.swing.JComboBox<>();
        addBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        selectscorer = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD GOAL");

        selectSch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select School" }));
        selectSch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectSchItemStateChanged(evt);
            }
        });

        addBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        selectscorer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select scorer" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 167, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectSch, 0, 303, Short.MAX_VALUE)
                            .addComponent(selectscorer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(selectSch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectscorer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void selectSchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectSchItemStateChanged
        // TODO add your handling code here:
        if (selectSch.getSelectedItem() != null){
            String schoolNumber = selectSch.getSelectedItem().toString();
            String RealNumber = schoolNumber.substring(0, schoolNumber.indexOf("."));
            Common.schoolid=Integer.parseInt(RealNumber);
            popultePlayers();
        }
    }//GEN-LAST:event_selectSchItemStateChanged

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO goals (studentNumber, matchNumber, schoolNumber)"
                + "VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String StudentNumber = selectscorer.getSelectedItem().toString();
            String RealNumber = StudentNumber.substring(0, StudentNumber.indexOf(". "));
            
            int matchid = Common.matchid;
                    
            pstmt.setInt(1, Integer.parseInt(RealNumber));
            pstmt.setInt(2, matchid);
            pstmt.setInt(3, Common.schoolid);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Successfully Regestered!");
            setVisible(false);
            KabumbuFootballLeage.lgdr.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(KabumbuFootballLeage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddGoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddGoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddGoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddGoal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> selectSch;
    private javax.swing.JComboBox<String> selectscorer;
    // End of variables declaration//GEN-END:variables
}
