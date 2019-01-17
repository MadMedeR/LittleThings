package randomStuff;

import java.awt.AWTEvent;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseOutside {
	public static int mouseX, mouseY;
	public static JFrame frame;
	public static JLabel label;
	
    public static void main(String[] args) {
    	launchJFrame();
        Toolkit.getDefaultToolkit().addAWTEventListener(
        	new Listener(), AWTEvent.MOUSE_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK
        );
    }
    
    public static void launchJFrame() {
    	frame = new JFrame("Mouse Position");
    	label = new JLabel("x=undefined y=undefined");
    	frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    private static class Listener implements AWTEventListener {
        public void eventDispatched(AWTEvent event) {
        	System.out.println(event);
        	if (event.getID() == FocusEvent.FOCUS_LOST) {
            	mouseX = MouseInfo.getPointerInfo().getLocation().x;
            	mouseY = MouseInfo.getPointerInfo().getLocation().y;
        		label.setText("x= " + mouseX + " , y= " + mouseY);
                frame.pack();
        		try {
        			Thread.sleep(250);
        		} catch (InterruptedException ex) {}
        	}
            frame.setVisible(true);
        }
    }
}