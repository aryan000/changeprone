/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeprone;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
import jxl.write.WriteException;

/**
 *
 * @author aryan_000
 */
public class Cho extends javax.swing.JFrame {

    /**
     * Creates new form ChoAndFch
     */
    public Cho() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select First File");

        jButton1.setText("Select First File");
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public void addCho(File f) throws IOException, BiffException, WriteException 
     { 
         
         Workbook workbook1 = Workbook.getWorkbook(f); // read mode
         System.out.println("adding cho in files");
         WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1); // write mode
         int sheetno = workbook.getNumberOfSheets();
            
         System.out.println("Total number of sheets are  : " + sheetno);
            
            for(int i =0;i<sheetno; i++)
            {
                WritableSheet sheet2 = workbook.getSheet(i);
                System.out.println(sheet2.getCell(0,0).getContents());
                int col_tach = -1;
                int loc_col = -1;
                int cho_col = sheet2.getColumns();
                int chd_col = cho_col+1;
//                System.out.println("NUmber of columns is : "  +cho_col);
                for(int j =0;j<sheet2.getColumns();j++)
                {
                    String temp = sheet2.getCell(j,0).getContents();
//                    System.out.println( "check " + j  + temp);
                    if(temp.equals("TACH"))
                    {col_tach = j;
                      
                      sheet2.addCell(new Label(cho_col , 0 , "CHO"));
                      chd_col = cho_col + 1;
                    
                    }
                    
                    if(temp.equals("LOC"))
                    {
                        loc_col = j;
                        sheet2.addCell(new Label(chd_col , 0 , "CHD"));
                    }
                    
                } 
                 
                
//                if(col_tach!=-1)
//                    System.out.println("Tach found and now adding CHO");
//                
//                else System.out.println("Not Found tach");
                int tach_value , loc_value;
                double chd_value;
                if(col_tach!=-1)
                {
                    for(int j=1;j<sheet2.getRows();j++)
                    {
                        tach_value = Integer.parseInt(sheet2.getCell(col_tach, j).getContents());
                        loc_value = Integer.parseInt(sheet2.getCell(loc_col, j).getContents());
                        if(tach_value==0)
                        {   
                            Number cho = new Number( cho_col, j , tach_value);

                            sheet2.addCell(cho);
                        }

                        else
                        {
                            Number cho = new Number(cho_col , j , 1);

                            sheet2.addCell(cho);
                        }

                        chd_value = (double)tach_value/loc_value;
                        
                        Number chd = new Number(chd_col , j , chd_value);
                        sheet2.addCell(chd);
                    } 
                }// end of all the rows in a single sheet
                System.out.println("cho adding completed");
                
            } // end of all the sheet
        
            workbook.write();
            workbook.close();
            workbook1.close();
         
     }
     
     
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String userDir = System.getProperty("user.home");
        JFileChooser folder = new JFileChooser(userDir+"/Desktop");
        folder.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
     "Excel Files  (*.xls)", "xls");
        folder.setFileFilter(xmlfilter);
        int returnvalue = folder.showSaveDialog(this);
        File myfolder = null;

        if(returnvalue == JFileChooser.APPROVE_OPTION)
        {
            myfolder = folder.getSelectedFile();
            //            System.out.println(myfolder);
        }

        if(myfolder!=null)
        {
            JOptionPane.showMessageDialog(null,"The current choosen file directory is : " + myfolder);
            jLabel1.setText(myfolder.toString());
            try {
                addCho(myfolder);
                FchAndLchAndCho cho = new FchAndLchAndCho();
                 cho.addFchAndLch(myfolder);
            } catch (IOException | BiffException | WriteException ex) {
                Logger.getLogger(Cho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Cho().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}