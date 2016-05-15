import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Admin {
	private JButton button;
	private JTextArea textArea, fNameText, lNameText, idText;
	private JFrame accessFrame;
	public StudentList sl = new StudentList();

	//opens admin panel
	public void openAdmin() {
		accessFrame = new JFrame("Admin");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel("Enter password");

		button = new JButton();
		button.setText("Enter");
		ButtonListener bl = new ButtonListener();
		button.addActionListener(bl);

		textArea = new JTextArea(1, 15);

		panel.add(textArea);
		panel.add(label);
		panel.add(button);

		accessFrame.add(panel);

		accessFrame.setSize(300, 300);
		accessFrame.setLocationRelativeTo(null);
		accessFrame.setVisible(true);
	}

	//opens the admin access panel
	public void openAccess() {
		JFrame frame = new JFrame("AdminAccess");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JButton fileOpener = new JButton();
		fileOpener.setText("Show Students");
		fileOpener.addActionListener(new OpenFileListener());

		JLabel fNameLabel = new JLabel("Enter first name");
		fNameText = new JTextArea(1, 15);
		fNameLabel.setHorizontalAlignment(JLabel.LEFT);
		fNameLabel.setVerticalAlignment(JLabel.BOTTOM);

		JLabel lNameLabel = new JLabel("Enter last name");
		lNameText = new JTextArea(1, 15);

		JLabel idLabel = new JLabel("Enter ID");
		idLabel.setHorizontalAlignment(JLabel.LEFT);
		idLabel.setVerticalAlignment(JLabel.BOTTOM);
		idText = new JTextArea(1, 15);

		JButton newStudent = new JButton();
		newStudent.setText("Add Student");
		newStudent.addActionListener(new NewStudentListener());

		panel.add(fileOpener);
		panel.add(fNameLabel);
		panel.add(fNameText);
		panel.add(lNameLabel);
		panel.add(lNameText);
		panel.add(idLabel);
		panel.add(idText);
		panel.add(newStudent);

		frame.add(panel);
		frame.setSize(200, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	//Opens "VEI_Class.txt"
	public class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				FileConverter fc = new FileConverter();
				fc.openFile();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}

	//Uses a scanner to create a new student object
	public class NewStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				String fName = fNameText.getText().trim();
				String lName = lNameText.getText().trim();
				String idNum = idText.getText().trim();
				if (!fName.equalsIgnoreCase("") || !lName.equalsIgnoreCase("") || !idNum.equalsIgnoreCase("")) {
					Student stu = new Student(fName, lName, idNum);
					sl.add(stu);
					FileConverter fc = new FileConverter();
					fc.addStudent(fName, lName, idNum);
					fNameText.replaceRange("", 0, fName.length());
					lNameText.replaceRange("", 0, lName.length());
					idText.replaceRange("", 0, idNum.length());
				}
				if(fName.equalsIgnoreCase("")){
					fNameText.replaceRange("You need something in here.", 0, fName.length());
				}
				if(lName.equalsIgnoreCase("")){
					lNameText.replaceRange("You need something in here.", 0, lName.length());
				}
				if(idNum.equalsIgnoreCase("")){
					idText.replaceRange("You need something in here.", 0, idNum.length());
				}
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}

	//tests password
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String pass = textArea.getText();
			if (pass.equals("A")) { //"A" is the password
				Admin ex = new Admin();
				accessFrame.dispatchEvent(new WindowEvent(accessFrame, WindowEvent.WINDOW_CLOSING));
				ex.openAccess();
			} else {
				textArea.replaceRange("Incorrect. \\(*X*)/", 0, textArea.getText().length());
			}
		}
	}
}