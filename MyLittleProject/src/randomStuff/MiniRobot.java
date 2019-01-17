package randomStuff;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MiniRobot extends Robot {

	public BufferedImage screenshot;
	private final Rectangle screensize;
	
	public MiniRobot() throws AWTException {
		super();
		screensize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	}
	
	public void takeScreenshot() {
		screenshot = createScreenCapture(screensize);
	}
	
	public void saveScreenshot() {
		File outputfile = new File("screenshot.png");
		try {
			outputfile.createNewFile();
		} catch (IOException e) {}
		
		for (int i=0;i<10;i++)
			try {
				ImageIO.write(screenshot, "png", outputfile);
				System.out.println(outputfile + " erzeugt");
				break;
			} catch (IOException e) {}
	}
	
	public void interrupt1() {
		keyPress(KeyEvent.VK_CONTROL);
		keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public static void main(String[] args) {
		MiniRobot r;
		try {
			r = new MiniRobot();
		} catch (AWTException e) {
			e.printStackTrace();
			r = null;
		}
		
		try { Thread.sleep(5000);} catch (InterruptedException e) {}
		r.interrupt1();
		try { Thread.sleep(100);} catch (InterruptedException e) {}
		r.takeScreenshot();
		r.saveScreenshot();
	}

}
