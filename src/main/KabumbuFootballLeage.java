package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import updates.AddGoal;
import updates.AddPenalty;
import updates.CoachUpdate;
import updates.FixtureUpdate;
import updates.RefereeUpdate;
import updates.SchoolUpdate;
import updates.StudentUpdate;
import view.CoachRegesteredHomePage;
import view.SchoolRegestrationConfirmation;
import view.LogIn;
import view.RefereeRegestration;
import view.SchoolRegestrationHomePage;
import view.HomePage;
import view.RefereeRegestrationConfirmatiom;
import view.CoachRegestrationFormConfirmation;
import view.CoachRegestrationForm;
import view.LiveGameDetailRegistration;
import view.MatchRegistration;
import view.MatchRegistrationConfirmation;
import view.RefereeRegesteredHomePage;
import view.SchoolRegestration;
import view.StudentRegestrationConfirmation;
import view.StudentRegestrationForm;
import view.StudentsRegesteredHomepage;
import view.TheLeageTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Victor
 */
public class KabumbuFootballLeage {

    public static LogIn login;
    public static HomePage hp;
    public static SchoolRegestration srf;
    public static SchoolRegestrationConfirmation srfc;
    public static SchoolRegestrationHomePage srhp;
    public static CoachRegesteredHomePage crhp;
    public static CoachRegestrationForm crf;
    public static CoachRegestrationFormConfirmation crfc;
    public static RefereeRegesteredHomePage rrhp;
    public static RefereeRegestration rrf;
    public static RefereeRegestrationConfirmatiom rrfc;
    public static StudentsRegesteredHomepage strhp;
    public static StudentRegestrationForm strf;
    public static StudentRegestrationConfirmation strc;
    public static TheLeageTable lt;
    public static LiveGameDetailRegistration lgdr;
    public static MatchRegistration mr;
    public static MatchRegistrationConfirmation mrc;
    
    public static AddGoal ag;
    public static AddPenalty ap;
    public static FixtureUpdate fup;
    
    
    public static CoachUpdate cup;
    public static RefereeUpdate rup;
    public static SchoolUpdate scup;
    public static StudentUpdate stup;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KabumbuFootballLeage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(KabumbuFootballLeage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(KabumbuFootballLeage.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS schools ("
                    + "schoolid INT NOT NULL,"
                    + "schoolname VARCHAR(200) NOT NULL,"
                    + "pobox INT NOT NULL,"
                    + "postalcode INT NOT NULL,"
                    + "city VARCHAR(200) NOT NULL,"
                    + "amountpaid INT NOT NULL,"
                    + "PRIMARY KEY (schoolid));";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS students ("
                    + "id INT AUTO_INCREMENT,"
                    + "firstName VARCHAR(50) NOT NULL,"
                    + "lastName VARCHAR(50) NOT NULL,"
                    + "schoolid INT NOT NULL,"
                    + "dateOfBirth DATE NOT NULL,"
                    + "registrationNumber INT NOT NULL,"
                    + "email VARCHAR(50),"
                    + "PRIMARY KEY (id),"
                    + "FOREIGN KEY (schoolid) REFERENCES schools (schoolid));";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS coach ("
                    + "id INT AUTO_INCREMENT,"
                    + "firstName VARCHAR(50) NOT NULL,"
                    + "lastName VARCHAR(50) NOT NULL,"
                    + "schoolid INT NOT NULL, "
                    + "dateOfBirth DATE NOT NULL,"
                    + "nationalId INT NOT NULL,"
                    + "phoneNumber INT NOT NULL, "
                    + "email VARCHAR(50) NOT NULL, "
                    + "schoolCoaching VARCHAR(200) NOT NULL, "
                    + "medicalIssue VARCHAR(200) NOT NULL, "
                    + "explanation VARCHAR(200), "
                    + "PRIMARY KEY (id), "
                    + "FOREIGN KEY (schoolid) REFERENCES schools (schoolid));";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS referees ("
                    + "id INT AUTO_INCREMENT,"
                    + "firstname VARCHAR(50) NOT NULL,"
                    + "lastname VARCHAR(50) NOT NULL,"
                    + "dateOfBirth DATE NOT NULL,"
                    + "schoolid INT NOT NULL,"
                    + "nationalid INT NOT NULL,"
                    + "phoneNumber INT NOT NULL,"
                    + "emailAddress VARCHAR(200) NOT NULL,"
                    + "sex VARCHAR(200) NOT NULL,"
                    + "yearBeganReferee VARCHAR(200) NOT NULL,"
                    + "schoolTeam VARCHAR(200) NOT NULL,"
                    + "willingToRefereeInterCountyGames VARCHAR(50) NOT NULL,"
                    + "gradeOfReferee VARCHAR(200) NOT NULL,"
                    + "availableForSecondLevelGames VARCHAR(200) NOT NULL,"
                    + "PRIMARY KEY (id),"
                    + "FOREIGN KEY (schoolid) REFERENCES schools (schoolid));";
            stmt.executeUpdate(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS fixtures("
                    + "matchid INT AUTO_INCREMENT,"
                    + "homeTeam INT NOT NULL,"
                    + "awayTeam INT NOT NULL,"
                    + "dateTime TIMESTAMP NOT NULL,"
                    + "refereeOfficiating INT NOT NULL,"
                    + "PRIMARY KEY (matchid),"
                    + "FOREIGN KEY (homeTeam) REFERENCES schools (schoolid),"
                    + "FOREIGN KEY (awayTeam) REFERENCES schools (schoolid),"
                    + "FOREIGN KEY (refereeOfficiating) REFERENCES referees (id));";
            stmt.executeUpdate(sql);
            
            sql = " CREATE TABLE IF NOT EXISTS Goals( "
                    + "goalid INT AUTO_INCREMENT, "
                    + "studentNumber INT NOT NULL, "
                    + "matchNumber INT NOT NULL, "
                    + "schoolNumber INT NOT NULL, "
                    + "PRIMARY KEY (goalid), "
                    + "FOREIGN KEY (studentNumber) REFERENCES students (id), "
                    + "FOREIGN KEY (matchNumber) REFERENCES fixtures (matchid), "
                    + "FOREIGN KEY (schoolNumber) REFERENCES schools (schoolid)); ";
                stmt.executeUpdate(sql);
            
            sql = " CREATE TABLE IF NOT EXISTS Penalties ( "
                    + "penaltyid INT AUTO_INCREMENT, "
                    + "studentNum INT NOT NULL, "
                    + "matchNum INT NOT NULL, "
                    + "schoolNum INT NOT NULL, "
                    + "PRIMARY KEY (penaltyid), "
                    + "FOREIGN KEY (studentNum) REFERENCES students (id), "
                    + "FOREIGN KEY (matchNum) REFERENCES fixtures (matchid), "
                    + "FOREIGN KEY (schoolNum) REFERENCES schools (schoolid)); ";
            stmt.executeUpdate(sql);

            login = new LogIn();
            hp = new HomePage();
            srf = new SchoolRegestration();
            srfc = new SchoolRegestrationConfirmation();
            srhp = new SchoolRegestrationHomePage();
            crhp = new CoachRegesteredHomePage();
            crf = new CoachRegestrationForm();
            crfc = new CoachRegestrationFormConfirmation();
            rrhp = new RefereeRegesteredHomePage();
            rrf = new RefereeRegestration();
            rrfc = new RefereeRegestrationConfirmatiom();
            strhp = new StudentsRegesteredHomepage();
            strf = new StudentRegestrationForm();
            strc = new StudentRegestrationConfirmation();
            lt = new TheLeageTable();
            lgdr = new LiveGameDetailRegistration();
            mr = new MatchRegistration();
            mrc = new MatchRegistrationConfirmation();
            
            cup = new CoachUpdate();
            rup = new RefereeUpdate();
            scup = new SchoolUpdate();
            stup = new StudentUpdate();
            
            ag = new AddGoal();
            ap = new AddPenalty();
            fup = new FixtureUpdate();

            hp.setVisible(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error starting application", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
