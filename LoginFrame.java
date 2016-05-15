import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LoginFrame {
	private JTextArea studentID;
	private StudentList sl;
	private FileConverter fc;
	private JButton button, admin;
	private JFrame frame;
	private JPanel panel;

	//opens a JFrame that is the login for the Admin and the Student
	public void openWindow() throws IOException {
		frame = new JFrame("Log In");
		panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JLabel label = new JLabel("Enter your ID");

		button = new JButton();
		button.setText("Log In");
		ButtonListener bl = new ButtonListener();
		button.addActionListener(bl);

		studentID = new JTextArea(1, 15);

		admin = new JButton();
		admin.setText("Admin Access");
		AdminListener al = new AdminListener();
		admin.addActionListener(al);
		
		panel.add(label);
		panel.add(studentID);
		panel.add(button);
		panel.add(admin, BorderLayout.SOUTH);

		frame.add(panel);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		sl = new StudentList();
		fc = new FileConverter();
		sl.setList(fc.textToList());
	}

	//when button is clicked, it will search for a student with the same ID and then sign in.
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String idNum = studentID.getText().trim();
				int rosterIndex = sl.searchID(idNum);
				if (rosterIndex > -1) {
					StudentLogin studLog = new StudentLogin(rosterIndex);
				} else {
					studentID.replaceRange("ID not found. Try again.", 0, studentID.getText().length());
				}
			} catch (IOException exc) {
				System.out.println(exc.toString());
			}
		}
	}

	//the listener that opens Admin JFrame
	public class AdminListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Admin ex = new Admin();
			ex.openAdmin();
		}
	}
}