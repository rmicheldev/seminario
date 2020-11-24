package com.dark.seminario;

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
    public static final String  XLSX_FILE_PATH = "/home/rmichel/Desktop/2-EOAC90903F history data - 2020-10-20_2020-10-20.xls";
    public static final String  CSV_FILE = "/home/rmichel/Desktop/al/estMet.csv";
    
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
        Fotovol fv = new Fotovol(powerByHours);
        fv.loadFile(XLSX_FILE_PATH);
        fv.extractData();
        
        
        if(registrosEM != null){
            Set<String> keySet = registrosEM.keySet();
            for(String key : keySet){
                if(powerByHours.containsKey(key)){
                    registrosEM.get(key).setEnergiaGerada(powerByHours.get(key).getMean());
                }else{
//                    System.out.println("NÃO Achou "+key);
                }
            }
            
            for(String key : keySet){
                if(registrosEM.get(key).hasEnergiaGerada()){
                    System.out.println(registrosEM.get(key).toString());
                }
            }
        }
    }
}