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
        public float[] GreatCircleDist(float gpsla1, float gpslo1, float gpsla2, float gpslo2){
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
    public void AddComment(String FileName, float DistKM, float DistMI) throws IOException{
        File inFile = new File(FileName);
        File outFile = new File("TEMP.tmp");
         //input
        FileInputStream fis  = new FileInputStream(FileName);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        // output         
        FileOutputStream fos = new FileOutputStream(outFile);
        PrintWriter out = new PrintWriter(fos);
        String thisLine = "";
        while ((thisLine = in.readLine()) != null) {
              if(thisLine.contains("DTSTAMP"))out.println("COMMENT:distance in kilometers "+DistKM+"; distance in miles "+DistMI); 
              out.println(thisLine);
        }
    out.flush();
    out.close();
    in.close();
    
    inFile.delete();
    outFile.renameTo(inFile);      
    }
}
