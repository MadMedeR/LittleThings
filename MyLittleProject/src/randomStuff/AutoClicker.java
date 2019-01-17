package randomStuff;

import java.awt.*;
import java.awt.event.*;

import Prog1Tools.IOTools;

//Very dangerous!!!!
public class AutoClicker {

	public static int rate = 0;
	
	public static void main (String[] args) {
		
		rate = IOTools.readInt("Speed of the auto-clicker (Must be at least 500 miliseconds):");
		if (rate<500) rate = 500;
		try {
			Robot robot = new Robot();
			int i=0;
			while (i<30*1000/rate) { //läuft 30 Sekunden
				try {
					Thread.sleep(rate);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					i++;
				} catch (InterruptedException ex) {}
			}
		} catch (AWTException e) {}
	}
}