package randomStuff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Very dangerous!!!!

public class KlickApp extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	boolean f6;
    Robot bot;

    public static void main(String[] args) {
        new KlickApp();
    }

    public KlickApp() {
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        f6 = false;

        addKeyListener(this);

        this.setSize(100, 100);
        this.setVisible(true);
        this.run();

    }
    public void run() {
        while (true) { //Endlosschleife!!!
            if (f6) {
                bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(KeyEvent.VK_F6);
        if (e.getKeyCode() == KeyEvent.VK_F6) {
            if (f6) {
                f6 = false;
            } else {
                f6 = true;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
