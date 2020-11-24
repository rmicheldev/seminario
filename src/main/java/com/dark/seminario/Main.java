package com.dark.seminario;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author rmichel
 */
public class Main {
    
//    public static final String  XLSX_FILE_PATH = "D:\\Rodrigo\\OneDrive\\UNISINOS\\Conteudo\\2 -  Seminário [Josiane Brietzke Porto]\\dados\\Logs Inversor solar Michel\\1-Dia Sol\\EOAC909168 history data - 2020-10-20_2020-10-20.xls";;
    public static final String  XLSX_FILE_PATH = "/home/rmichel/Desktop/2-EOAC90903F history data - 2020-10-20_2020-10-20.xls";
    public static final String  CSV_FILE = "/home/rmichel/Desktop/al/estMet.csv";
    
    public static void main(String[] args) throws IOException, InvalidFormatException {
    
        ArrayList<FinalData> registrosEM = new ArrayList<>();
        Map<Integer, TimeStep> powerByHours = new HashMap<>();
        
        EstMet em = new EstMet(registrosEM);
        em.loadFile(CSV_FILE);
        em.extractData();
        
        Fotovol fv = new Fotovol(powerByHours);
        fv.loadFile(XLSX_FILE_PATH);
        fv.extractData();

        
    }
}