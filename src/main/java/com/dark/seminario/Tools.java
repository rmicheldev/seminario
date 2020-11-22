package com.dark.seminario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rmichel
 */
public class Tools {
    
    public static Calendar getTime(String timestamp){
        Calendar calendar = null;
        try {
            Date date = null;
            DateFormat formatter = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            date = (java.util.Date)formatter.parse(timestamp);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        } catch (ParseException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return calendar;
    }
}
