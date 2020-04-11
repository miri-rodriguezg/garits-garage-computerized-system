/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import demrar.DBConnectivity;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author acwf580
 */
public class JobReport extends javax.swing.JPanel {

   // private static File jpgOriginal = new File("JobReport.jpg");
   // private File jpgResized = new File("ActualStockReport.jpg");

    private static Document jobReportDoc = new Document(PageSize.A4.rotate());
    
    /**
     * Creates new form JobReport
     */
    public JobReport() {
        initComponents();
        queryMechanics();
    }
    
    public static BufferedImage getScreenShot(Component component) {

        BufferedImage image = new BufferedImage(770, 400, BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());

        return image;

    }

    public static void SaveScreenShot(Component component, String filename) throws Exception {

        BufferedImage img = getScreenShot(component);
        ImageIO.write(img, "jpg", new File(filename));

    }
public static void printJobReport() throws BadElementException, IOException {
        try {
            PdfWriter writer = PdfWriter.getInstance(jobReportDoc, new FileOutputStream("JobReport.pdf"));
            jobReportDoc.open();

            Image jobReportI = Image.getInstance("JobReport.jpg");

            jobReportDoc.add(jobReportI);

            jobReportDoc.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void queryMechanics() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        mechanicBox.setModel(model);
        Connection connection = DBConnectivity.getConnection();
        String sql = "SELECT staffID From Mechanic ";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                mechanicBox.addItem(rs.getString("staffID"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        DBConnectivity.disconnect(connection);
    }

    public void generateReport(Connection connection) {
        String annualTimeSQL = "SELECT AVG(actualTime) FROM Job WHERE jobType = 'Annual' ";
        String motTimeSQL = "SELECT AVG(actualTime) FROM Job WHERE jobType = 'MoT' ";
        String repairTimeSQL = "SELECT AVG(actualTime) FROM Job WHERE jobType = 'Repair' ";
        String annualCostSQL = "SELECT AVG(i.amount), j.jobType "
                + "FROM Invoice AS i "
                + "INNER JOIN Job AS j ON i.VehicleregNo = j.VehicleregNo "
                + "WHERE j.jobType = 'Annual' ";
        String motCostSQL = "SELECT AVG(i.amount), j.jobType "
                + "FROM Invoice AS i "
                + "INNER JOIN Job AS j ON i.VehicleregNo = j.VehicleregNo "
                + "WHERE j.jobType = 'MoT' ";

        String repairCostSQL = "SELECT AVG(i.amount), j.jobType "
                + "FROM Invoice AS i "
                + "INNER JOIN Job AS j ON i.VehicleregNo = j.VehicleregNo "
                + "WHERE j.jobType = 'Repair' ";

        String totalTimeSQL = "SELECT AVG(actualTime) FROM Job WHERE jobType != 'Sell Parts' ";

        String totalCostSQL = "SELECT AVG(i.amount), j.jobType "
                + "FROM Invoice AS i "
                + "INNER JOIN Job AS j ON i.VehicleregNo = j.VehicleregNo "
                + "WHERE j.jobType != 'Sell Parts' ";

        if (mechanicButton.isSelected()) {
            String mechanicId = mechanicBox.getSelectedItem().toString();
            annualTimeSQL = annualTimeSQL + "AND mechanicId = '" + mechanicId + "' ";
            motTimeSQL = motTimeSQL + "AND mechanicId = '" + mechanicId + "' ";
            repairTimeSQL = repairTimeSQL + "AND mechanicId = '" + mechanicId + "' ";
            annualCostSQL = annualCostSQL + "AND j.mechanicId = '" + mechanicId + "' ";
            motCostSQL = motCostSQL + "AND j.mechanicId = '" + mechanicId + "' ";
            repairCostSQL = repairCostSQL + "AND j.mechanicId = '" + mechanicId + "' ";
            totalTimeSQL = totalTimeSQL + "AND mechanicId = '" + mechanicId + "' ";
            totalCostSQL = totalCostSQL + "AND j.mechanicId = '" + mechanicId + "' ";
        }

        try {
            Statement annualTimeStatement = connection.createStatement();
            Statement motTimeStatement = connection.createStatement();
            Statement repairTimeStatement = connection.createStatement();
            Statement annualCostStatement = connection.createStatement();
            Statement motCostStatement = connection.createStatement();
            Statement repairCostStatement = connection.createStatement();
            Statement totalTimeStatement = connection.createStatement();
            Statement totalCostStatement = connection.createStatement();
            ResultSet annualTimeRS = annualTimeStatement.executeQuery(annualTimeSQL);
            ResultSet motTimeRS = motTimeStatement.executeQuery(motTimeSQL);
            ResultSet repairTimeRS = repairTimeStatement.executeQuery(repairTimeSQL);
            ResultSet annualCostRS = annualCostStatement.executeQuery(annualCostSQL);
            ResultSet motCostRS = motCostStatement.executeQuery(motCostSQL);
            ResultSet repairCostRS = repairCostStatement.executeQuery(repairCostSQL);
            ResultSet totalTimeRS = totalTimeStatement.executeQuery(totalTimeSQL);
            ResultSet totalCostRS = totalCostStatement.executeQuery(totalCostSQL);

            while (annualTimeRS.next()) {
                double time = annualTimeRS.getDouble(1);
                averageTable.setValueAt(time, 0, 1);
            }
            while (motTimeRS.next()) {
                double time = motTimeRS.getDouble(1);
                averageTable.setValueAt(time, 1, 1);
            }
            while (repairTimeRS.next()) {
                double time = repairTimeRS.getDouble(1);
                averageTable.setValueAt(time, 2, 1);
            }
            while (annualCostRS.next()) {
                BigDecimal cost = annualCostRS.getBigDecimal(1);
                if (cost == null) {
                    averageTable.setValueAt("0.0", 0, 2);
                } else {
                    averageTable.setValueAt(cost, 0, 2);
                }
            }
            while (motCostRS.next()) {
                BigDecimal cost = motCostRS.getBigDecimal(1);
                if (cost == null) {
                    averageTable.setValueAt("0.0", 1, 2);
                } else {
                    averageTable.setValueAt(cost, 1, 2);
                }

            }
            while (repairCostRS.next()) {
                BigDecimal cost = repairCostRS.getBigDecimal(1);
                if (cost == null) {
                    averageTable.setValueAt("0.0", 2, 2);
                } else {
                    averageTable.setValueAt(cost, 2, 2);
                }

            }
            while (totalTimeRS.next()) {
                double time = totalTimeRS.getDouble(1);
                averageTable.setValueAt(time, 3, 1);
            }
            while (totalCostRS.next()) {
                BigDecimal cost = totalCostRS.getBigDecimal(1);
                if (cost == null) {
                    averageTable.setValueAt("0.0", 3, 2);
                } else {
                    averageTable.setValueAt(cost, 3, 2);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

        averagesType = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        averageTable = new javax.swing.JTable();
        mechanicButton = new javax.swing.JRadioButton();
        overallButton = new javax.swing.JRadioButton();
        mechanicBox = new javax.swing.JComboBox<>();
        printReport = new javax.swing.JButton();
        generateReportButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        currentDateText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setText("GARITS");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.jpg"))); // NOI18N

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Averages");

        averageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Annual Service", null, null},
                {"MoT", null, null},
                {"Repair", null, null},
                {"All", null, null}
            },
            new String [] {
                "Job", "Time", "Price(£)"
            }
        ));
        jScrollPane1.setViewportView(averageTable);

        averagesType.add(mechanicButton);
        mechanicButton.setText("Mechanic:");

        averagesType.add(overallButton);
        overallButton.setSelected(true);
        overallButton.setText("Overall");

        mechanicBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mechanicBoxActionPerformed(evt);
            }
        });

        printReport.setText("Print");
        printReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReportActionPerformed(evt);
            }
        });

        generateReportButton.setText("Generate report");
        generateReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Report Date:");

        currentDateText.setText(LocalDate.now().toString());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(281, 281, 281)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(95, 95, 95)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(generateReportButton)
                            .addGap(18, 18, 18)
                            .addComponent(printReport))))
                .addGap(0, 291, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(overallButton)
                        .addGap(147, 147, 147)
                        .addComponent(mechanicButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mechanicBox, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mechanicButton)
                    .addComponent(overallButton)
                    .addComponent(mechanicBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(currentDateText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printReport)
                    .addComponent(generateReportButton))
                .addGap(5, 5, 5)
                .addComponent(backButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void generateReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportButtonActionPerformed
        // TODO add your handling code here:
        Connection connection = DBConnectivity.getConnection();
        generateReport(connection);
        DBConnectivity.disconnect(connection);
    }//GEN-LAST:event_generateReportButtonActionPerformed

    private void mechanicBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mechanicBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mechanicBoxActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        Homepage homepage = (Homepage) SwingUtilities.getWindowAncestor(this);
        homepage.setContentPane(new GenerateReportFranchisee());
        homepage.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void printReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReportActionPerformed
        // TODO add your handling code here:
        
        getScreenShot(this);
        try {
            SaveScreenShot(this, "JobReport.jpg");
        } catch (Exception ex) {
            Logger.getLogger(GenerateStockReportForeperson.class.getName()).log(Level.SEVERE, null, ex);
        }
        //rotate(input, output, ROTATE_LEFT);
        //resize(jpgOriginal, jpgResized, 850, 474, "jpg");

        try {
            printJobReport();
        } catch (BadElementException ex) {
            Logger.getLogger(JobReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JobReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable averageTable;
    private javax.swing.ButtonGroup averagesType;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel currentDateText;
    private javax.swing.JButton generateReportButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> mechanicBox;
    private javax.swing.JRadioButton mechanicButton;
    private javax.swing.JRadioButton overallButton;
    private javax.swing.JButton printReport;
    // End of variables declaration//GEN-END:variables
}
