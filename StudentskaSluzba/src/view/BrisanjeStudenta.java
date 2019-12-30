package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BrisanjeStudenta extends JDialog{
	
	private static final long serialVersionUID = 3591599721565020284L;
	
	public BrisanjeStudenta(JFrame parentFrame,boolean modal)
	{
		super(parentFrame,modal);
		
		Object[] options = {"Odbaci",
		"Potvrdi"};

		/*ImageIcon imageIcon4=new ImageIcon(ImageIO.read(getClass().getResourceAsStream("delete.png")));
		Image i4 = imageIcon4.getImage();
		Image ii = i4.getScaledInstance(10, 10, Image.SCALE_SMOOTH);*/
		
		setLocationRelativeTo(parentFrame);
		JOptionPane.showOptionDialog(parentFrame,
		"Da li ste sigurni da zelite obrisati studenta?",
		"Brisanje studenta",
		JOptionPane.YES_NO_CANCEL_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		options,
		options[1]);
	}
			
		
		//zasto ostane mali prozor gore desno?
}
