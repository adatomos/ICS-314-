package ics314;

public class caltime {
	private String filename;
	private int time;
	
	public caltime(int time, String filename){
		this.time = time;
		this.filename = filename;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	
}
