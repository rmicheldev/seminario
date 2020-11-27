package com.dark.seminario;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author rmichel
 */
public class FinalData {
    private static DecimalFormat df = new DecimalFormat("0.00");
    private Calendar date;
    private double precipitacao;
    private double pressao;
    private double pressaoMaxAnt;
    private double pressaoMinAnt;
    private double radiacaoGlobal;
    private double temperatura;
    private double temperaturaMaxAnt;
    private double temperaturaMinAnt;
    private double temperaturaOrvalho;
    private double temperaturaOrvalhoMaxAnt;
    private double temperaturaOrvalhoMinAnt;
    private double umidade;
    private double umidadeMaxAnt;
    private double umidadeMinAnt;
    private double ventoDir;
    private double ventoMax;
    private double ventoVel;
    private Double energiaGerada;

    /**
     * @return the precipitacao
     */
    public double getPrecipitacao() {
        return precipitacao;
    }

    /**
     * @param precipitacao the precipitacao to set
     */
    public void setPrecipitacao(double precipitacao) {
        this.precipitacao = precipitacao;
    }

    /**
     * @return the pressao
     */
    public double getPressao() {
        return pressao;
    }

    /**
     * @param pressao the pressao to set
     */
    public void setPressao(double pressao) {
        this.pressao = pressao;
    }

    /**
     * @return the pressaoMaxAnt
     */
    public double getPressaoMaxAnt() {
        return pressaoMaxAnt;
    }

    /**
     * @param pressaoMaxAnt the pressaoMaxAnt to set
     */
    public void setPressaoMaxAnt(double pressaoMaxAnt) {
        this.pressaoMaxAnt = pressaoMaxAnt;
    }

    /**
     * @return the pressaoMinAnt
     */
    public double getPressaoMinAnt() {
        return pressaoMinAnt;
    }

    /**
     * @param pressaoMinAnt the pressaoMinAnt to set
     */
    public void setPressaoMinAnt(double pressaoMinAnt) {
        this.pressaoMinAnt = pressaoMinAnt;
    }

    /**
     * @return the radiacaoGlobal
     */
    public double getRadiacaoGlobal() {
        return radiacaoGlobal;
    }

    /**
     * @param radiacaoGlobal the radiacaoGlobal to set
     */
    public void setRadiacaoGlobal(double radiacaoGlobal) {
        this.radiacaoGlobal = radiacaoGlobal;
    }

    /**
     * @return the temperatura
     */
    public double getTemperatura() {
        return temperatura;
    }

    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * @return the temperaturaMaxAnt
     */
    public double getTemperaturaMaxAnt() {
        return temperaturaMaxAnt;
    }

    /**
     * @param temperaturaMaxAnt the temperaturaMaxAnt to set
     */
    public void setTemperaturaMaxAnt(double temperaturaMaxAnt) {
        this.temperaturaMaxAnt = temperaturaMaxAnt;
    }

    /**
     * @return the temperaturaMinAnt
     */
    public double getTemperaturaMinAnt() {
        return temperaturaMinAnt;
    }

    /**
     * @param temperaturaMinAnt the temperaturaMinAnt to set
     */
    public void setTemperaturaMinAnt(double temperaturaMinAnt) {
        this.temperaturaMinAnt = temperaturaMinAnt;
    }

    /**
     * @return the temperaturaOrvalho
     */
    public double getTemperaturaOrvalho() {
        return temperaturaOrvalho;
    }
    
    /**
    * @param temperaturaOrvalho the temperaturaOrvalho to set
     */
    public void setTemperaturaOrvalho(double temperaturaOrvalho) {
        this.temperaturaOrvalho = temperaturaOrvalho;
    }

    /**
     * @return the temperaturaOrvalhoMaxAnt
     */
    public double getTemperaturaOrvalhoMaxAnt() {
        return temperaturaOrvalhoMaxAnt;
    }

    /**
     * @param temperaturaOrvalhoMaxAnt the temperaturaOrvalhoMaxAnt to set
     */
    public void setTemperaturaOrvalhoMaxAnt(double temperaturaOrvalhoMaxAnt) {
        this.temperaturaOrvalhoMaxAnt = temperaturaOrvalhoMaxAnt;
    }

    /**
     * @return the temperaturaOrvalhoMinAnt
     */
    public double getTemperaturaOrvalhoMinAnt() {
        return temperaturaOrvalhoMinAnt;
    }

    /**
     * @param temperaturaOrvalhoMinAnt the temperaturaOrvalhoMinAnt to set
     */
    public void setTemperaturaOrvalhoMinAnt(double temperaturaOrvalhoMinAnt) {
        this.temperaturaOrvalhoMinAnt = temperaturaOrvalhoMinAnt;
    }

    /**
     * @return the umidade
     */
    public double getUmidade() {
        return umidade;
    }

    /**
     * @param umidade the umidade to set
     */
    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    /**
     * @return the umidadeMaxAnt
     */
    public double getUmidadeMaxAnt() {
        return umidadeMaxAnt;
    }

    /**
     * @param umidadeMaxAnt the umidadeMaxAnt to set
     */
    public void setUmidadeMaxAnt(double umidadeMaxAnt) {
        this.umidadeMaxAnt = umidadeMaxAnt;
    }

    /**
     * @return the umidadeMinAnt
     */
    public double getUmidadeMinAnt() {
        return umidadeMinAnt;
    }

    /**
     * @param umidadeMinAnt the umidadeMinAnt to set
     */
    public void setUmidadeMinAnt(double umidadeMinAnt) {
        this.umidadeMinAnt = umidadeMinAnt;
    }

    /**
     * @return the ventoDir
     */
    public double getVentoDir() {
        return ventoDir;
    }

    /**
     * @param ventoDir the ventoDir to set
     */
    public void setVentoDir(double ventoDir) {
        this.ventoDir = ventoDir;
    }

    /**
     * @return the ventoMax
     */
    public double getVentoMax() {
        return ventoMax;
    }

    /**
     * @param ventoMax the ventoMax to set
     */
    public void setVentoMax(double ventoMax) {
        this.ventoMax = ventoMax;
    }

    /**
     * @return the ventoVel
     */
    public double getVentoVel() {
        return ventoVel;
    }

    /**
     * @param ventoVel the ventoVel to set
     */
    public void setVentoVel(double ventoVel) {
        this.ventoVel = ventoVel;
    }

    /**
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setEnergiaGerada(double energiaGerada) {
        this.energiaGerada = energiaGerada;
    }
    public double getEnergiaGerada() {
        return energiaGerada;
    }

    public boolean hasEnergiaGerada() {
        return energiaGerada != null;
    }

    @Override
    public String toString() {
        String out = "";
        out += "Data: "+toDate(date);
        out += " Radiação: "+radiacaoGlobal;
        out += " Energia: "+energiaGerada;
        return out;
    }
    
    private String toDate(Calendar date) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd-HH");
            // Output "Wed Sep 26 14:23:28 EST 2012"
            
            String formatted = format1.format(date.getTime());
            return(formatted);            
            // Output "Wed Sep 26 00:00:00 EST 2012"
        } catch (Exception ex) {
            return "0000000000";
        }
    }
    
    private String toISODate(Calendar date) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            // Output "Wed Sep 26 14:23:28 EST 2012"
            
            String formatted = format1.format(date.getTime());
            return(formatted);            
            // Output "Wed Sep 26 00:00:00 EST 2012"
        } catch (Exception ex) {
            return "0000000000";
        }
    }

    public static String toCSVTitle() {
        String text;
        text =  "\"data\",";
        text += "\"precipitacao\",";
        text += "\"pressao\",";
        text += "\"pressaoMaxAnt\",";
        text += "\"pressaoMinAnt\",";
        text += "\"radiacaoGlobal\",";
        text += "\"temperatura\",";
        text += "\"temperaturaMaxAnt\",";
        text += "\"temperaturaMinAnt\",";
        text += "\"temperaturaOrvalho\",";
        text += "\"temperaturaOrvalhoMaxAnt\",";
        text += "\"temperaturaOrvalhoMinAnt\",";
        text += "\"umidade\",";
        text += "\"umidadeMaxAnt\",";
        text += "\"umidadeMinAnt\",";
        text += "\"ventoDir\",";
        text += "\"ventoMax\",";
        text += "\"ventoVel\",";
        text += "\"energiaGerada\"";
        return text;
    }
    public String toCSV() {
        String text;
        text = "\""+toISODate(date)+"\",";
        text += precipitacao + ",";
        text += pressao + ",";
        text += pressaoMaxAnt + ",";
        text += pressaoMinAnt + ",";
        text += radiacaoGlobal + ",";
        text += temperatura + ",";
        text += temperaturaMaxAnt + ",";
        text += temperaturaMinAnt + ",";
        text += temperaturaOrvalho + ",";
        text += temperaturaOrvalhoMaxAnt + ",";
        text += temperaturaOrvalhoMinAnt + ",";
        text += umidade + ",";
        text += umidadeMaxAnt + ",";
        text += umidadeMinAnt + ",";
        text += ventoDir + ",";
        text += ventoMax + ",";
        text += ventoVel + ",";
        text += df.format(energiaGerada).toString().replace(",", ".");
        return text;
    }
}
