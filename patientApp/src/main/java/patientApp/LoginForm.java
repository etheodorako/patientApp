package patientApp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import DataBase.DButilities;
import Helpers.Patient;
import Helpers.User;

public class LoginForm extends JFrame implements ActionListener {
	JButton SUBMIT;
	JPanel panel;
	JLabel label1, label2;
	final JTextField text1, text2;

	LoginForm() {
		label1 = new JLabel();
		label1.setText("Username:");
		text1 = new JTextField(15);

		label2 = new JLabel();
		label2.setText("Password:");
		text2 = new JPasswordField(15);

		SUBMIT = new JButton("SUBMIT");

		label1.setBounds(80, 70, 200, 30);
		label2.setBounds(80, 110, 200, 30);
		text1.setBounds(300, 70, 200, 30);
		text2.setBounds(300, 110, 200, 30);
		SUBMIT.setBounds(150, 160, 100, 30);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label1)
						.addComponent(label2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(text2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(text1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(67))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(305, Short.MAX_VALUE)
					.addComponent(SUBMIT)
					.addGap(59))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label1)
						.addComponent(text1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label2)
						.addComponent(text2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(SUBMIT)
					.addContainerGap(143, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		SUBMIT.addActionListener(this);
		setTitle("LOGIN FORM");

	}

	public void actionPerformed(ActionEvent ae) {
		String value1 = text1.getText();
		String value2 = text2.getText();
		
		final User user = DButilities.login(value1, value2);

		if (user!=null) {
			

			NextPage page = new NextPage(user);
			page.setBounds(100, 100, 600, 300);
			page.setVisible(true);
			page.setLocationRelativeTo(null);
			this.dispose();
			
		} else {
			System.out.println("enter the valid username and password");
			JOptionPane.showMessageDialog(this, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}



	public static void main(String arg[]) {

		try {
			LoginForm frame = new LoginForm();
			
			frame.setVisible(true);
			frame.setBounds(100, 100, 600, 300);
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	
}}