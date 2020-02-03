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
public class Coach {
    private int id;
    private String fName;
    private String lName;
    private Date dateOfBirth;
    private int schoolId;
    private int idNum;
    private int phoneNum;
    private String emailAdd;
    private String schCoaching;
    private String medicalIssue;
    private String explanationMedical;
    
    public Coach (int id, String fName, String lName, Date dateOfBirth, int schoolId, int idNum, int phoneNum, String emailAdd, String schCoaching, String medicalIssue, String explanationMedical ){
        this.fName = fName;
        this.lName = lName;
        this.dateOfBirth = dateOfBirth;
        this.schoolId = schoolId;
        this.idNum = idNum;
        this.phoneNum = phoneNum;
        this.emailAdd = emailAdd;
        this.schCoaching = schCoaching;
        this.medicalIssue = medicalIssue;
        this.explanationMedical = explanationMedical;
        
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

    public void setDay(Date day) {
        this.dateOfBirth = day;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }
    
    

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public String getSchCoaching() {
        return schCoaching;
    }

    public void setSchCoaching(String schCoaching) {
        this.schCoaching = schCoaching;
    }

    public String getMedicalIssue() {
        return medicalIssue;
    }

    public void setMedicalIssue(String medicalIssue) {
        this.medicalIssue = medicalIssue;
    }

    public String getExplanationMedical() {
        return explanationMedical;
    }

    public void setExplanationMedical(String explanationMedical) {
        this.explanationMedical = explanationMedical;
    }

    @Override
    public String toString() {
        return "Coach{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", dateOfirth=" + dateOfBirth + ", schoolId=" + schoolId + ", idNum=" + idNum + ", phoneNum=" + phoneNum + ", emailAdd=" + emailAdd + ", schCoaching=" + schCoaching + ", medicalIssue=" + medicalIssue + ", explanationMedical=" + explanationMedical + '}';
    }

   
    
    
    
    
}

