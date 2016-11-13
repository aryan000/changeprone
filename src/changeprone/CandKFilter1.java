/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeprone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Number;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author aryan_000
 */

public class CandKFilter1 extends javax.swing.JFrame {

    /**
     * Creates new form CandKFilter1
     */
    public CandKFilter1() {
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setLabelFor(jLabel1);
        jLabel1.setText(" No File Selected");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Select CSV FILE"));

        jButton1.setText("Browse for CSV");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setLabelFor(jLabel1);
        jLabel2.setText(" No File Selected");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Project FILE"));

        jButton2.setText("Browse for Project");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Filter C and K Metrics");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2))
                .addGap(38, 38, 38)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String userDir = System.getProperty("user.home");
        JFileChooser candkfile = new JFileChooser(userDir+"/Desktop");
        candkfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
         FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
     "excel files (*.xls)", "xls");
         candkfile.setFileFilter(xmlfilter);
         int returnvalue = candkfile.showSaveDialog(this);
        File myfile= null;
        if(returnvalue == JFileChooser.APPROVE_OPTION)
        {
            myfile = candkfile.getSelectedFile();
        }
             ArrayList<CSVFile> data = null  ;  
        if(myfile!=null)
        {   
            jLabel2.setText(myfile.getAbsolutePath());
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String userDir = System.getProperty("user.home");
        JFileChooser candkfile = new JFileChooser(userDir+"/Desktop");
        FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
     "csv files (*.csv)", "csv");
        candkfile.setFileFilter(xmlfilter);
        candkfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnvalue = candkfile.showSaveDialog(this);
        
        File myfile= null;
        if(returnvalue == JFileChooser.APPROVE_OPTION)
        {
            myfile = candkfile.getSelectedFile();
        }
             ArrayList<CSVFile> data = null  ;  
        if(myfile!=null)
        {   
            jLabel1.setText(myfile.getAbsolutePath());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    ArrayList<CSVFile> getcsv( File f)
     {
          ArrayList<CSVFile> data = new ArrayList<>();  
          FileReader fr = null;
            try {
                fr = new FileReader(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CandKFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader br = new BufferedReader(fr);
            String st;
            try {
                while ((st = br.readLine()) != null) {
//                    System.out.println(st);
                    CSVFile t = new CSVFile(st);
                    data.add(t);
                }
            } catch (IOException ex) {
                Logger.getLogger(CandKFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          return data;
     }
     
     
     ArrayList<String> getjavafiles( File f  , int version)
     {
         ArrayList<String> javafiles = new ArrayList<>();
        
        try {
            Workbook wb = null;
             wb = Workbook.getWorkbook(f);
            Sheet sh = wb.getSheet(version);
//            System.out.println(sh.getRows());
            for(int i =1;i<sh.getRows();i++)
            {  
//                System.out.println(sh.getCell(1,i).getContents());
                javafiles.add(sh.getCell(0,i).getContents());
                
            }
        } catch (IOException | BiffException ex) {
            Logger.getLogger(CandKFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//         System.out.println("before returning");
        return javafiles;
     }
     
  public Boolean ismatch(String jfile , String candkfile)
  {
      
       
      String    pattern = jfile.substring(0,jfile.lastIndexOf("."));
      
      Boolean result =  candkfile.matches(".*.\\."+pattern);
      
//      System.out.println( jfile + " and " + candkfile + result );
      return result;
  }
  
  
  public void buildcsv(HashMap<String , CSVFile> candkdata) throws IOException, WriteException 
  {
      File ft = new File("C:\\Users\\aryan_000\\Desktop\\ck.xls");
       WritableWorkbook workbook =  Workbook.createWorkbook(ft);
       WritableSheet sheet = workbook.createSheet("candk", 0); 
        
        
        int row = 0 , column = 0;
        sheet.addCell(new Label ( column++ ,row,"FileName "));
        sheet.addCell(new Label ( column++ ,row,"Understand FileName "));
        sheet.addCell(new Label ( column++ ,row,"COl1"));
        sheet.addCell(new Label ( column++ ,row,"COl2"));
        sheet.addCell(new Label ( column++ ,row,"COl3"));
        sheet.addCell(new Label ( column++ ,row,"COl4"));
        sheet.addCell(new Label ( column++ ,row,"COl5"));
        
        row++;
        column=0;
        for (String key : candkdata.keySet()) 
        {
            CSVFile temp = candkdata.get(key);
            sheet.addCell(new Label ( column++ ,row,key));
            sheet.addCell(new Label(column++ , row , temp.name));
            
          for (int i=0;i<temp.metric.size();i++) {
              int num = temp.metric.get(i);
              sheet.addCell(new Number(column++ , row , num));
          } 
          row++;
          column = 0;
//            System.out.println( key  + "    " + temp.name);
            
         }
        
        
        workbook.write();
        workbook.close();
        
        
  }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         
        File f = new File(jLabel1.getText());
        ArrayList<CSVFile> data = null  ;  
        data = getcsv(f); 
        
        System.out.println("received data of csv : " + data.size());
        int version = 0;
        ArrayList<String> javafiles = getjavafiles(new File(jLabel2.getText()),version );
        
        System.out.println("javafiles names received : " + javafiles.size());
        
        HashMap<String, CSVFile> candkdata = new HashMap<>();
        
        String candkfilename;
        for(String filename : javafiles)
        {
            for(CSVFile data1 : data)
            {
                candkfilename = data1.name;
                
                if(ismatch(filename,candkfilename))
                {
                    candkdata.put(filename,data1);
                    break;
                }
            }
        }
        
        try {
            buildcsv(candkdata);
        } catch (IOException | WriteException ex) {
            Logger.getLogger(CandKFilter1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("total rows are : " + candkdata.size());
        
      
//        for (String key : candkdata.keySet()) {
//    // ...
//            
//            CSVFile temp = candkdata.get(key);
//            
//            sheet.addCell(new Label ( column++ ,row,key));
//            
//            System.out.println( key  + "    " + temp.name);
//            
//    }
//        
      
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CandKFilter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CandKFilter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CandKFilter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CandKFilter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CandKFilter1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
