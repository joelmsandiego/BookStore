/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.store.daoutils;

/**
 *
 * @author Jeric
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author cerberus
 */
public class DateFormatterUtil {
    
    private static final Logger LOG = LoggerFactory.getLogger(DateFormatterUtil.class);
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat year = new SimpleDateFormat("yyyy");
    private static final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    public String stringToDate(Date date){
        String retval = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
            retval = dateFormat.format(date);
        }catch(Exception e){
            LOG.debug("ERROR MESSAGE: "+e.getMessage());
        }
        return retval;
    }
    public DateFormatterUtil() { }
    
     public String hrisDefaultDate(Date date){
        String retval = null;
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        try{
            retval = dateFormat.format(date);
        }catch(Exception e){
            LOG.debug("ERROR MESSAGE: "+e.getMessage());
        }
        return retval;
    }
    public String getDateTime(){
        String retval = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        try{
            retval = dateFormat.format(date);
        }catch(Exception e){
            LOG.debug("ERROR MESSAGE: "+e.getMessage());
        }
        LOG.debug("RETVAL: "+retval);
        return retval;
    }
    public static String convertDateAndTimeToString(Date date){
        String retval = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        try{
            retval = dateFormat.format(date);
        }catch(Exception e){
            LOG.debug("ERROR MESSAGE: "+e.getMessage());
        }
//        LOG.debug("RETVAL: "+retval);
        return retval;
    }
      public static String convertDateOnlyString(Date date){
        String retval = null;
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
//        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd, yyyy");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            retval = dateFormat.format(date);
        }catch(Exception e){
            LOG.debug("ERROR MESSAGE: "+e.getMessage());
        }
//        LOG.debug("RETVAL: "+retval);
        return retval;
    }
    public static Date extractYear(String dateYear) {
        Date retval = null;
            try {
                retval = year.parse(dateYear);
            } catch (Exception pe) {
                LOG.debug("format exception : " + pe.getMessage());
            }
        return retval;
    }
    public Date extractDate(String dateString) {
        Date retval = null;
        if(dateString != null && dateString.trim().isEmpty() == false) {
            try {
                retval = DATE_FORMATTER.parse(dateString);
            } catch (Exception pe) {
                LOG.debug("format exception : " + pe.getMessage());
            }
        }
        return retval;
    }
    //sssssssss
     public Date extractDateAndTime(String dateString) {
        Date retval = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if(dateString != null && dateString.trim().isEmpty() == false) {
            try {
                retval = dateFormat.parse(dateString);
            } catch (Exception pe) {
                LOG.debug("format exception : " + pe.getMessage());
            }
        }
        return retval;
    }
    
    //sdddd
    public String convertDate(Date date) {
        return DATE_FORMATTER.format(date);
    }
    
    public String timeToString(String timeToString){
            
       DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
       Date date = new Date();
       
       String time=dateFormat.format(date);
       return time;
    }
    
    public Date stringToTime(String time){
         
      LOG.debug("Converting String to time."+time);
     // String startDateString = "hh:mm:ss";
      DateFormat df = new SimpleDateFormat("hh:mm:ss");
      Date startDate = null;
        try {
            startDate = df.parse(time);
            LOG.debug("String Converted."+time);
        } catch (ParseException ex) {
            LOG.debug("ERROR: Converting TIME : " + time);
        }
      return startDate;
    }
    public Date dateToTime(String datatime){
        SimpleDateFormat Datetime = new SimpleDateFormat("MM/dd/yyyy");
           Date retval = null;
        if(datatime != null && datatime.trim().isEmpty() == false) {
            try {
                retval = Datetime.parse(datatime);
                LOG.debug("NEW DATE {}", retval);
            } catch (Exception pe) {
                LOG.debug("format exception : " + pe.getMessage());
            }
        }
     
        return retval;

    }
}


