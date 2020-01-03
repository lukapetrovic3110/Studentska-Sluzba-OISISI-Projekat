package view;

import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class StudentiJTable extends JTable {
	
	private static final long serialVersionUID = 3870532450326465610L;
	private TableRowSorter<StudentTableModel> sorter;
	
	public StudentiJTable()
	{
		StudentTableModel model=new StudentTableModel();
		this.setModel(model);
		sorter=new TableRowSorter<StudentTableModel> (model);
		sorter.setSortable(3, false);
		sorter.setSortable(4, false);
		sorter.setSortable(5, false);
		sorter.setSortable(7, false);
		//sorter.setSortable(12, false);  TREBA!
		
		sorter.setComparator(2, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] god1=o1.split("\\.");
				String[] god2=o2.split("\\.");
				
				if(god1[2].equals(god2[2])) {
					
					if(god1[1].equals(god2[1])){
						if(god1[0].equals(god2[0])){
							return 0;
						}else if(Integer.parseInt(god1[0]) < (Integer.parseInt(god2[0]))){
							return -1;
						}else{
							return 1;
						}
					}else if(Integer.parseInt(god1[1]) < (Integer.parseInt(god2[1]))){
						return -1;
					}else{
						return 1;
					}
				}else if(Integer.parseInt(god1[2]) < (Integer.parseInt(god2[2]))){
					return -1;
				}else{
					return 1;
				}
			}

			
		});
		
		sorter.setComparator(6, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] niz1=o1.split("-");
				String[] niz2=o2.split("-");
				
				if(niz1[0].equals(niz2[0])) {
					
					if(niz1[2].equals(niz2[2])){
						if(niz1[1].equals(niz2[1])){
							return 0;
						}else if(Integer.parseInt(niz1[1]) < (Integer.parseInt(niz2[1]))){
							return -1;
						}else{
							return 1;
						}
					}else if(Integer.parseInt(niz1[2]) < (Integer.parseInt(niz2[2]))){
						return -1;
					}else{
						return 1;
					}
				}else{
					return o1.compareTo(o2);
				}
			}

			
		});
		

		
		
		
		
		this.setRowSorter(sorter);
		
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//this.setModel(new StudentTableModel()); 
		
		
	}
	
    @Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
