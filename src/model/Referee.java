/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Victor
 */
public class Referee {
    
    private int id;
    private String fName;
    private String lName;
    private Date dateOfBirth;
    private int schoolId;
    private int nationalId;
    private int phoneNumber;
    private String emailAddress;
    private String sex;
    private int yearBeganReferee;
    private String schoolTeam;
    private String willingInterCountyGames;
    private String refereeGrade;
    private String availableSecondarylevel;
    
    public Referee(int id, String fName, String lName, Date dateOfBirth, int schoolId, int nationalId, int phoneNumber, String emailAddress, String sex, int yearBeganReferee, String schoolTeam, String willingInterCountyGames, String refereeGrade, String availableSecondLevel){
        this.fName = fName;
        this.lName = lName;
        this.dateOfBirth = dateOfBirth;
        this.schoolId = schoolId;
        this.nationalId = nationalId;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.sex = sex;
        this.yearBeganReferee = yearBeganReferee;
        this.schoolTeam = schoolTeam;
        this.willingInterCountyGames = willingInterCountyGames;
        this.refereeGrade = refereeGrade;
        this.availableSecondarylevel = availableSecondLevel;
        
    }

    public String getRefereeGrade() {
        return refereeGrade;
    }

    public void setRefereeGrade(String refereeGrade) {
        this.refereeGrade = refereeGrade;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }
    
    

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getYearBeganReferee() {
        return yearBeganReferee;
    }

    public void setYearBeganReferee(int yearBeganReferee) {
        this.yearBeganReferee = yearBeganReferee;
    }

    public String getSchoolTeam() {
        return schoolTeam;
    }

    public void setSchoolTeam(String schoolTeam) {
        this.schoolTeam = schoolTeam;
    }

    public String getWillingInterCountyGames() {
        return willingInterCountyGames;
    }

    public void setWillingInterCountyGames(String willingInterCountyGames) {
        this.willingInterCountyGames = willingInterCountyGames;
    }

    public String getAvailableSecondarylevel() {
        return availableSecondarylevel;
    }

    public void setAvailableSecondarylevel(String availableSecondarylevel) {
        this.availableSecondarylevel = availableSecondarylevel;
    }

    @Override
    public String toString() {
        return "Referee{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", dateOfBirth=" + dateOfBirth + ", schoolId=" + schoolId + ", nationalId=" + nationalId + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + ", sex=" + sex + ", yearBeganReferee=" + yearBeganReferee + ", schoolTeam=" + schoolTeam + ", willingInterCountyGames=" + willingInterCountyGames + ", refereeGrade=" + refereeGrade + ", availableSecondarylevel=" + availableSecondarylevel + '}';
    }

    

    
    
    
    
    
    
}
