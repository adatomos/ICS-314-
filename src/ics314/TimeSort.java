package ics314;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TimeSort {

	public static void main(String[] args) throws IOException {
		startsort(args);
		
	}

	public static void startsort(String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("Need more than 1 .ics file");
		} else {
			String[] names = args;
			int[] times = new int[args.length];
			for (int i = 0; i < args.length; i++) {
				times[i] = findstarttime(args[i]);
			}
			caltime[] cals = new caltime[args.length];
			for (int i = 0; i < names.length; i++) {
				cals[i] = new caltime(times[i], names[i]);
			}

			Arrays.sort(cals, new caltimeComp());

			 for(int i = 0; i < cals.length; i++){
			 System.out.println(cals[i].getTime() + " " +
			 cals[i].getFilename());
			 }
			 addcircledist(cals);
		}
	}

	private static int findstarttime(String filename) {
		String str = "";
		int time = 0;
		File file = new File(filename);
		try {
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				String line = in.nextLine();
				if (line.contains("DTSTART")) {
					str = line.substring(line.lastIndexOf('T') + 1,
							line.length());
					time = Integer.parseInt(str);
					// System.out.println(time);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return time;
	}

	public static void addcircledist(caltime[] cals) throws IOException{
		float[] deg1,deg2, dist;
		for(int i = 0; i < (cals.length - 1); i++){
			deg1 = GreatCircleDistance.GetGeo(cals[i].getFilename());
			deg2 = GreatCircleDistance.GetGeo(cals[i+1].getFilename());
			dist = GreatCircleDistance.GreatCircleDist(deg1[0], deg1[1], deg2[0], deg2[1]);
			System.out.println(deg1[0] + " " + deg1[1] + " "  + deg2[0] + " " + deg2[1] + " "  + dist[0] + " " + dist[1]);
			GreatCircleDistance.AddComment(cals[i].getFilename(), dist[0], dist[1]);
			if(i == (cals.length -2)){
				GreatCircleDistance.AddCommentLastEvent(cals[i+1].getFilename());
			}
		}
	}
}
