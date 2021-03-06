/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tours_n_travel;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author shaha
 */
public class AdminAccess extends javax.swing.JFrame {

    /** Creates new form AdminAccess */
    public AdminAccess() {
        initComponents();
        this.setLocationRelativeTo(null);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(10);
        showUsers1();
        showUsers2();
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(new Color(244,244,244));
        jTable1.setBackground(new Color(0,44,45));
        jTable1.setSelectionBackground(new Color(101,180,143));
        jTable1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        
        jTable1.setOpaque(true);
        
        JTableHeader Theader = jTable1.getTableHeader();
        Theader.setBackground(Color.black);
        Theader.setForeground(Color.white);
        Theader.setFont(new Font("Verdana", Font.BOLD, 18));
        
        jTable2.setRowHeight(30);
        jTable2.setShowGrid(true);
        jTable2.setGridColor(new Color(244,244,244));
        jTable2.setBackground(new Color(0,44,45));
        jTable2.setSelectionBackground(new Color(101,180,143));
        jTable2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        
        jTable2.setOpaque(true);
        
        JTableHeader Theader2 = jTable2.getTableHeader();
        Theader2.setBackground(Color.black);
        Theader2.setForeground(Color.white);
        Theader2.setFont(new Font("Verdana", Font.BOLD, 18));
        
        
    }
    
    
    
    
    public ArrayList<User> userList(String table_name){
        ArrayList<User> users = new ArrayList<User>();
        
        
        String q = "select SrNo, name, email, fare from "+table_name;
        //Connections and stuff
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel", "root", "");
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(q);
            User user;
            while(rs.next()){
                user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
               users.add(user);
            }
        }
        catch(Exception ex){
            System.err.println(ex);
        }
        return users;
    }
    
    public void showUsers1(){
        ArrayList<User> list = userList("registeredusers");
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        Object[] row = new Object[4];
        for(int i = 0; i<list.size();i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getEmail();
            row[3] = list.get(i).getFare();
            model.addRow(row);
        }
        for(int i = 0; i < 6 - list.size(); i++){
            row[0] = "";
            row[1] = "";
            row[2] = "";
            row[3] = "";
            model.addRow(row);
        }
    }
    
    public void showUsers2(){
        ArrayList<User> list = userList("travellog");
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        Object[] row = new Object[4];
        for(int i = 0; i<list.size();i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getEmail();
            row[3] = list.get(i).getFare();
            model.addRow(row);
        }
        for(int i = 0; i < 6 - list.size(); i++){
            row[0] = "";
            row[1] = "";
            row[2] = "";
            row[3] = "";
            model.addRow(row);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 22, 30));

        jPanel3.setBackground(new java.awt.Color(0, 44, 45));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 180, 143), 2));

        jTable1.setBackground(new java.awt.Color(0, 44, 45));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 244, 244)));
        jTable1.setForeground(new java.awt.Color(244, 244, 244));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Email", "Total Fare"
            }
        ));
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(1);
        }

        jTable2.setBackground(new java.awt.Color(0, 44, 45));
        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 244, 244)));
        jTable2.setForeground(new java.awt.Color(244, 244, 244));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Email", "Total Fare"
            }
        ));
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(1);
        }

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(244, 244, 244));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Guest Users");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 180, 143), 2));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(244, 244, 244));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registered Users");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 180, 143), 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(0, 44, 45));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(244, 244, 244));
        jButton2.setText("Fall Back");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 180, 143), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 44, 45));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(244, 244, 244));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bookings Database");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 180, 143), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Landing_Page lp = new Landing_Page();
        lp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminAccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAccess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

}
