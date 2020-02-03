/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Victor
 */
public class MatchReg {
    
    private int matchid;
    private int teamA;
    private int teamB;
    private Timestamp date;
    private int referee;
    
    public MatchReg(int matchid, int teamA, int teamB, Timestamp date, int referee){
        this.matchid = matchid;
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
        this.referee = referee;
      
    }

    public int getMatchid() {
        return matchid;
    }

    public void setMatchid(int matchid) {
        this.matchid = matchid;
    }

    public int getTeamA() {
        return teamA;
    }

    public void setTeamA(int teamA) {
        this.teamA = teamA;
    }

    public int getTeamB() {
        return teamB;
    }

    public void setTeamB(int teamB) {
        this.teamB = teamB;
    }

    public Timestamp getDate() {
        return date;
    }

    public void Timestamp(Timestamp date) {
        this.date = date;
    }

    public int getReferee() {
        return referee;
    }

    public void setReferee(int referee) {
        this.referee = referee;
    }

    @Override
    public String toString() {
        return "MatchReg{" + "matchid=" + matchid + ", teamA=" + teamA + ", teamB=" + teamB + ", date=" + date + ", referee=" + referee +  '}';
    }
    
    
}
