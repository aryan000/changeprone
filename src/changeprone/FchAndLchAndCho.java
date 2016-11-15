/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeprone;

import java.io.File;
import java.io.IOException;
import static java.lang.Math.abs;
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
    public final static HashMap<String, Integer> loc = new HashMap<>();
    static int curr_version  = 0;
        
        
   
   public void addFchAndLch(File f) throws IOException, BiffException, WriteException
{
    
         Workbook workbook1 = Workbook.getWorkbook(f); // read mode
         System.out.println("Adding Fch , Lch , Frch , CSD , Csbc , Lca , Lcd ");
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
                int csd_col = fch_col+3;
                int csbc_col = fch_col+4;
                int lca_col = fch_col+5;
                int lcd_col = fch_col + 6;
                int wch_col = fch_col + 7;
//                System.out.println(fch_col  + " and " + csd_col);
                int csd_value ;
                double csbc_value;
                int loc_col = -1;
                
                int boc_col = 1;
                int tach_col = 1, chd_col = 1;
                
                for(int j =0;j<sheet2.getColumns();j++)
                {
                    String temp = sheet2.getCell(j,0).getContents();
//                    System.out.println(temp);
                    if(temp.equals("CHO"))
                    { cho_col = j;
                      sheet2.addCell(new Label(fch_col , 0 , "FCH"));
                      sheet2.addCell(new Label(lch_col , 0 , "LCH"));
                      sheet2.addCell(new Label(frch_col , 0 , "FRCH"));
                      sheet2.addCell(new Label(csd_col , 0 , "CSD"));
                      sheet2.addCell(new Label(csbc_col , 0 , "CSBC"));
                      sheet2.addCell(new Label(lca_col , 0 , "LCA"));
                      sheet2.addCell(new Label(lcd_col , 0 , "LCD"));
                      
                      
                    }
                    if(temp.equals("LOC"))
                    {
                        loc_col = j;
                    } 
                    
                    if(temp.equals("TACH"))
                    {
                        tach_col = j;
                    }
                    
                    if(temp.equals("CHD"))
                    {
                        chd_col = j;
                    }
                    if(temp.equals("BOC"))
                    {
                        boc_col = j;
                    }
                    
                } 
                
//                System.out.println("cho column is : " + cho_col);
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
                                   lch_val  = 0;
                                   frch.put(filename,0);
                                   jxl.write.Number fch_metric_value = new jxl.write.Number( fch_col, j , curr_version);
                                   sheet2.addCell(fch_metric_value);
                                   jxl.write.Number lch_metric_value = new jxl.write.Number( lch_col, j , curr_version);
                                   sheet2.addCell(lch_metric_value);
                                   jxl.write.Number frch_metric_value = new jxl.write.Number( frch_col, j , curr_version);
                                   sheet2.addCell(frch_metric_value);
                                 
                               }
                               
                               
                               int loc_value = Integer.parseInt(sheet2.getCell(loc_col, j).getContents());
                               
                               if(loc.containsKey(filename))
                               {
                                   csd_value = abs(loc_value - loc.get(filename));
                                   csbc_value = (double)loc_value/loc.get(filename);
                               }
                               
                               else
                               {
                                   csd_value = 0;
                                   csbc_value = 1.00;
                                   loc.put(filename,loc_value);
                               }
                                  
                                  jxl.write.Number csd_metric_value = new jxl.write.Number(csd_col, j, csd_value);
                                  sheet2.addCell(csd_metric_value);
                                  
                                   jxl.write.Number csbc_metric_value = new jxl.write.Number(csbc_col, j, csbc_value);
                                   sheet2.addCell(csbc_metric_value);
                                  

                               // adding lca and lcd
                                   
                                   try{
                                   int tach_value  =  Integer.parseInt(sheet2.getCell(tach_col, j).getContents());
                                   double chd_value =  Double.parseDouble(sheet2.getCell( chd_col, j).getContents());
                                    
                                   int lca_value , lcd_value;
                                   if(lch_val==curr_version || lch_val==0)
                                   {
                                       lca_value = tach_value;
                                       lcd_value = (int) chd_value;
                                   }
                                   else
                                   {
                                       HashMap<String,TachAndChd> lca = LcaAndLcd.lcaandlcd.get(lch_val);
                                       
                                       lca_value = lca.get(filename).getTach();
                                       lcd_value = (int) lca.get(filename).getChd();
                                   }
                                   
                                   
//                                       System.out.println( " lca value is : " + lca_value + " and " + "lcd value is :  " + lcd_value);
                                   jxl.write.Number lca_metric_value = new jxl.write.Number(lca_col, j, lca_value);
                                   sheet2.addCell(lca_metric_value);
                                   jxl.write.Number lcd_metric_value = new jxl.write.Number(lcd_col, j, lcd_value);
                                   sheet2.addCell(lcd_metric_value);
                                    }
                                   catch(NumberFormatException e)
                                   {
                                       System.err.println(e);
                                   }                            
                                 
                                   
                                   // adding wch
                                   
                                   

                                   
                                   
                           } // end of j which is row
                                   
                            
                }
                
                curr_version ++;
            }

            
            workbook.write();
            workbook.close();
            workbook1.close();
            System.out.println("fch lch cho frch csd csbs added ");

} 
   
   public void addwch(File f) throws IOException, BiffException, WriteException 
   {    
        Workbook workbook1 = Workbook.getWorkbook(f); // read mode
        System.out.println("Adding WCH");
        WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1); // write mode
        int sheetno = workbook.getNumberOfSheets();
        
        String filename;
        for(int i =0;i<sheetno; i++)
        {
            WritableSheet sheet2 = workbook.getSheet(i);
            int wch_col , boc_col = 2 , wcd_col ;
            double wch_value = 0 , wcd_value = 0;
            curr_version = 1;
            for(int j =0;j<sheet2.getColumns();j++)
                { 
                    String temp = sheet2.getCell(j,0).getContents();
                    if(temp.equals("BOC"))
                        boc_col = j;
                } 
            
            wch_col = sheet2.getColumns();
            wcd_col = wch_col + 1;
            sheet2.addCell(new Label(wch_col , 0 , "WCH"));
            sheet2.addCell(new Label(wcd_col , 0 , "WCD"));
            for(int j =1;j<sheet2.getRows();j++)
            { 
                filename = sheet2.getCell(0,j).getContents();
                int boc_value = Integer.parseInt(sheet2.getCell(boc_col, j).getContents());
//                    System.out.println("boc value is : "+ boc_value);
                double temp;
                System.out.println(filename + boc_value+1 + curr_version );
                for(int r = boc_value + 1 ; r<= curr_version  ; r++)
                {
                    HashMap<String,TachAndChd> lca = LcaAndLcd.lcaandlcd.get(r);
                    int tach_val = lca.get(filename).getTach();
                    double chd_val = lca.get(filename).getChd();
                    temp =   Math.pow(2,r- curr_version);
                    
                    wch_value += tach_val*temp;
                    wcd_value += chd_val*temp;
                    System.out.println(filename + tach_val + "and " + chd_val + " and " + wch_value + " and " + wcd_value);
                }
                jxl.write.Number wch_metric_value = new jxl.write.Number(wch_col , j ,wch_value);
                 sheet2.addCell(wch_metric_value);
                 jxl.write.Number wcd_metric_value = new jxl.write.Number(wcd_col , j ,wcd_value);
                 sheet2.addCell(wcd_metric_value);
            }
            
            curr_version++;
        }
        
       workbook.write();
       workbook.close();
       workbook1.close();
       System.out.println("wch added ");
   }
   
   
   public void addAcdfAndATAF(File f) throws IOException, BiffException, WriteException
   {
        Workbook workbook1 = Workbook.getWorkbook(f); // read mode
        System.out.println("Adding ACDF ATAF and WFR");
        WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1); // write mode
        int sheetno = workbook.getNumberOfSheets();
        
       
        String filename;
        for(int i =0;i<sheetno; i++)
        {
            
            WritableSheet sheet2 = workbook.getSheet(i);
             int acdf_col = -1 ,ataf_col = -1 , frch_col = -1 , boc_col = 1 , frch_value=0 ,wfr_col = -1 , wfr_value=0;
            double acdf_value = 0 , ataf_value = 0;
            curr_version = 1;
            for(int j =0;j<sheet2.getColumns();j++)
                { 
                    String temp = sheet2.getCell(j,0).getContents();
                    if(temp.equals("BOC"))
                        boc_col = j;
                    if(temp.equals("FRCH"))
                        frch_col = j;
                } 
            
             acdf_col = sheet2.getColumns();
            ataf_col = acdf_col + 1;
            wfr_col = acdf_col+2;
            sheet2.addCell(new Label(acdf_col , 0 , "ACDF"));
            sheet2.addCell(new Label(ataf_col , 0 , "ATAF"));
            sheet2.addCell(new Label(wfr_col , 0 , "WFR"));
            for(int j =1;j<sheet2.getRows();j++)
            { 
                filename = sheet2.getCell(0,j).getContents();
                int boc_value = Integer.parseInt(sheet2.getCell(boc_col, j).getContents());
//                    System.out.println("boc value is : "+ boc_value);
                
                frch_value = Integer.parseInt(sheet2.getCell(frch_col, j).getContents());
                
                if(frch_value ==0)
                {
                    jxl.write.Number acdf_metric_value = new jxl.write.Number(acdf_col , j ,0);
                 sheet2.addCell(acdf_metric_value);
                 jxl.write.Number ataf_metric_value = new jxl.write.Number(ataf_col , j ,0);
                 sheet2.addCell(ataf_metric_value);
                 
                 wfr_value = 0;
                    for(int r = boc_value + 1 ; r<= curr_version  ; r++)
                      {
                          HashMap<String,TachAndChd> lca = LcaAndLcd.lcaandlcd.get(r);
                          int wfr_tach_value = lca.get(filename).getTach();
                          
                          if(wfr_tach_value==0)
                              continue;
                          else
                              wfr_value += r-1;
                          
                      }
                    
                    jxl.write.Number wfr_metric_value = new jxl.write.Number(wfr_col, j, wfr_value);
                    sheet2.addCell(wfr_metric_value);
                }
                else
                { 
                    double chd_value = 0;
                    int tach_value = 0;
                    int wfr_tach_value = 0;
                    wfr_value = 0;
                    for(int r = boc_value + 1 ; r<= curr_version  ; r++)
                      {
                          HashMap<String,TachAndChd> lca = LcaAndLcd.lcaandlcd.get(r);
                          wfr_tach_value = lca.get(filename).getTach();
                          tach_value += wfr_tach_value;
                          chd_value += lca.get(filename).getChd();
                          
                          if(wfr_tach_value==0)
                              continue;
                          else
                              wfr_value += r-1;
                          
                      } 
                    
                      acdf_value = (double)chd_value/frch_value;
                      ataf_value = (double)tach_value/frch_value;
                      
                    jxl.write.Number acdf_metric_value = new jxl.write.Number(acdf_col, j, acdf_value);
                    sheet2.addCell(acdf_metric_value);
                    jxl.write.Number ataf_metric_value = new jxl.write.Number(ataf_col, j, ataf_value);
                    sheet2.addCell(ataf_metric_value);
                    jxl.write.Number wfr_metric_value = new jxl.write.Number(wfr_col, j, wfr_value);
                    sheet2.addCell(wfr_metric_value);
                }  
            }
         
            
            curr_version++;
        }
       workbook.write();
       workbook.close();
       workbook1.close();
       System.out.println("ACDF and ATAF and WFR added ");
   }
   
   
   
}
 
