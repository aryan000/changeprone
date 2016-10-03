/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeprone;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


/**
 *
 * @author aryan_000
 */
public class CreateExcel   {
 
    
    
    public static void main(String[] args) throws IOException, WriteException {
        // TODO code application logic here
        System.out.println("hello world");
        File f = new File("C:\\Users\\aryan_000\\Desktop\\output.xls");
//        WritableWorkbook workbook = Workbook.createWorkbook(new File("output.xls"));
        WritableWorkbook workbook = Workbook.createWorkbook(f);
        WritableSheet sheet = workbook.createSheet("First Sheet", 0);
        
//        WritableSheet sheet1 = workbook.getSheet("First Sheet");
        String str = "aryan"; 
        
        Label label = new Label(0, 0, "Label (String)");
         
        sheet.addCell((WritableCell) label);
        workbook.write();
        workbook.close();
        System.out.println("finished");
                
    }
     
    
}
