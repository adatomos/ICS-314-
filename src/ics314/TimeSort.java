package ics314;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TimeSort {

	public static void startsort(ArrayList<String> args) throws IOException {
		if (args.size() < 2) {
			System.out
					.println("Need more than 1 .ics file for Great Circle Distance");
		} else {
			String[] names = new String[args.size()];
			for (int i = 0; i < args.size(); i++) {
				names[i] = args.get(i);
			}
			int[] times = new int[args.size()];
			for (int i = 0; i < args.size(); i++) {
				times[i] = findstarttime(args.get(i));
			}
			caltime[] cals = new caltime[args.size()];
			for (int i = 0; i < names.length; i++) {
				cals[i] = new caltime(times[i], names[i]);
			}

			Arrays.sort(cals, new caltimeComp());

//			for (int i = 0; i < names.length; i++) {
//				System.out.println(cals[i].getTime() + " "
//						+ cals[i].getFilename());
//			}

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

	public static void addcircledist(caltime[] cals) throws IOException {
		float[] deg1, deg2, dist;
		for (int i = 0, j = 1; j < cals.length; i++, j++) {
//			System.out.println("i is "
//					+ GreatCircleDistance.IfGotGeo(cals[i].getFilename())
//					+ "j is "
//					+ GreatCircleDistance.IfGotGeo(cals[j].getFilename()));
			if (GreatCircleDistance.IfGotGeo(cals[i].getFilename())
					&& GreatCircleDistance.IfGotGeo(cals[j].getFilename())) {
				//System.out.println("Has geo at " + i + "and " + j);
				deg1 = GreatCircleDistance.GetGeo(cals[i].getFilename());
				deg2 = GreatCircleDistance.GetGeo(cals[j].getFilename());
				dist = GreatCircleDistance.GreatCircleDist(deg1[0], deg1[1],
						deg2[0], deg2[1]);
				// System.out.println(deg1[0] + " " + deg1[1] + " " + deg2[0]
				// + " " + deg2[1] + " " + dist[0] + " " + dist[1]);
				GreatCircleDistance.AddComment(cals[i].getFilename(), dist[0],
						dist[1]);
				if (j == (cals.length - 1)) {
					GreatCircleDistance.AddCommentLastEvent(cals[j]
							.getFilename());
				}
			} else if (GreatCircleDistance.IfGotGeo(cals[i].getFilename())
					&& !GreatCircleDistance.IfGotGeo(cals[j].getFilename())
					&& j < (cals.length - 1)) {
				//System.out.println("Made it " + i + " " + j);
				for (j++; j < (cals.length - 1); j++) {
					if (GreatCircleDistance.IfGotGeo(cals[j].getFilename())) {
						j--; // cancel out outer for loop i++, j++
						i--;
						break;
					}
				}
			} else if (GreatCircleDistance.IfGotGeo(cals[i].getFilename())
					&& !GreatCircleDistance.IfGotGeo(cals[j].getFilename())
					&& j == (cals.length - 1)) {
				GreatCircleDistance.AddCommentLastEvent(cals[j].getFilename());
			}
		}
	}
}
