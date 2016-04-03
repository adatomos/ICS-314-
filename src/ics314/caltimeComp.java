package ics314;

import java.util.Comparator;

public class caltimeComp implements Comparator<caltime> {

	@Override
	public int compare(caltime cal1, caltime cal2) {
		return cal1.getTime() < cal2.getTime() ? -1
				: cal1.getTime() > cal2.getTime() ? 1 : 0;
	}

}
