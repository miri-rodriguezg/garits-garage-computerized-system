/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import demrar.DBConnectivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.proteanit.sql.DbUtils;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import users.Admin;

/**
 *
 * @author emmanuelle
 */
public class ManageJobMechanic extends javax.swing.JPanel {

    /**
     * Creates new form ManageJobMechanic
     */
    public ManageJobMechanic() {
        initComponents();
    }

    public void stockAlert() {
        for (int i = 0; i < table2.getRowCount(); i++) {
            String quantityInTable = table2.getValueAt(i, 5).toString();
            String thresholdInTable = table2.getValueAt(i, 6).toString();
            String partNameInTable = table2.getValueAt(i, 1).toString();

            int intQuantity = Integer.parseInt(quantityInTable);
            int intThreshold = Integer.parseInt(thresholdInTable);
            if (intQuantity <= intThreshold) {
                JOptionPane.showMessageDialog(null, "LOW STOCK LEVEL FOR " + partNameInTable + "!");

            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        loadParts = new javax.swing.JButton();
        done = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        workDone = new javax.swing.JTextField();
        actualTime = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        usePart = new javax.swing.JButton();
        loadJobs = new javax.swing.JButton();
        status = new javax.swing.JComboBox<>();
        partId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jobId = new javax.swing.JTextField();
        logOut4 = new javax.swing.JButton();

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setText("GARITS");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Manage Job");

        jLabel9.setText("Description of work done:");

        jLabel10.setText("Actual Time Needed:");

        loadParts.setText("Load Spare Parts");
        loadParts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadPartsActionPerformed(evt);
            }
        });

        done.setText("Done");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(table);

        jScrollPane4.setViewportView(jScrollPane3);

        jLabel12.setText("Job Id:");

        workDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workDoneActionPerformed(evt);
            }
        });

        actualTime.setText("1");
        actualTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualTimeActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(table2);

        jScrollPane7.setViewportView(jScrollPane6);

        usePart.setText("Use this part");
        usePart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usePartActionPerformed(evt);
            }
        });

        loadJobs.setText("Load Pending Tasks");
        loadJobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadJobsActionPerformed(evt);
            }
        });

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "In Process", "Complete" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        partId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partIdActionPerformed(evt);
            }
        });

        jLabel11.setText("Part No:");

        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        jLabel13.setText("Quantity needed:");

        jLabel14.setText("Change job status:");

        jobId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobIdActionPerformed(evt);
            }
        });

        logOut4.setText("Log Out");
        logOut4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logOut4)
                    .addComponent(jLabel2))
                .addGap(1, 1, 1))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(workDone, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(49, 49, 49)
                            .addComponent(actualTime))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(60, 60, 60)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(128, 128, 128)
                                .addComponent(jobId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(partId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(usePart))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(loadParts)))
                        .addGap(125, 125, 125))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(done)
                            .addComponent(loadJobs)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(loadJobs)))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jobId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(actualTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(workDone, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logOut4)
                            .addComponent(backButton))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(loadParts)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(partId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(usePart)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(done)
                        .addGap(93, 93, 93))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadPartsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadPartsActionPerformed
        // TODO add your handling code here:
        Connection conn = DBConnectivity.getConnection();
        String sql = "SELECT * from StockLedger";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            table2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
        DBConnectivity.disconnect(conn);
    }//GEN-LAST:event_loadPartsActionPerformed

    private void workDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workDoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_workDoneActionPerformed

    private void actualTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actualTimeActionPerformed

    private void usePartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usePartActionPerformed

//Allows mechanic to use parts to update the job, reducing quantity of parts and inserting them to parts used to then use for invoice     
        Connection conn = DBConnectivity.getConnection();
        int intQuantity = Integer.parseInt(quantity.getText());
        int intId = Integer.parseInt(partId.getText());
        String sql = "UPDATE StockLedger set quantity = quantity - '" + intQuantity + "' where partNo = '" + intId + "' ";
        String sql2 = "INSERT into PartsUsed (partNo, quantity, jobNo, dateUsed) values (?,?,?,?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            PreparedStatement pst2 = conn.prepareStatement(sql2);

            pst2.setString(1, partId.getText());
            pst2.setString(2, quantity.getText());
            pst2.setString(3, jobId.getText());

            LocalDate localDate = LocalDate.now();
            pst2.setString(4, java.sql.Date.valueOf(localDate).toString());

            pst.execute();
            pst2.execute();

            JOptionPane.showMessageDialog(null, "Saved");
            stockAlert();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                DBConnectivity.disconnect(conn);
            } catch (Exception e) {
            }
        }
        DBConnectivity.disconnect(conn);
    }//GEN-LAST:event_usePartActionPerformed

    private void loadJobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadJobsActionPerformed
        // TODO add your handling code here:
        Connection conn = DBConnectivity.getConnection();
        String sql = "SELECT * from Job where status = 'Pending' ";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
        DBConnectivity.disconnect(conn);
    }//GEN-LAST:event_loadJobsActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_statusActionPerformed

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
//Allow mechanic to update job status and details
        Connection conn = DBConnectivity.getConnection();
        String sql = "UPDATE Job set workDone = '" + workDone.getText() + "', actualTime = '" + actualTime.getText() + "', status = '" + status.getSelectedItem().toString() + "'  where jobNo = '" + jobId.getText() + "' ";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.execute();
            conn.close();
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                DBConnectivity.disconnect(conn);
            } catch (Exception e) {
            }
        }
        DBConnectivity.disconnect(conn);
    }//GEN-LAST:event_doneActionPerformed

    private void partIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_partIdActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void jobIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobIdActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        Homepage homepage = (Homepage) SwingUtilities.getWindowAncestor(this);
        homepage.setContentPane(new MechanicHome());

        homepage.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void logOut4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut4ActionPerformed
        // TODO add your handling code here:
        InputStream music;
       try{
           music = new FileInputStream(new File("goodbye.wav"));
           AudioStream audio = new AudioStream(music);
           AudioPlayer.player.start(audio);
           
           
       }catch(Exception e){
           
           System.out.println(e.getMessage());
       }
        Homepage homepage = (Homepage) SwingUtilities.getWindowAncestor(this);
        homepage.dispose();

        new Homepage().setVisible(true);
    }//GEN-LAST:event_logOut4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actualTime;
    private javax.swing.JButton backButton;
    private javax.swing.JButton done;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jobId;
    private javax.swing.JButton loadJobs;
    private javax.swing.JButton loadParts;
    private javax.swing.JButton logOut4;
    private javax.swing.JTextField partId;
    private javax.swing.JTextField quantity;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    private javax.swing.JButton usePart;
    private javax.swing.JTextField workDone;
    // End of variables declaration//GEN-END:variables
}
