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
public class GreatCircleDistance {
        public float GreatCircleDistKM(float gpsla1, float gpslo1, float gpsla2, float gpslo2){
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
        return distanceKM;
  
  }
        public float GreatCircleDistMI(float gpsla1, float gpslo1, float gpsla2, float gpslo2){
            float distanceMI = (float) (GreatCircleDistKM(gpsla1,gpslo1,gpsla2,gpslo2)*0.62137);
            return distanceMI;  // distance in miles
        }
    
}
