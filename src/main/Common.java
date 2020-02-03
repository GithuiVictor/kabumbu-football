/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.School;
import model.Coach;
import model.MatchReg;
import model.Referee;
import model.Students;

/**
 *
 * @author Victor
 */
public class Common {
    
    public static School CURRENT_SCHOOL = new School(0, null,0, null, null, null, 0);
    public static Coach CURRENT_COACH = new Coach(0, null, null, null,0,0,0,null,null,null,null);
    public static Referee CURRENT_REFEREE = new Referee(0,null,null,null,0,0,0,null,null,0,null, null,null,null);
    public static Students CURRENT_STUDENTS = new Students(0, null, null,0,null,0,null);
    public static MatchReg CURRENT_MATCHREG = new MatchReg(0, 0, 0, null, 0);
    
    public static int studentId = 0;
    public static int coachId = 0;
    public static int refereeid = 0;
    public static int schoolid = 0;
    public static int matchid = 0;
}
