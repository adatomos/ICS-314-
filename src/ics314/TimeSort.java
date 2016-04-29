package ics314;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class TimeSort {

	/**
	 * startsort sorts the given files by their date and time then passes the
	 * data to addcircledist
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void startsort(ArrayList<String> args) throws IOException {
		if (args.size() > 0) {
			String[] names = new String[args.size()];
			for (int i = 0; i < args.size(); i++) {
				names[i] = args.get(i);
			}
			int[] times = new int[args.size()];
			ArrayList<Integer> dates = new ArrayList<Integer>();
			for (int i = 0; i < args.size(); i++) {
				times[i] = findstarttime(args.get(i));
				dates.add(findstartdate(args.get(i)));
			}

			List<List<Integer>> manydates = new ArrayList<List<Integer>>();
			List<List<String>> manyfiles = new ArrayList<List<String>>();
			TreeSet<Integer> unique = new TreeSet<Integer>(dates);
			Iterator<Integer> iterator = unique.iterator();
//			for (Integer stuff : unique) {
//				System.out.println("Date: "+ stuff);
//			}
			Object[] elements = unique.toArray();
			for (int i = 0; i < unique.size(); i++) {
				manydates.add(new ArrayList<Integer>());
				manyfiles.add(new ArrayList<String>());
			}

			for (int i = 0; i < dates.size(); i++) {
				for (int j = 0; j < elements.length; j++) {
					if (elements[j].equals(dates.get(i))) {
						manydates.get(j).add(times[i]);
						manyfiles.get(j).add(names[i]);
					}
				}
			}
			for (int i = 0; i < manydates.size(); i++) {
				caltime[] cals = new caltime[manydates.get(i).size()];
				for (int j = 0; j < manydates.get(i).size(); j++) {
					cals[j] = new caltime(manydates.get(i).get(j), manyfiles
							.get(i).get(j));
				}
				Arrays.sort(cals, new caltimeComp());
				
				if(iterator.hasNext()){
	        System.out.println("Date: "+iterator.next());
	      }

				for (int k = 0; k < cals.length; k++) {
					System.out.println(cals[k].getTime() + " "
							+ cals[k].getFilename());
				}
				System.out.println();

				addcircledist(cals);
			}
		}
	}

	/**
	 * findstartdate finds the starting date in the .ics file
	 * 
	 * @param filename
	 * @return
	 */
	private static int findstartdate(String filename) {
		String str = "";
		int date = 0;
		File file = new File(filename);
		try {
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				String line = in.nextLine();
				if (line.contains("DTSTART")) {
					str = line.substring(line.lastIndexOf(':') + 1,
							line.lastIndexOf('T'));
					date = Integer.parseInt(str);
					// System.out.println(time);
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * findstarttime finds the starting time in the .ics file
	 * 
	 * @param filename
	 * @return
	 */
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
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return time;
	}

	/**
	 * addcircledist calls GreatCircleDist methods to compute the great circle
	 * distance and input it into the files.
	 * 
	 * @param cals
	 * @throws IOException
	 */
	private static void addcircledist(caltime[] cals) throws IOException {
		float[] deg1, deg2, dist;
		ArrayList<String> gotGEO = new ArrayList();
		ArrayList<String> noGEO = new ArrayList();
		for (int i = 0; i < cals.length; i++) {
			if (GreatCircleDistance.IfGotGeo(cals[i].getFilename())) {
				gotGEO.add(cals[i].getFilename());
			} else
				noGEO.add(cals[i].getFilename());

		}
		if (gotGEO.size() > 1) {
			for (int i = 0, j = 1; j < gotGEO.size(); i++, j++) {
				deg1 = GreatCircleDistance.GetGeo(gotGEO.get(i));
				deg2 = GreatCircleDistance.GetGeo(gotGEO.get(j));
				dist = GreatCircleDistance.GreatCircleDist(deg1[0], deg1[1],
						deg2[0], deg2[1]);
				GreatCircleDistance.AddComment(gotGEO.get(i), dist[0], dist[1]);
				if (j == (gotGEO.size() - 1)) {
					GreatCircleDistance.AddCommentLastEvent(gotGEO.get(j));
				}
			}
		} else if (gotGEO.size() == 1) {
			GreatCircleDistance.AddCommentOnlyEventWithLocation(gotGEO.get(0));
		}
		if (noGEO.size() > 0) {
			for (int k = 0; k < noGEO.size(); k++) {
				GreatCircleDistance.AddCommentEventNoLocation(noGEO.get(k));
			}
		}
	}
}
