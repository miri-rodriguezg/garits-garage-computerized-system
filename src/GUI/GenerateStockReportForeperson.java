/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import demrar.DBConnectivity;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import demrar.SplitDate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author acwf580
 */
public class GenerateStockReportForeperson extends javax.swing.JPanel {

    private static File jpgOriginal = new File("StockReport.jpg");
    private File jpgResized = new File("ActualStockReport.jpg");

    private static Document stockReportDoc = new Document(PageSize.A4.rotate());
    
        

    /**
     * Creates new form GenerateStockReport
     */
    public GenerateStockReportForeperson() {
        initComponents();

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportTableParts = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        monthBeginningText = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        monthEndText = new javax.swing.JLabel();
        currentDateText = new javax.swing.JLabel();
        printReportButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        reportTableOrders = new javax.swing.JTable();
        generateReportButton = new javax.swing.JButton();
        enterYearText = new javax.swing.JLabel();
        enterMonthText = new javax.swing.JLabel();
        yearSpinner = new javax.swing.JSpinner();
        monthSpinner = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setText("GARITS");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.jpg"))); // NOI18N

        jLabel3.setText("Quick Fix Fitters");

        reportTableParts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Part Name", "Code", "Vehicle Type", "Price", "Stock lvl", "Initial cost", "Used", "Delivery", "New stock lvl", "Stock cost", "Threshold lvl"
            }
        ));
        jScrollPane1.setViewportView(reportTableParts);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Spare Parts /  Stock Level Report");

        jLabel5.setText("Report Period:");

        jLabel6.setText("Report Date:");

        jLabel7.setText("Senior Storekeeper: ");

        jLabel8.setText("Ms E. Kournikova");

        monthBeginningText.setText("Month Beginning");

        jLabel10.setText("-");

        monthEndText.setText("Month End");

        currentDateText.setText(LocalDate.now().toString());

        printReportButton.setText("Print");
        printReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReportButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        reportTableOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "OrderNo", "Description", "Quantity", "Price(£)"
            }
        ));
        jScrollPane2.setViewportView(reportTableOrders);

        generateReportButton.setText("Generate report");
        generateReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportButtonActionPerformed(evt);
            }
        });

        enterYearText.setText("Enter year:");

        enterMonthText.setText("Enter month:");

        yearSpinner.setModel(new javax.swing.SpinnerNumberModel(2019, 2010, 9999, 1));
        JSpinner.NumberEditor editor = new javax.swing.JSpinner.NumberEditor(yearSpinner, "#");
        yearSpinner.setEditor(editor);
        editor.getTextField().setHorizontalAlignment(javax.swing.JTextField.CENTER);

        monthSpinner.setModel(new javax.swing.SpinnerListModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));

        jLabel9.setText("19 High St.,");

        jLabel11.setText("Ashford,");

        jLabel12.setText("Kent, CT16 8YY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enterYearText)
                            .addComponent(enterMonthText)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(generateReportButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(printReportButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(monthBeginningText)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(monthEndText))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(currentDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(208, 208, 208)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(511, 511, 511)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(monthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addGap(597, 597, 597)
                            .addComponent(jLabel2)))
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap(424, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(monthBeginningText)
                    .addComponent(jLabel10)
                    .addComponent(monthEndText))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enterYearText)
                            .addComponent(yearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enterMonthText)
                            .addComponent(monthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(currentDateText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printReportButton)
                    .addComponent(generateReportButton))
                .addGap(34, 34, 34)
                .addComponent(backButton))
        );
    }// </editor-fold>//GEN-END:initComponents
public static BufferedImage getScreenShot(Component component) {

        BufferedImage image = new BufferedImage(1000, 600, BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());

        return image;

    }

    public static void SaveScreenShot(Component component, String filename) throws Exception {

        BufferedImage img = getScreenShot(component);
        ImageIO.write(img, "jpg", new File(filename));

    }
public static void printStockReport() throws BadElementException, IOException {
        try {
            PdfWriter writer = PdfWriter.getInstance(stockReportDoc, new FileOutputStream("StockReport.pdf"));
            stockReportDoc.open();

            Image stockReportI = Image.getInstance("StockReport.jpg");

            stockReportDoc.add(stockReportI);

            stockReportDoc.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void printReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReportButtonActionPerformed

        getScreenShot(this);
        try {
            SaveScreenShot(this, "StockReport.jpg");
        } catch (Exception ex) {
            Logger.getLogger(GenerateStockReportForeperson.class.getName()).log(Level.SEVERE, null, ex);
        }
        //rotate(input, output, ROTATE_LEFT);
        resize(jpgOriginal, jpgResized, 850, 474, "jpg");

        try {
            printStockReport();
        } catch (BadElementException ex) {
            Logger.getLogger(GenerateStockReportForeperson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerateStockReportForeperson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printReportButtonActionPerformed

    public static void resize(File ogImage, File resizedImage, int width, int height, String format) {
        try {
            BufferedImage og = ImageIO.read(ogImage);
            BufferedImage resized = new BufferedImage(width, height, og.getType());
            Graphics2D g2 = resized.createGraphics();
            g2.drawImage(og, 0, 0, width, height, null);
            g2.dispose();
            ImageIO.write(resized, format, resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportButtonActionPerformed
        /* Gets inputs from jSpinners and converts them to int so that they can be used for LocalDate later.
           After the report is generated, the button, spinners and text are hidden so they don't show up in the
           report screenshot.
         */
        try {
            String yearText = yearSpinner.getValue().toString();
            String monthText = monthSpinner.getValue().toString();
            int year = Integer.parseInt(yearText);
            int month = Integer.parseInt(monthText);
            if (month < 13 && month > 0) {
                Connection connection = DBConnectivity.getConnection();
                generateReportTables(connection, year, month);
            }
            enterYearText.setVisible(false);
            enterMonthText.setVisible(false);
            yearSpinner.setVisible(false);
            monthSpinner.setVisible(false);
            generateReportButton.setEnabled(false);
            generateReportButton.setVisible(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_generateReportButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        Homepage homepage = (Homepage) SwingUtilities.getWindowAncestor(this);
        homepage.setContentPane(new ForepersonHome());

        homepage.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    public void generateReportTables(Connection connection, int year, int month) {

        LocalDate localDate = LocalDate.now();
        currentDateText.setText(localDate.toString()); //Shows when the report was generated.
        LocalDate selectedDate = LocalDate.of(year, month, 1);
        String daysInLastMonth = String.valueOf(selectedDate.lengthOfMonth());
        String targetDateBeginning = (selectedDate.toString()).substring(0, 8); //This might seem redundant but I need this so I can attach the last day of month one line below
        String targetDateEnding = targetDateBeginning + daysInLastMonth;
        targetDateBeginning = targetDateBeginning + "01";
        monthBeginningText.setText(targetDateBeginning); //Sets display for date period of the report.
        monthEndText.setText(targetDateEnding);
        String usedStockSQL = "SELECT sl.partName, sl.partNo, sl.vehicleType, sl.price, sl.quantity, sl.treshold, pu.quantity AS quantityUsed, pu.dateUsed "
                + "FROM StockLedger AS sl "
                + "INNER JOIN PartsUsed AS pu ON sl.partNo = pu.partNo "
                + "WHERE pu.dateUsed >= '" + targetDateBeginning + "' AND pu.dateUsed <= '" + targetDateEnding + "' "
                + "ORDER BY sl.partName ASC";

        String orderedStockSQL = "SELECT sl.partName, sl.partNo, sl.vehicleType, sl.price, sl.quantity, sl.treshold, po.quantity AS quantityOrdered, po.dateOrdered "
                + "FROM StockLedger AS sl "
                + "INNER JOIN PartsOrdered AS po ON sl.partNo = po.partNo "
                + "WHERE po.dateOrdered >= '" + targetDateBeginning + "' AND po.dateOrdered <= '" + targetDateEnding + "' "
                + "ORDER BY sl.partName ASC";

        try {

            Statement usedStatement = connection.createStatement();
            ResultSet usedRS = usedStatement.executeQuery(usedStockSQL);
            Statement orderStatement = connection.createStatement();
            ResultSet orderRS = orderStatement.executeQuery(orderedStockSQL);
            int row = 0;
            DefaultTableModel model = (DefaultTableModel) reportTableParts.getModel();
            int maxRows = model.getRowCount() - 1;
            //This first section iterates through the results of 'usedStockSQL' and adds the relevant values to the table.
            //It assumes that there is no overlap with PartsOrdered, so parts delivered is set to 0. Later on the code checks
            //whether there is an overlap and adjusts the table accordingly.
            while (usedRS.next()) {
                if (row > maxRows) { //Adds new rows to the table in case there is too much data.
                    model.addRow(new Object[]{});
                    maxRows++;
                }
                int partsUsed = usedRS.getInt("quantityUsed");
                int newQuantity = usedRS.getInt("quantity");
                int initialQuantity = newQuantity + partsUsed;
                BigDecimal newQuantityValue = BigDecimal.valueOf(newQuantity); //ValueOf returns a BigDecimal of a non-BigDecimal value
                BigDecimal initialQuantityValue = BigDecimal.valueOf(initialQuantity);
                BigDecimal partPrice = usedRS.getBigDecimal("price");
                reportTableParts.setValueAt(usedRS.getString("partName"), row, 0);
                reportTableParts.setValueAt(usedRS.getString("partNo"), row, 1);
                reportTableParts.setValueAt(usedRS.getString("vehicleType"), row, 2);
                reportTableParts.setValueAt(partPrice, row, 3);
                reportTableParts.setValueAt(initialQuantity, row, 4);
                reportTableParts.setValueAt((partPrice.multiply(initialQuantityValue)), row, 5);
                reportTableParts.setValueAt(partsUsed, row, 6);
                reportTableParts.setValueAt(0, row, 7);
                reportTableParts.setValueAt(newQuantity, row, 8);
                reportTableParts.setValueAt((partPrice.multiply(newQuantityValue)), row, 9);
                reportTableParts.setValueAt(usedRS.getInt("treshold"), row, 10);
                row++;
            }
            /*
            This one took me a while: in order to resolve overlaps in cases where there is the same part number in both
            parts ordered and parts used, I check the entire table for each iteration of results from 'orderedStockSQL'.
            If the part numbers match, I update the initial stock values and the amount of parts delivered. New stock
            remains the same because we assume that the stock in StockLedger has been updated both after using parts and
            after ordering them. It may be inefficient, but it works. If there are no matches in partNo, then the code that 
            runs is almost the same as the code for used parts above.
             */
            while (orderRS.next()) {

                boolean partMatch = false;
                String currentPartNo = orderRS.getString("partNo");
                int partsOrdered = orderRS.getInt("quantityOrdered");
                int newQuantity = orderRS.getInt("quantity");
                int initialQuantity = newQuantity - partsOrdered;
                for (int tempRow = 0; tempRow < row; tempRow++) {
                    String tablePartNo = reportTableParts.getValueAt(tempRow, 1).toString();
                    if (currentPartNo.equals(tablePartNo)) {
                        partMatch = true;
                        int initialParts = Integer.parseInt(reportTableParts.getValueAt(tempRow, 4).toString());
                        initialParts = initialParts - partsOrdered;
                        float partsPrice = Float.parseFloat(reportTableParts.getValueAt(tempRow, 3).toString());
                        BigDecimal partsPriceD = BigDecimal.valueOf(partsPrice);
                        reportTableParts.setValueAt(partsPriceD.multiply(BigDecimal.valueOf(initialParts)), tempRow, 5);
                        reportTableParts.setValueAt(initialParts, tempRow, 4);
                        reportTableParts.setValueAt(partsOrdered, tempRow, 7);
                        break;
                    }
                }
                if (partMatch == false) {
                    if (row > maxRows) {
                        model.addRow(new Object[]{});
                        maxRows++;
                    }
                    BigDecimal newQuantityValue = BigDecimal.valueOf(newQuantity);
                    BigDecimal initialQuantityValue = BigDecimal.valueOf(initialQuantity);
                    BigDecimal partPrice = orderRS.getBigDecimal("price");
                    reportTableParts.setValueAt(orderRS.getString("partName"), row, 0);
                    reportTableParts.setValueAt(orderRS.getString("partNo"), row, 1);
                    reportTableParts.setValueAt(orderRS.getString("vehicleType"), row, 2);
                    reportTableParts.setValueAt(partPrice, row, 3);
                    reportTableParts.setValueAt(initialQuantity, row, 4);
                    reportTableParts.setValueAt((partPrice.multiply(initialQuantityValue)), row, 5);
                    reportTableParts.setValueAt(0, row, 6);
                    reportTableParts.setValueAt(partsOrdered, row, 7);
                    reportTableParts.setValueAt(newQuantity, row, 8);
                    reportTableParts.setValueAt((partPrice.multiply(newQuantityValue)), row, 9);
                    reportTableParts.setValueAt(orderRS.getInt("treshold"), row, 10);
                    row++;
                }
            }
            //Here we calculate the total initial stock cost and current stock cost for the report, and add it to the end of the table.
            if (row > maxRows) {
                model.addRow(new Object[]{});
                maxRows++;
            }
            reportTableParts.setValueAt("Total", row, 0);
            maxRows = row;
            float initialCostTotal = 0;
            float stockCostTotal = 0;
            for (int i = 0; i < maxRows; i++) {
                float initialCost = Float.parseFloat(reportTableParts.getValueAt(i, 5).toString());
                initialCostTotal = initialCostTotal + initialCost;
            }
            reportTableParts.setValueAt(initialCostTotal, row, 5);
            for (int j = 0; j < maxRows; j++) {
                float stockCost = Float.parseFloat(reportTableParts.getValueAt(j, 9).toString());
                stockCostTotal = stockCostTotal + stockCost;
            }
            reportTableParts.setValueAt(stockCostTotal, row, 9);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String orderSQL = "SELECT po.orderNo, po.partNo, po.dateOrdered, po.quantity, sl.partName, sl.price "
                + "FROM PartsOrdered AS po "
                + "INNER JOIN StockLedger AS sl ON sl.partNo = po.partNo "
                + "WHERE po.dateOrdered >= '" + targetDateBeginning + "' AND po.dateOrdered <= '" + targetDateEnding + "' "
                + "ORDER BY po.orderNo";

        String sumSQL = "SELECT ROUND(SUM(sl.price*po.quantity), 2) AS [totalOrderPrice(£)] "
                + "FROM PartsOrdered AS po "
                + "INNER JOIN StockLedger AS sl ON po.partNo = sl.partNo";

        try {
            Statement orderStatement = connection.createStatement();
            Statement totalStatement = connection.createStatement();
            ResultSet rs2 = orderStatement.executeQuery(orderSQL);
            ResultSet sumRS = totalStatement.executeQuery(sumSQL);
            DefaultTableModel model2 = (DefaultTableModel) reportTableOrders.getModel();
            int orderTableRow = 0;
            int otMaxRow = reportTableOrders.getRowCount() - 1;
            //Similarly to used parts, code iterates through the results from query and fills in the appropriate columns.
            while (rs2.next()) {
                if (orderTableRow > otMaxRow) {
                    model2.addRow(new Object[]{});
                    otMaxRow++;
                }
                int orderQuantity = rs2.getInt("quantity");
                BigDecimal price = rs2.getBigDecimal("price");
                reportTableOrders.setValueAt(rs2.getInt("orderNo"), orderTableRow, 0);
                reportTableOrders.setValueAt(rs2.getString("partName"), orderTableRow, 1);
                reportTableOrders.setValueAt(orderQuantity, orderTableRow, 2);
                reportTableOrders.setValueAt(price.multiply(BigDecimal.valueOf(orderQuantity)), orderTableRow, 3);
                orderTableRow++;

            }
            if (orderTableRow > otMaxRow) {
                model2.addRow(new Object[]{});
                otMaxRow++;
            }
            reportTableOrders.setValueAt("Total", orderTableRow, 0);
            reportTableOrders.setValueAt(sumRS.getBigDecimal("totalOrderPrice(£)"), orderTableRow, 3);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    

    

public JTable getPartsTable() {
        ///invoiceTable.getValueAt(int row, int column);
        return reportTableParts;
    }

    public JTable getOrdersTable() {
        return reportTableOrders;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel currentDateText;
    private javax.swing.JLabel enterMonthText;
    private javax.swing.JLabel enterYearText;
    private javax.swing.JButton generateReportButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel monthBeginningText;
    private javax.swing.JLabel monthEndText;
    private javax.swing.JSpinner monthSpinner;
    private javax.swing.JButton printReportButton;
    private javax.swing.JTable reportTableOrders;
    private javax.swing.JTable reportTableParts;
    private javax.swing.JSpinner yearSpinner;
    // End of variables declaration//GEN-END:variables
}
