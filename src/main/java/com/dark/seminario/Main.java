package com.dark.seminario;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 *
 * @author rmichel
 */
public class Main {

    public static final String  XLSX_FILE_PATH = "D:\\Rodrigo\\OneDrive\\UNISINOS\\Conteudo\\2 -  Seminário [Josiane Brietzke Porto]\\dados\\Logs Inversor solar Michel\\1-Dia Sol\\EOAC909168 history data - 2020-10-20_2020-10-20.xls";

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("A Tabela possui" + workbook.getNumberOfSheets() + " Folha(s) : ");
 
        // 3. Or you can use a Java 8 forEach with lambda
        System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        }); 

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
 

        // 3. Or you can use Java 8 forEach loop with lambda
        System.out.println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
        Map<Integer, TimeStep> powerByHours = new HashMap<>();
        
        int jump = 0;
        for (Row row: sheet) {
            if(jump++ > 2){
                Cell dthr = row.getCell(1); 
                String vdthr = dataFormatter.formatCellValue(dthr);
                
                Calendar time = Tools.getTime(vdthr);
                int hour = time.get(Calendar.HOUR_OF_DAY);
                
                System.out.print(hour + " <<<<  ");
                System.out.print(vdthr + " ");
                
                Cell status = row.getCell(2); 
                String vstatus = dataFormatter.formatCellValue(status);
                System.out.print(vstatus + " ");
                
                Cell power = row.getCell(6); 
                String vpower = dataFormatter.formatCellValue(power);
                System.out.print(vpower);
                
                double iPower = 0;
                try{
                    iPower = Double.valueOf(vpower);
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
    }
}