package guitest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.JScrollBar;

public class Letstrythis {

  private String calname = "default";
  private String tstartdatep1 = "";
  private String tstartdatep2 = "";
  private String tstartdatep3 = "";
  private String tstartdate = "";
  private String tstarttime = "";
  private String tstart = "";
  private String tenddatep1 = "";
  private String tenddatep2 = "";
  private String tenddatep3 = "";
  private String tenddate = "";
  private String tendtime = "";
  private String tend = "";
  private String msg = "";
  private String gpslat = "";
  private String gpslong = "";
  private String clas = "";
  private JFrame frame;
  private int test = 1, conttest = 1, ascii = 0;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextField textField_3;
  private String[] timearray={"0","1","2","3","4","5","6","7","8","9","10","11","12"};


  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Letstrythis window = new Letstrythis();
          window.frame.setVisible(true);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }


  /**
   * Create the application.
   * @throws IOException 
   */
  public Letstrythis() throws IOException {
    initialize();
  }


  /**
   * Initialize the contents of the frame.
   */
  private void initialize() throws IOException{
    frame = new JFrame();
    frame.setBounds(100, 100, 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    /*********************************************************
     * ENTER CALENDAR NAME LINE
     *********************************************************/
    
    /**********ENTER CALENDAR NAME: LABEL**********/
    //ENTER CALENDAR NAME: LABEL
    JLabel lblEnterCalendarName = new JLabel("Enter Calendar Name:");       //MAKE THE LABEL
    lblEnterCalendarName.setBounds(6, 6, 141, 16);                          //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblEnterCalendarName);                       //ADD THE LABEL TO THE FRAME
    /**********THIS IS DONE**********/
    
    /**********ENTER CALENDAR NAME: TEXTBOX**********/
    textField_1 = new JTextField();                                         //MAKE THE TEXT FIELD
    textField_1.setBounds(141, 0, 134, 28);                                 //SET THE POSITION OF THE TEXT FIELD
    frame.getContentPane().add(textField_1);                                //ADD THE TEXT FIELD TO THE FRAME
    textField_1.setColumns(10);                                             //SET THE NUMBER OF COLUMNS IN THE TEXT FIELD                
    
    /**********ENTER CALENDAR NAME: ENTER BUTTON**********/
    JButton btnEnter = new JButton("enter");                                //MAKE THE BUTTON
    btnEnter.setBounds(268, 1, 76, 29);                                     //SET THE POSITION OF THE BUTTON
    frame.getContentPane().add(btnEnter);                                   //ADD THE BUTTON TO THE FRAME
    btnEnter.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        calname = textField_1.getText();
        JOptionPane.showMessageDialog(null, calname);
      }
    });
    
    /*********************************************************
     * START DATE LINE
     *********************************************************/
    
    /**********START DATE: LABEL**********/
    JLabel lblStartDate = new JLabel("Start Date: ");                       //MAKE THE LABEL
    lblStartDate.setBounds(6, 34, 70, 16);                                  //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblStartDate);                               //ADD THE LABEL TO THE FRAME
    /**********THIS IS DONE**********/
    
    /**********START DATE: YEAR LABEL**********/
    JLabel lblYear = new JLabel("Year:");                                   //MAKE THE LABEL
    lblYear.setBounds(141, 34, 31, 16);                                     //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblYear);                                    //ADD THE LABEL TO THE FRAME
    /**********THIS IS DONE**********/
    
    /**********START DATE: YEAR COMBO BOX**********/
    String[] startdateyear = {"2016","2017","2018","2019","2020","2021","2022","2023"};
    JComboBox comboBox_1 = new JComboBox(startdateyear);                    //MAKE THE COMBO BOX
    comboBox_1.setBounds(168, 30, 87, 27);                                  //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox_1);                                 //ADD THE COMBO BOX TO THE FRAME
    comboBox_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tstartdatep1 = comboBox_1.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null, tstartdatep1);
      }
    });
    
    /**********START DATE: MONTH LABEL**********/
    JLabel lblMonth = new JLabel("Month:");                                 //MAKE THE LABEL
    lblMonth.setBounds(258, 34, 44, 16);                                    //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblMonth);                                   //ADD THE LABEL TO THE FRAME
    /**********THIS IS DONE**********/
    
    /**********START DATE: MONTH COMBO BOX**********/
    String[] startdatemonth = {"01","02","03","04","05","06","07","08","09",
        "10","11","12"};
    JComboBox comboBox_2 = new JComboBox(startdatemonth);                   //MAKE THE COMBO BOX
    comboBox_2.setBounds(299, 30, 67, 27);                                  //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox_2);                                 //ADD THE COMBO BOX TO THE FRAME
    comboBox_2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tstartdatep2 = comboBox_2.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null, tstartdatep2);
      }
    });
    
    /**********START DATE: DAY LABEL**********/
    JLabel lblDay = new JLabel("Day:");                                     //MAKE THE LABEL
    lblDay.setBounds(368, 34, 31, 16);                                      //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblDay);                                     //ADD THE LABEL TO THE FRAME
    /**********THIS IS DONE**********/
    
    /**********START DATE: DAY COMBO BOX**********/
    String[] startdateday = {"01","02","03","04","05","06","07","08","09",
        "10","11","12","13","14","15","16","17","18","19","20","21","22",
        "23","24","25","26","27","28","29","30","31"};
    JComboBox comboBox = new JComboBox(startdateday);                       //MAKE THE COMBO BOX
    comboBox.setBounds(393, 30, 67, 27);                                    //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox);                                   //ADD THE COMBO BOX TO THE FRAME
    comboBox.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tstartdatep3 = comboBox.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null, tstartdatep3);
      }
    });
    
    /*********************************************************
     * END DATE LINE
     *********************************************************/
    
    /**********END DATE: LABEL**********/
    JLabel lblEndDate = new JLabel("End Date:");                            //MAKE THE LABEL
    lblEndDate.setBounds(6, 62, 60, 16);                                    //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblEndDate);                                 //ADD THE LABEL TO THE FRAME
    
    /**********END DATE: YEAR LABEL**********/
    JLabel lblYear_1 = new JLabel("Year:");                                 //MAKE THE LABEL
    lblYear_1.setBounds(141, 62, 31, 16);                                   //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblYear_1);                                  //ADD THE LABEL TO THE FRAME
    
    /**********END DATE: YEAR COMBO BOX**********/
    JComboBox comboBox_4 = new JComboBox(startdateyear);                    //MAKE THE COMBO BOX
    comboBox_4.setBounds(168, 58, 87, 27);                                  //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox_4);                                 //ADD THE COMBO BOX TO THE FRAME
    comboBox_4.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tenddatep1 = comboBox_4.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null, tenddatep1);
      }
    });
    
    /**********END DATE: MONTH LABEL**********/
    JLabel lblMonth_1 = new JLabel("Month: ");                              //MAKE THE LABEL
    lblMonth_1.setBounds(258, 62, 52, 16);                                  //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblMonth_1);                                 //ADD THE LABEL TO THE FRAME
    
    /**********END DATE: MONTH COMBO BOX**********/
    JComboBox comboBox_5 = new JComboBox(startdatemonth);                   //MAKE THE COMBO BOX
    comboBox_5.setBounds(299, 58, 67, 27);                                  //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox_5);                                 //ADD THE COMBO BOX TO THE FRAME
    comboBox_5.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tenddatep2 = comboBox_5.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null, tenddatep2);
      }
    });
    
    
    /**********END DATE: DAY LABEL**********/
    JLabel lblDay_1 = new JLabel("Day:");                                   //MAKE THE LABEL
    lblDay_1.setBounds(368, 62, 31, 16);                                    //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblDay_1);                                   //ADD THE LABEL TO THE FRAME
    
    /**********END DATE: DAY COMBO BOX**********/
    JComboBox comboBox_6 = new JComboBox(startdateday);                     //MAKE THE COMBO BOX
    comboBox_6.setBounds(393, 58, 67, 27);                                  //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox_6);                                 //ADD THE COMBO BOX TO THE FRAME
    comboBox_6.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tenddatep3 = comboBox_6.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null, tenddatep3);
      }
    });
    
    /*********************************************************
     * START TIME LINE
     *********************************************************/
    
    /**********START TIME: LABEL**********/
    JLabel lblStartTime = new JLabel("Start Time:");                        //MAKE THE LABEL
    lblStartTime.setBounds(6, 90, 70, 16);                                  //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblStartTime);                               //ADD THE LABEL TO THE FRAME
    
    /**********START TIME: COMBO BOX**********/
    String[] starttimearray={"000000","010000","020000","030000","040000",
        "050000","060000","070000","080000","090000","100000","110000",
        "120000","130000","140000","150000","160000","170000","180000",
        "190000","200000","210000","220000","230000"};
    JComboBox comboBox_3 = new JComboBox(starttimearray);                   //MAKE THE COMBO BOX
    comboBox_3.setBounds(141, 86, 129, 27);                                 //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox_3);                                 //ADD THE COMBO BOX TO THE FRAME
    comboBox_3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tstarttime = comboBox_3.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null, tstarttime);
      }
    });
    
    
    /*********************************************************
     * END TIME LINE
     *********************************************************/
    
    /**********END TIME: LABEL**********/
    JLabel lblEndTime = new JLabel("End Time:");                            //MAKE THE LABEL
    lblEndTime.setBounds(6, 118, 70, 16);                                   //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblEndTime);                                 //ADD THE LABEL TO THE FRAME
    
    /**********END TIME: COMBO BOX**********/
    JComboBox comboBox_7 = new JComboBox(starttimearray);                   //MAKE THE COMBO BOX
    comboBox_7.setBounds(141, 114, 129, 27);                                //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox_7);                                 //ADD THE COMBO BOX TO THE FRAME
    comboBox_7.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tendtime = comboBox_7.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null, tendtime);
      }
    });
    
    /*********************************************************
     * GPS LATITUDE LINE
     *********************************************************/
    
    /**********GPS LATITUDE: LABEL**********/
    JLabel lblGpsLattitude = new JLabel("GPS Latitude:");                   //MAKE THE LABEL
    lblGpsLattitude.setBounds(6, 146, 87, 16);                              //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblGpsLattitude);                            //ADD THE LABEL TO THE FRAME
    
    /**********GPS LATITUDE: TEXT FIELD**********/
    textField_2 = new JTextField();                                         //MAKE THE TEXT FIELD
    textField_2.setBounds(141, 140, 134, 28);                               //SET THE POSITION OF THE TEXT FIELD
    frame.getContentPane().add(textField_2);                                //ADD THE TEXT FIELD TO THE FRAME
    textField_2.setColumns(10);                                             //SET THE NUMBER OF COLUMNS IN THE TEXT FIELD
    
    /**********GPS LATITUDE: ENTER BUTTON**********/
    JButton btnEnter_1 = new JButton("enter");                              //MAKE THE BUTTON
    btnEnter_1.setBounds(268, 141, 76, 29);                                 //SET THE POSITION OF THE BUTTON
    frame.getContentPane().add(btnEnter_1);                                 //ADD THE BUTTON TO THE FRAME
    btnEnter_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gpslat = textField_2.getText();
        if(isDouble(gpslat) && Double.parseDouble(gpslat) > -90 && Double.parseDouble(gpslat) < 90){
          JOptionPane.showMessageDialog(null, gpslat);
        }
        else{
          textField_2.setText("0");
        }
      }
    });
    
    /*********************************************************
     * GPS LONGITUDE LINE
     *********************************************************/
    
    /**********GPS LONGITUDE: LABEL**********/
    JLabel lblGpsLongitude = new JLabel("GPS Longitude:");                  //MAKE THE LABEL
    lblGpsLongitude.setBounds(6, 174, 100, 16);                             //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblGpsLongitude);                            //ADD THE LABEL TO THE FRAME
    
    /**********GPS LONGITUDE: TEXT FIELD**********/
    textField_3 = new JTextField();                                         //MAKE THE TEXT FIELD
    textField_3.setBounds(141, 168, 134, 28);                               //SET THE POSITION OF THE TEXT FIELD
    frame.getContentPane().add(textField_3);                                //ADD THE TEXT FIELD TO THE FRAME
    textField_3.setColumns(10);                                             //SET THE NUMBER OF COLUMNS IN THE TEXT FIELD
    
    /**********GPS LONGITUDE: ENTER BUTTON**********/
    JButton btnNewButton = new JButton("enter");                            //MAKE THE BUTTON
    btnNewButton.setBounds(268, 169, 76, 29);                               //SET THE POSITION OF THE BUTTON
    frame.getContentPane().add(btnNewButton);                               //ADD THE BUTTON TO THE FRAME
    btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gpslong = textField_3.getText();
        if(isDouble(gpslong)&& Double.parseDouble(gpslong) > 0 && Double.parseDouble(gpslong) < 180){
          JOptionPane.showMessageDialog(null, gpslong);
        }
        else{
          textField_3.setText("0");
        }
      }
    });
    
    /*********************************************************
     * CLASS OF EVENT LINE
     *********************************************************/
    
    /**********CLASS OF EVENT: LABEL**********/
    String[] classeventlist = {"PUBLIC", "PRIVATE", "CONFIDENTIAL"};
    JLabel lblClassOfEvent = new JLabel("Class of Event:");                 //MAKE THE LABEL
    lblClassOfEvent.setBounds(6, 202, 100, 16);                             //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblClassOfEvent);                            //ADD THE LABEL TO THE FRAME
    
    /**********CLASS OF EVENT: COMBO BOX**********/
    JComboBox comboBox_8 = new JComboBox(classeventlist);                   //MAKE THE COMBO BOX
    comboBox_8.setBounds(141, 198, 129, 27);                                //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox_8);                                 //ADD THE COMBO BOX TO THE FRAME
    comboBox_8.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        clas = comboBox_8.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null, clas);
      }
    });
    
    /*********************************************************
     * ENTER MESSAGE LINE
     *********************************************************/
    
    /**********ENTER MESSAGE: LABEL**********/
    JLabel lblEnterMessage = new JLabel("Enter Message:");                  //MAKE THE LABEL
    lblEnterMessage.setBounds(6, 230, 100, 16);                             //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblEnterMessage);
    
    /**********ENTER MESSAGE: TEXT AREA**********/
    JTextArea textArea = new JTextArea();                                   //MAKE THE TEXT AREA
    JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.setBounds(141, 230, 385, 142);                                   //SET THE POSITION OF THE TEXT AREA
    textArea.setLineWrap(true);                                             //MAKE THE TEXT WRAP
    textArea.setWrapStyleWord(true);                                        //MAKE THE WORDS WRAP
    frame.getContentPane().add(scroll);                                     //ADD THE SCROLLABLE TEXT AREA TO THE FRAME
    
    /**********ENTER MESSAGE: ENTER BUTTON**********/
    JButton btnEnter_2 = new JButton("enter");                              //MAKE THE BUTTON
    btnEnter_2.setBounds(524, 225, 76, 29);                                 //SET THE POSITION OF THE BUTTON
    frame.getContentPane().add(btnEnter_2);                                 //ADD THE BUTTON TO THE FRAME
    btnEnter_2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        msg = textArea.getText();
        JOptionPane.showMessageDialog(null, msg);
      }
    });
    
    /**********DONE BUTTON**********/
    JButton btnDone = new JButton("Done");
    btnDone.setBounds(513, 1, 87, 28);
    frame.getContentPane().add(btnDone);
    btnDone.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JOptionPane.showMessageDialog(null, "Creating Calendar!");
        try {
          tstartdate = tstartdatep1 + tstartdatep2 + tstartdatep3;
          tstart = tstartdate + "T" + tstarttime;
          tenddate = tenddatep1 + tenddatep2 + tenddatep3;
          tend = tenddate + "T" + tendtime;
          createics(calname, tstart, tend, msg, gpslat, gpslong, clas);
        }
        catch (IOException e1) {
          // TODO Auto-generated catch block
          System.out.println("btnDone: IOException caught!");
        }
      }
    });
  }
  public boolean isDouble(String str){
    try{
      Double.parseDouble(str);
      return true;
    }catch(NumberFormatException e){
      return false;
    }
  }
  
  private static void createics(String name, String start, String end,
      String msg, String gpsla, String gpslo, String clas)
      throws IOException {
    FileWriter write = new FileWriter("ics314.ics");

    write.write("BEGIN:VCALENDAR" + '\n'
        + "PRODID:-//Google Inc//Google Calendar 70.9054//EN" + '\n'
        + "VERSION:2.0" + '\n' + "CALSCALE:GREGORIAN" + '\n'
        + "METHOD:PUBLISH" + '\n' + "X-WR-CALNAME:");
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

