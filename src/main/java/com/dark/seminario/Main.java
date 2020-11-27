package com.dark.seminario;

import java.io.File;
import java.io.FileWriter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author rmichel
 */
public class Main {
    
//    public static final String  XLSX_FILE_PATH = "D:\\Rodrigo\\OneDrive\\UNISINOS\\Conteudo\\2 -  Seminário [Josiane Brietzke Porto]\\dados\\Logs Inversor solar Michel\\1-Dia Sol\\EOAC909168 history data - 2020-10-20_2020-10-20.xls";;
    public static final String  XLSX_FILE_PATH1 = "/home/rmichel/Desktop/al/DadosSolar1.xls";
    public static final String  XLSX_FILE_PATH2 = "/home/rmichel/Desktop/al/DadosSolar2.xls";
    public static final String  XLSX_FILE_PATH3 = "/home/rmichel/Desktop/al/DadosSolar3.xls";
    public static final String  XLSX_FILE_PATH4 = "/home/rmichel/Desktop/al/DadosSolar4.xls";
    
    public static final String  CSV_FILE = "/home/rmichel/Desktop/al/estMet.csv";
    public static final String  CSV_Saida = "saida.csv";
    
    public static void main(String[] args) throws IOException, InvalidFormatException {
        Map<String, FinalData> registrosEM = null;
        Map<String, TimeStep> powerByHours = null;
        try {
            registrosEM = new HashMap<>();
            
            EstMet em = new EstMet(registrosEM);
            em.loadFile(CSV_FILE);
            em.extractData();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        powerByHours = new HashMap<>();
        
        Fotovol fv1 = new Fotovol(powerByHours);
        fv1.loadFile(XLSX_FILE_PATH1);
        fv1.extractData();
        
        Fotovol fv2 = new Fotovol(powerByHours);
        fv2.loadFile(XLSX_FILE_PATH2);
        fv2.extractData();
        
        Fotovol fv3 = new Fotovol(powerByHours);
        fv3.loadFile(XLSX_FILE_PATH3);
        fv3.extractData();
        
        Fotovol fv4 = new Fotovol(powerByHours);
        fv4.loadFile(XLSX_FILE_PATH4);
        fv4.extractData();
        
        if(registrosEM != null){
            Set<String> keySet = registrosEM.keySet();
            for(String key : keySet){
                if(powerByHours.containsKey(key)){
                    registrosEM.get(key).setEnergiaGerada(powerByHours.get(key).getMean());
                }else{
//                    System.out.println("NÃO Achou "+key);
                }
            }
            
            FileWriter csvOutputFile = new FileWriter(CSV_Saida);
            
            csvOutputFile.append(FinalData.toCSVTitle());
            csvOutputFile.append("\r\n");
            
            for(String key : keySet){
                if(registrosEM.get(key).hasEnergiaGerada()){
                    String toCSV = registrosEM.get(key).toCSV();
                    csvOutputFile.append(toCSV);
                    csvOutputFile.append("\r\n");
                }
            }
            
            
            String toCSV = registrosEM.get("2020100913").toCSV();
            csvOutputFile.append(toCSV);
            csvOutputFile.append("\r\n");
            
            csvOutputFile.flush();
            csvOutputFile.close();
        }
    }
}