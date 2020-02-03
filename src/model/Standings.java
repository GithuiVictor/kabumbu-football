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
public class Standings {
    private String school;
    private int mp;
    private int w;
    private int d;
    private int l;
    private int pts;
    private int gf;
    private int ga;
    private int gd;
    
    public Standings(String school, int mp, int w, int d, int l, int pts, int gf, int ga, int gd){
        this.school = school;
        this.mp = mp;
        this.w = w;
        this.d = d;
        this.l = l;
        this.pts = pts;
        this.gf = gf;
        this.ga = ga;
        this.gd = gd;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getGf() {
        return gf;
    }

    public void setGf(int gf) {
        this.gf = gf;
    }

    public int getGa() {
        return ga;
    }

    public void setGa(int ga) {
        this.ga = ga;
    }

    public int getGd() {
        return gd;
    }

    public void setGd(int gd) {
        this.gd = gd;
    }

    @Override
    public String toString() {
        return "Standing{" + "school=" + school + ", mp=" + mp + ", w=" + w + ", d=" + d + ", l=" + l + ", pts=" + pts + ", gf=" + gf + ", ga=" + ga + ", gd=" + gd + '}';
    }
      
    
}
