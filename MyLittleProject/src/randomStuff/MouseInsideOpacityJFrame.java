package randomStuff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseInsideOpacityJFrame implements MouseListener {
	private JFrame swingFrame;
	private JLabel swingLabel;
	
	int width,height,mouseX,mouseY;
	      
	public MouseInsideOpacityJFrame() {		
		swingFrame = new JFrame();
		swingLabel = new JLabel();
	}
	
	public void launchJFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)screenSize.getWidth();
		height = (int)screenSize.getHeight();
		swingFrame.setTitle("Anzeige");
		swingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		swingFrame.setUndecorated(true);
		swingFrame.setOpacity(0.5f);
		swingLabel.setText("x= undefined, y= undefined, zum Beenden: rechts-oben klicken");
		swingFrame.add(swingLabel, BorderLayout.NORTH);
		swingFrame.addMouseListener(this);
		swingFrame.setSize(width,height);
        swingFrame.setVisible(true);
	}
    
	public void getLocationXY() {
		mouseX = MouseInfo.getPointerInfo().getLocation().x;
		mouseY = MouseInfo.getPointerInfo().getLocation().y;
	}
	
	public void mousePressed(MouseEvent e) {
		this.getLocationXY();
		swingLabel.setText("x= " + mouseX + " , y= " + mouseY + ", zum Beenden: rechts-oben klicken");
		if (mouseX>width-30 && mouseY<30) {
			System.exit(0);
		}
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
 
 	public static void main (String[] args) {
		MouseInsideOpacityJFrame maus = new MouseInsideOpacityJFrame();
		maus.launchJFrame();
	}
}