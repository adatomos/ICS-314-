/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics314;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Ada
 */
/**
 * GreatCirleDistance returns float array containing Great Circle Distance 
 *   in kilometers(index 0 and miles(index 1)
 * input parameters: latitude and longitude of two locations 
 */
public class GreatCircleDistance {
        public static float[] GreatCircleDist(float gpsla1, float gpslo1, float gpsla2, float gpslo2){
        float[] distance = new float[2];
        float EarthRadius = (float)6371; //in km
        float rlat1, rlat2;  // gpsla in radians
        float Drlat, Drlon; // change in gpsla and gpslo
        rlat1 = (float)Math.toRadians(gpsla1);
        rlat2 = (float)Math.toRadians(gpsla2);
        Drlat = (float)Math.toRadians(gpsla2-gpsla1);
        Drlon = (float)Math.toRadians(gpslo2-gpslo1);

        float a = (float) (Math.sin(Drlat/2) * Math.sin(Drlat/2) +
                Math.cos(rlat1) * Math.cos(rlat2) *
                Math.sin(Drlon/2) * Math.sin(Drlon/2));
        float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));

        float distanceKM = EarthRadius * c;
        distance[0] = distanceKM;  // distancee in kilometers
        float distanceMI = (float) (distanceKM*0.62137);
        distance[1] = distanceMI; // distance in miles
        return distance;
  }  
  /** 
   * GetGeo method returns float array 
   * containing latitude(index 0) and longitude(index 1) from file
   * input parameter: FileName  ex: ics314.ics  
   */
        public static float[] GetGeo(String FileName){
        String[] str = new String[2];
        String[] str1 = new String[2];
        float[] degrees = new float[2];
        File file =new File(FileName);
        Scanner in = null;
        try {
            in = new Scanner(file);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("GEO")){
                   str = line.split(":");
                   str1 = str[1].split(";");
                   degrees[0] = Float.parseFloat(str1[0]);
                   degrees[1] = Float.parseFloat(str1[1]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } return degrees;
  }
  /** 
   * AddComment method adds COMMENT field to .ics file after ClASS field 
   * input parameters: FileName  ex: ics314.ics; distance in km; distance in miles (calculated
   *    using GreatCircleDist)
   */
   public static void AddComment(String FileName, float DistKM, float DistMI) throws IOException{
       String str = FileName;
       FileInputStream fis = null;
       BufferedReader in = null;
       FileOutputStream fos = null;
       File inFile = new File(FileName);
       File outFile = new File("TEMP");
            try { //input
                     fis = new FileInputStream(inFile); 
                     in = new BufferedReader(new InputStreamReader(fis)); 
                // output
                 fos = new FileOutputStream(outFile);
           try (PrintWriter out = new PrintWriter(fos)) {
               String thisLine = "";
               while ((thisLine = in.readLine()) != null) {
                   if(thisLine.contains("DTSTART"))out.println("COMMENT:distance to next event in kilometers "+DistKM+"; in miles "+DistMI);
                   out.println(thisLine);
               }
               out.flush();
           }
            }finally {
            if (fis!= null)
            fis.close();
            if (in!= null)
            in.close();
            if (fos!= null)
            fos.close();
      }
     inFile.delete();
    outFile.renameTo(inFile); 
    }
       /** 
   * AddCommentLastEvent method adds COMMENT field to the last .ics file. The COMMENT 
   *     line is inserted after the CLASS field indicating that this is the last event
   * input parameters: FileName of last event ex: ics314.ics 
   */
    public static void AddCommentLastEvent(String FileName) throws IOException{
        File inFile = new File(FileName);
        File outFile = new File("TEMP2.tmp");
            try ( //input
                    FileInputStream fis = new FileInputStream(inFile)) {
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                // output
                FileOutputStream fos = new FileOutputStream(outFile);
                PrintWriter out = new PrintWriter(fos);
                String thisLine = "";
                while ((thisLine = in.readLine()) != null) {
                    if(thisLine.contains("DTSTART"))out.println("COMMENT:This is the last event");
                    out.println(thisLine);
                }
                out.flush();
                out.close();
                in.close();
                fos.close();
            }
    System.gc();  
    
    inFile.delete();
    outFile.renameTo(inFile);      
    }
         /** 
   * IfGotGeo method returns boolean 
   * true if there are latitude and longitude, false otherwise
   * input parameter: FileName  ex: ics314.ics  
   */
        public static Boolean IfGotGeo(String FileName){
        String[] str = new String[2];
        String str1 = ":;"; boolean bool = true;
        File file =new File(FileName);
        Scanner in = null;
        try {
            in = new Scanner(file);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("GEO")){
                   str = line.split("O");
                   //System.out.println(str[1]);
                   if(str[1].compareTo(str1)==0){
                       bool = false;
                   }
                   else bool = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bool;
  }
}