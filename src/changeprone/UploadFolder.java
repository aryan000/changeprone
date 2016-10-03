/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeprone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author aryan_000
 */
public class UploadFolder extends javax.swing.JFrame {

    /**
     * Creates new form UploadFolder
     * @param folder
     */
//    ArrayList filenames = new ArrayList();
    ArrayList<Files> filenames = new ArrayList<>();
    
//    WritableWorkbook workbook = Workbook.createWorkbook(new File("output.xls"));
    
    public void listofFiles( File folder)
{
    for(File testfile : folder.listFiles())
    {
        if(testfile.isDirectory())
        {
            listofFiles(testfile);
        }
        else
        {
//            System.out.println(testfile);
//            System.out.println(testfile.getName());
//            System.out.println("Size of the file is : " + testfile.length() + "Bytes");
        
         
            String ext = null  ;
            String temp = testfile.getPath();
            int i = temp.lastIndexOf('.');
            if(i>0)
                ext = temp.substring(i+1);
            
            if(ext.equals("java"))
            {
//                JOptionPane.showMessageDialog(null,"File name is : " + testfile.getName());
                 filenames.add(new Files(testfile.getName(),testfile.length(),testfile , testfile.getPath()));
                 
            }
        }
    }
} // end of listfo files function
    
    public void sortByName()
    {
         Collections.sort(filenames, (Files o1, Files o2) -> o1.Filename.compareTo(o2.Filename));
    }

    public UploadFolder() {
        initComponents();
       
        jInternalFrame1.setVisible(false);
        
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
        jButton2 = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        FileDetails = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText(" Change Proneness");

        jButton1.setText("Select Folder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Process");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jInternalFrame1.setVisible(true);

        FileDetails.setAutoCreateRowSorter(true);
        FileDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No", "File Names", "File Size", "File Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(FileDetails);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenu1.setText("File");

        jMenuItem1.setText(" New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                non(evt);
            }
        });
        jMenu3.add(About);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String userDir = System.getProperty("user.home");
        JFileChooser folder = new JFileChooser(userDir+"/Desktop");
        folder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
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
        }
        
        listofFiles(myfolder);
        sortByName();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void addsheet( WritableWorkbook workbook , File f) throws IOException, WriteException
    {
             workbook = Workbook.createWorkbook(f);
            int sheetno = workbook.getNumberOfSheets();
            
            String version = "version " + (sheetno);
            System.out.println(sheetno);
            WritableSheet sheet = workbook.createSheet(version, 0);
            
            int count = 1;
            int row =  0 ;
            int column = 0;
            sheet.addCell(new Label (column++,row ,"S.No"));
            sheet.addCell(new Label ( column++ ,row, "Filename "));
            sheet.addCell(new Label(column++ ,row, "File Size "));
            sheet.addCell(new Label(column++ ,row, "Location "));
            row++;
            column = 0;
             
            for (Files filename : filenames) 
            {
                String size = Long.toString(filename.Filesize) + "Bytes";
//                System.out.println(filename.Filename);
                Label sno = new Label (column++,row ,Integer.toString(count++));
                Label fname = new Label ( column++ ,row, filename.Filename);
                Label colsize = new Label(column++ ,row, size);
                Label location = new Label(column++ ,row, filename.FileLocation);
                
                sheet.addCell(sno);
                sheet.addCell(fname);
                sheet.addCell(colsize);
                sheet.addCell(location);
                
                row++;
                column = 0;
                
            }
            
            workbook.write();
            workbook.close();
            System.out.println("finished when the file does not exist");
            
    }
    
    
    public void addsheet(Workbook workbook1 ,File f) throws IOException, WriteException
    {   
        System.out.println("when file exists");
          WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1);
            int sheetno = workbook.getNumberOfSheets();
            
            
            for(int i =0;i<sheetno; i++)
            {
                WritableSheet sheet2 = workbook.getSheet(i);
            }
            
//            workbook.write();
            
            System.out.println(sheetno);
            String version = "version " + sheetno;
            WritableSheet sheet = workbook.createSheet(version, sheetno+1);
            
            int count = 1;
            int row =  0 ;
            int column = 0;
            sheet.addCell(new Label (column++,row ,"S.No"));
            sheet.addCell(new Label ( column++ ,row, "Filename "));
            sheet.addCell(new Label(column++ ,row, "File Size "));
            sheet.addCell(new Label(column++ ,row, "Location "));
            row++;
            column = 0;
             
            for (Files filename : filenames) 
            {
                String size = Long.toString(filename.Filesize) + "Bytes";
//                System.out.println(filename.Filename);
                Label sno = new Label (column++,row ,Integer.toString(count++));
                Label fname = new Label ( column++ ,row, filename.Filename);
                Label colsize = new Label(column++ ,row, size);
                Label location = new Label(column++ ,row, filename.FileLocation);
                
                sheet.addCell(sno);
                sheet.addCell(fname);
                sheet.addCell(colsize);
                sheet.addCell(location);
                
                row++;
                column = 0;
                
            }
            
            workbook.write();
            workbook.close();
            workbook1.close();
            System.out.println("finished when the file already exists");
            
    }
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            // TODO add your handling code here:
//        for (Files filename : filenames) {
//            System.out.println(filename.Filename );
//            System.out.println(filename.Filesize);
//            System.out.println(filename.FileLocation);
//            System.out.println(filename.file);
//        }
            jInternalFrame1.setVisible(true);
//            File f = new File("C:\\Users\\aryan_000\\Desktop\\output.xls");
            File f = new File("C:\\Users\\aryan_000\\Desktop\\output.xls");
            
            boolean checkfile = f.exists();
            
            if(!checkfile)
            {
            WritableWorkbook workbook  = Workbook.createWorkbook(f); 
            addsheet(workbook,f);
            workbook.close();
            }
            
            else
            { 
              Workbook workbook = Workbook.getWorkbook(f);
              addsheet(workbook,f);
              workbook.close();
                
            }
            int count = 1;
            DefaultTableModel model = (DefaultTableModel) FileDetails.getModel();
             
            for (Files filename : filenames) 
            {
                String size = Long.toString(filename.Filesize) + "Bytes";
                model.addRow(new Object[]{count++,filename.Filename, (size + "Bytes ") , filename.FileLocation});
            }
            
            
            JOptionPane.showMessageDialog(null,"Total number of files are : " + filenames.size());
            filenames.clear();
        } catch (IOException ex) {
            Logger.getLogger(UploadFolder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(UploadFolder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(UploadFolder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void non(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_non
        // TODO add your handling code here:
    }//GEN-LAST:event_non

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
            java.util.logging.Logger.getLogger(UploadFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UploadFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UploadFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UploadFolder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UploadFolder().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JTable FileDetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables





}