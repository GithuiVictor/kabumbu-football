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
public class Students {
    
   private int id;
   private String fName;
   private String lName;
   private int schoolId;
   private Date dateOfBirth;
   private int regestrationNumber;
   private String emailAddress;
   
   public Students(int id, String fName, String lName,int schoolId, Date dateOfBirth, int regestrationNumber, String emailAddress){
       this.fName = fName;
       this.lName = lName;
       this.schoolId = schoolId;
       this.dateOfBirth = dateOfBirth;
       this.regestrationNumber = regestrationNumber;
       this.emailAddress = emailAddress;
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

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dayOfBirth) {
        this.dateOfBirth = dayOfBirth;
    }

    public int getRegestrationNumber() {
        return regestrationNumber;
    }

    public void setRegestrationNumber(int regestrationNumber) {
        this.regestrationNumber = regestrationNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Students{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", schoolId=" + schoolId + ", dateOfBirth=" + dateOfBirth + ", regestrationNumber=" + regestrationNumber + ", emailAddress=" + emailAddress + '}';
    }
    
    
    
    
   
   
   
   
    
}
