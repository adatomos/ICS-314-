/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics314;

/**
 *
 * @author Ada
 */
//import java.io.PrintWriter;
import static java.lang.System.*;
import java.io.*;
public class ICS314 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        
        
        /**********************
         * 
         * this is chris's comment block!
         * 
         **********************/
 //hello Nigel and Chris      
        try{
            FileWriter fw = new FileWriter("314.ics");
            PrintWriter pw = new PrintWriter(fw);
            pw.println("BEGIN:VCALENDAR");
            pw.println("PRODID:-//Google Inc//Google Calendar 70.9054//EN");
            pw.println("VERSION:2.0");
            pw.println("CALSCALE:GREGORIAN");
            pw.println("METHOD:PUBLISH");
            pw.println("X-WR-CALNAME:ICS 314");
            pw.println("X-WR-TIMEZONE:Pacific/Honolulu");
            pw.println("X-WR-CALDESC:for class");
            pw.println("BEGIN:VEVENT");
            pw.println("DTSTART:20160219T180000Z");
            pw.println("DTEND:20160219T190000Z");
            pw.println("DTSTAMP:20160218T055806Z");
            pw.println("UID:tccsg6j6deenb9gr61l0h7gcas@google.com");
            pw.println("CREATED:20160218T055746Z");
            pw.println("DESCRIPTION:");
            pw.println("LAST-MODIFIED:20160218T055746Z");
            pw.println("LOCATION:");
            pw.println("SEQUENCE:0");
            pw.println("STATUS:CONFIRMED");
            pw.println("SUMMARY:Meet with TA by 02/27 next Saturday");
            pw.println("TRANSP:OPAQUE");
            pw.println("END:VEVENT");
            pw.println("END:VCALENDAR");
            pw.close();
        }catch (IOException e){
            out.println("ERROR");
        }
    }
    
}
