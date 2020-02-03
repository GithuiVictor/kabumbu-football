/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Victor
 */
public class School {
    private int id;
    private String name;
    private int schoolId;
    private String poBox;
    private String code;
    private String city;
    private double amount;

    public School(int id, String name,int schoolId, String poBox, String code, String city, double amount) {
        this.name = name;
        this.schoolId = schoolId;
        this.poBox = poBox;
        this.code = code;
        this.city = city;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "School{" + "id=" + id + ", name=" + name + ", schoolId=" + schoolId + ", poBox=" + poBox + ", code=" + code + ", city=" + city + ", amount=" + amount + '}';
    }

    
    
}
