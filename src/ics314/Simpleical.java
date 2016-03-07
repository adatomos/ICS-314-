import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Simpleical {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub

    userinter();
  }


  public static void userinter() throws IOException {
    String calname, tstart, tend, msg, gpslat, gpslong, clas;
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter Calendar Name:");
    calname = input.nextLine();
    
    System.out.println("Enter Start date and time in yearmonthdateTtime format, ex. 20160218T210000 :");
    tstart = input.nextLine();
    
    System.out.println("Enter End date and time in yearmonthdateTtime format, ex. 20160218T210000 :");
    tend = input.nextLine();
    
    System.out.println("Enter GPS latitude if applicable, leave blank if not, ex. 37.386013 :");
    gpslat = input.nextLine();
    
    System.out.println("Enter GPS longitude if applicable, leave blank if not, ex. -122.082932 :");
    gpslong = input.nextLine();
    
    System.out.println("Enter class of event, (PUBLIC, PRIVATE, CONFIDENTIAL):");
    clas = input.nextLine();
    
    System.out.println("Enter Message:");
    msg = input.nextLine();
    
    createics(calname, tstart, tend, msg, gpslat, gpslong, clas);
    
    input.close();
  }
  
  private static void createics(String name, String start, String end, String msg, String gpsla, String gpslo, String clas) throws IOException{
    FileWriter write = new FileWriter("ics314.ics");
    
    write.write("BEGIN:VCALENDAR"+'\n'+"PRODID:-//Google Inc//Google Calendar 70.9054//EN"+'\n'+
                "VERSION:2.0"+'\n'+"CALSCALE:GREGORIAN"+ '\n' +"METHOD:PUBLISH"+'\n' + "X-WR-CALNAME:");
    write.write((name + '\n'));
    write.write("X-WR-TIMEZONE:Pacific/Honolulu\nBEGIN:VEVENT\nDTSTART:");
    write.write((start + '\n'));
    write.write("DTEND:");
    write.write((end + '\n'));
    write.write("GEO:");
    write.write((gpsla + ";" + gpslo + '\n'));
    write.write("CLASS:");
    write.write((clas + '\n'));
    write.write("UID:tccsg6j6deenb9gr61l0h7gcas@google.com\nDESCRIPTION:\nLOCATION:\nSEQUENCE:3\nSTATUS:CONFIRMED\nSUMMARY:");
    write.write((msg + '\n'));
    write.write("TRANSP:OPAQUE\nEND:VEVENT\nEND:VCALENDAR\n");

    write.close();
  }
}
