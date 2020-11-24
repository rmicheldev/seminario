package com.dark.seminario;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author rmichel
 */
public class Fotovol {
    Sheet sheet;
    Workbook workbook;
    Map<Integer, TimeStep> powerByHours;
            
    public Fotovol(Map<Integer, TimeStep> powerByHours){
        this.powerByHours = powerByHours;
    }
    
    public void loadFile(String filename){
        try {
            // Creating a Workbook from an Excel file (.xls or .xlsx)
            workbook = WorkbookFactory.create(new File(filename));
            
            // Retrieving the number of sheets in the Workbook
            System.out.println("A Tabela possui" + workbook.getNumberOfSheets() + " Folha(s) : ");
            
            // 3. Or you can use a Java 8 forEach with lambda
            System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
            workbook.forEach(sheet -> {
                System.out.println("=> " + sheet.getSheetName());
            });
            
            // Getting the Sheet at index zero
            sheet = workbook.getSheetAt(0);
        } catch (IOException | InvalidFormatException | EncryptedDocumentException ex) {
            Logger.getLogger(Fotovol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void extractData(){
        try {
            DataFormatter dataFormatter = new DataFormatter();
            
            // 3. Or you can use Java 8 forEach loop with lambda
            System.out.println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
                        
            int jump = 0;
            for (Row row: sheet) {
                if(jump++ > 2){
                    Cell dthr = row.getCell(1);
                    String vdthr = dataFormatter.formatCellValue(dthr);
                    
                    Calendar time = Tools.getTime("yyyy-MM-dd HH:mm:ss", vdthr);
                    int hour = time.get(Calendar.HOUR_OF_DAY);
                    
                    System.out.print(hour + " <<<<  ");
                    System.out.print(vdthr + " ");
                    
                    Cell status = row.getCell(2);
                    String vstatus = dataFormatter.formatCellValue(status);
                    System.out.print(vstatus + " ");
                    
                    Cell ppv = row.getCell(12);
                    String vppv = dataFormatter.formatCellValue(ppv);
                    System.out.print(vppv);
                    
                    double iPower = 0;
                    try{
                        iPower = Double.valueOf(vppv);
                    }catch(NumberFormatException e){
                        
                    }
                    
                    if(powerByHours.containsKey(hour)){
                        TimeStep temp = powerByHours.get(hour);
                        temp.newStep(iPower);
                    } else{
                        TimeStep ts = new TimeStep();
                        ts.newStep(iPower);
                        powerByHours.put(hour, ts);
                    }
                    
                }
                System.out.println("");
            }
            
            // Closing the workbook
            workbook.close();
            
            for (Integer key : powerByHours.keySet()) {
                
                //Capturamos o valor a partir da chave
                TimeStep value = powerByHours.get(key);
                System.out.println(key + " = " + value.count + "    "+value.power + "  Media "+value.getMean());
            }
        } catch (IOException ex) {
            Logger.getLogger(Fotovol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
