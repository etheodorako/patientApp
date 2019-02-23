package patientApp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import DataBase.DButilities;
import Helpers.Patient;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;


public  class PatientProfile extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JXDatePicker datePicker;



	private JLabel lblSchoolId;
	private JLabel label1;
	private JLabel lblSurname;
	private JLabel lblBirth;
	private JLabel lblClass;
	private JLabel lblTelFather;
	private JLabel lblTelMother;
	private JLabel lblTelDoctor;
	private JLabel lblParentEmail;
	private JLabel lblAllergies;
	private JLabel lblHealthIssues;
	private JLabel lblSpecialNeeds;
	
	private JButton btnEditForm;
	private JButton btnCancel;
	private JButton btnSubmit;
	
	private long birthTemp;
	private JComboBox<String> comboBox;
	
	public PatientProfile(String schoolID) {
		getContentPane().setEnabled(false);
		
		final List<String> fields = new ArrayList<String>();
		Patient p = DButilities.getPatientById(schoolID);
		System.out.println(p);
		
		setBounds(100, 100, 710, 506);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("120px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("230px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("120px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("230px:grow"),},
			new RowSpec[] {
				RowSpec.decode("40px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("40px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("40px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("40px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("40px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("40px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("40px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("40px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("40px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("40px"),}));
				
		
		lblSchoolId = new JLabel("  School ID:");
		getContentPane().add(lblSchoolId, "1, 1, fill, fill");
		
		textField = new JTextField();
		textField.setFont(new Font("Monospaced", Font.ITALIC, 12));
		textField.setColumns(10);
		textField.setText(p.getSchoolID());
		textField.setEditable(false);
		getContentPane().add(textField, "3, 1, fill, fill");
		
		lblAllergies = new JLabel("  Allergies:");
		getContentPane().add(lblAllergies, "5, 1, fill, fill");
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setFont(new Font("Monospaced", Font.ITALIC, 12));
		textField_9.setColumns(10);
		textField_9.setText(p.getKnownAllergies());
		getContentPane().add(textField_9, "7, 1, fill, fill");
		
		label1 = new JLabel("  Name:");
		getContentPane().add(label1, "1, 3, fill, fill");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setText(p.getName());
		textField_1.setFont(new Font("Monospaced", Font.ITALIC, 12));
		getContentPane().add(textField_1, "3, 3, fill, fill");
		
		lblSurname = new JLabel("  Surname:");
		getContentPane().add(lblSurname, "1, 5, fill, fill");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setText(p.getSurname());
		textField_2.setFont(new Font("Monospaced", Font.ITALIC, 12));
		getContentPane().add(textField_2, "3, 5, fill, fill");
		
		lblHealthIssues = new JLabel("  Health Issues:");
		getContentPane().add(lblHealthIssues, "5, 5, fill, fill");
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setFont(new Font("Monospaced", Font.ITALIC, 12));
		textField_10.setColumns(10);
		textField_10.setText(p.getKnownHealthIssues());
		getContentPane().add(textField_10, "7, 5, fill, fill");
		
		lblBirth = new JLabel("  Birth:");
		getContentPane().add(lblBirth, "1, 7, default, fill");
		
		datePicker = new JXDatePicker();
		datePicker.setDate(p.getBirth());
		datePicker.setFormats(new SimpleDateFormat("yyyy.MM.dd"));
		datePicker.setEditable(false);
		datePicker.setFont(new Font("Monospaced", Font.ITALIC, 12));
		getContentPane().add(datePicker, "3, 7, fill, fill");
		
		lblClass = new JLabel("  Class:");
		getContentPane().add(lblClass, "1, 9, fill, fill");
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Monospaced", Font.ITALIC, 12));
		comboBox.addItem("A");
		comboBox.addItem("B");
		comboBox.addItem("C");
		comboBox.setSelectedItem(p.getClS());
		comboBox.setEditable(false);
//		comboBox.setEnabled(false);

		getContentPane().add(comboBox, "3, 9, fill, fill");
		
		lblSpecialNeeds = new JLabel("  Special Needs:");
		getContentPane().add(lblSpecialNeeds, "5, 9, fill, fill");
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setFont(new Font("Monospaced", Font.ITALIC, 12));
		textField_11.setColumns(10);
		textField_11.setText(p.getSpecialNeeds());
		getContentPane().add(textField_11, "7, 9, fill, fill");
		
		lblTelFather = new JLabel("  Tel. Father:");
		getContentPane().add(lblTelFather, "1, 11, fill, fill");
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setFont(new Font("Monospaced", Font.ITALIC, 12));
		textField_5.setText(p.getTel_father());
		getContentPane().add(textField_5, "3, 11, fill, fill");
		
		
		lblTelMother = new JLabel("  Tel. Mother:");
		getContentPane().add(lblTelMother, "1, 13, fill, fill");
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setFont(new Font("Monospaced", Font.ITALIC, 12));
		textField_6.setText(p.getTel_mother());
		getContentPane().add(textField_6, "3, 13, fill, fill");

		
		lblTelDoctor = new JLabel("  Tel. Doctor");
		getContentPane().add(lblTelDoctor, "1, 15, fill, fill");
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setFont(new Font("Monospaced", Font.ITALIC, 12));
		textField_7.setText(p.getTel_doctor());
		getContentPane().add(textField_7, "3, 15, fill, fill");
		
				btnEditForm = new JButton("Edit Form");
				btnEditForm.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						btnEditForm.setVisible(false);
						btnEditForm.setEnabled(false);
						btnCancel.setVisible(true);
						btnCancel.setEnabled(true);
						btnSubmit.setVisible(true);
						btnSubmit.setEnabled(true);
					
						fields.add(textField_1.getText());
						fields.add(textField_2.getText());
						fields.add(comboBox.getSelectedItem().toString());
						fields.add(textField_5.getText());
						fields.add(textField_6.getText());
						fields.add(textField_7.getText());
						fields.add(textField_8.getText());
						fields.add(textField_9.getText());
						fields.add(textField_10.getText());
						fields.add(textField_11.getText());

						birthTemp = datePicker.getDate().getTime();
						
						textField_1.setEditable(true);
						textField_2.setEditable(true);
						datePicker.setEditable(true);
						comboBox.setEditable(true);
						textField_5.setEditable(true);
						textField_6.setEditable(true);
						textField_7.setEditable(true);
						textField_8.setEditable(true);
						textField_9.setEditable(true);
						textField_10.setEditable(true);
						textField_11.setEditable(true);



						
					}
				});
				getContentPane().add(btnEditForm, "7, 15, center, center");

		
		lblParentEmail = new JLabel("  Parent e-mail:");
		getContentPane().add(lblParentEmail, "1, 17, fill, fill");
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setFont(new Font("Monospaced", Font.ITALIC, 12));
		textField_8.setText(p.getMailOfParent());
		getContentPane().add(textField_8, "3, 17, fill, fill");
		
		btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnEditForm.setVisible(true);
				btnEditForm.setEnabled(true);
				btnCancel.setVisible(false);
				btnCancel.setEnabled(false);
				btnSubmit.setVisible(false);
				btnSubmit.setEnabled(false);
				
				textField_1.setEditable(false);
				textField_1.setText(fields.get(0));
				textField_2.setEditable(false);
				textField_2.setText(fields.get(1));
				datePicker.setEditable(false);
				datePicker.setDate(new Date(birthTemp));
				comboBox.setEditable(false);
				comboBox.setSelectedItem(fields.get(2));
				textField_5.setEditable(false);
				textField_5.setText(fields.get(3));
				textField_6.setEditable(false);
				textField_6.setText(fields.get(4));
				textField_7.setEditable(false);
				textField_7.setText(fields.get(5));
				textField_8.setEditable(false);
				textField_8.setText(fields.get(6));
				textField_9.setEditable(false);
				textField_9.setText(fields.get(7));
				textField_10.setEditable(false);
				textField_10.setText(fields.get(8));
				textField_11.setEditable(false);
				textField_11.setText(fields.get(9));

				
				fields.clear();
				
			}
		});
		btnCancel.setEnabled(false);
		btnCancel.setVisible(false);
		getContentPane().add(btnCancel, "5, 17, center, default");
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setEnabled(false);
		btnSubmit.setVisible(false);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Patient p = new Patient(
						textField.getText(), 
						textField_1.getText(), 
						textField_2.getText(), 
						new java.sql.Date(datePicker.getDate().getTime()), 
						comboBox.getSelectedItem().toString(), 
						textField_5.getText(), 
						textField_6.getText(), 
						textField_7.getText(), 
						textField_8.getText(), 
						textField_9.getText(), 
						textField_10.getText(), 
						textField_11.getText()
				);
			
				DButilities.updatePatient(p);
				
				btnEditForm.setVisible(true);
				btnEditForm.setEnabled(true);
				btnCancel.setVisible(false);
				btnCancel.setEnabled(false);
				btnSubmit.setVisible(false);
				btnSubmit.setEnabled(false);
				
				textField_1.setEditable(false);
				textField_2.setEditable(false);
				datePicker.setEditable(false);
				comboBox.setEditable(false);
				textField_5.setEditable(false);
				textField_6.setEditable(false);
				textField_7.setEditable(false);
				textField_8.setEditable(false);
				textField_9.setEditable(false);
				textField_10.setEditable(false);
				textField_11.setEditable(false);

				
				fields.clear();
				
				JOptionPane.showMessageDialog(getContentPane(), "Patient profile haw been updated succesfully.");
				
			}
		});
		getContentPane().add(btnSubmit, "7, 17, center, default");
		
	}
}

