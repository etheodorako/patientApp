package patientApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Helpers.User;

public class NextPage extends JFrame implements ActionListener {
	JButton SUBMIT;
	JPanel panel;
	JLabel label1, label2, label3;
	final JTextField  text2;
	User user;
	

	NextPage(User user) {
		this.user = user;
		
		label1 = new JLabel();
		label1.setText("Question:");
		label3 = new JLabel();
		label3.setText(user.getQuestion());
		
		
		label2 = new JLabel();
		label2.setText("Answer:");
		text2 = new JTextField(15);

		SUBMIT = new JButton("SUBMIT");

		label1.setBounds(80, 70, 200, 30);
		label2.setBounds(80, 110, 200, 30);
		label3.setBounds(300, 70, 200, 30);
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
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		String value = text2.getText();
		

		if (user.getAnswer().equals(value)) {
			
			patientsList page = new patientsList();
			page.setVisible(true);
			
			this.dispose();
			
		} else {
			System.out.println("enter the valid answer");
			JOptionPane.showMessageDialog(this, "Incorrect answer", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}



}