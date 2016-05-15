import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StudentLogin {
	private int index;
	private StudentList sl;
	private FileConverter fc;
	
	//The JFrame that opens when a student successfully logs in
	public StudentLogin(int i) throws IOException{
		index = i;
		sl = new StudentList();
		fc = new FileConverter();
		sl.setList(fc.textToList());
		JFrame loginFrame = new JFrame("Welcome, "+sl.get(index).getFName() + " " + sl.get(index).getLName());
		JPanel loginPanel = new JPanel();
		
		JButton clockInButton = new JButton();
		clockInButton.setText("Clock In");
		clockInButton.addActionListener(new ClockInButtonListener());
		
		JButton clockOutButton = new JButton();
		clockOutButton.setText("Clock Out");
		clockOutButton.addActionListener(new ClockOutButtonListener());
		
		loginPanel.add(clockInButton);
		loginPanel.add(clockOutButton);
		
		loginFrame.add(loginPanel);
		loginFrame.setSize(300, 300);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setVisible(true);
	}
	
	//the listener for the button that clocks in the student
	public class ClockInButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			sl.get(index).clockIn();
			System.out.println("Clock In  : "+ sl.get(index).getTimeIn());
		}
	}
	
	//the listener for the button that allows the student to clock out
	public class ClockOutButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			sl.get(index).setClockOut(sl.get(index).getTime());
			System.out.println("Clock Out : " + sl.get(index).getTimeOut());
		}
	}
}
