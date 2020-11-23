package com.dark.seminario;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.BufferedReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author rmichel
 */
public class Main {
    
//    public static final String  XLSX_FILE_PATH = "D:\\Rodrigo\\OneDrive\\UNISINOS\\Conteudo\\2 -  Seminário [Josiane Brietzke Porto]\\dados\\Logs Inversor solar Michel\\1-Dia Sol\\EOAC909168 history data - 2020-10-20_2020-10-20.xls";;
    public static final String  XLSX_FILE_PATH = "/home/rmichel/Desktop/2-EOAC90903F history data - 2020-10-20_2020-10-20.xls";
    public static final String  CSV_FILE = "/home/rmichel/Desktop/RIO PARDO (A813).csv";

    
    public static void main(String[] args) throws IOException, InvalidFormatException {

        try {
            BufferedReader br = new BufferedReader(new FileReader(CSV_FILE));
            String line = "";
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(";");
                System.out.println(Arrays.toString(country));
                System.out.println((country[0]));
            }
        }catch(IOException e){
        }
        
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
    }
}