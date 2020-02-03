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
import main.KabumbuFootballLeage;
import view.CoachRegestrationForm;

/**
 *
 * @author Victor
 */
public class RefereeUpdate extends javax.swing.JFrame {

    /**
     * Creates new form RefereeUpdate
     */
    public RefereeUpdate() {
        initComponents();
        String sql = "SELECT schoolname, schoolid FROM schools;";
        jComboBox1.removeAllItems();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String schoolN = rs.getString("schoolname");
                int schoolID = rs.getInt("schoolid");
                jComboBox1.addItem(schoolN);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoachRegestrationForm.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public void populateRefereeUpdate() {
        String sql = "SELECT referees.*, schools.schoolname FROM referees, schools WHERE  schools.schoolid = referees.schoolid AND referees.id = ?;";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Common.refereeid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                firstNameTF.setText(rs.getString("firstname"));
                lastNameTf.setText(rs.getString("lastname"));
                dateOfBirthTf.setText(rs.getDate("dateOfBirth") + "");
                schoolIdTf.setText(rs.getInt("schoolid") + "");
                nationalIdTf.setText(rs.getInt("nationalid") + "");
                phoneNumberTf.setText(rs.getInt("phoneNumber") + "");
                emailAddressTf.setText(rs.getString("emailAddress"));
                if (rs.getString("sex").contentEquals("male")) {
                    maleRBtn.setSelected(true);
                    femaleRBtn.setSelected(false);
                } else {
                    maleRBtn.setSelected(false);
                    femaleRBtn.setSelected(true);
                }
                yearBeganRefering.setValue(rs.getInt("yearBeganReferee"));
                jComboBox1.setSelectedItem(rs.getString("schoolTeam"));
                if (rs.getString("willingToRefereeInterCountyGames").contentEquals("Yes")) {
                    yesRBtn.setSelected(true);
                    noRBtn.setSelected(false);
                } else {
                    yesRBtn.setSelected(false);
                    noRBtn.setSelected(true);
                }

                if (rs.getString("gradeOfReferee").contentEquals("Juvenile")) {
                    juvenileCheckBox.setSelected(true);
                    minorCheckBox.setSelected(false);
                    seniorCheckBox.setSelected(false);
                } else if (rs.getString("gradeOfReferee").contentEquals("Minor")) {
                    juvenileCheckBox.setSelected(false);
                    minorCheckBox.setSelected(true);
                    seniorCheckBox.setSelected(false);
                } else {
                    juvenileCheckBox.setSelected(false);
                    minorCheckBox.setSelected(false);
                    seniorCheckBox.setSelected(true);
                }

                if (rs.getString("availableForSecondLevelGames").contentEquals("All Time")) {
                    allTimeCheckBox.setSelected(true);
                    weekdaysCheckBox.setSelected(false);
                    weekendCheckBox.setSelected(false);
                } else if (rs.getString("availableForSecondLevelGames").contentEquals("Week-days")) {
                    allTimeCheckBox.setSelected(false);
                    weekdaysCheckBox.setSelected(true);
                    weekendCheckBox.setSelected(false);
                } else {
                    allTimeCheckBox.setSelected(false);
                    weekdaysCheckBox.setSelected(false);
                    weekendCheckBox.setSelected(true);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(RefereeUpdate.class.getName()).log(Level.SEVERE, null, ex);
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

        maleOrFemale = new javax.swing.ButtonGroup();
        yesOrNo = new javax.swing.ButtonGroup();
        refereeGrades = new javax.swing.ButtonGroup();
        Availability = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstNameTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastNameTf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateOfBirthTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        schoolIdTf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nationalIdTf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        phoneNumberTf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        emailAddressTf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        maleRBtn = new javax.swing.JRadioButton();
        femaleRBtn = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        yearBeganRefering = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        yesRBtn = new javax.swing.JRadioButton();
        noRBtn = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        juvenileCheckBox = new javax.swing.JCheckBox();
        minorCheckBox = new javax.swing.JCheckBox();
        seniorCheckBox = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        allTimeCheckBox = new javax.swing.JCheckBox();
        weekdaysCheckBox = new javax.swing.JCheckBox();
        weekendCheckBox = new javax.swing.JCheckBox();
        updateBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REFEREE UPDATES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Last Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Date Of Birth");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("School Id");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("National Id");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Phone Number");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Email Address");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Sex");

        maleOrFemale.add(maleRBtn);
        maleRBtn.setText("Male");

        maleOrFemale.add(femaleRBtn);
        femaleRBtn.setText("Female");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Since when did you begine referee?  Year");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("School Team");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select school" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Are you willing to referee inter-county games?");

        yesOrNo.add(yesRBtn);
        yesRBtn.setText("yes");

        yesOrNo.add(noRBtn);
        noRBtn.setText("No");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("If yes which grades do you referee?");

        refereeGrades.add(juvenileCheckBox);
        juvenileCheckBox.setText("Juvenile");

        refereeGrades.add(minorCheckBox);
        minorCheckBox.setText("Minor");

        refereeGrades.add(seniorCheckBox);
        seniorCheckBox.setText("Senior");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Are you available to referee second level games?");

        Availability.add(allTimeCheckBox);
        allTimeCheckBox.setText("All time");

        Availability.add(weekdaysCheckBox);
        weekdaysCheckBox.setText("Week days");

        Availability.add(weekendCheckBox);
        weekendCheckBox.setText("Weekends");

        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(weekendCheckBox)
                    .addComponent(weekdaysCheckBox)
                    .addComponent(allTimeCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(yesRBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noRBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seniorCheckBox)
                                    .addComponent(minorCheckBox)
                                    .addComponent(juvenileCheckBox)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(schoolIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(nationalIdTf))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(firstNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dateOfBirthTf)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lastNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(phoneNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(emailAddressTf, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(maleRBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(femaleRBtn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(yearBeganRefering, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateOfBirthTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(schoolIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nationalIdTf, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAddressTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maleRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(femaleRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearBeganRefering, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yesRBtn)
                    .addComponent(noRBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(juvenileCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minorCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seniorCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allTimeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weekdaysCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weekendCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        String sql = "UPDATE referees "
                + "SET firstname = ?, lastname = ?, dateOfBirth = ?, schoolid = ?, nationalid = ?, phoneNumber = ?, emailAddress = ?, sex = ?, yearBeganReferee = ?, schoolteam = ?, willingToRefereeInterCountyGames = ?, gradeOfReferee = ?, availableForSecondLevelGames = ? "
                + "WHERE id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String fName = firstNameTF.getText();
            String lName = lastNameTf.getText();
            String date = dateOfBirthTf.getText();
            int schoolid = Integer.parseInt(schoolIdTf.getText());
            int nationalid = Integer.parseInt(nationalIdTf.getText());
            int phoneNumber = Integer.parseInt(phoneNumberTf.getText());
            String emailAddress = emailAddressTf.getText();
            String sex;
            if (maleRBtn.isSelected()) {
                sex = "male";
            } else {
                sex = "female";
            }
            int yearBeganReferee = Integer.parseInt(yearBeganRefering.getValue().toString());
            String schoolCoaching = jComboBox1.getSelectedItem().toString();
            String willingInterCountyGames;
            if (yesRBtn.isSelected()) {
                willingInterCountyGames = "Yes";
            } else {
                willingInterCountyGames = "No";
            }
            String refereeGrade;
            if (juvenileCheckBox.isSelected()) {
                refereeGrade = "Juvenile";
            } else if (minorCheckBox.isSelected()) {
                refereeGrade = "Minor";
            } else {
                refereeGrade = "Senior";
            }
            String availableSecondLevel;
            if (allTimeCheckBox.isSelected()) {
                availableSecondLevel = "All Time";
            } else if (weekdaysCheckBox .isSelected()) {
                availableSecondLevel = "Week-days";
            } else {
                availableSecondLevel = "Weekends";
            }

            pstmt.setString(1, fName);
            pstmt.setString(2, lName);
            pstmt.setString(3, date);
            pstmt.setInt(4, schoolid);
            pstmt.setInt(5, nationalid);
            pstmt.setInt(6, phoneNumber);
            pstmt.setString(7, emailAddress);
            pstmt.setString(8, sex);
            pstmt.setInt(9, yearBeganReferee);
            pstmt.setString(10, schoolCoaching);
            pstmt.setString(11, willingInterCountyGames);
            pstmt.setString(12, refereeGrade);
            pstmt.setString(13, availableSecondLevel);
            pstmt.setInt(14, Common.refereeid);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Successfully !");
            setVisible(false);
            KabumbuFootballLeage.rrhp.populateReferee();
            KabumbuFootballLeage.rrhp.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(KabumbuFootballLeage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_updateBtnActionPerformed

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
            java.util.logging.Logger.getLogger(RefereeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RefereeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RefereeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RefereeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RefereeUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Availability;
    private javax.swing.JCheckBox allTimeCheckBox;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField dateOfBirthTf;
    private javax.swing.JTextField emailAddressTf;
    private javax.swing.JRadioButton femaleRBtn;
    private javax.swing.JTextField firstNameTF;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox juvenileCheckBox;
    private javax.swing.JTextField lastNameTf;
    private javax.swing.ButtonGroup maleOrFemale;
    private javax.swing.JRadioButton maleRBtn;
    private javax.swing.JCheckBox minorCheckBox;
    private javax.swing.JTextField nationalIdTf;
    private javax.swing.JRadioButton noRBtn;
    private javax.swing.JTextField phoneNumberTf;
    private javax.swing.ButtonGroup refereeGrades;
    private javax.swing.JTextField schoolIdTf;
    private javax.swing.JCheckBox seniorCheckBox;
    private javax.swing.JButton updateBtn;
    private javax.swing.JCheckBox weekdaysCheckBox;
    private javax.swing.JCheckBox weekendCheckBox;
    private javax.swing.JSpinner yearBeganRefering;
    private javax.swing.ButtonGroup yesOrNo;
    private javax.swing.JRadioButton yesRBtn;
    // End of variables declaration//GEN-END:variables
}
