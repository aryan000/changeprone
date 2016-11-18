/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import changeprone.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author aryan_000
 */


public class CreateExcel   {
 
    public static void write_excel()
    {
         XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("version 1");
        
        System.out.println("created");
        Row row = sheet.createRow((short)0);
        Cell col = row.createCell(0);
        col.setCellValue("FileName");
        row.createCell(1).setCellValue("Boc");
                
        System.out.println("here");
           FileOutputStream fos;
       try {
         fos= new FileOutputStream("C:\\Users\\aryan_000\\Desktop\\output.xlsx");
         wb.write(fos);
         fos.close();
       } catch (FileNotFoundException e) {
       } catch (IOException e) {
       }
    }
    
    
    
    public static void add_column() throws FileNotFoundException, IOException
    {
        String excelFilePath = "C:\\Users\\aryan_000\\Desktop\\output.xlsx";
        FileOutputStream outputStream = new FileOutputStream(new File(excelFilePath));
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook wbout = new XSSFWorkbook( );
        Workbook wbin = new XSSFWorkbook(inputStream);
        Sheet firstsheet = wbin.getSheetAt(0);
        
        XSSFSheet sheet = (XSSFSheet) wbout.createSheet("version 1");
        
        int max_row = firstsheet.getLastRowNum();
        for(int i =0;i<max_row;i++)
        {
            Row row = sheet.createRow(i);
            
            for(int j =0;j<firstsheet.getLeftCol();j++)
            {
//                String str = firstsheet.get
//                Cell col = row.createCell(j).setCellValue(firstsheet.getRow(i).getCell(j).getStringCellValue());
            }
        }
    }
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        System.out.println("hello world");
       // File f = new File("C:\\Users\\aryan_000\\Desktop\\output.xls");


/*//        WritableWorkbook workbook = Workbook.createWorkbook(new File("output.xls"));
        WritableWorkbook workbook = Workbook.createWorkbook(f);
        WritableSheet sheet = workbook.createSheet("First Sheet", 0);
        
//        WritableSheet sheet1 = workbook.getSheet("First Sheet");
        String str = "aryan"; 
        
        Label label = new Label(0, 0, "Label (String)");
         
        sheet.addCell((WritableCell) label);
        workbook.write();
        workbook.close();
        System.out.println("finished");
   */   
        
       
       write_excel();
       
       add_column();
       
        
        
    }
     
    
}
