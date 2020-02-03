package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import main.Common;
import main.KabumbuFootballLeage;
import model.Standings;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();
        populateFixtures();
        populateStandings();
        popultetopScorers();
        populateTeamRepremanded();
        populateTopSchools();
        populateCertificates();
    }
    
    public void popultetopScorers(){
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Player");
        columnNames.add("School");
        columnNames.add("Goals");
        
        Vector<Vector<Object>> data = new Vector<>();
        
        String sql = "SELECT COUNT(g.studentNumber) AS goals, p.firstName AS firstName, p.lastName AS lastName, s.schoolname AS school "
                + "FROM goals g, students p, schools s "
                + "WHERE g.studentNumber = p.id "
                + "AND p.schoolid = s.schoolid "
                + "GROUP BY g.studentNumber "
                + "ORDER BY COUNT(g.studentNumber) DESC "
                + "LIMIT 10";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                
                row.add(rs.getString("firstName") +" " +rs.getString("lastName"));
                row.add(rs.getString("school"));
                row.add(rs.getString("goals"));
        
                data.add(row);
                
            }
            topTenScorersTable.setModel(new DefaultTableModel(data, columnNames){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
            

            
        } catch (SQLException ex) {
            Logger.getLogger(CoachRegestrationForm.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    public void populateTeamRepremanded(){
        Vector<String> columnNames = new Vector<>();
        columnNames.add("School");
        
        Vector<Vector<Object>> data = new Vector<>();
        
        String sql = "SELECT * "
                + "FROM schools s "
                + "ORDER BY (SELECT COUNT(*) FROM penalties p WHERE p.schoolNum = s.schoolid) DESC LIMIT 3; ";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                
                row.add(rs.getString("s.schoolname"));
        
                data.add(row);
                
            }
            teamsRepremandedTable.setModel(new DefaultTableModel(data, columnNames){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
            

            
        } catch (SQLException ex) {
            Logger.getLogger(CoachRegestrationForm.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    public void populateTopSchools(){
         Vector<Object> columnNames = new Vector<>();
        Vector<Vector<Object>> data = new Vector<>();

        columnNames.add("Rank");
        columnNames.add("School");
        columnNames.add("MP");
        columnNames.add("W");
        columnNames.add("D");
        columnNames.add("L");
        columnNames.add("Pts");
        columnNames.add("GD");
        try {
            int rank = 1;
            int count = 0;
            for (Standings s : generateStandings()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rank++);
                    row.add(s.getSchool());
                    row.add(s.getMp());
                    row.add(s.getW());
                    row.add(s.getD());
                    row.add(s.getL());
                    row.add(s.getPts());
                    row.add(s.getGd());
                    
                    count++;
                    
 
                    data.add(row);
                    
                    if (count == 3){
                        break;
                    }
            }

            topThreeBestSchoolsTable.setModel(new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void populateCertificates(){
        Vector<String> columnNames = new Vector<>();
        columnNames.add("School");
        
        Vector<Vector<Object>> data = new Vector<>();
        
        String sql = "SELECT * "
                + "FROM schools s "
                + "ORDER BY (SELECT COUNT(*) FROM penalties p WHERE p.schoolNum = s.schoolid) ASC LIMIT 3; ";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                
                row.add(rs.getString("s.schoolname"));
        
                data.add(row);
                
            }
            certificateTable.setModel(new DefaultTableModel(data, columnNames){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
            } catch (SQLException ex) {
            Logger.getLogger(CoachRegestrationForm.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    public void populateFixtures(){
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Match Id");
        columnNames.add("Home Team");
        columnNames.add("Away Team");
        columnNames.add("Date and Time");
        columnNames.add("Referee");
        columnNames.add("Goals");
        
        Vector<Vector<Object>> data = new Vector<>();
        
        String sql = "SELECT f.matchid, h.schoolname, a.schoolname, f.dateTime, ref.firstname, ref.lastname "
                + "FROM fixtures f, schools h, schools a, referees ref "
                + "WHERE f.homeTeam = h.schoolid "
                + "AND f.awayTeam = a.schoolid "
                + "AND f.refereeOfficiating = ref.id;";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "");
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                
                row.add(rs.getString("f.matchid"));
                row.add(rs.getString("h.schoolname"));
                row.add(rs.getString("a.schoolname"));
                row.add(rs.getString("f.dateTime"));
                row.add(rs.getString("ref.firstname") +rs.getString("ref.lastname"));
                
                data.add(row);
                
            }
            fixturetable.setModel(new DefaultTableModel(data, columnNames){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
            

            
        } catch (SQLException ex) {
            Logger.getLogger(CoachRegestrationForm.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    
    public void populateStandings() {
        Vector<Object> columnNames = new Vector<>();
        Vector<Vector<Object>> data = new Vector<>();

        columnNames.add("Rank");
        columnNames.add("School");
        columnNames.add("MP");
        columnNames.add("W");
        columnNames.add("D");
        columnNames.add("L");
        columnNames.add("Pts");
        columnNames.add("GD");
        try {
            int rank = 1;
            for (Standings s : generateStandings()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rank++);
                    row.add(s.getSchool());
                    row.add(s.getMp());
                    row.add(s.getW());
                    row.add(s.getD());
                    row.add(s.getL());
                    row.add(s.getPts());
                    row.add(s.getGd());

                    data.add(row);
            }

            leagueT.setModel(new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public List<Standings> generateStandings() throws SQLException {
        List<Standings> standings = new ArrayList<>();

        String sql = "SELECT * FROM Schools";
        Statement pstmt = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kambumbufootballleagemanagementsystem", "root", "")) {
            pstmt = conn.createStatement();

            ResultSet rsS = pstmt.executeQuery(sql);
            while (rsS.next()) {
                Vector<Object> row = new Vector<>();
                int schoolnumb = rsS.getInt("Schoolid");
                String schoolname = rsS.getString("schoolname");

                Standings standing = new Standings(schoolname, WIDTH, WIDTH, WIDTH, WIDTH, WIDTH, WIDTH, WIDTH, WIDTH);

                //SCHOOL
                standing.setSchool(schoolname);

                int w = 0;
                int d = 0;
                int l = 0;
                int pts = 0;
                int gf = 0;
                int ga = 0;
                int gd = 0;
                int mp = 0;

                sql = "SELECT * FROM fixtures WHERE homeTeam = " + schoolnumb + " OR homeTeam = " + schoolnumb;
                pstmt = conn.createStatement();
                ResultSet rsM = pstmt.executeQuery(sql);
                while (rsM.next()) {
                    mp++;
                    int gameID = rsM.getInt("matchid");

                    int schoolGoals = 0;
                    int opponGoals = 0;

                    sql = "SELECT * FROM Goals WHERE schoolNumber = " + schoolnumb + " AND matchNumber = " + gameID;
                    pstmt = conn.createStatement();
                    ResultSet rsG = pstmt.executeQuery(sql);
                    while (rsG.next()) {
                        if (rsG.getInt("schoolNumber") == schoolnumb) {
                            schoolGoals++;
                        } else {
                            opponGoals++;
                        }
                    }

                    if (schoolGoals > opponGoals) {
                        w++;
                        pts += 3;
                    }
                    if (schoolGoals < opponGoals) {
                        l++;
                    }
                    if (schoolGoals == opponGoals) {
                        d++;
                        pts++;
                    }

                    gf += schoolGoals;
                    ga += opponGoals;

                    gd = gf - ga;
                    standing.setW(w);
                    standing.setD(d);
                    standing.setL(l);
                    standing.setPts(pts);
                    standing.setGf(gf);
                    standing.setGa(ga);
                    standing.setGd(gd);

                }

                //MP
                standing.setMp(mp);
                standings.add(standing);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.sort(standings, Comparator.comparingInt(Standings::getPts).thenComparing(Standings::getGd));
        Collections.reverse(standings);
        return standings;
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        schoolRegisteredBtn = new javax.swing.JButton();
        coachRegisteredBtn = new javax.swing.JButton();
        playersRegisteredBtn = new javax.swing.JButton();
        refereeRegisteredBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fixturetable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        leagueT = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        topThreeBestSchoolsTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        topTenScorersTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        certificateTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        teamsRepremandedTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KABUMBU FOOTBALL LEAGUE MANAGEMENT INFORMATION SYSTEM");

        schoolRegisteredBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        schoolRegisteredBtn.setText("Schools Registered");
        schoolRegisteredBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schoolRegisteredBtnActionPerformed(evt);
            }
        });

        coachRegisteredBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        coachRegisteredBtn.setText("Coach Registered");
        coachRegisteredBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachRegisteredBtnActionPerformed(evt);
            }
        });

        playersRegisteredBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        playersRegisteredBtn.setText("Players Registered");
        playersRegisteredBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playersRegisteredBtnActionPerformed(evt);
            }
        });

        refereeRegisteredBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        refereeRegisteredBtn.setText("Referee Registered");
        refereeRegisteredBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refereeRegisteredBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(schoolRegisteredBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coachRegisteredBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refereeRegisteredBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playersRegisteredBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(schoolRegisteredBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playersRegisteredBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refereeRegisteredBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coachRegisteredBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(481, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrations", jPanel1);

        fixturetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Team A", "Team B"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        fixturetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fixturetableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(fixturetable);

        jButton2.setText("Add Match");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setText("Update Match");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Fixtures", jPanel2);

        leagueT.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        leagueT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Team names", "GP", "W", "D", "L", "GF", "GA", "GD", "PTS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(leagueT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("League Table", jPanel3);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TOP THREE BEST TEAMS");

        topThreeBestSchoolsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "School name", "Position", "Points", "Amount Recieving"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(topThreeBestSchoolsTable);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TOP TEN SCORER");

        topTenScorersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "School Name", "Position", "Total Goals"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(topTenScorersTable);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MOST DISCIPLINED SCHOOL");

        certificateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "School Name", "Number of penalty cards"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(certificateTable);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REPREMANDED TEAMS");

        teamsRepremandedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(teamsRepremandedTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)))
                        .addGap(21, 21, 21)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Results", jPanel4);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        KabumbuFootballLeage.login.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void refereeRegisteredBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refereeRegisteredBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        KabumbuFootballLeage.rrhp.setVisible(true);
    }//GEN-LAST:event_refereeRegisteredBtnActionPerformed

    private void playersRegisteredBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playersRegisteredBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        KabumbuFootballLeage.strhp.setVisible(true);
    }//GEN-LAST:event_playersRegisteredBtnActionPerformed

    private void coachRegisteredBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachRegisteredBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        KabumbuFootballLeage.crhp.setVisible(true);
    }//GEN-LAST:event_coachRegisteredBtnActionPerformed

    private void schoolRegisteredBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schoolRegisteredBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        KabumbuFootballLeage.srhp.setVisible(true);
    }//GEN-LAST:event_schoolRegisteredBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        KabumbuFootballLeage.mr.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fixturetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fixturetableMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            JTable source = (JTable) evt.getSource();
            int row = source.rowAtPoint(evt.getPoint());
            
            Common.matchid = Integer.parseInt(source.getModel().getValueAt(row, 0).toString());
            
            KabumbuFootballLeage.hp.populateFixtures();
            System.out.println("I WAS HRRE in the begining " + Common.matchid);
            KabumbuFootballLeage.lgdr.populateLiveMatch();
                    
            KabumbuFootballLeage.lgdr.setVisible(true);
        }
    }//GEN-LAST:event_fixturetableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Common.matchid = Integer.parseInt(fixturetable.getModel().getValueAt(fixturetable.getSelectedRow(), 0).toString());
        KabumbuFootballLeage.fup.populateFixtureUpdate();
        KabumbuFootballLeage.fup.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    
    public void clear(){
       
    }
    
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable certificateTable;
    private javax.swing.JButton coachRegisteredBtn;
    private javax.swing.JTable fixturetable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable leagueT;
    private javax.swing.JButton playersRegisteredBtn;
    private javax.swing.JButton refereeRegisteredBtn;
    private javax.swing.JButton schoolRegisteredBtn;
    private javax.swing.JTable teamsRepremandedTable;
    private javax.swing.JTable topTenScorersTable;
    private javax.swing.JTable topThreeBestSchoolsTable;
    // End of variables declaration//GEN-END:variables
}
