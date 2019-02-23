package patientApp ; 

import java.awt.EventQueue;

//import com.google.gson.Gson;

//import Classes.Grade;
//import Classes.Student;
//import WebServices.JAXRSConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DataBase.DButilities;
import Helpers.Patient;

//import java.awt.Component;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.ListSelectionModel;
//import javax.swing.JScrollPane;


/**
 * 
 * This is the frame for the other user of the desktop app
 *
 */
public final class patientsList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JButton btnNewButton_2;
	private JLabel lblPatientCatalog;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientsList frame = new patientsList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public patientsList() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 506);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		JButton btnNewButton_1 = new JButton(
				"Add Student");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new AddStudentFrame().setVisible(true);
			}
		});
		
		btnNewButton_2 = new JButton("Refresh Table");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				drawTable(scrollPane);
		}});
		
		lblPatientCatalog = new JLabel("Patients Catalog");

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(122)
					.addComponent(btnNewButton_1)
					.addGap(63)
					.addComponent(btnNewButton_2)
					.addContainerGap(152, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(217)
					.addComponent(lblPatientCatalog)
					.addContainerGap(280, Short.MAX_VALUE))
		);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblPatientCatalog)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addGap(34))
		);

		

		drawTable(scrollPane);
		
		contentPane.setLayout(gl_contentPane);
	}

	
	/**
	 * Draws the table for the students
	 * @param scrollPane
	 */
	public void drawTable(JScrollPane scrollPane){
		
		table_1 = new JTable();
		table_1.setRowSelectionAllowed(true);

		table_1.setModel(
				new DefaultTableModel(new Object[][] {},
						new String[] { "SCHOOL_ID", "NAME","SURNAME","","" }) {
					public boolean isCellEditable(int row, int column) {
						return false;// This causes all cells to be not editable
					}
				});

		table_1.setAutoCreateRowSorter(true);

		final List<Patient> lPatient = DButilities.getPatients();
		
		for (Patient p : lPatient) {
			Object[] rowData = new Object[table_1.getModel().getColumnCount()];
			rowData[0] = p.getSchoolID();
			rowData[1] = p.getName();
			rowData[2] = p.getSurname();
			rowData[3] = p.getBirth();
			rowData[4] = p.getCl();

			((DefaultTableModel) table_1.getModel()).addRow(rowData);
		}

		// Sort columns
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table_1.getModel());
		table_1.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
		 
		int columnIndexToSort = 1;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
		 
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		
		//Add mouse listener for double-clisking
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
	               JTable target = (JTable) e.getSource();
	               int row = target.getSelectedRow();
	               
	               PatientProfile pProfileFrame = new PatientProfile(target.getValueAt(row, 0).toString());
	               pProfileFrame.setVisible(true);
	            }
				
			}
		});

		
		scrollPane.setViewportView(table_1);
					
	
	}
	
}