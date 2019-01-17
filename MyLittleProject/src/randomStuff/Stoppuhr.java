package randomStuff;

import java.util.Calendar;

public class Stoppuhr {
	public static void main(String[] args) {
		Calendar start = Calendar.getInstance();
		String startTime = String.format("%02d", start.get(Calendar.HOUR_OF_DAY)) + ":"
				+ String.format("%02d",start.get(Calendar.MINUTE)) + ":" 
				+ String.format("%02d",start.get(Calendar.SECOND));
		System.out.println("Startzeit: "+startTime);
	    try{ System.in.read(); }catch(Exception e){} // wait for key press
		Calendar end = Calendar.getInstance();
		String endTime = String.format("%02d", end.get(Calendar.HOUR_OF_DAY)) + ":"
				+ String.format("%02d",end.get(Calendar.MINUTE)) + ":" 
				+ String.format("%02d",end.get(Calendar.SECOND));
		System.out.println("Endzeit: " + endTime);
	}
}