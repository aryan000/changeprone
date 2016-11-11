/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeprone;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
public class FchAndLchAndCho {
    
    
    public final static HashMap<String, Integer> fch = new HashMap<>();
    public final static HashMap<String, Integer> lch = new HashMap<>();
    public final static HashMap<String, Integer> frch = new HashMap<>();
        static int curr_version  = 0;
        
        
   public void addCho(File f) throws IOException, BiffException, WriteException 
     { 
         
         Workbook workbook1 = Workbook.getWorkbook(f); // read mode
         System.out.println("here");
         WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1); // write mode
         int sheetno = workbook.getNumberOfSheets();
            
            
            for(int i =0;i<sheetno; i++)
            {
                WritableSheet sheet2 = workbook.getSheet(i);
                
                int col_tach = -1;
                 
                int cho_col = sheet2.getColumns();
                for(int j =0;i<sheet2.getColumns();j++)
                {
                    String temp = sheet2.getCell(j,0).getContents();
                    System.out.println(temp);
                    if(temp.equals("TACH"))
                    {col_tach = j;
                      sheet2.addCell(new Label(cho_col , 0 , "CHO"));
                    break;}
                    
                } 
                System.out.println("here after tach");
                int tach_value;
                
                if(col_tach!=-1)
                {
                    for(int j=1;j<sheet2.getRows();j++)
                    {
                        tach_value = Integer.parseInt(sheet2.getCell(col_tach, j).getContents());

                        if(tach_value==0)
                        {   
                            jxl.write.Number cho = new jxl.write.Number( cho_col, j , tach_value);

                            sheet2.addCell(cho);
                        }

                        else
                        {
                            jxl.write.Number cho = new jxl.write.Number(cho_col , j , 1);

                            sheet2.addCell(cho);
                        }


                    } 
                }// end of all the rows in a single sheet
                System.out.println("cho adding completed");
                
            } // end of all the sheet
        
            workbook.write();
            workbook.close();
            workbook1.close();
         
     }
  
   public void addFchAndLch(File f) throws IOException, BiffException, WriteException
{
         Workbook workbook1 = Workbook.getWorkbook(f); // read mode
         System.out.println("here");
         WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1); // write mode
         int sheetno = workbook.getNumberOfSheets();
            
            
            for(int i =0;i<sheetno; i++)
            {
                WritableSheet sheet2 = workbook.getSheet(i);
                 
                 
                String filename ;
                int cho_value , cho_col =-1, fch_val;
                int lch_val , frch_val ;
                 
                int fch_col = sheet2.getColumns();
                int lch_col = fch_col+1;
                int frch_col = fch_col+2;
                int chd_col = fch_col+3;
                
                int loc_col = -1;
                for(int j =0;j<sheet2.getColumns();j++)
                {
                    String temp = sheet2.getCell(j,0).getContents();
                    System.out.println(temp);
                    if(temp.equals("CHO"))
                    { cho_col = j;
                      sheet2.addCell(new Label(fch_col , 0 , "FCH"));
                      sheet2.addCell(new Label(lch_col , 0 , "LCH"));
                      
                      sheet2.addCell(new Label(frch_col , 0 , "FRCH"));
                    }
                    if(temp.equals("LOC"))
                    {
                        loc_col = j;
                    }
                    
                } 
                
                System.out.println("cho column is : " + cho_col);
                if(cho_col!=-1)
                {
                            for(int j =1;j<sheet2.getRows();j++)
                           {

                               filename = sheet2.getCell(0,j).getContents();
                               if (fch.containsKey(filename)) {

                                   // file present

                                   fch_val = fch.get(filename);
                                   lch_val = lch.get(filename);
                                   frch_val = frch.get(filename); 
                                   
                                   // adding fch
                                   if(fch_val!=0)
                                   {
                                       jxl.write.Number fch_metric_value = new jxl.write.Number( fch_col, j , fch_val);
                                       sheet2.addCell(fch_metric_value);
                                   }

                                   else
                                   {
                                       cho_value = Integer.parseInt(sheet2.getCell(cho_col, j).getContents());

                                       if(cho_value==0)
                                       {
                                          jxl.write.Number fch_metric_value = new jxl.write.Number( fch_col, j , fch_val);
                                          sheet2.addCell(fch_metric_value); 
                                       }

                                       else
                                       {
                                          jxl.write.Number fch_metric_value = new jxl.write.Number( fch_col, j , curr_version);
                                          sheet2.addCell(fch_metric_value); 

                                          fch.put(filename, curr_version);
                                       }
                                   } 
                                   
                                   
                                   // adding lch
                                  cho_value = Integer.parseInt(sheet2.getCell(cho_col, j).getContents());
                                  if(cho_value==0)
                                  {
                                     jxl.write.Number lch_metric_value = new jxl.write.Number( lch_col, j , lch_val);
                                     sheet2.addCell(lch_metric_value);  
                                  } 
                                  
                                  else
                                  {
                                     jxl.write.Number lch_metric_value = new jxl.write.Number( lch_col, j , curr_version);
                                     sheet2.addCell(lch_metric_value);   
                                     lch.put(filename, curr_version);
                                     frch_val ++;
                                     frch.put(filename,frch_val);
                                  }
                                   
                                  // adding frch
                                  jxl.write.Number frch_metric_value = new jxl.write.Number( frch_col, j , frch_val);
                                     sheet2.addCell(frch_metric_value);  


                               } else {

                                   // file not present
                                   fch.put(filename,0);
                                   lch.put(filename, 0);
                                   frch.put(filename,0);
                                   jxl.write.Number fch_metric_value = new jxl.write.Number( fch_col, j , curr_version);
                                   sheet2.addCell(fch_metric_value);
                                   jxl.write.Number lch_metric_value = new jxl.write.Number( lch_col, j , curr_version);
                                   sheet2.addCell(lch_metric_value);
                                   jxl.write.Number frch_metric_value = new jxl.write.Number( frch_col, j , curr_version);
                                   sheet2.addCell(frch_metric_value);
                               }


                           }
                }
                
                curr_version ++;
            }

            
            workbook.write();
            workbook.close();
            workbook1.close();
            System.out.println("fch added ");

}
   
   
   
   
   
}
 
