package randomStuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.EventQueue.invokeLater;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ExtendedJDialog extends JDialog { //LauncherBot10
	
	private JLabel exePathLabel;
	private JTextField exePathTextField;
    private JButton saveButton;
    private JPanel pan;

	public ExtendedJDialog(String... s) {
		initComponents(s);
	}

	private void initComponents(String... s) {
		
		exePathLabel = new JLabel("Anzeige");
		exePathTextField = new JTextField("Hallo");
		saveButton = new JButton("Speichern");
		pan = new JPanel();
	    pan.setLayout(new FlowLayout());
		setModal(true);
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Hallo Welt");
		pan.add(exePathLabel);
		pan.add(exePathTextField);
		pan.add(saveButton);
		add(pan);
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				saveButtonActionPerformed(evt);
			}
		});
		
		setLocationRelativeTo(null); //Ausrichtung mittig
	}
	
	private void saveButtonActionPerformed(ActionEvent evt) {
		exePathTextField.setText("Welt");
	}
	
	public static void main(String args[]) {
		
		invokeLater(new Runnable() {
			public void run() {
				new ExtendedJDialog().setVisible(true);
			}
		});
	}
}
