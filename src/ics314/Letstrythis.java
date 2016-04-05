package guitest;

import ics314.TimeSort;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

  private String filename = "default";
  private String tstartdatep1 = "2016";
  private String tstartdatep2 = "01";
  private String tstartdatep3 = "01";
  private String tstartdate = "";
  private String tstarttimep1 = "00";
  private String tstarttimep2 = "00";
  private String tendtimep1 = "00";
  private String tendtimep2 = "00";
  private String tstarttime = "000000";         //add an initialized time later
  private String tstart = "";
  private String tenddatep1 = "2016";
  private String tenddatep2 = "01";
  private String tenddatep3 = "01";
  private String tenddate = "";
  private String tendtime = "000000";           // ad an initialized time later
  private String tend = "";
  private String msg = "default";
  private String gpslat = "0";
  private String gpslong = "1";
  private String clas = "PUBLIC";
  private JFrame frame;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextField textField_3;
  String[] startdateyear = {"2016","2017","2018","2019","2020","2021","2022","2023"};
  String[] startdatemonth = {"01","02","03","04","05","06","07","08","09",
      "10","11","12"};
  String[] startdateday = {"01","02","03","04","05","06","07","08","09",
      "10","11","12","13","14","15","16","17","18","19","20","21","22",
      "23","24","25","26","27","28","29","30","31"};
  String[] starttimearray={"000000","010000","020000","030000","040000",
      "050000","060000","070000","080000","090000","100000","110000",
      "120000","130000","140000","150000","160000","170000","180000",
      "190000","200000","210000","220000","230000"};
  String[] zerototwentyfour = {"00","01","02","03","04","05","06","07","08","09",
                               "10","11","12","13","14","15","16","17","18","19",
                               "20","21","22","23","24"};
  String[] zerotosixty = {"00","01","02","03","04","05","06","07","08","09",
                      "10","11","12","13","14","15","16","17","18","19",
                      "20","21","22","23","24","25","26","27","28","29",
                      "30","31","32","33","34","35","36","37","38","39",
                      "40","41","42","43","44","45","46","47","48","49",
                      "50","51","52","53","54","55","56","57","58","59",
                      "60"};

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
	ArrayList<String> list = new ArrayList<String>();
    frame = new JFrame();
    frame.setBounds(100, 100, 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    /*********************************************************
     * ENTER CALENDAR NAME LINE
     *********************************************************/
    
    /**********ENTER CALENDAR NAME: LABEL**********/
    //ENTER CALENDAR NAME: LABEL
    JLabel lblEnterCalendarName = new JLabel("Enter File Name:");       //MAKE THE LABEL
    lblEnterCalendarName.setBounds(6, 6, 141, 16);                          //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblEnterCalendarName);                       //ADD THE LABEL TO THE FRAME
    /**********THIS IS DONE**********/
    
    /**********ENTER CALENDAR NAME: TEXTBOX**********/
    textField_1 = new JTextField();                                         //MAKE THE TEXT FIELD
    textField_1.setBounds(141, 0, 254, 28);                                 //SET THE POSITION OF THE TEXT FIELD
    frame.getContentPane().add(textField_1);                                //ADD THE TEXT FIELD TO THE FRAME
    textField_1.setColumns(10);                                             //SET THE NUMBER OF COLUMNS IN THE TEXT FIELD                
    
//    /**********ENTER CALENDAR NAME: ENTER BUTTON**********/
//    JButton btnEnter = new JButton("enter");                                //MAKE THE BUTTON
//    btnEnter.setBounds(268, 1, 76, 29);                                     //SET THE POSITION OF THE BUTTON
//    frame.getContentPane().add(btnEnter);                                   //ADD THE BUTTON TO THE FRAME
//    btnEnter.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent e)
//      {
//        filename = textField_1.getText() + ".ics";
//        //JOptionPane.showMessageDialog(null, calname);
//      }
//    });
    
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
    JComboBox comboBox_1 = new JComboBox(startdateyear);                    //MAKE THE COMBO BOX
    comboBox_1.setBounds(168, 30, 87, 27);                                  //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox_1);                                 //ADD THE COMBO BOX TO THE FRAME
    comboBox_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tstartdatep1 = comboBox_1.getSelectedItem().toString();
        //JOptionPane.showMessageDialog(null, tstartdatep1);
      }
    });
    
    /**********START DATE: MONTH LABEL**********/
    JLabel lblMonth = new JLabel("Month:");                                 //MAKE THE LABEL
    lblMonth.setBounds(258, 34, 44, 16);                                    //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblMonth);                                   //ADD THE LABEL TO THE FRAME
    /**********THIS IS DONE**********/
    
    /**********START DATE: MONTH COMBO BOX**********/
    JComboBox comboBox_2 = new JComboBox(startdatemonth);                   //MAKE THE COMBO BOX
    comboBox_2.setBounds(299, 30, 67, 27);                                  //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox_2);                                 //ADD THE COMBO BOX TO THE FRAME
    comboBox_2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tstartdatep2 = comboBox_2.getSelectedItem().toString();
        //JOptionPane.showMessageDialog(null, tstartdatep2);
      }
    });
    
    /**********START DATE: DAY LABEL**********/
    JLabel lblDay = new JLabel("Day:");                                     //MAKE THE LABEL
    lblDay.setBounds(368, 34, 31, 16);                                      //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblDay);                                     //ADD THE LABEL TO THE FRAME
    /**********THIS IS DONE**********/
    
    /**********START DATE: DAY COMBO BOX**********/
    JComboBox comboBox = new JComboBox(startdateday);                       //MAKE THE COMBO BOX
    comboBox.setBounds(393, 30, 67, 27);                                    //SET THE POSITION OF THE COMBO BOX
    frame.getContentPane().add(comboBox);                                   //ADD THE COMBO BOX TO THE FRAME
    comboBox.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tstartdatep3 = comboBox.getSelectedItem().toString();
        //JOptionPane.showMessageDialog(null, tstartdatep3);
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
        //JOptionPane.showMessageDialog(null, tenddatep1);
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
        //JOptionPane.showMessageDialog(null, tenddatep2);
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
        //JOptionPane.showMessageDialog(null, tenddatep3);
      }
    });
    
    /*********************************************************
     * START TIME LINE
     *********************************************************/
    
    /**********START TIME: START TIME LABEL**********/
    JLabel lblStartTime = new JLabel("Start Time:");                        //MAKE THE LABEL
    lblStartTime.setBounds(6, 90, 70, 16);                                  //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblStartTime);
    
    
    JComboBox comboBox_9 = new JComboBox(zerototwentyfour);
    comboBox_9.setBounds(141, 86, 67, 27);
    frame.getContentPane().add(comboBox_9);
    comboBox_9.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tstarttimep1 = comboBox_9.getSelectedItem().toString();
        //JOptionPane.showMessageDialog(null, tstarttime);
      }
    });
    
    JLabel lblMinutes = new JLabel(":");
    lblMinutes.setBounds(205, 90, 4, 16);
    frame.getContentPane().add(lblMinutes);
    
    
    JComboBox comboBox_10 = new JComboBox(zerotosixty);
    comboBox_10.setBounds(207, 86, 67, 27);
    frame.getContentPane().add(comboBox_10); 
    comboBox_10.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tstarttimep2 = comboBox_10.getSelectedItem().toString();
        //JOptionPane.showMessageDialog(null, tstarttime);
      }
    });
   
//    /**********START TIME: COMBO BOX**********/
//    JComboBox comboBox_3 = new JComboBox(starttimearray);                   //MAKE THE COMBO BOX
//    comboBox_3.setBounds(434, 142, 129, 27);                                //SET THE POSITION OF THE COMBO BOX
//    frame.getContentPane().add(comboBox_3);                                 //ADD THE COMBO BOX TO THE FRAME
//    comboBox_3.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent e)
//      {
//        tstarttime = comboBox_3.getSelectedItem().toString();
//        //JOptionPane.showMessageDialog(null, tstarttime);
//      }
//    });
    
    /*********************************************************
     * END TIME LINE
     *********************************************************/
    
    /**********END TIME: END TIME LABEL**********/
    JLabel lblEndTime = new JLabel("End Time:");                            //MAKE THE LABEL
    lblEndTime.setBounds(6, 118, 70, 16);                                   //SET THE POSITION OF THE LABEL
    frame.getContentPane().add(lblEndTime);
    
    
    JComboBox comboBox_11 = new JComboBox(zerototwentyfour);
    comboBox_11.setBounds(141, 114, 67, 27);
    frame.getContentPane().add(comboBox_11);
    comboBox_11.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tendtimep1 = comboBox_11.getSelectedItem().toString();
        //JOptionPane.showMessageDialog(null, tstarttime);
      }
    });
    
    
    JLabel label_1 = new JLabel(":");
    label_1.setBounds(205, 118, 4, 16);
    frame.getContentPane().add(label_1);
    
    
    JComboBox comboBox_12 = new JComboBox(zerotosixty);
    comboBox_12.setBounds(207, 114, 67, 27);
    frame.getContentPane().add(comboBox_12);
    comboBox_12.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tendtimep2 = comboBox_12.getSelectedItem().toString();
        //JOptionPane.showMessageDialog(null, tstarttime);
      }
    });
        
//    /**********END TIME: COMBO BOX**********/
//    JComboBox comboBox_7 = new JComboBox(starttimearray);                   //MAKE THE COMBO BOX
//    comboBox_7.setBounds(444, 170, 129, 27);                                //SET THE POSITION OF THE COMBO BOX
//    frame.getContentPane().add(comboBox_7);                                 //ADD THE COMBO BOX TO THE FRAME
//    comboBox_7.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent e)
//      {
//        tendtime = comboBox_7.getSelectedItem().toString();
//        //JOptionPane.showMessageDialog(null, tendtime);
//      }
//    });
    
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
    JButton btnEnter_1 = new JButton("check");                              //MAKE THE BUTTON
    btnEnter_1.setBounds(268, 141, 76, 29);                                 //SET THE POSITION OF THE BUTTON
    frame.getContentPane().add(btnEnter_1);                                 //ADD THE BUTTON TO THE FRAME
    btnEnter_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(isDouble(textField_2.getText()) && Double.parseDouble(textField_2.getText()) > -90 && Double.parseDouble(textField_2.getText()) < 90){
          gpslat = textField_2.getText();
          JOptionPane.showMessageDialog(null, "Input Verified!");
        }
        else{
          textField_2.setText("0");
          JOptionPane.showMessageDialog(null, "Please enter a number between -90 and 90");
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
    JButton btnNewButton = new JButton("check");                            //MAKE THE BUTTON
    btnNewButton.setBounds(268, 169, 76, 29);                               //SET THE POSITION OF THE BUTTON
    frame.getContentPane().add(btnNewButton);                               //ADD THE BUTTON TO THE FRAME
    btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(isDouble(textField_3.getText())&& Double.parseDouble(textField_3.getText()) > 0 && Double.parseDouble(textField_3.getText()) < 180){
          gpslong = textField_3.getText();
          JOptionPane.showMessageDialog(null, "Input Verified!");
        }
        else{
          textField_3.setText("1");
          JOptionPane.showMessageDialog(null, "Please enter a number between 0 and 180");
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
        //JOptionPane.showMessageDialog(null, clas);
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
    scroll.setBounds(141, 230, 453, 142);                                   //SET THE POSITION OF THE TEXT AREA
    textArea.setLineWrap(true);                                             //MAKE THE TEXT WRAP
    textArea.setWrapStyleWord(true);                                        //MAKE THE WORDS WRAP
    frame.getContentPane().add(scroll);                                     //ADD THE SCROLLABLE TEXT AREA TO THE FRAME
    
//    /**********ENTER MESSAGE: ENTER BUTTON**********/
//    JButton btnEnter_2 = new JButton("enter");                              //MAKE THE BUTTON
//    btnEnter_2.setBounds(524, 225, 76, 29);                                 //SET THE POSITION OF THE BUTTON
//    frame.getContentPane().add(btnEnter_2);                                 //ADD THE BUTTON TO THE FRAME
//    btnEnter_2.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent e)
//      {
//        msg = textArea.getText();
//        //JOptionPane.showMessageDialog(null, msg);
//      }
//    });
    
    /**********DONE BUTTON**********/
    JButton btnDone = new JButton("Done");
    btnDone.setBounds(513, 1, 87, 28);
    frame.getContentPane().add(btnDone);
    btnDone.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        try {
          filename = textField_1.getText() + ".ics";
          tstarttime = tstarttimep1 + tstarttimep2 + "00";
          tendtime = tendtimep1 + tendtimep2 + "00";
          tstartdate = tstartdatep1 + tstartdatep2 + tstartdatep3;
          tstart = tstartdate + "T" + tstarttime;
          tenddate = tenddatep1 + tenddatep2 + tenddatep3;
          tend = tenddate + "T" + tendtime;
          msg = textArea.getText();
          
          if(isDouble(textField_3.getText())&& Double.parseDouble(textField_3.getText()) > 0 && Double.parseDouble(textField_3.getText()) < 180
              && isDouble(textField_2.getText()) && Double.parseDouble(textField_2.getText()) > -90 && Double.parseDouble(textField_2.getText()) < 90){
            gpslat = textField_2.getText();
            gpslong = textField_3.getText();
            System.out.println(filename);
            System.out.println(tstart);
            System.out.println(tend);
            System.out.println(msg);
            System.out.println(gpslat);
            System.out.println(gpslong);
            System.out.println(clas);
            list.add(filename);
//    		list.add("f1.ics");
//    		list.add("f2.ics");
//    		list.add("f3.ics");
//    		list.add("f4.ics");
//    		list.add("f5.ics");
            createics(filename, tstart, tend, msg, gpslat, gpslong, clas);
            JOptionPane.showMessageDialog(null, "Calendar Created!");
            textField_1.setText("default"); // filename
            textField_2.setText("0"); // gpslat
            textField_3.setText("1"); // gpslong
            textArea.setText(""); // msg
          }
          else{
            textField_2.setText("0");
            textField_3.setText("1");
            JOptionPane.showMessageDialog(null, "Input error: GPS Lattitude/Longitude... Setting Default Values");
          }
        }
        catch (IOException e1) {
          // TODO Auto-generated catch block
          System.out.println("btnDone: IOException caught!");
        }
      }
    });
    frame.addWindowListener(new WindowAdapter()
    {
    	@Override
		public void windowClosing(WindowEvent event) {
//			// TODO Auto-generated method stub
//    		list.add("f1.ics");
//    		list.add("f2.ics");
//    		list.add("f3.ics");
//    		list.add("f4.ics");
//    		list.add("f5.ics");
		for(int i = 0; i < list.size(); i ++){
		System.out.println(list.get(i));
	}
			try {
				TimeSort.startsort(list);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
			
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
    FileWriter write = new FileWriter(name);

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
