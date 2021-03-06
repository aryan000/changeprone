/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import changeprone.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author aryan_000
 */
class CSVFile 
{ 
    public String kind = "";
    public String name = "";
    int [] arr = new int[10];
    ArrayList<Integer> metric = new ArrayList<>();
    
  public CSVFile(String st)
  {   
      int i =0;
      for (String retval: st.split(",")) {
            
          if(i==0)
          {
              kind = retval;
              i++;
          }
          else if(i==1)
          {
              name = retval;
              i++;
          }
         else if(retval.isEmpty())
         {
             metric.add(0);
         }
          else
         {  
             metric.add(Integer.parseInt(retval));
//             arr[i-2] = Integer.parseInt(retval?);
//             i++;
         }
                      
                   }
  } 
}
public class CandKFilter extends javax.swing.JFrame {

    /**
     * Creates new form CandKFilter
     */
    public CandKFilter() {
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
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FileList = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("No File Selected");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Choose CSV File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("File Selection");

        jLabel3.setText("No File Selected");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setText("Choose Project File");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Select Project version ( only in number)");

        jTextField1.setText("0");

        jButton3.setText("Filter C and K File ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        FileList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.Noll", "File Name", "C and K File Name", "Checkbox", "Selection"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FileList.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(FileList);
        FileList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton4)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(22, 22, 22))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (IOException ex) {
            Logger.getLogger(CandKFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(CandKFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//         System.out.println("before returning");
        return javafiles;
     }
     
     
     
    public void match(ArrayList<CSVFile> data , String str)
    {
        Pattern pattern = Pattern.compile(str);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String userDir = System.getProperty("user.home");
        JFileChooser candkfile = new JFileChooser(userDir+"/Desktop");
        candkfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnvalue = candkfile.showSaveDialog(this);
        
        File myfile= null;
        if(returnvalue == JFileChooser.APPROVE_OPTION)
        {
            myfile = candkfile.getSelectedFile();
//            System.out.println(myfolder);         
        }
             ArrayList<CSVFile> data = null  ;  
        if(myfile!=null)
        {   
            jLabel1.setText(myfile.getAbsolutePath());
//            JOptionPane.showMessageDialog(null,"The current choosen file directory is : " + myfile);
//            File f = new File(myfile.getAbsolutePath());
//            data = getcsv(f);
            
        } 
        
//            ArrayList<String> javafiles = getjavafiles(new File("C:\\Users\\aryan_000\\Desktop\\output.xls"));
//            System.out.println(javafiles.size());
//        System.out.println("javafiles size is : " + data.size());
        
        
       
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String userDir = System.getProperty("user.home");
        JFileChooser projectfile = new JFileChooser(userDir+"/Desktop");
        projectfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnvalue = projectfile.showSaveDialog(this);
        
        File myfile= null;
        if(returnvalue == JFileChooser.APPROVE_OPTION)
        {
            myfile = projectfile.getSelectedFile();
//            System.out.println(myfolder);         
        }
            
        if(myfile!=null)
        {   
            jLabel3.setText(myfile.getAbsolutePath());
//            JOptionPane.showMessageDialog(null,"The current choosen file directory is : " + myfile);
//            File f = new File(myfile.getAbsolutePath());
//            data = getcsv(f);
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
     public Boolean ismatch(String jfile , String candkfile)
  {
      return jfile.matches(".*"+jfile);
  }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // here i have to process the file
        
        File f = new File(jLabel1.getText());
        ArrayList<CSVFile> data = null  ;  
        data = getcsv(f); 
        
        System.out.println("received data of csv : " + data.size());
        int version = Integer.parseInt(jTextField1.getText());
        ArrayList<String> javafiles = getjavafiles(new File(jLabel3.getText()),version );
        
        System.out.println("javafiles names received : " + javafiles.size());
        
        
        
         ArrayList<ArrayList<String>> outer = new ArrayList<>(); 
        String line ;
      String pattern  ;
       DefaultTableModel model = (DefaultTableModel) FileList.getModel();
//      Scanner sc = new Scanner(System.in);
      int count = 1;
        for (String javafile : javafiles) {
//          ArrayList<String> inner = new ArrayList<String>(); 
//          inner.add(javafiles.get(j));
            System.out.println("filename is : " + javafile);
            for (CSVFile data1 : data) {
                //            System.out.println( data.get(i).name);
                line = data1.name;
                System.out.println("CSVFile name is : " + line);
                String temp = javafile;
                pattern = temp.substring(0,temp.lastIndexOf("."));
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(line);
                if (m.find( )) {
//                    System.out.println("Found value: " + m.group(0));
//                    inner.add(line);
                    model.addRow(new Object[]{count++, temp, line, data1.metric, Boolean.FALSE});
                } else {
//                    System.out.println("NO MATCH");
                }
            } 
//        outer.add(inner);
        }
        // end of button function  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        System.out.println("Number of rows : " + FileList.getRowCount());
        for (int i = 0; i < FileList.getRowCount(); i++) {
            Boolean isChecked = false;
            
      isChecked =  (Boolean) FileList.getValueAt(i, 4);
            
     if (isChecked) {
        //get the values of the columns you need. 
         System.out.println(FileList.getValueAt(i, 2).toString());
         
    } else {
//        System.out.printf("Row %s is not checked \n", i);
    }
     isChecked = false;
//            System.out.println(FileList.getValueAt(i, 0 ).toString()  + FileList.getValueAt(i, 1) + FileList.getValueAt(i, 4));
}
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(CandKFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CandKFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CandKFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CandKFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CandKFilter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FileList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

