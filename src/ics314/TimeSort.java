package ics314;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TimeSort {

	public static void startsort(ArrayList<String> args) throws IOException {
		/**if (args.size() < 2) {
			System.out
					.println("Need more than 1 .ics file for Great Circle Distance");
		} else {*/
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

			for (int i = 0; i < names.length; i++) {
				System.out.println(cals[i].getTime() + " "
						+ cals[i].getFilename());
			}

			addcircledist(cals);
		//}
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
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return time;
	}

	public static void addcircledist(caltime[] cals) throws IOException {
                float[] deg1, deg2, dist;
                ArrayList<String> gotGEO = new ArrayList();
                ArrayList<String> noGEO = new ArrayList();
                for (int i = 0; i < cals.length; i++){
                    if (GreatCircleDistance.IfGotGeo(cals[i].getFilename())){
                        gotGEO.add(cals[i].getFilename());
                    }
                    else noGEO.add(cals[i].getFilename());
                
                }
                if(gotGEO.size()>1){
		for (int i = 0,j = 1; j < gotGEO.size(); i++,j++) {
				deg1 = GreatCircleDistance.GetGeo(gotGEO.get(i));
				deg2 = GreatCircleDistance.GetGeo(gotGEO.get(j));
				dist = GreatCircleDistance.GreatCircleDist(deg1[0], deg1[1],
						deg2[0], deg2[1]);
				GreatCircleDistance.AddComment(gotGEO.get(i), dist[0],
						dist[1]);
				if (j == (gotGEO.size() - 1)) {
					GreatCircleDistance.AddCommentLastEvent(gotGEO.get(j));
				}
                }
                }else if(gotGEO.size()==1) {
                    GreatCircleDistance.AddCommentOnlyEventWithLocation(gotGEO.get(0));
                }
                if(noGEO.size()>0){
                    for(int k = 0; k < noGEO.size();k++ ){
                       GreatCircleDistance.AddCommentEventNoLocation(noGEO.get(k)); 
                    }
                }
	}
}
