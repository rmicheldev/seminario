package com.dark.seminario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

/**
 *
 * @author rmichel
 */
public class EstMet {
    Map<String, FinalData> registrosEM;
    
    public EstMet(Map<String, FinalData> registrosEM){
        this.registrosEM = registrosEM;
    }
    
    ArrayList<String[]> info = new ArrayList<>();
    
    public void loadFile(String fileName){    
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] inf = line.split(";");
                info.add(inf);
            }
        }catch(IOException e){
        }
    }
    
    public void extractData() throws Exception{
        info.remove(0);
        for(String[] inf: info){
            Calendar date = toDate(inf[0], inf[1]);
            String hashDate = toHashDate(date);
            
            FinalData fd = new FinalData();
            fd.setDate(date);
            fd.setPrecipitacao(vToDouble(inf[2]));
            fd.setPressao(vToDouble(inf[3]));
            fd.setPressaoMaxAnt(vToDouble(inf[4]));
            fd.setPressaoMinAnt(vToDouble(inf[5]));
            fd.setRadiacaoGlobal(vToDouble(inf[6]));
            fd.setTemperatura(vToDouble(inf[7]));
            fd.setTemperaturaMaxAnt(vToDouble(inf[9]));
            fd.setTemperaturaMinAnt(vToDouble(inf[10]));
            fd.setTemperaturaOrvalho(vToDouble(inf[8]));
            fd.setTemperaturaOrvalhoMaxAnt(vToDouble(inf[11]));
            fd.setTemperaturaOrvalhoMinAnt(vToDouble(inf[12]));
            fd.setUmidadeMaxAnt(vToDouble(inf[13]));
            fd.setUmidadeMinAnt(vToDouble(inf[14]));
            fd.setUmidade(vToDouble(inf[15]));
            fd.setVentoDir(vToDouble(inf[16]));
            fd.setVentoMax(vToDouble(inf[17]));
            fd.setVentoVel(vToDouble(inf[18]));
            
            if(registrosEM.containsKey(hashDate)){
                throw new Exception("Registro duplicado "+hashDate);    
            } else{
                registrosEM.put(hashDate, fd);
            }
        }
    }
    
    private double vToDouble(String v){
        try{
            String rv = v.replaceAll(",", ".");
            Double dv = Double.valueOf(rv);
            return dv;
        } catch(NumberFormatException e) {
        }
        return 0;
    }
    
    private Calendar toDate(String d1, String d2){
        String day = d1;
        String hour = d2.substring(0, 2);
        String date = day + " "+ hour+":00";
        Calendar time = Tools.getTime("yyyy/MM/dd HH:mm", date);
        time.add(Calendar.HOUR, -3);

        return time;
    }

    private String toHashDate(Calendar date) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHH");
            // Output "Wed Sep 26 14:23:28 EST 2012"
            
            String formatted = format1.format(date.getTime());
            return(formatted);            
            // Output "Wed Sep 26 00:00:00 EST 2012"
        } catch (Exception ex) {
            return "0000000000";
        }
    }
}
