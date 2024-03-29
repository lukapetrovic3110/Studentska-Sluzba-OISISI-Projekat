package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import model.Student;

public class PrikaziButtonColumn extends AbstractCellEditor
       implements TableCellRenderer, TableCellEditor, MouseListener {

	private static final long serialVersionUID = 1343768131059619058L;

	private JButton renderButton; 	// dugme koje se iscrtava
	private JButton editorButton; 	// dugme koje obradjuje akciju
	private JTable table;
	private boolean isEditorActive = false; // da li je aktivno editovanje celije tabele

	public PrikaziButtonColumn(JTable table, int column) {
		
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this); 		// nacin iscrtavanje celije
		this.table.getColumnModel().getColumn(column).setCellEditor(this); 	// nacin editovanja celije
		this.table.addMouseListener(this);

		this.renderButton = new JButton("prikazi");
		this.editorButton = new JButton("prikazi");

		this.editorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				
				if(TabbedPane.tabbedPane.getSelectedComponent() == TabbedPane.panelStudenti)
				{
					PrikaziDugmeStudenta pk = new PrikaziDugmeStudenta(MainWindow.getInstance(),true,false);
					pk.setVisible(true);
				}
				else if(TabbedPane.tabbedPane.getSelectedComponent() == TabbedPane.panelProfesori)
				{
					PrikaziSpisakPredmetaProfesoraDialog prikaziDugmeProfesora = new PrikaziSpisakPredmetaProfesoraDialog(MainWindow.getInstance(), true);
					prikaziDugmeProfesora.setVisible(true);
				}
				else
				{
					
					PrikaziStudenteKojiSlusajuDialog prikaziStudenteKojiSlusajuDialog = new PrikaziStudenteKojiSlusajuDialog(MainWindow.getInstance(), true);
					Student.polje = 0;
					prikaziStudenteKojiSlusajuDialog.setVisible(true);	
					
				}
			}
		});

		this.isEditorActive = false;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return new PanelPredmeti(this.renderButton, 20, 20);
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return new PanelPredmeti(this.editorButton, 20, 20);
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing(); // ekplicitno navodimo da je editovanje celije je zavrseno
		}
		isEditorActive = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
