package view;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class AboutDialog extends JDialog{
	private static final long serialVersionUID = 3591599721565020284L;
	
	public AboutDialog(JFrame parentFrame,boolean modal) {
		super(parentFrame,modal);
		//JOptionPane.showMessageDialog(null, "tekst", "About", JOptionPane.PLAIN_MESSAGE);
		String longMessage="dieGFJD\njsidnfuhgyda\nnkafsa\nfghj\ngtfhgjukh\ndfgh\nsd\nfdg\nfgfh\ndf\ndfd\n";
	    JTextArea textArea = new JTextArea(7, 30);
	    textArea.setText(longMessage);
	    textArea.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    JOptionPane.showMessageDialog(parentFrame, scrollPane);
	}

};	
